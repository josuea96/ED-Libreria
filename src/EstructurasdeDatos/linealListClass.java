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
public class linealListClass <T>{
    private Node first;//Creación de los nodos que se usaran en las listas sencillas (primero y ultimo)
    private Node last;
    
    //Métodos
    
    /**
     * 
     * @param data 
     */
    public void insertFirst(T data){//Método para insertar 
        Node node = new Node(data);
        if(isEmpty()){//Si está vacia la lista
            first = node;//First apunta a nodo
            last = node;//Last apunta a nodo
        }
        else{//Si no está vacia la lista
            node.setNext(first);//El nodo va a apuntar a siguiente (donde se encuentra el puntero first)
            first = node;//El apuntador first va a apuntar al nuevo nodo
        }
    }
    
    private boolean isEmpty(){//Metodo para ver si la lista esta vacia
        return first == null;
    }
    
    public void empty(){
        first = null;
    }
    
    /**
     * 
     * @param data 
     */
    public void insertFinal(T data){//Método para insertar al final de la lista
        Node node = new Node(data);
        if((first != null) && (last != null)){//Si los apuntadores son diferentes de null
            last.setNext(node);//El last va a apuntar a siguiente (donde se encuentra el nodo)
            last = node;//Last apuntara al nuevo nodo
            node.setNext(null);//Lo que apuntara el nodo creado en el siguiente lugar, será a null
        }
        else{//Si no está vacia la lista
            first = node;
            node.setNext(last);
            last = node;
        }
    }
    
    public void showList(){//Método para imprimir la lista
        if(!isEmpty()){//Se verifica si la lista no esta vacia
            Node aux;//Creamos un puntero auxiliar
            aux = first;//Que se encontrara ubicado en el nodo que tiene el apuntador first
            while(aux != null){//Empieza un ciclo while para verificar si el apuntador
                //auxiliar no se encuentra en null y de no ser así
                //System.out.print("[ #" + aux.getData() + " ] -> ");//Se imprime el dato que se
                //encuentra en el puntero
                System.out.print(aux.getData());
                System.out.println("");
                aux = aux.getNext();//Y se va moviendo el puntero hasta llegar al final del arreglo
            }
            //System.out.println("☠");//Se imprime un simbolo haciendo referencia a null
        }
        else{//Si la lista se encuentra vacia, se imprime un mensaje mencionandolo
            System.out.println("La lista esta vacia");
        }
    }
    
    public Node searchNode(T data){
        Node aux;
        if(isEmpty()){//Si está vacío retorna falso
            return null;
        }
        else{//Si contiene elementos
            aux = first;//colocamos auxiliar al inicio de la lista
            while(aux.getData() != data && aux != last){//Mientras que no encuentre el dato, recorre la lista
                aux = aux.getNext();//Se recorre la lista
            }
            if(aux.getData() == data){//Si el dato que se encontró es igual al que se busca
                return aux;//regresa el dato auxiliar
            }
            else{
                return null;
            }
        }
    }
    
    public void eFirst(){
        setFirst(first.getNext());
    }
    
    public void eLast(){
        Node a = first;
        while (a.getNext().getNext() != null) {
            a = a.getNext();
        }
        setLast(a);
        getLast().setNext(null);
    }

    public boolean eNode(T data){
        if (isEmpty()){
            System.out.println("La lista está vacía.");
            return false;
        } 
        else{
            Node t, t2;
            t = first;
            t2 = null;
            if(getFirst().getData().equals(data)){
                eFirst();
                return true;
            } else if(getLast().getData().equals(data)){
                eLast();
                return true;
            } 
            else {
                while (t.getNext() != null && t.getNext().getData() != data && !data.equals(t.getNext().getData())){
                    t = t.getNext(); 
                }
                if (t.getNext()!=null && t.getNext().getData().equals(data)) {
                    t.setNext(t.getNext().getNext());
                    return true;
                }
                System.out.println("El dato no se encontró en la lista");
                return false;
            }
        }
    }
    
    public Node getFirst() {
        return first;
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