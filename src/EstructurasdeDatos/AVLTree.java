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
public class AVLTree {
    private AVLNode root;
    
    //Constructor
    
    public AVLTree() {       
        this.root = null;
    }
    
    //Buscar nodo
    
    public AVLNode fetch (int d, AVLNode r){
        if (root == null){//No hay nodos
            return null;
        }else if (root.data == d){//Si el dato que buscamos esta en raiz
            return root;
        }else if (root.data < d){//Si el dato es mayor que la raiz
            return fetch (d, r.right);//Lo buscamos por la derecha
        }
        else{
            return fetch (d,r.left);//Lo buscamos por la izquierda
        }
    }

    //Obtener factor de balance
    public int getBF(AVLNode node){
        if(node == null){
            return -1;
        }else{
            return node.bf;
        }
    }
    
    //Recaulcular factor de balance
    public int calcBF(AVLNode node){
        return Math.max(getBF(node.left), getBF(node.right)) + 1;
    }
    
    //Rotación simple a la izquierda
    public AVLNode rightRotation (AVLNode r){
        //Declaramos un auxiliar
        AVLNode aux = r.left;
        r.left = aux.right;
        aux.right = r;
        r.bf = calcBF(r);
        aux.bf = calcBF(aux);
        return aux;
    }
    
    //Rotación simple a la derecha
    public AVLNode leftRotation (AVLNode r){
        //Declaramos un auxiliar
        AVLNode aux = r.right;
        r.right = aux.left;
        aux.left = r;
        r.bf = calcBF(r);
        aux.bf = calcBF(aux);
        return aux;
    }
    
    //Rotación doble a la izquierda
    public AVLNode dRightRotation (AVLNode r){
        AVLNode aux;
        r.left = rightRotation(r.left);
        aux = leftRotation(r);
        return aux;
    }
    
    //Rotación doble a la izquierda
    public AVLNode dLeftRotation (AVLNode r){
        AVLNode aux;
        r.right = leftRotation(r.right);
        aux = rightRotation(r);
        return aux;
    }
    
    //Insertar nodo ALV
    public AVLNode insertAVL (AVLNode n, AVLNode sr){
        AVLNode newDad = sr;//second root
        if(n.data < sr.data){
            if(sr.left == null){
                sr.left = n;
            }
            else{
                sr.left = insertAVL(n, sr.left);
                if(getBF(sr.left) - getBF(sr.right) == 2){
                    if(n.data < sr.left.data){
                        newDad = leftRotation(sr);
                    }
                    else{
                        newDad = dLeftRotation(sr);
                    }
                }
            }
        }else if(n.data > sr.data){
            if(sr.right == null){
                sr.right = n;
            }
            else{
                sr.right = insertAVL(n, sr.right);
                if((getBF(sr.right) - getBF(sr.left)) == 2){
                    if(n.data > sr.right.data){
                        newDad = rightRotation(sr);
                    }
                    else{
                        newDad = dRightRotation(sr);
                    }
                }
            }
        }
        else{
            System.out.println("El nodo está duplicado");
        }
        //Actualizar BF
        if(sr.left == null && sr.right != null){
            sr.bf = sr.right.bf + 1;
        }
        else if (sr.right == null && sr.left != null){
            sr.bf = sr.left.bf + 1;
        }
    }
}
