package dataStructure;

/**
 * 
 * @author Tejas Satish
 * 
 */

public class BST<T extends Comparable<T>> {

    class Node{
        T data;
        Node left=null;
        Node right=null;
        Node(T data){
            this.data=data;
        }
    }

    Node root=null;

    /**
     * Adds node to BST
     * @param data data of element
     */

    public void add(T data){
        root=addRecursive(root, data);
    }
    /**
     * Searches if node with data exists
     * @param data data of element
     * @return boolean
     */
    public boolean search(T data){
        root=searchRecursive(root, data);
        if(root==null){
            return false;
        }else{
            return true;
        }
    }
    /**
    *  Deletes node with data, balances the subtree
    * @param data data of element to be deleted
    * @throws NullPointerException if underflows
    */
    public void delete(T data)throws Exception{
        try {
            if(root==null){
                throw new NullPointerException("Underflows");
            }

            root=deleteRecursive(root, data);
        } catch (NullPointerException e) {
            throw e;
        }
    }
    /**
     *  Finds maximum element 
     * @return data of max node
     */
    public T max(){
        return maximum(root);
    }
    /**
     *  Finds minimum element 
     * @return data of min node
     */
    public T min(){
        return minimum(root);
    }
    /**
     * Prints the tree in inorder
     */
    public void preorder(){
        preorderRecursive(root);
    }   
    /**
     * Prints the tree in inorder
     */
    public void inorder(){
        inorderRecursive(root);
    }   
    /**
     * Prints the tree in postorder
     */
    public void postorder(){
        postorderRecursive(root);
    }   
    //  * how compareTo works
    //  * +ve - curr obj > spec obj
    //  *  -ve - curr obj <spec obj
    //  *  0 - equal


    //BST helper classes
    private Node addRecursive(Node root,T data){
        if(root==null){
            root=new Node(data);
            return root;
        }else if(data.compareTo(root.data)>0){
            root.right=addRecursive(root.right, data);
        }else if(data.compareTo(root.data)<0){
            root.left=addRecursive(root.left, data);
        }
        return root;
    }

    private Node searchRecursive(Node root,T data){
        if(root==null||root.data==data){ //base case
            return root; 
        }else if(data.compareTo(root.data)>0){ //recursively searches right
            return root.right=searchRecursive(root.right, data); 
        }
        return root.left=searchRecursive(root.left, data); //recursively searches left
    }

    private Node deleteRecursive(Node root,T data){
        if(root==null){
            return root;
        }else if(data.compareTo(root.data)>0){
            root.right=deleteRecursive(root.right, data);
        }else if(data.compareTo(root.data)<0){
            root.left=deleteRecursive(root.left, data);
        }else{
            if(root.left==null){ //only has right child
                return root.right;
            }else if(root.right==null){//only has left child
                return root.right;
            }else{ //has both children
                root.data=minimum(root.right);
                root.right=deleteRecursive(root.right,root.data);
            }
        }
        return root;
    }

    private void preorderRecursive(Node root){
        if(root==null){
        }else{
            System.out.print(root.data+" ");
            preorderRecursive(root.left);
            preorderRecursive(root.right);
        }
    }

    private void inorderRecursive(Node root){
        if(root==null){
        }else{
            inorderRecursive(root.left);
            System.out.print(root.data+" ");
            inorderRecursive(root.right);
        }
    }

    private void postorderRecursive(Node root){
        if(root==null){
        }else{
            postorderRecursive(root.left);
            postorderRecursive(root.right);
            System.out.print(root.data+" ");
        }
    }

    private T minimum(Node root){ //checks left subtree and returns min
        T min=root.data;
        while(root.left!=null){
            min=root.left.data;
            root=root.left;
        }
        return min;
    }

    private T maximum(Node root){ //checks left subtree and returns max
        T max=root.data;
        while(root.right!=null){
            max=root.right.data;
            root=root.right;
        }
        return max;
    }
}
