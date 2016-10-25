/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EstructurasdeDatos;

/**
 *
 * @author josuealexis96
 * @param <T>
 */
public class doubleLnkList<T> {
    //Atributos
    NodeDL first;
    NodeDL last;
    
    //Métodos
    
    /**
     * Este método inserta un nodo al inicio de la lista
     * @param data es de tipo genérico y contiene la información importante
     */
    public void insertFirst(T data){
        //Creamos nuestro nodo
        NodeDL node = new NodeDL (data);
        //SI la lista esta vacía
        if (isEmpty()){
            this.first = node;
            this.last = node;
        }
        else{//Si la lista tiene elementos
            node.setNext(first);//El apuntador "SIGUIENTE" del nuevo nodo, apunta al primer nodo de la lista
            first.setPrev(node);//El apuntador "ANTERIOR" del primer nodo de la lista apunta al nuevo nodo
            first = node;//El apuntador first (que es atributo de la lista) es igual al nodo creado
        } 
    }
    
    /**
     * Metodo en donde insertaremos un nodo en la ultima posición
     * @param data 
     */
    public void insertLast(T data){
        //Creamos nuestro nodo
        NodeDL node = new NodeDL (data);
        //SI la lista esta vacía
        if (isEmpty()){
            this.first = node;
            this.last = node;
        }
        else{//Si la lista tiene elementos
            node.setPrev(last);//El apuntador "ANTERIOR" del nuevo nodo, apunta al ultimo nodo de la lista
            last.setNext(node);//El apuntador "SIGUIENTE" del ultimo nodo de la lista apunta al nuevo nodo
            last = node;//El apuntador last (que es atributo de la lista) es igual al nodo creado
        } 
    }
    
    public boolean isEmpty(){
        return first == null && last == null;
    }
    
    /**
     * 
     * @param data
     * @return 
     */
    public NodeDL searchNode(T data){
        NodeDL aux;
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
    
    public void showList(){//Método para mostrar la lista
        if(!isEmpty()){//Se verifica si la lista no vacia
            NodeDL point;//Se crea un puntero
            point = (NodeDL) first;//Y se iguala a primero para empezar a recorrer el arreglo
            System.out.print("☠ ");
            while(point != null){//Si la ubicación en donde esta el puntero es diferente de null
                System.out.print("<==" + " [ " + point.data + " ] " + " ==> ");//Se imprime el dato encontrado en el nodo
                point = point.getNext();//Se recorre la posición del puntero en 1
            }
            System.out.print("☠");//Se imprime una calavera para indicar que es null
        }
        else{
            System.out.println("La lista esta vacia");//Si la lista esta vacia se imprime un mensaje
            //indicando que esta vacia
        }
    }
    
    public void showInvertList(){
        if(!isEmpty()){//Se verifica si la lista no vacia
            NodeDL point;//Se crea un puntero
            point = (NodeDL) last;//Y se iguala a last para empezar a recorrer desde el ultimo nodo hasta el primero
            System.out.print("☠ ");
            while(point != null){//Si la ubicación en donde esta el puntero es diferente de null
                System.out.print("<==" + " [ " + point.data + " ] " + " ==> ");//Se imprime el dato encontrado en el nodo
                point = point.prev;//Se recorre la posición del puntero 1 lugar a la izquierda
            }
            System.out.print("☠");//Se imprime una calavera para indicar que es null
        }
        else{
            System.out.println("La lista esta vacia");//Si la lista esta vacia se imprime un mensaje
            //indicando que esta vacia
        }
    }
    
    /**
     * 
     * @param data
     * @return 
     */
    public boolean eNode(T data){//Se crea un método para borrar un nodo en especifico
        NodeDL aux = searchNode(data);//Se crea nodo que se utiliza para guardar el valor
        //del dato que se desea buscar en el nodo usando el metodo searchNode
        if (aux==null){//Si al recorrer los nodos, el auxiliar llega hasta el valor null
            //significa que no se encontro el nodo
            System.out.println("No se encontró el nodo");//y por este motivo se manda un mensaje
            //notificando que el nodo no se encontró
            return false;//regresando así un valor boolean falso
        }
        else{
            if(aux == first){//Si al comparar el auxiliar con el primer nodo y exitosamente es el nodo
                //que se esta buscando
                eNodeFirst();//Se elimina el primer nodo
            }
            else if(aux == last){//Si al comparar el auxiliar con el ultimo nodo y exitosamente es el nodo
                //que se esta buscando
                    eNodeLast();//Se elimina el ultimo nodo
            }
            else{
                aux.prev.next = aux.getNext();
                aux.next.prev = aux.getPrev();
            }
            return true;
        }
    }
    
    public void eNodeFirst(){
        //movemos al apuntador first al siguiente nodo y el previo de este lo ponemos el null
        first = first.getNext();
        //first.prev = null;
        first.setPrev(null);
    }
    
    public void eNodeLast(){
        //movemos al apuntador last al nodo anteriory el next de este ultimo
        //last.prev.next = null;
        //last = last.prev;
        last = last.getPrev();
        last.setNext(null);
    }
    
    public void eList(){//Se crea un método que sirve para eliminar la lista y
        first = null;//el puntero que apunta al primer nodo (primero) apunta al valor null
        //para que de esta forma no tome en cuenta los demas nodos y la lista quede vacia
    }

    public NodeDL getFirst() {
        return first;
    }

    public void setFirst(NodeDL first) {
        this.first = first;
    }

    public NodeDL getLast() {
        return last;
    }

    public void setLast(NodeDL last) {
        this.last = last;
    }
}