package RedBlack;


public class RBTree<T extends Comparable, E> implements RBTreeInterface<T, E>  {


    RedBlackNode root=new RedBlackNode();
    
  
    public void insert(T key, E value) 
    {
        //System.out.println("Piyush");
  
            if(root.name==null)
            {
                root.b=false;
                root.name=key;
                root.A.add(value);
                root.left=null;
                root.right=null;   
            }
            else
            {
                RedBlackNode root1=new RedBlackNode();
                RedBlackNode root2=new RedBlackNode();
                RedBlackNode root3=new RedBlackNode();
                RedBlackNode temp=new RedBlackNode();
                RedBlackNode temp2=new RedBlackNode();
                root2=root;
                root1=root;
                
                while(root1!=null)
                {
                    root2=root1;
                    if(root1.name.compareTo(key)==0)
                    {
                        root1.A.add(value);
                        
                        return;
                    }
                    else if(root1.name!=null)
                    {
                        //int a=root1.name.compareTo(key);
                          // System.out.println(root1.name+" "+key+" "+a);
                        if(root1.name.compareTo(key)>0)
                            {
                              
                               // if(root1.left!=null)
                                //System.out.println(root1.name+" "+root1.left.name);
                                //System.out.println("true1");
                                  root1=root1.left;
                                
                            }
                        else
                            {
                                root1=root1.right;
                            }
                }
                }
                root1=new RedBlackNode();
                root1.parent=root2;
                
                root1.name=key;
                root1.b=true;
                root1.left=null;
                root1.right=null;
                root1.A.add(value);
                
                //System.out.println(root2.name);
                        if(root2.name.compareTo(key)>0)
                            {
                                root2.left=root1;
                                //System.out.println("true1");
                            }
                        else
                            {
                               root2.right=root1;
                            }
                /*
                if(root1==root.left)
                {
                    System.out.println("true");
                }
                else if(root1==root.right)
                {
                    System.out.println("false");
                }
                else
                    System.out.println("false2");
              */
                
                if(root1.parent!=null && root1.parent.parent!=null)
                while(root1.parent.b)
                {
                    
                    //System.out.println("gupta "+root1.name);
                   // printrb (root);
                    // System.out.println("piyush");
                     boolean bool=true;
                   
                      if(root1.parent==root1.parent.parent.left)
                        {
                            root3=root1.parent.parent.right;
                            if(root3!=null)
                            {
                                //System.out.println("piyushgupta7");
                                if(root3.b)
                                    {
                                        root3.b=false;
                                        root1.parent.b=false;
                                        root1.parent.parent.b=true;
                                        root1=root1.parent.parent;
                                        bool=false;
                                    } 
                            }
                             if(bool)
                                    {
                                        // System.out.println("piyushgupta6");
                                        if(root1.parent.parent!=null)
                                        {
                                             boolean b1=false;
                                            if(root1==root1.parent.right)
                                            {
                                                b1=true;
                                                //System.out.println("piyush");
                                                temp2=root1.left;
                                               temp=root1.parent;
                                               root1.parent.parent.left=root1;
                                               root1.left=temp;
                                               root1.parent=temp.parent;
                                               temp.parent=root1;
                                               temp.right=temp2;
                                               if(temp2!=null)
                                               temp2.parent=temp;
                                               //System.out.println(temp.name+" "+root1.name);
                                               //System.out.println(temp.parent.name+" "+root1.parent.name);
                                               root1=temp;
                                               
                                               //System.out.println(temp.name+" "+root1.name);
                                               //System.out.println(temp.parent.name+" "+root1.parent.name);
                                            }
                                            if(root1.parent.parent!=null)
                                            {
                                                //System.out.println("piyushg");
                                                temp=root1.parent.right;
                                                root1.parent.right=root1.parent.parent; 
                                               
                                                
                                                if(temp!=null)
                                                {
                                                    root1.parent.parent.left=temp;
                                                     temp.parent=root1.parent.parent;
                                                }
                                                else
                                                    root1.parent.parent.left=null;
                                                
                                                temp2=root1.parent.parent;
                                                
                                                
                                                if(temp2.parent!=null)
                                                
                                                {
                                                    root1.parent.parent=temp2.parent;
                                                         if(root1.parent.parent.name.compareTo(root1.parent.name)>0)
                                                root1.parent.parent.left=root1.parent;
                                                else
                                                    root1.parent.parent.right=root1.parent;
                                                    
                                                }
                                                else
                                                {
                                                   if(b1)
                                                    System.out.println("piyushgupta---------1");
                                                    else
                                                     System.out.println("piyushgupta---------2");   
                                                    System.out.println("root "+root.name+" piyush"+key);
                                                     root=root1.parent;
                                                    // System.out.println("root "+root.name);
                                                    root1.parent.parent=null;}
                                                root1.parent.right.parent=root1.parent;
                                                root1.parent.b=false;
                                                root1.parent.right.b=true;
                                                
                                                /*root=root1;
                                                System.out.printf(root.name+" red ");
                                                if(root.left!=null)
                                                    System.out.printf(root.left.name+" left");
                                                if(root.right!=null)
                                                     System.out.printf(root.right.name+" right");
                                                System.out.println();
                                                
                                                root=root1.parent;
                                                System.out.printf(root.name+" red ");
                                                if(root.left!=null)
                                                    System.out.printf(root.left.name+" left");
                                                if(root.right!=null)
                                                     System.out.printf(root.right.name+" right");
                                                System.out.println();
                                                
                                                root=root1.parent.right;
                                                 System.out.printf(root.name+" red ");
                                                if(root.left!=null)
                                                    System.out.printf(root.left.name+" left");
                                                if(root.right!=null)
                                                     System.out.printf(root.right.name+" right");
                                                
                                                System.out.println();
                                                System.out.println("piyushg "+root1.name+root1.parent.name);*/
                                                
                                            }
                                        }
                                    }

                        }
                        else
                        {
                            // System.out.println("piyushgupta5"+root1.parent.parent.name);
                             
                            root3=root1.parent.parent.left;
                           
                            if(root3!=null)
                            {    
                                if(root3.b)
                                    {
                                       // System.out.println("piyushgupta2");
                                        root3.b=false;
                                        root1.parent.b=false;
                                        root1.parent.parent.b=true;
                                           // System.out.println("piyushgupta2"+root1.name+ " "+root1.parent.name+" "+root1.parent.parent.name);
                                        //System.out.println(root3.name+" "+root3.parent.right.name);
                                        root1=root1.parent.parent;
                                         //System.out.println("piyushgupta2"+root1.name);
                                         bool=false;
                                    } 
                            }
                            if(root1.parent!=null)
                                if(root1.parent.parent!=null)
                            if(root1.parent.parent!=null &&bool)
                                {
                                    
                                          //System.out.println("piyushgupta3");
                                   
                                         boolean b1=false;
                                        if(root1==root1.parent.left)
                                        {
                                            b1=true;
                                             temp=root1.parent;
                                             temp2=root1.right;
                                             root1.parent.parent.right=root1;
                                             root1.right=temp;
                                             root1.parent=temp.parent;
                                             temp.parent=root1;
                                             temp.left=temp2;
                                             if(temp2!=null)
                                             temp2.parent=temp;
                                             root1=temp;
                                        }
                                        if(root1.parent.parent!=null)
                                        {
                                            temp=root1.parent.left;
                                            root1.parent.left=root1.parent.parent;
                                            
                                            if(temp!=null)
                                            {
                                                root1.parent.parent.right=temp;
                                                temp.parent=root1.parent.parent;
                                            }
                                            else
                                                root1.parent.parent.right=null;
                                            
                                            temp2=root1.parent.parent;
                                            if(temp2.parent!=null)
                                            {
                                                root1.parent.parent=temp2.parent;
                                                
                                               // System.out.println(root1.parent.parent.name+" "+root1.parent.name+" piyush");
                                                if(root1.parent.parent.name.compareTo(root1.parent.name)>0)
                                                root1.parent.parent.left=root1.parent;
                                                else
                                                    root1.parent.parent.right=root1.parent;
                                            }
                                            else
                                                 {
                                                     if(b1)
                                                     System.out.println("piyushgupta----------3");
                                                     else
                                                        System.out.println("piyushgupta----------4");  
                                                     System.out.println("root "+root.name+" piyush"+key);
                                                     root=root1.parent;
                                                    // System.out.println("root "+root.name);
                                                    root1.parent.parent=null;}
                                            
                                            root1.parent.left.parent=root1.parent;
                                            
                                            root1.parent.b=false;
                                            root1.parent.left.b=true;
                                        }
                                }

                        }                     /* temp=root;
                                                root=root1;
                                                System.out.printf(root.name+" red ");
                                                if(root.left!=null)
                                                    System.out.printf(root.left.name+" left");
                                                if(root.right!=null)
                                                     System.out.printf(root.right.name+" right");
                                                System.out.println();
                                                
                                                root=root1.parent;
                                                System.out.printf(root.name+" red ");
                                                if(root.left!=null)
                                                    System.out.printf(root.left.name+" left");
                                                if(root.right!=null)
                                                     System.out.printf(root.right.name+" right");
                                                System.out.println();
                                                
                                                root=root1.parent.right;
                                                 System.out.printf(root.name+" red ");
                                                if(root.left!=null)
                                                    System.out.printf(root.left.name+" left");
                                                if(root.right!=null)
                                                     System.out.printf(root.right.name+" right");
                                                  /* temp=root;
                                                root=root1;
                                                System.out.printf(root.name+" red ");
                                                if(root.left!=null)
                                                    System.out.printf(root.left.name+" left");
                                                if(root.right!=null)
                                                     System.out.printf(root.right.name+" right");
                                                System.out.println();
                                                
                                                root=root1.parent;
                                                System.out.printf(root.name+" red ");
                                                if(root.left!=null)
                                                    System.out.printf
                                                System.out.println();

                    root=temp;*/
                    //System.out.println(root1.name);
                 
                     if(root1.parent==null  )
                     {   
                     
                         
                        break;
                     }
                     else if(root1.parent.parent==null)
                         break;
                     
                }
                
                
                
                
                
            }
            
            root.b=false;
            //System.out.println(" ");
            //printrb (root);
            
                
    }
    
public void printrb(RedBlackNode<T,E> roota)
{
    if(roota==null)
        return;
    else
    {
        if(roota.b)
            {
                System.out.printf(roota.name +" Red " );
                if(roota.left!=null)
                    System.out.printf(roota.left.name +" left " );
                if(roota.right!=null)
                    System.out.printf(roota.right.name +" right " );
                if(roota.parent!=null)
                    System.out.printf(roota.parent.name +" parent " );
                System.out.println();
            }
        
        else
          
        {   
            System.out.printf(roota.name +" Black ");
             if(roota.left!=null)
                    System.out.printf(roota.left.name +" left " );
                if(roota.right!=null)
                    System.out.printf(roota.right.name +" right " );
                if(roota.parent!=null)
                    System.out.printf(roota.parent.name +" parent " );
                  System.out.println();
             
        }  
        
        printrb(roota.left);
        printrb(roota.right);
    }
}
   
    public RedBlackNode<T, E> search(T key) 
    {
        
        RedBlackNode root1=new RedBlackNode();
        RedBlackNode root2=new RedBlackNode();
        root1=root;
        if(root==null)
            return root2;
        else
        {
            while(root1!=null)
                {
                    if(root1.name!=null)
                    {
                     
                        //int a=root1.name.compareTo(key);
                           //System.out.println(root1.name+" "+key+" "+a);
                        if(root1.name.compareTo(key)==0)
                        {
                           // System.out.println("piyush");
                            return root1;
                        }
                        else 
                        {
                            
                                if(root1.name.compareTo(key)>0)
                                    {
                                        root1=root1.left;
                                    }
                                else
                                    {
                                        root1=root1.right;
                                    }
                        }
                    }
                }
            
            return root2;
        }
    }
}