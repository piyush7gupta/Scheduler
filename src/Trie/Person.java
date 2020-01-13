package Trie;

public class Person<T> {
    
    

    public String Name;
    public String Phone_Number;
    public Person(String name, String phone_number) {
       
        Name=name;
        Phone_Number=phone_number;
    
    }
    
    public String toString()
    {
        String s="[Name: "+Name+", Phone="+Phone_Number+"]";
        return s;
        
                
    }
    public String getName() {
        return Name;
    }
}

/*
if(root1.parent.parent.name.compareTo(root1.parent.name)>0)
    root1.parent.parent.left=root1.parent;
else
    root1.parent.parent.right=root1.parent;
*/