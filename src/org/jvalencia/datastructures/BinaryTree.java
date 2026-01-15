package org.jvalencia.datastructures;

public class BinaryTree {
    private TreeNode root; // La raíz es el punto de entrada al árbol

    public BinaryTree() {
        this.root = null;
    }

    // Metodo para insertar un dato buscando su lugar correcto
    public void insert(int data) {
        TreeNode newNode = new TreeNode(data);

        if (root == null) {
            // Caso 1: El árbol está vacío, el nuevo nodo es la raíz
            root = newNode;
        } else {
            // Caso 2: El árbol no está vacío, buscamos dónde ponerlo
            TreeNode current = root; // Empezamos en la raíz
            TreeNode parent;         // Necesitamos recordar al padre

            while (true) {
                parent = current;
                // Si el dato es menor, vamos a la izquierda
                if (data < current.data) {
                    current = current.left;
                    if (current == null) { // Encontramos un hueco
                        parent.left = newNode;
                        return;
                    }
                }
                // Si el dato es mayor o igual, vamos a la derecha
                else {
                    current = current.right;
                    if (current == null) { // Encontramos un hueco
                        parent.right = newNode;
                        return;
                    }
                }
            }
        }
    }

    // Metodo público para imprimir en orden (InOrder)
    public void inOrder() {
        inOrderRec(root);
        System.out.println("");
    }

    // Metodo recursivo privado para recorrer el árbol
    // Lógica: Izquierda -> Raíz -> Derecha
    private void inOrderRec(TreeNode localRoot) {
        if (localRoot != null) {
            inOrderRec(localRoot.left);        // Ir a la izquierda
            System.out.print(localRoot.data + " "); // Imprimir dato
            inOrderRec(localRoot.right);       // Ir a la derecha
        }
    }
}
