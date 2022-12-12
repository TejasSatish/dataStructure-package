package dataStructure;
/**
 * 
 * 
 * @author Tejas Satish
 * 
 * 
 */
public class MaxHeap<T extends Comparable<T>>{
    class Node{
        T data;
        Node left;
        Node right;

        public Node(T data){
            this.data=data;
        }
        public Node(){

        }
    }
    private Node root=null;
    private int size=0;

    public void insert(T data){
        size++;
        root=insertRecursively(root,data);
        inorder();
        System.out.println(" ");
        root=heapify(root);
        inorder();
        System.out.println(" ");
    }
    private Node insertRecursively(Node root, T data){
        if(root==null){
            root=new Node(data);
        }else if(root.left==null){
            root.left=insertRecursively(root.left, data);
        }else if(root.left!=null && root.right==null){
            root.right=insertRecursively(root.right, data);
        }else if(root.left!=null && root.right!=null){
            if(isEmpty(root.left) && isEmpty(root.right)){
                root.left=insertRecursively(root.left, data);
            }else if(!isEmpty(root.left) && isEmpty(root.right)){
                root.right=insertRecursively(root.right, data);
            }else{
                return root;
            }
        }
        return root;
    }

    private boolean isEmpty(Node root){
        if(root.left!=null && root.right!=null){
            return false;
        }
        return true;
    }
    //  * how compareTo works
    //  * +ve - curr obj > spec obj
    //  *  -ve - curr obj <spec obj
    //  *  0 - equal
    
    private Node heapify(Node root){
        if(root==null){
            return root;
        }
        Node l=root.left;
        Node r=root.right;
        l=heapify(l);
        r=heapify(r);
        Node temp=new Node();
        if(l!=null && r!=null){
            if((root.data.compareTo(r.data))<0 || (root.data.compareTo(l.data))<0){ // l or r greater than root
                if(l.data.compareTo(r.data)>0){ //l is greater than r 
                    temp.left=l.left;
                    temp.right=l.right;
                    l.left=root;
                    l.right=r;
                    root.left=temp.left;
                    root.right=temp.right;
                    return l;
                }else{  // r is greater than l
                    temp.left=r.left;
                    temp.right=r.right;
                    r.left=l;
                    r.right=root;
                    root.left=temp.left;
                    root.right=temp.right;
                    return r;
                }
            }
        }else if(l!=null && r==null){
            System.out.println("6666666");
            if((root.data.compareTo(l.data))<0){ // l is greater than root
                temp.left=l.left;
                temp.right=l.right;
                l.left=root;
                l.right=r;
                root.left=temp.left;
                root.right=temp.right;
                return l;
            }
        }else if(l==null && r!=null){
            if((root.data.compareTo(r.data))<0){ // r is greater than root
                temp.left=r.left;
                temp.right=r.right;
                r.left=l;
                r.right=root;
                root.left=temp.left;
                root.right=temp.right;
                return r;
            }
        }else{
        }
        return root;
    }


    public void inorder(){
        inorderRecursive(root);
    }
    private void inorderRecursive(Node root){
        if(root==null){
            return;
        }
        inorderRecursive(root.left);
        System.out.print(root.data+" ");
        inorderRecursive(root.right);
    }
}