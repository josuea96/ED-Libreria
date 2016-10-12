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
public class NodeC <T>{
    //Atributos
    public NodeC next;
    T data;
    
    //Metrodos
    
    //Constructor con dato
    public NodeC (T data){
        this.data = data;
        this.next = null;
    }
    
    //Constructor Nulo
    public NodeC(){
        this.data = null;
        this.next = null;
    }
    
    //Getters and Setters
    public T getData(){
        return this.data;
    }
    
    public void setData(T d){
        this.data = d;
    }
}
