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
public class NodeDL <T>{
    //Atributos
    NodeDL next;
    NodeDL prev;
    T data;
    
    public NodeDL (T data){
        this.data = data;
    }

    public NodeDL getNext() {
        return next;
    }

    public void setNext(NodeDL next) {
        this.next = next;
    }

    public NodeDL getPrev() {
        return prev;
    }

    public void setPrev(NodeDL prev) {
        this.prev = prev;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    
}
