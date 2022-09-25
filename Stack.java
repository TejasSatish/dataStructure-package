package dataStructure;

/**
 * 
 * @author Tejas Satish
 * 
 */
import java.util.NoSuchElementException;

public class Stack<T> {
    class Node {// inner class node
        T data;
        Node below=null;
        public Node(T data){
            this.data=data;
        }
    }
    private Node top=null;
    private int size;
    /**
     * 
     * @param data data of top node
     */
    public Stack(T data){
        top=new Node(data);
        size++;
    }
    /**
     * 
     * @param data data of node
     * @throws NullPointerException if head doesn't exist
     */
    public void push(T data)throws Exception{
        try {
            if(top==null){
                throw new NullPointerException("No top found");
            }
            Node new_node=new Node(data);
            Node temp=top;
            new_node.below=temp;
            top=new_node;
            size++;
        } catch (NullPointerException e) {
            throw e;
        }
    }
    /**
     * 
     * @return returns data of popped node
     * @throws NullPointerException if head doesn't exist
     */
    public T pop()throws Exception{
        T data=null;
        try {
            if(top==null){
                throw new NullPointerException("No top found");
            }
            data=top.data;
            Node node=top.below;
            top=node;
            size--;
        } catch (NullPointerException e) {
            throw e;
        }
        return data;
    }
    /**
     * 
     * @return data of top node
     * @throws NullPointerException if head doesn't exist
     */
    public T peek()throws Exception{
        T data=null;
        try {
            if(top==null){
                throw new NullPointerException("No top found");
            }
            data=top.data;
        } catch (NullPointerException e) {
            throw e;
        }
        return data;
    }
    /**
     * 
     * @param data data element to be searched
     * @return index of node with data
     * @throws NullPointerException if head doesn't exist
     * @throws NoSuchElementException if specified data element doesn't exist in stack
     */
    public int getIndexOf(T data)throws Exception{
        int index=0;
        Node node=null;
        try {
            node=top;
            if(top==null){
                throw new NullPointerException("No top found");
            }
            for(index=0;index<size;index++){
                if(node.data==data){
                    break;
                }
                node=node.below;
            }
            if(node==null){
                throw new NoSuchElementException("Element specified doesn't exist");
            } 
        } catch (NullPointerException e) {
            throw e;
        } catch (NoSuchElementException e) {
            throw e;
        }
            return index;
    }
    
    public int size()throws Exception{
        try{
            if(top==null){
                throw new NullPointerException("No top found");
            }
        }catch(NullPointerException e){
            throw e;
        }
        return size;
    }
}
