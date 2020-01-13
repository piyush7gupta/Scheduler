package ProjectManagement;

public class Job implements Comparable<Job> {

  
    public String name;
    public Project project;
    public User user;
    public int jobtime;
    public int finaltime=0;
    public int arrivingtime;
    public int status=0;
    public int jobcounter;
    
    public Job(String n, Project p, User u , int j,int a,int p1)
    {
        name=n;
        project=p;
        user=u;
        jobtime=j;
        jobcounter =p1;
        
    }
    @Override
    public int compareTo(Job job) 
    {
        if(project.priority!=job.project.priority)
        return project.priority-job.project.priority;
        else
        return job.jobcounter-jobcounter;
        
    }
}