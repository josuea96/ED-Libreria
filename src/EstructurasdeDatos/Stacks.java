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
public class Stacks <T>{
    //Atributos
    private NodeS top;
    private int size;
    
    //Contructor
    public Stacks(){
        this.top = null;
        this.size = 0;
    }
    
    //Getters
    /**
     * 
     * @return stack's top
     */
    public NodeS getTop(){
        return top;
    }
    
    /**
     * 
     * @return  stack's size
     */
    public int getSize(){//Método para obtener el tamaño de la pila
        return size;//Regresa size
    }
    
    public boolean isEmpty(){//Método para verificar si la pila esta vacia
        return top == null;//Se realiza una comparación para ver si top esta apuntando a null
        //o no
    }
    
    public void emptyStack(){//Método para vaciar la pila
        top = null;//Se apunta top a null para vaciarla
        size = 0;//Se regresa el tamaño de la pila a cero
    }

    public void setTop(NodeS top){
        this.top = top;
    }

    public void setSize(int size){
        this.size = size;
    }
    
    /**
     * Introduce un nuevo elemento a la pila
     * @param data node's info 
     */
    public void push(T data){
        NodeS node = new NodeS(data);//Crea un nodo que contenga como parametro el dato
        //del mismo
        if (isEmpty()){//Primero hay que verificar si la pila no esta vacia, si esta vacia
            top = node;//El nodo creado va a ser apuntado por el top
        }
        else{//Si la pila no está vacía
            node.setNext(top);//El nuevo nodo va a apuntar a donde esta apuntando el apuntador top
            //eso significa que apuntara al nodo a quien top esta apuntando
            top = node;//El apuntador top se mueve de lugar ya que nose borrara ningun nodo, y apunta
            //al nodo que se esta agregando
        }
        ++size;//Como se agrego un dato, la pila incrementa en 1
    }
    
    /**
     * Elimina un elemento de la pila
     */
    public void pop(){//Método para ir sacando dato por dato de la pila
        if (!isEmpty()){//Se realiza un ciclo if para ver si la pila no esta vacia, si no lo está
            top.setNext(top);//El apuntador top apunta al siguiente nodo
            --size;//Y se reduce el tamaño de la pila en 1
        }
        else{//De no ser así
            System.out.println("La pila está vacia");//Se despliega un mensaje para mencionar
            //que la pila se encuentra vacia
        }
    }
    
    public void showStack(){//Método para mostrar la pila
        if(!isEmpty()){//Se hace una verificación de si la pila no esta vacia
            NodeS aux = top;//De ser ese el caso, se crea un apuntador auxiliar que este apuntando a top
            do{//Se adentra en un ciclo para sacar los datos de la pila
                System.out.println(aux.getData());//Empieza a imprimir los datos de la pila
                System.out.println("|");
                System.out.println("V");
                aux = aux.getNext();//Cuando el dato se imprime se mueve la posición de aux en 1
            }while(aux != null);//El ciclo sigue y termina hasta que aux no este apuntando a null
                System.out.println("null");
        }
        else{//Si la pila se encuentra vacia, se imprime un mensaje
            System.out.println("la pila esta vacia");
        }
    }
}