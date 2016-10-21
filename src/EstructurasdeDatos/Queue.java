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
     * Metodo en donde insertaremos un nodo en la ultima posición
     * @param data 
     */
    public void insertLast(T data){
        Node node = new Node(data);//Creamos un nodo que contenga un dato
        if(isEmpty()){//Se empieza por verificar si la lista esta vacia
            this.first = node;//De ser así, los apuntadores first y last apuntan
            //al nodo creado con anterioridad
            this.last = node;
        }
        else{//En caso contrario
            node.setNext(node);//El nodo esta apuntando
            last = node;//El apuntador cambia para apuntar al nuevo nodo
        }
        ++this.size;//Como se inserto un dato, el tamaño de la fila aumenta en 1
    }
    
    public boolean isEmpty(){//Método boolean para verificar si la pila esta o no esta vacia
        return first == null;//Se regresa una comparación de si first es igual a null
    }

    public Object getFirst() {
        return first.getData();
    }
    
    /**
     * Método para borrar el primer dato que se encuentra en la lista
     */
    public void deleteFirst(){
        Node temp;//Se inicia creando un apuntador temporal de tipo nodo
        if(isEmpty()){//Analizamos la fila para ver si esta vacia, si lo esta
            //ee despliega un mensaje diciendo que no se puede borrar nada porque no
            //hay nada en la fila
            System.out.println("La lista esta vacia y no se puede borrar el primero");
        }
        else{
            temp = last;//El apuntador temporal apunta al ultimo nodo
            while(temp.getNext()!=first){//Se va recorriendo de derecha a izquierda
                //y se detiene hasta que el siguiente nodo este siendo apuntado por
                //first
                temp = temp.getNext();
            }
            temp.setNext(null);//Cuando el siguiente nodo este siendo apuntado por first
            //Se declara que lo que sigue despues del apuntador temporal, sea null y no un nodo
            first = temp;//Se mueve el apuntador first a donde temporal esta apuntando
            --this.size;//Como se elimino un dato, se reduce el tamaño de la fila
        }
    }
    
    /**
     * Método para vaciar toda la fila
     */
    public void setEmpty(){//Los apuntadores se igualan a null mientras que las variables
        //que ocupan datos enteros, se igualan a 0 como en el caso del tamaño de la pila
        this.first = null;
        this.last = null;
        this.size = 0;
    }
    

    public int getSize() {//Método para obtener el tamaño de la pila
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