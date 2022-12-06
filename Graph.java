package dataStructure;
/**
 * 
 * @author Tejas Satish
 * 
 */
import java.util.*;

public class Graph<T> {
    private Map<T,LinkedList<T>> adjacencyList = new HashMap<T,LinkedList<T>>();

    static int Vcount=0;
    static int Ecount=0;

    /**
     * Adds vertex to the graph
     * @param data data of the vertex
     */
    public void addVertex(T data){
        adjacencyList.put(data, new LinkedList<T>());
        Vcount++;
    }

    /**
     * Adds edge to graph
     * @param source the source vertex
     * @param dest the destination vertex
     * @param bidirectional whether the edge is bidirectional or not
     * @throws Exception check LinkedList exceptions
     */
    public void addEdge(T source, T dest,boolean bidirectional)throws Exception{
        try {
            if(!adjacencyList.containsKey(source)){
                addVertex(source);
            }
            if(!adjacencyList.containsKey(dest)){
                addVertex(dest);
            }
            adjacencyList.get(source).insertAtTail(dest);
            Ecount++;
            if(bidirectional==true){
                adjacencyList.get(dest).insertAtTail(source);
            }
        } catch (Exception e) {
            throw e;
        }
    }
    /**
     * Gives the number of vertices present in the grapph
     * @return
     */
    public int countVertices(){
        return Vcount;    
    }
    /**
     * Gives the number of edges present in the graph
     * bidirectional edged only count as 1
     * @return
     */
    public int countEdges(){
        return Ecount;    
    }
    /**
     * Checks if vertex exists in the graph
     * @param data vertex
     * @return boolean
     */
    public boolean hasVertice(T data){
        return adjacencyList.containsKey(data);
    }
    /**
     * Checks if edge exists in the graph
     * @param src source vertex
     * @param dest destination vertex
     * @return boolean
     * @throws Exception check LinkedList exceptions
     */
    public boolean hasEdge(T src,T dest)throws Exception{
        try{
            return adjacencyList.get(src).has(dest) && adjacencyList.get(dest).has(src);
        }catch(Exception e){
            throw e;
        }
    }
    //learn how an adjacency list works
    //need to compare existing paths to find MST
    public LinkedList<T> findPath(T src, T dest)throws Exception{
        LinkedList<T> path= new LinkedList<T>();
        LinkedList<T> srcList=adjacencyList.get(src);
        int index=0;
        if(srcList.has(dest)){
            LinkedList<T> sliced=srcList.slice(dest);
            path.join(sliced);
            return path;
        }else{
            findPath(srcList.getNode(index++), dest);
        }
        return path;
    }

    
    
}
