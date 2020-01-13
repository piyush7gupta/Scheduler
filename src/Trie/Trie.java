package Trie;
import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
public class Trie<T> implements TrieInterface {
    
    TrieNode root ;
    public Trie()
    {
         root = new TrieNode();
    }

    public void printTrie(TrieNode trieNode) {
        if(trieNode==null)
            return;
       if(trieNode.stud!=null)
       {
           Person p=(Person)trieNode.stud;
           System.out.println(p);
       }
      
          for(int i=0;i<trieNode.arr.length;i++)
          {
              if(trieNode.arr[i]!=null)
                  printTrie (trieNode.arr[i]);
          }
      
    }

    @Override
    public boolean delete(String word) {
        int a;
        if(search(word)!=null)
        {
            TrieNode temp=root;
            int i=0;
            for(;i<word.length();i++)
            {
                 a=word.charAt(i)-' ';
                    temp=temp.arr[a];
            }
            temp.stud=null;
            while(temp!=root)
            {
                
                if(temp.size==0)
                {
                    TrieNode temp1=temp.parent;
                    
                    int b=temp.val;
                    temp=temp1;
                    temp1.arr[b]=null;
                    temp1.size--;
                    
                }
                else 
                    break;

            }
            return true;
        }
        else
        return false;
    }

    @Override
    public TrieNode search(String word) {
        TrieNode temp=root;
        int i=0;
        for(;i<word.length();i++)
        {
             int a=word.charAt(i)-' ';
            if(temp.arr[a]!=null)
            {
               
                temp=temp.arr[a];
         
            }
            else 
                return null;
        }
        if(temp.stud!=null)
        return temp;
        else
            return null;
    }

    @Override
    public TrieNode startsWith(String prefix) {
        TrieNode temp=root;
        int i=0;
        for(;i<prefix.length();i++)
        {
            int a=prefix.charAt(i)-' ';
            if(temp.arr[a]!=null)
                temp=temp.arr[a];
            else
                return null;
        }
        return temp;
        
        
    }

    @Override
    public boolean insert(String word, Object value) {
        TrieNode temp=root;
        int i=0;
        for(;i<word.length();i++)
        {
            int a=word.charAt(i)-' ';
            //System.out.print(word.charAt(i));
            if(temp.arr[a]!=null)
            {
               
                
                temp=temp.arr[a];
         
            }
           
            else
            {
                 temp.size++;
                 //System.out.print((char)(temp.val+32)+" "+temp.size+" ");
                temp.arr[a]=new TrieNode();
                temp.arr[a].parent=temp;
                temp.level=i+1;
               
                temp=temp.arr[a];
                 temp.val=a;
                 
            }
           
           
        }
          //System.out.println();
         if(temp.stud!=null)
            return false;
        else
            temp.stud=value;
        
        
        return true;
    }

    @Override
    public void printLevel(int level) {
           
        Queue<TrieNode> q = new LinkedList();
        
        int value=1;
        int value1=level;
        q.add(root);
        ArrayList A1=new ArrayList<Character>();
        while(q.peek()!=null)
        {
            TrieNode node=q.poll();
            if(value1==node.level)
            {
            
            System.out.print("Level "+level +": ");
                A1=new ArrayList<Character>();
               value1--;
               value=1;
               
            }
            if(node.level==level+1)
                break;
            
            for(int i=0;i<node.arr.length;i++)
            {
                if(node.arr[i]!=null)
                {
                    if(level==node.level)
                    {
                    char c=(char)(i+' '); 
                if(i!=0)
                                   /*{
                                        if(value==0)
                                       {
                                           System.out.print(',');
                                       } 
                                       else 
                                           value=0;

                                           System.out.print(c);
                                   }*/
                                   A1.add(c);

                    }
                        q.add(node.arr[i]);
                }
            }
            
        }
         A1=sort(A1);
                    if(A1.size()>0)
                    System.out.print(A1.get(0));
                     for(int i=1;i<A1.size();i++)
            {
                System.out.print(","+A1.get(i));
            }
        System.out.println();

        
    }
    
    @Override
    public void print()
    {
        System.out.println("-------------");
        System.out.println("Printing Trie");
        Queue<TrieNode> q = new LinkedList();
        int level =1;
        int value=1;
        q.add(root);
        ArrayList A1=new ArrayList<Character>();
        while(q.peek()!=null)
        {
            TrieNode node=q.poll();
            if(level==node.level)
            {
                    if(level!=1)
                    {

                        A1=sort(A1);
                        if(A1.size()>0)
                        System.out.print(A1.get(0));
                         for(int i=1;i<A1.size();i++)
                {
                    System.out.print(","+A1.get(i));
                }
                        System.out.println();

                    }
                   System.out.print("Level "+level +": ");
                    A1=new ArrayList<Character>();
                   level++;
                   value=1;
            }
            for(int i=0;i<node.arr.length;i++)
            {
                if(node.arr[i]!=null)
                {
                   
                    char c=(char)(i+' ');
                    
                   if(i!=0)
                   /*{
                        if(value==0)
                       {
                           System.out.print(',');
                       } 
                       else 
                           value=0;

                           System.out.print(c);
                   }*/
                   A1.add(c);
                        q.add(node.arr[i]);
                }
            }
            
        }
              A1=sort(A1);
               if(A1.size()>0)
                    System.out.print(A1.get(0));
                     for(int i=1;i<A1.size();i++)
            {
                System.out.print(","+A1.get(i));
            }
        System.out.println();
        if(A1.size()!=0)
        
        {
            System.out.print("Level "+level +": ");
            System.out.println();
        }
        System.out.println("-------------");
        
        
    }
        public ArrayList<Character> sort(ArrayList<Character> A)
    {
        ArrayList<Character> A1= new ArrayList();
        boolean b=true;
         for(int i=0;i<A.size();i++)
            {
          A1.add(A.get(i));
            
            }
        while(b)
        {
            for(int i=0;i<A.size();i++)
            {
                if(A1.get(i)!=null)
                A1.set(i, A.get(i));
            
            
            }
            for(int i=0;i<A.size()-1;i++)
            {
                char c=A.get(i);
                    char d=A.get(i+1);
                   //System.out.println(c+" "+d+" "+i);
                if(c>d)
                {
                    
                  // System.out.println("piyush");
                    char e=A.get(i);
                    A.set(i, A.get(i+1));
                   // System.out.println(A1.get(i+1));
                    A.set(i+1,e);
                    //System.out.println(A1.get(i+1)+"LOD");

                }
            }
            b=false;
            for(int i=0;i<A.size();i++)
            {
                char c=A.get(i);
                char d=A1.get(i);
                //System.out.println(c+" "+d+" "+i);
                if(c!=d)
                {
                    b=true;
                }
            }
            
        }
        return A;
    }
}
