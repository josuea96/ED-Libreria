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
public class Stacks <T>{
    //Atributos
    private NodeS top;
    private int size;
    
    //Contructor
    public Stacks(){
        this.top = null;
        this.size = 0;
    }
    
    //Getters
    /**
     * 
     * @return stack's top
     */
    public NodeS getTop(){
        return top;
    }
    
    /**
     * 
     * @return  stack's size
     */
    public int getSize(){
        return size;
    }
    
    public void setNext(){
        
    }
    
    public boolean isEmpty(){
        return top == null;
    }
    
    public void emptyStack(){
        top = null;
        size = 0;
    }

    public void setTop(NodeS top) {
        this.top = top;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    /**
     * Introduce un nuevo elemento a la pila
     * @param data node's info 
     */
    public void push(T data){
        NodeS node = new NodeS(data);
        if (isEmpty()){
            top = node;
        }
        else{//Si la pila no está vacía
            node.setNext(top); //node.next=top;
            top = node;
        }
        ++size;
    }
    
    /**
     * Elimina un elemento de la pila
     */
    public void pop(){
        if (!isEmpty()){
            //top = top.getNext();
            top.setNext(top);
            --size;
        }
        else{
            System.out.println("La pila está vacia");
        }
    }
    
    public void showStack(){
        if(!isEmpty()){
            NodeS aux = top;
            do{
                System.out.println(aux.getData());
                System.out.println("|");
                System.out.println("V");
                aux = aux.getNext();
            }while(aux != null);
                System.out.println("null");
        }
        else{
            System.out.println("la pila esta vacia");
        }
    }
}
