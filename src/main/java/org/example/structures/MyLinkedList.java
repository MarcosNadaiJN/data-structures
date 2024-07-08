package org.example.structures;

public class MyLinkedList<T> {
    public MyLinkedList() {
        this.head = null;
    }

    private Node<T> head;
    private int length = 0;

    public Node<T> getHead() {
        return this.head;
    }

    public Node<T> getLast(){
        Node<T> temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }

    public void insertAtBegin(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        length++;
    }

    public void insertAtEnd(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) { // If the head of the list is null, then this node, is the first one being inserted;
            head = newNode;
        } else {
            Node<T> current = head; // It creates a copy of the head, so it can iterate through the list, but preserve the actual head of the list;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode; // As soon as it finds a node where the "next" field is null, it means that we are at the end of the list, so we can set it as the newNode being added;
        }
        length++;
    }

    public void removeFromBegin() {
        Node<T> node = head;
        if (node != null) {
            head = node.next;
            node.next = null;
            length--;
        }
    }

    public void removeFromEnd(){
        Node<T> current = head;
        for(int i = 1; i < length - 1; i++) {
            current = current.next;
        }
        current.next = null;
        length--;
    }

    public Node<T> getAtPosistion(int position) {
        if(position <= 0) {
            return this.getHead();
        } else if (position >= length) {
            return this.getLast();
        } else {
            Node<T> current = head;
            for (int i = 1; i < position; i++) {
                current = current.next;
            }
            return current.next;
        }
    }

    public void insertAt(T data, int position) {
        if (position <= 0) {
            this.insertAtBegin(data);
        } else if (position >= length) {
            this.insertAtEnd(data);
        } else {
            Node<T> temp = head;
            for(int i = 1; i < position; i++) {
                temp = temp.next;
            }
            Node<T> newNode = new Node<>(data);
            newNode.next = temp.next;
            temp.next = newNode;
            length++;
        }
    }

    public void removeAt(int position){
        if(position <= 0) {
            this.removeFromBegin();
        } else if (position >= length) {
            this.removeFromEnd();
        } else {
            Node<T> current = head;
            for (int i = 1; i < position; i++) {
                current = current.next;
            }
            Node<T> nodeToBeRemoved = current.next;
            current.next = nodeToBeRemoved.next;
            nodeToBeRemoved.next = null;
            length--;
        }
    }

    public static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}