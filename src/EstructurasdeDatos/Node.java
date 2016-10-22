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
public class Node <T> {
    T data;
    Node next;
    
    /**
     * Constructor
     * @param data 
     */
    public Node (T data){
        this.data = data;
        this.next = null;
    }
    
    public Node(){
        this.data = null;
        this.next = null;
    }

    public T getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}