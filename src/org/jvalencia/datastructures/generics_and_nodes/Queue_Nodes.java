package org.jvalencia.datastructures.generics_and_nodes;

    public class Queue_Nodes<T> {
        private Node<T> head; // Front
        private Node<T> tail; // Rear
        private int size;

        public Queue_Nodes() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public void enqueue(T data) {
            Node<T> newNode = new Node<>(data);
            if (isEmpty()) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        public T dequeue() {
            if (isEmpty()) return null;
            T data = head.data;
            head = head.next;
            if (head == null) tail = null;
            size--;
            return data;
        }

        public T peek() {
            return isEmpty() ? null : head.data;
        }

        public boolean isEmpty() {
            return head == null;
        }
    }


