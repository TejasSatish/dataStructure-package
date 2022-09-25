package dataStructure;

/**
 *  SINGLY LINKED LIST
 *  METHODS:
 *  >void insertAtHead(T data) Inserts at head
 *  >void insertAtIndex(int data,T data) Creates Node with data, then inserts at index
 *  >void insertAtTail(T data) Inserts at tail
 *  >void delete(int index) deletes at index
 *  >T getNode(int index) returns data of node
 *  >int getIndexOf(T data) returns index of node with data, if node doesnt exist returns -1
 *  >int size() returns size of Linked List
 * 
 * 
 * AUTHOR:
 * Tejas Satish
 * 25/9/22
 */

public class LinkedList<T> {
    // Node class
    class Node{
        T data;
        Node next=null;
        public Node(T data){
            this.data=data;
            this.next=null;
        }
    }

    private Node head=null;
    private int size;

    public LinkedList(T data){
        head=new Node(data);
        size++;
    }

    /**INSERT FUNCTIONS
     * >at head
     * >at index
     * >at tail
     * */
    public void insertAtHead(T data)throws Exception{
        try{
            if(head==null){
                throw new NullPointerException("No head found");
            }
            Node new_node=new Node(data);
            Node temp=head;
            new_node.next=temp;
            head=new_node;
            size++;
        }catch(NullPointerException e){
            throw e;
        }
    }
    
    // overloading to accept both data and a Node itsef
    public void insertAtIndex(int index,T data)throws Exception{
        try {
            if(head==null){
                throw new NullPointerException("No head found");
            }
            if(index>=size){
                throw new ArrayIndexOutOfBoundsException("Index doesn't exist");
            }
            Node new_node=new Node(data);
            Node temp=head;
            //Node prev=temp;
            Node next=temp.next;            
            for(int i=0;i<index-1 && temp.next!=null;i++){
                //prev=temp;
                temp=temp.next;
                next=temp.next;
            }
            new_node.next=next;
            temp.next=new_node;
            size++;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        } catch (NullPointerException e) {
            throw e;
        }
    }

    public void insertAtTail(T data)throws Exception{
        try {
            if(head==null){
                throw new NullPointerException("No head found");
            }
            Node new_node=new Node(data);
            Node temp=head;            
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=new_node;
            size++;
        } catch (NullPointerException e) {
            throw e;
        }
    }
    
    //deletes at index
    public void delete(int index)throws Exception{
        try{
            if(head==null){
                throw new NullPointerException("No head found");
            }
            if(index>=size){
                throw new ArrayIndexOutOfBoundsException("Index doesn't exist");
            }
            Node temp=head;
            Node prev=head;
            Node next=temp.next;
            if(index==0){
                temp=null;
                prev=null;
                head=next;
                size--;
            }else{
                for(int i=0;i<index && temp.next!=null;i++){
                    prev=temp;
                    temp=temp.next;
                    next=temp.next;
                }
                prev.next=next;
                size--;
            }
        }catch(ArrayIndexOutOfBoundsException e){
            throw e;
        }catch(NullPointerException e){
            throw e;
        }
    }

    public T getNode(int index)throws Exception{
        Node node=head;
        try{
            if(head==null){
                throw new NullPointerException("No head found");
            }
            if(index>=size){
                throw new ArrayIndexOutOfBoundsException("Index doesn't exist");
            }
            node=head;
            for(int i=0;i<index;i++){
                node=node.next;
            }
        }catch(ArrayIndexOutOfBoundsException e){
            throw e;
        }catch(NullPointerException e){
            throw e;
        }
        return node.data;
    }

    //returns node with data. If no such node, returns null
    public int getIndexOf(T data)throws Exception{
        Node node=null;
        int index=0;
        try{
            if(head==null){
                throw new NullPointerException("No head found");
            }
            if(index>=size){
                throw new ArrayIndexOutOfBoundsException("Index doesn't exist");
            }
            node=head;
            for(index=0;index<size;index++){
                if(node.data==data){
                    break;
                }
                node=node.next;
            }
        }catch(ArrayIndexOutOfBoundsException e){
            throw e;
        }catch(NullPointerException e){
            throw e;
        }
        if(node==null){
            return -1;
        }else{
            return index;
        }
    }

    //returns size of linked list
    public int size()throws Exception{
        try {
            if(head==null){
                throw new NullPointerException("No head found");
            }
        } catch (NullPointerException e) {
            throw e;
        }
        return size;
    }
}