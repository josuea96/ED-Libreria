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
public class Queue <T>{
    
    //Atributos
    private Node first;
    private Node last;
    private int size;
    
    //Constructor
    public Queue(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    
    public Queue(T data) {
        insertLast(data);
    }
    
    //Métodos
    
    /**
     * 
     * @param data 
     */
    public void insertLast(T data){
        Node node = new Node(data);
        if(isEmpty()){
            this.first = node;
            this.last = node;
        }
        else{
            node.setNext(node);
            last = node;
        }
        ++this.size;
    }
    
    public boolean isEmpty(){
        return first == null;
    }

    public Object getFirst() {
        return first.getData();
    }
    
    public void deleteFirst(){
        Node temp;
        if(isEmpty()){
            System.out.println("La lista esta vacia y no se puede borrar el primero");
        }
        else{
            temp = last;
            while(temp.getNext()!=first){
                temp = temp.getNext();
            }
            temp.setNext(null);
            first = temp;
            --this.size;
        }
    }
    
    public void setEmpty(){
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    

    public int getSize() {
        return size;
    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public Node getLast() {
        return last;
    }

    public void setLast(Node last) {
        this.last = last;
    }
}