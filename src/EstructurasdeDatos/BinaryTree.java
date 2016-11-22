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
        if(isEmpty(root)){
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
    
    public boolean isEmpty(NodeTree root){
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
}