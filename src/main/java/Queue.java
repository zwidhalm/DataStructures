package main.java;

public class Queue {
    private class Node{
        private int data;
        private Node next;
        private Node(int data){this.data = data;}
    }

    private Node head;
    private Node tail;

    public void add(int data){
        Node newNode = new Node(data);

        if(tail != null){
            tail.next = newNode;
        }




    }
}
