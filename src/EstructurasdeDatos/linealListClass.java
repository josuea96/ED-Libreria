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
public class linealListClass {
    private Node first;
    private Node last;
    
    //Métodos
    
    public void insertFirst(int n){
        Node node = new Node(n);
        if(isEmpty()){//Si está vacia la lista
            first = node;
            last = node;
        }
        else{//Si no está vacia la lista
            node.next = first;
            first = node;
        }
    }
    
    private boolean isEmpty(){
        return first == null;
    }
    
    public void insertFinal(int n){
        Node node = new Node(n);
        if(isEmpty()){//Si está vacia la lista
            first = node;
            last = node;
        }
        else{//Si no está vacia la lista
            last = node;
            first = node;
        }
    }
    
    public void showList(){
        if(!isEmpty()){
            Node aux;
            aux = first;
            while(aux.next != null){
                System.out.print("[ #" + aux.data + " ] -> ");
                aux = aux.next;
            }
        }
        else{
            System.out.println("La lista esta vacia");
        }
    }
}