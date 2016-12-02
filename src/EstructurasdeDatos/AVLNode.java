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
public class AVLNode {
    
    int data, bf;
    AVLNode left, right;

    public AVLNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}