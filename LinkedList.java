package dataStructure;
 /**
  * @author Tejas Satish
  */

import java.util.NoSuchElementException;
public class LinkedList<T> {
    
    class Node{// inner class Node
        T data;
        Node next=null;
        public Node(T data){
            this.data=data;
            this.next=null;
        }
    }

    private Node head=null;
    private int size;
    private Node tail=null;
    /**
     * 
     * @param data data of head node
     */
    public LinkedList(T data){
        head=new Node(data);
        tail=head;
        size++;
    }

    /**
     * 
     * @param data data of node
     */
    public void insertAtHead(T data){
            Node new_node=new Node(data);
            if(head==null){
                head=new_node;
            }else{
                Node temp=head;
                new_node.next=temp;
                head=new_node;
                size++;
            }
    }
    
    /**
     * 
     * @param index index at which node is to ne inserted
     * @param data data of node
     * @throws NullPointerException if head doesn't exist
     * @throws ArrayIndexOutOfBoundsException if index doesn't exist
     */
    public void insertAtIndex(int index,T data)throws Exception{
        try {
            if(index>=size || index<0){
                if(index==0 && size==0){
                    
                }else{
                    throw new ArrayIndexOutOfBoundsException("Index doesn't exist");
                }
            }
            if(index==0){
                insertAtHead(data);
            }else if(index ==(size-1)){
                insertAtTail(data);
            }else{
                Node new_node=new Node(data);
                Node temp=head;
                //Node prev=temp;
                Node next=temp.next;            
                for(int i=1;i<index-1 && temp.next!=null;i++){
                    //prev=temp;
                    temp=temp.next;
                    next=temp.next;
                }
                new_node.next=next;
                temp.next=new_node;
                size++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw e;
        } catch (NullPointerException e) {
            throw e;
        }
    }
     /**
      * 
      * @param data data of node
      */
    public void insertAtTail(T data)throws Exception{
            Node new_node=new Node(data);
            tail.next=new_node;            
            tail=tail.next;
            size++;
    }
    
    /**
     * 
     * @param index index of node
     * @throws NullPointerException if head doesn't exist
     * @throws ArrayIndexOutOfBoundsException if index doesn't exist
     */
    public void delete(int index)throws Exception{
        try{
            if(head==null){
                throw new NullPointerException("Underflows");
            }
            if(index>=size || index<0){
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
    /**
     * 
     * @param index index of node
     * @return data held by node
     * @throws NullPointerException if head doesn't exist
     * @throws ArrayIndexOutOfBoundsException if index doesn't exist
     */
    public T getNode(int index)throws Exception{
        Node node=head;
        try{
            if(head==null){
                throw new NullPointerException("No head found");
            }
            if(index>=size || index<0){
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

    /**
     * 
     * @param data
     * @return
     * @throws NullPointerException if head doesn't exist
     * @throws ArrayIndexOutOfBoundsException if index doesn't exist
     * @throws NoSuchElementException if specified data element doesn't exist in list
     */
    public int getIndexOf(T data)throws Exception{
        Node node=null;
        int index=0;
        try{
            if(head==null){
                throw new NullPointerException("Underflows");
            }
            if(index>=size || index<0){
                throw new ArrayIndexOutOfBoundsException("Index doesn't exist");
            }
            node=head;
            for(index=0;index<size;index++){
                if(node.data==data){
                    break;
                }
                node=node.next;
            }
            if(node==null){
                throw new NoSuchElementException("Element specified doesn't exist");
            }
        }catch(ArrayIndexOutOfBoundsException e){
            throw e;
        }catch(NullPointerException e){
            throw e;
        }catch(NoSuchElementException e){
            throw e;
        }
            return index;
    }

    /**
     * 
     * @return size of the linked list
     * @throws NullPointerException if head doesn't exist
     */
    public int size()throws Exception{
        try {
            if(head==null){
                throw new NullPointerException("Underflows");
            }
        } catch (NullPointerException e) {
            throw e;
        }
        return size;
    }
}