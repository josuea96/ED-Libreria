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
public class NodeS <T>{
    //Atributos
    private T data;
    private NodeS next;
    
    //fConstructor
    public NodeS (T data){
        this.data = data;
        this.next = null;
    }
    
    public void setData(T data){
        this.data = data;
    }
    
    public T getData(){
        return this.data;
    }
    
    public void setNext(NodeS n){
        this.next = n;
    }

    public NodeS getNext() {
        return next;
    }
}
