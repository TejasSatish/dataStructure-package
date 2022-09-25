package dataStructure;
public class Stack<T> {
    class Node {
        T data;
        Node below=null;
        public Node(T data){
            this.data=data;
        }
    }
    private Node top=null;
    private int size;

    public Stack(T data){
        top=new Node(data);
        size++;
    }


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
        } catch (NullPointerException e) {
            throw e;
        }
        if(node==null){
            return -1;
        }else{
            return index;
        }
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
