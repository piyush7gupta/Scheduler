package PriorityQueue;

import java.util.List;
import java.util.ArrayList;

public class MaxHeap<T extends Comparable> implements PriorityQueueInterface<T> {


    public ArrayList A= new ArrayList<T>();
    ArrayList<Integer> A1= new ArrayList();
    int val=0;
    int size=0;
    @Override
    public void insert(T element) {
        
        val++;
        A.add(element);
        A1.add(val);
        size++;
        int a=size-1;
        int b=(a-1)/2;
        while(b>=0)
        {
            T s1 =(T)A.get(b);
            T s2=(T)A.get(a);
            if(s1.compareTo(s2)<0)
            {
                T temp=s1;
                A.set(b,s2);
                A.set(a, temp);
                int q=A1.get(b);
                A1.set(b,A1.get(a));
                A1.set(a, q);
                int x=b;
                b=(b-1)/2;
                a=x;
            }
            else
            break;
        }
        /*
        for(int i=0;i<A.size();i++)
        {
            Student sa=(Student)A.get(i);
           System.out.print(sa.getName()+" ");
        }
        System.out.println();
        */
    }

    @Override
    public T extractMax() {
        /* for(int i=0;i<A.size();i++)
        {
            Student sa=(Student)A.get(i);
           System.out.print(sa.getName()+" ");
        }
        System.out.println();
         for(int i=0;i<A.size();i++)
        {
            Student sa=(Student)A.get(i);
           System.out.print(A1.get(i)+" ");
        }
        System.out.println();
        */
        
         int a=size;
        if(a==0)
        return null;
        T value=(T)A.get(0);
       
        a--;
        T temp=(T)A.get(a);
         A.set(0, temp);
         A1.set(0,A1.get(a));
         A1.remove(a);
        A.remove(a);size--;
        
        
        int b=0;
        if(b<size)
        while(A.get(b)!=null)
        {
            T s=(T)A.get(b);
            T s1=null;
            T s2=null;
            int k=2,l=2;
            if(2*b+1<size)
            {
                 s1=(T)A.get(2*b+1);
                k=s.compareTo(s1);          
            }
             if(2*b+2<size)
            {
                 s2=(T)A.get(2*b+2);
                l=s.compareTo(s2);          
            }
            // System.out.println(k+" "+l+" "+size);
            if(k==0)
            {
                if(A1.get(b)<A1.get(2*b+1))
                    k++;
            }
            if(l==0)
            {
                  if(A1.get(b)<A1.get(2*b+2))
                    l++;
            }
             if(k>0 && l>0)
             {
                 break;
             }
            else
             {
                 if(s2!=null)
                 {
                     
                    int b1=0;
                     if(s1.compareTo(s2)==0)
                        b1++;
                     if(A1.get(2*b+1)<A1.get(2*b+2))
                     {
                         b1+=10;
                     }
                     if(A1.get(2*b+1)>A1.get(2*b+2))
                     {
                         b1+=100;
                     }
                    // System.out.println(b1);
                     if(s1.compareTo(s2)>0 || b1==11)
                     {
                         T swap=(T)(A.get(2*b+1));
                         A.set(2*b+1, A.get(b));
                         A.set(b, swap);
                         
                         int swap1=(A1.get(2*b+1));
                         A1.set(2*b+1, A1.get(b));
                         A1.set(b, swap1);
                         b=2*b+1;
                     }
                     else if(s1.compareTo(s2)<0 || b1==101)
                     {
                          T swap=(T)(A.get(2*b+2));
                         A.set(2*b+2, A.get(b));
                         A.set(b, swap);
                         
                         int swap2=(A1.get(2*b+2));
                         A1.set(2*b+2, A1.get(b));
                         A1.set(b, swap2);
                          b=2*b+2;
                     }
                   
                     
                 }
                 else
                 {
                         T swap=(T)(A.get(2*b+1));
                         A.set(2*b+1, A.get(b));
                         A.set(b, swap);
                         int swap1=(A1.get(2*b+1));
                         A1.set(2*b+1, A1.get(b));
                         A1.set(b, swap1);
                         
                         b=2*b+1;
                 } 
                    
             }
             
                   
            
        }
        
        /*for(int i=0;i<A.size();i++)
        {
            Student sa=(Student)A.get(i);
           System.out.print(sa.getName()+" ");
        }
                System.out.println("piyush");
        for(int i=0;i<A.size();i++)
        {
            Student sa=(Student)A.get(i);
           System.out.print(A1.get(i)+" ");
        }
        System.out.println();*/
        return value;
    }

}