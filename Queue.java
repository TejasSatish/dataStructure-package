package dataStructure;

/**
 * 
 * @author Tejas Satish
 * 
 */
public class Queue<T> {
    class Node{ //inner class
        T data;
        Node next=null;
        Node(T data){
            this.data=data;
        }
    }
    private Node front=null;
    private Node rear=null;
    private int size=0;
    /**
     * 
     * @param data data of node
     */
    public Queue(T data){
        Node new_node = new Node(data);
        front=new_node;
        rear=new_node;
        size++;
    }
    /**
     * 
     * @param data data of node
     */
    public void enqueue(T data){
        Node new_node=new Node(data);
        if(front==null){
            front=new_node;
            rear=new_node;
            size++;
        }else{
            rear.next=new_node;
            Node temp=new_node;
            rear=temp;
            size++;
        }
    }
    /**
     * 
     * @return data of element dequeue'd
     * @throws NullPointerException if queue is empty
     */
    public T dequeue()throws Exception{
        T data;
        try {
            if(front== null && rear==null){
                throw new NullPointerException("Underflows");
            }
            data=front.data;
            Node temp=front.next;
            front=temp;
            size--;
            
        } catch (NullPointerException e) {
            throw e;
        }
        return data;
    }
 /**
  * 
  * @return size of queue
  * @throws NullPointerException if queue is empty
  */
    public int size()throws Exception{
        try {
            if(front==null && rear==null){
                throw new NullPointerException("Underflows");
            }
        } catch (NullPointerException e) {
            throw e;
        }
        return size;
    }
}
