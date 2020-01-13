package ProjectManagement;

public class User implements Comparable<User> 
{

    public String Name;
    
    public User (String n)
    {
        Name=n;
    }

    @Override
    public int compareTo(User user) {
        
        return 0;
    }
}
