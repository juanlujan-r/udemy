package org.jvalencia.datastructures;

public class TreeNode {
    public int data;       // Dato del nodo
    public TreeNode left;  // Hijo izquierdo (menores)
    public TreeNode right; // Hijo derecho (mayores)

        // Constructor
        public TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

