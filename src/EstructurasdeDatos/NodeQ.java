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
public class NodeQ <T> {
    
    T data;
    Node next;
    
    /**
     * Constructor
     * @param data 
     */
    public NodeQ (T data){
        this.data = data;
        this.next = null;
    }
    
}
