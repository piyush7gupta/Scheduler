package RedBlack;

import Util.RBNodeInterface;

import java.util.LinkedList;
import java.util.List;

public class RedBlackNode<T extends Comparable, E> implements RBNodeInterface<E> {

    T name;
    RedBlackNode<T,E> left;
    RedBlackNode<T,E> right;
    RedBlackNode<T,E> parent;
    boolean b;
    LinkedList A ;
     
    public RedBlackNode()
    {
        A =new LinkedList<E>();
    }
    @Override
    public E getValue() 
    {  
        return (E)A.getFirst();
        
    }

    @Override
    public List<E> getValues() {
        if(A.size()==0)
            return null;
        else            
        return A;
    }
}
