/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasdeDatos;

/**
 *
 * @author josuealexis96
 */
public class Deque <T>{
    
    private NodeDL first;
    private NodeDL last;
    private int size;
    
    //Constructor

    public Deque() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    /**
     * Este método inserta un nodo al inicio de la lista
     * @param data es de tipo genérico y contiene la información importante
     */
    public void insertFirst(T data){
        //Creamos nuestro nodo
        NodeDL node = new NodeDL (data);
        //SI la lista esta vacía
        if (isEmpty()){
            this.first = node;
            this.last = node;
            ++size;
        }
        else{//Si la lista tiene elementos
            node.setNext(first);//El apuntador "SIGUIENTE" del nuevo nodo, apunta al primer nodo de la lista
            first.setPrev(node);//El apuntador "ANTERIOR" del primer nodo de la lista apunta al nuevo nodo
            first = node;//El apuntador first (que es atributo de la lista) es igual al nodo creado
            ++size;
        } 
    }
    
    /**
     * Metodo en donde insertaremos un nodo en la ultima posición
     * @param data 
     */
    public void insertLast(T data){
        //Creamos nuestro nodo
        NodeDL node = new NodeDL (data);
        //SI la lista esta vacía
        if (isEmpty()){
            this.first = node;
            this.last = node;
            ++size;
        }
        else{//Si la lista tiene elementos
            node.setPrev(last);//El apuntador "ANTERIOR" del nuevo nodo, apunta al ultimo nodo de la lista
            last.setNext(node);//El apuntador "SIGUIENTE" del ultimo nodo de la lista apunta al nuevo nodo
            last = node;//El apuntador last (que es atributo de la lista) es igual al nodo creado
            ++size;
        } 
    }
    
    public void eNodeFirst(){
        //movemos al apuntador first al siguiente nodo y el previo de este lo ponemos el null
        first = first.getNext();
        //first.prev = null;
        first.setPrev(null);
        --size;//Se le resta size en 1 ya que quitamos un nodo de la lista
    }
    
    public void eNodeLast(){
        //movemos al apuntador last al nodo anteriory el next de este ultimo
        //last.prev.next = null;
        //last = last.prev;
        last = last.getPrev();
        last.setNext(null);
        --size;//Se le resta size en 1 ya que quitamos un nodo de la lista
    }
    
    public Object getFirst() {
        return first.getData();
    }
    
    public Object getLast(){
        return last.getData();
    }
    
    public boolean isEmpty(){
        return first == null && last == null && size == 0;
    }
    
    public void eList(){
        first = null;
        size = 0;
    }
    
    public int getSize(){
        return size;
    }

    public void setFirst(NodeDL first) {
        this.first = first;
    }

    public void setLast(NodeDL last) {
        this.last = last;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
}
