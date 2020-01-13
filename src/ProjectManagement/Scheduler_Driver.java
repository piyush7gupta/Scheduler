package ProjectManagement;

import java.io.*;
import java.net.URL;
import Trie.*;
import PriorityQueue.*;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;


public class Scheduler_Driver extends Thread implements SchedulerInterface {


    public static void main(String[] args) throws IOException {
        Scheduler_Driver scheduler_driver = new Scheduler_Driver();
        scheduler_driver.execute();
    }

    public void execute() throws IOException {


        File file;
        URL url = Scheduler_Driver.class.getResource("INP");
        file = new File(url.getPath());

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.err.println("Input file Not found");
        }
        String st;
        while ((st = br.readLine()) != null) {
            String[] cmd = st.split(" ");
            if (cmd.length == 0) {
                System.err.println("Error parsing: " + st);
                return;
            }

            switch (cmd[0]) {
                case "PROJECT":
                    handle_project(cmd);
                    break;
                case "JOB":
                    handle_job(cmd);
                    break;
                case "USER":
                    handle_user(cmd[1]);
                    break;
                case "QUERY":
                    handle_query(cmd[1]);
                    break;
                case "":
                    handle_empty_line();
                    break;
                case "ADD":
                    handle_add(cmd);
                    break;
                default:
                    System.err.println("Unknown command: " + cmd[0]);
            }
        }


        run_to_completion();

        print_stats();

    }
    
    
    Trie<Project> AllProject = new Trie();
    Trie<User> AllUser = new Trie();
    MaxHeap<Job> AllJobHeap = new MaxHeap(); 
    int time=0;
    ArrayList<Job> AllJobArray= new ArrayList();
    
    ArrayList<Job> FinishedJobs= new ArrayList();
    ArrayList<Job> NotFinishedJobs= new ArrayList();
    ArrayList<Job> NotReady =new ArrayList();
    int remaining=0;
    
        
        
   
    
    


    @Override
    public void run() {
        // till there are JOBS
        schedule();
    }


    @Override
    public void run_to_completion() 
    {
          int size1=AllJobHeap.A.size();
          while(AllJobHeap.A.size()!=0)
          {
                System.out.println("Running code");
                System.out.println("Remaining jobs: "+remaining);
              
                schedule();
                System.out.println("System execution completed");
          }
    }

    @Override
    public void handle_project(String[] cmd) {
        Project p=new Project(cmd[1] ,Integer.parseInt(cmd[2]),Integer.parseInt(cmd[3]));
        AllProject.insert(cmd[1], p);
        System.out.println("Creating project");
        

    }

    @Override
    public void handle_job(String[] cmd) {
        System.out.println("Creating job");
        TrieNode t1=AllProject.search(cmd[2]);
        User u=null;Project p=null;
        if(t1!=null)
         p= (Project)(AllProject.search(cmd[2]).getValue());
        else 
        {
            System.out.println("No such project exists. "+ cmd[2]);
            return;
        }
        
        
        TrieNode t2=AllUser.search(cmd[3]);
        if(t2!=null)
        u= (User)(AllUser.search(cmd[3]).getValue());
       
        else
        {
            System.out.println("No such user exists: "+ cmd[3]);
            return;  
        }
         Job j=new Job(cmd[1],p,u,Integer.parseInt(cmd[4]) );
            j.priority1=AllJobArray.size();
            AllJobArray.add(j);
            AllJobHeap.insert(j);
            remaining++;
        

    }

    @Override
    public void handle_user(String name) {
            User user=new User(name);
            AllUser.insert(name, user);
            System.out.println("Creating user");
    }

    @Override
    public void handle_query(String key) {
         System.out.println("Querying");   
        for(int i=0;i<AllJobArray.size();i++)
        {
            Job j=AllJobArray.get(i);
          
            if(key.equals(j.name))
            {
                if(j.status==0)
                 System.out.println(j.name+": NOT FINISHED");   
                if(j.status==1)
                 System.out.println(j.name+": COMPLETED");  
                
                return;
            }
        }
        System.out.println(key+": NO SUCH JOB");  
        
    }

    @Override
    public void handle_empty_line() {
            //System.out.println("--------------STATS---------------");
      System.out.println("Running code");
      System.out.println("Remaining jobs: "+remaining);
              
        schedule();
        System.out.println("Execution cycle completed");
    }

    @Override
    public void handle_add(String[] cmd) {
            TrieNode t1=AllProject.search(cmd[1]);
            //System.out.println("--------------STATS----------------------------STATS---------------");
        Project p=null;
        if(t1!=null)
        {
            p= (Project)(AllProject.search(cmd[1]).getValue());
        }
        if(p!=null)
        {
            p.budget += Integer.parseInt(cmd[2]);
            System.out.println("ADDING Budget");
             for(int i=0;i<NotFinishedJobs.size();i++)
                {
                    Job j=NotFinishedJobs.get(i);
                    if(j.project==p)
                    {
                        
                        NotFinishedJobs.remove(i);
                        i--;
                        AllJobHeap.insert(j);
                        remaining++;
                       
                    }
                    
                }
        }
    }

    @Override
    public void print_stats() {
        System.out.println("--------------STATS---------------");
        System.out.println("Total jobs done: "+FinishedJobs.size());
        for(int i=0;i<FinishedJobs.size();i++)
        {
            Job j=FinishedJobs.get(i);
            System.out.println("Job{user='"+j.user.Name+"', project='"+j.project.Name+"', jobstatus=COMPLETED, execution_time="+j.jobtime+", end_time="+j.finaltime+", name='"+j.name+"'}");
        }
        System.out.println("------------------------");
        System.out.println("Unfinished jobs: ");
        for(int i=0;i<NotFinishedJobs.size();i++)
        {
            Job j=NotFinishedJobs.get(i);
            System.out.println("Job{user='"+j.user.Name+"', project='"+j.project.Name+"', jobstatus=REQUESTED, execution_time="+j.jobtime+", end_time=null, name='"+j.name+"'}");

        }
        System.out.println("Total unfinished jobs: "+NotFinishedJobs.size());
        System.out.println("--------------STATS DONE---------------");
    }

    @Override
    public void schedule() {
        
        Job j= AllJobHeap.extractMax();
        while(j!=null)
        { 
            
            System.out.println("Executing: "+j.name+" from: "+j.project.Name);
            remaining--;
            if(j.jobtime<=j.project.budget)
            {
                j.project.budget-=j.jobtime;
                time+=j.jobtime;
                j.finaltime=time;
                FinishedJobs.add(j);
                j.status=1;
                
                System.out.println("Project: "+j.project.Name+" budget remaining: "+j.project.budget);
                break;
            }
            else
            {
                System.out.println("Un-sufficient budget.");
                NotFinishedJobs.add(j);
                j=AllJobHeap.extractMax();
                
            }
        }
    }
}
