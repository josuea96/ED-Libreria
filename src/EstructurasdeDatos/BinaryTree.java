//Josué Alexis Ramírez Pérez 513622 4º Semestre
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
public class BinaryTree{
    NodeTree root;
    int height;
    int elements;
    
    public BinaryTree(){
        this.root = null;
        this.height = -1;
        this.elements = 0;
    }
    
    public void addNode(int data){
        NodeTree node = new NodeTree(data);
        if(root == null){
            System.out.println("Esta lista esta vacia");
        }
        else{
            this.insertNode(node, this.root);
        }
    }
    
    public void insertNode(NodeTree node, NodeTree root){
        if(isEmpty()){
            root = node;
            height++;
        }
        else{//Si no está vacio
            //Si el nodo es mayor que raiz
            if(node.data >= root.data){
                //Si no tiene elementos a la izquierda
                if(root.right == null){//Caso Base
                    root.right = node;
                }
                else{//Si tiene un elemento a la izquierda
                    //Buscará por la izquierda hasta encontrar un espacio.
                    insertNode(node,root.right);
                }
            }
            else{//Si no es mayor que raiz
                if(root.left == null){//Caso Base
                    root.left = node;
                }
                else{//Si tiene un elemento a la derecha, buscará por la
                    //derecha hasta encontrar un espacio
                    insertNode(node, root.left);
                }
            }
        }
    }
    
    public void eNode(){
        
    }
    
    public void searchNode(){
        
    }
    
    public boolean isEmpty(){
        //return root.left == null && root.right == null;
        return root == null;
    }
    
    public NodeTree getRoot(){
        return this.root;
    }
    
    public void height(){
        
    }
    
    public int getElements(){
        return this.elements;
    }
    
    /**
     * Método para recorrer el arbol en InOrden
     * @param root 
     */
    public void inorden(NodeTree root){//Metodo para hacer el inorden
        if(root != null){
            inorden(root.right);//El puntero raiz se movera por la izquierda hasta encontrar un nulo
            System.out.print(root.data + " ");
            //Se imprime lo que se encuentra en la raiz
            inorden(root.left);//El puntero raiz se movera por la derecha hasta encontrar un nulo
        }
        /*else{
            System.out.println("El arbol se encuentra vacio");
        }
        */
    }
    
    public void postorden(NodeTree root){//Metodo para hacer el inorden
        if(root != null){
            inorden(root.left);//El puntero raiz se movera por la izquierda hasta encontrar un nulo
            inorden(root.right);//El puntero raiz se movera por la derecha hasta encontrar un nulo
            System.out.print(root.data + " ");
            //Se imprime lo que se encuentra en la raiz
        }
        /*else{
            System.out.println("El arbol se encuentra vacio");
        }
                */
    }
    
    public void preorden(NodeTree root){//Metodo para hacer el inorden
        if(root != null){
            System.out.print(root.data + " ");
            inorden(root.left);//El puntero raiz se movera por la izquierda hasta encontrar un nulo
            inorden(root.right);//El puntero raiz se movera por la derecha hasta encontrar un nulo
            //Se imprime lo que se encuentra en la raiz
        }
        /*else{
            System.out.println("El arbol se encuentra vacio");
        }
                */
    }
    
    public void deleteNode(int data){    
        if(searchNode(data, root) == null){ // si no se encontro el dato
            System.out.println("El nodo que busca no existe dentro del arbol");
        } else { //si se encontro el dato
            NodeTree aux = searchNode(data, root); //se crea un auxiliar 
            if(aux.right == null && aux.left == null){ //si no tiene "hijos"
                aux = null; //simplemente se borra
           } else { //si tiene "hijos"
                if(aux.right != null && aux.left != null){ //si tiene dos "hijos"
                    aux = aux.right; //el de la derecha se pasa al "centro"
                    aux.right = null; //se borra el nodo de la derecha
                } else { // si solo tiene un "hijo"
                    if(aux.right != null){ //si el "hijo" esta a la derecha
                        aux = aux.right; // el de la derecha se pasa al centro
                        aux.right = null;
                    } else { 
                        if(aux.left != null){ // si el "hijo" esta a la izquierda
                            aux = aux.left;
                            aux.left = null;
                        }
                    }
                }
            }
        }
        this.elements --; // el numero de elementos disminuye en 1
    }
    
    public  NodeTree searchNode(int data, NodeTree root){
        if(!isEmpty()){ // si no esta vacio el arbol
            if(root.data == data){ //checa si la raiz actual es el dato que se esta buscando
                return root;  //entonces devuelve el dato
            } else { //si no es, entonces checa
                if(root.data >= data && root.right != null){ //si el dato es menor que la raiz
                   // root = root.right; 
                    searchNode(data, root.right); // entonces va a buscar por la derecha
                } else {
                    if(root.data <= data && root.left != null){ //si el dato es mayor que la raiz
                        //root = root.left;
                        searchNode(data, root.left); //busca entonces por la izquierda
                    }
                } 
            } 
        }
        return null;
    }
}