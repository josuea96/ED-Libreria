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
public class circularListClass <T> extends NodeC{
    //Atributos
    public NodeC pivot;
    
    //Constructor
    public circularListClass(){
        pivot = null;
    }
    
    //Métodos
    public void insert(T data){
        //Creamos nuestro nodo a insertar
        NodeC node = new NodeC(data);
        if(!isEmpty()){//Si no está vacia la lista
            //Insertamos el nodo al inicio y recorremos los nodos
            node.setNext(pivot);
            findLast().next = node;
            pivot = node;
        }
        else{//Si la lista esta vacia
            pivot = node;
            node.setNext(pivot);
        }
    }
    
    public boolean isEmpty(){
        return pivot == null;
    }
    
    private NodeC findLast(){//Se esta creando un metodo que sera utilizado en el metodo de
        //insertar un nodo para de esta forma ubicar el ultimo nodo y que apunte al nodo creado
        NodeC aux = pivot;//Empezamos por crear un apuntador auxiliar que este apuntando
        //a nuestro pivote
        do{//Entramos a un ciclo en donde empezaremos a recorrer nuestra lista
            aux = aux.getNext();
        } 
        while(aux.getNext() != pivot);//Todo esto mientras que lo que sigue no este apuntando a pivote
        //Esto nos sirve para ubicar el ultimo nodo, ya que el ultimo nodo siempre esta apuntando al nodo
        //en donde el pivote esta apuntando
        return aux;
    }
    
    public boolean deleteNode(T data){
        NodeC a1 = searchNode(data); //Creamos un nodo apuntando a la información buscada.
        NodeC a2 = a1; //Creamos un segundo nodo para así usarlo para buscar el nodo anterior.
        if (a1 == null) { //Si el nodo no existe.
            System.out.println("No se encontró el nodo.");//Manda un comentario
            return false;
        } 
        else{//De no ser así
            if (a1 == pivot) { //Si el nodo se encuentra en la primera posición, es decir en pivote.
                findLast().next = a1.next; //El apuntador del último nodo apuntará al apuntador del nodo.
                pivot = a1.next; //Pivote apuntara al apuntador del nodo. 
                a1.next = null; //El apuntador del nodo apuntara a nulo.
            } 
            else{//Si el nodo no sé encuentra en la primera posición.
                do {
                    a2 = a2.next;
                } while (a2.next!=a1);
                a2.next = a1.next; //El apuntador 2 apuntara al siguiente lugar del primer apuntador
                a1.next = null; //El apuntador 1 apuntara a nulo
            } return true;
        }
    }
    
    public NodeC searchNode(T data){//Se crea un metodo con el cual estaremos buscando
        //un dato que querramos encontrar en nuestra lista circular
        NodeC point = pivot;//creamos un puntero que este apuntando al pivote para ir
        //verificando nodo por nodo
        if(isEmpty()){
            System.out.println("La lista está vacia");//En caso de que la lista este vacia
            //Se desplegara un mensaje confirmando esto anterior
            return null;
        }
        else{//De lo contrario
            if(point.data == data){//Si se realiza una comparación entre el dato que esta en el nodo
                //apuntado y el dato que estamos intentando buscar en la lista
                return point;//Se regresa el valor del nodo y ahi termina nuestra busqueda
            }
            else{//Si lo contrario no se cumple quiere decir que no se encuentra en el pivote y
                point = point.getNext();//se necesita mover el puntero para ir verificando valor por valor
                while(point.data != data && point != pivot){//El puntero se va recorriendo mientras se cumplan dos condiciones
                    //si el valor del puntero es diferente al valor que queremos encontrar y si no estamos en el pivote
                    point = point.getNext();
                }
                if(point.getData() == data){//Si el Apuntador encontro el dato, despliega el mensaje
                    //comunicando que el nodo se encuentra en la lista
                    System.out.println("El nodo esta disponible en el la lista");
                    return point;//Regresando de esta forma el valor que se encontro en el nodo apuntado
                }
                else{//En caso contrario, recorrio toda la lista y no encontro el número
                    //y de la misma forma, desplegara un mensaje comunicando que el valor no se encontró en
                    //la lista
                    System.out.println("El nodo no se encuentra disponible dentro de la lista");
                    return null;
                }
            }
        }
    }
    
    public void showList(){
        if(isEmpty()){
            System.out.println("La lista está vacia");
        }
        else{
            NodeC aux;
            aux = pivot;
            System.out.print("pivot == >");
            do{
                System.out.print(" [ " + aux.getData() + " ] ==>");
                aux = aux.next;
            } while(aux.next != pivot.next);
        }
    }
}
