package ProjectManagement;

import Trie.*;
public class Project extends TrieNode{
    
    public String Name;
    public int budget;
    public int priority;
    
   
    
    public Project (String n, int p,int b)
    {
       Name=n;

       priority=p;
              budget=b;
    }
    

}
