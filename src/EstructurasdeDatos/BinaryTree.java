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
    
    public void insertNode(int data, NodeTree root){
        NodeTree node = new NodeTree(data);
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
                    insertNode(data,root.right);
                }
            }
            else{//Si no es mayor que raiz
                if(root.left == null){//Caso Base
                    root.left = node;
                }
                else{//Si tiene un elemento a la derecha, buscará por la
                    //derecha hasta encontrar un espacio
                    insertNode(data, root.left);
                }
            }
        }
        this.elements++;
    }
    
    public void eNode(){
        
    }
    
    public void searchNode(){
        
    }
    
    public boolean isEmpty(NodeTree root){
        return root.left == null && root.right == null;
    }
    
    public NodeTree getRoot(){
        return this.root;
    }
    
    public void height(){
        
    }
    
    public void eElements(){
        
    }
    
}