package PriorityQueue;

public class Student implements Comparable<Student> {
    private String name;
    private Integer marks;
   

    public Student(String trim, int parseInt) {
        
        name=trim;
        marks=parseInt;
    }


    @Override
    public int compareTo(Student student) {
        int a=student.getMarks();
     
        return marks-a;

            
    }

    public String toString()
    {
        String s="Student{name='"+name+"', marks="+marks+"}";
        return s;
    }
    public String getName() {
        return name;
    }
    public int getMarks()
    {
        return marks;
    }
}
