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
}
