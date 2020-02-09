package main.java;

/*
Linked List Implementation. Could also be done as an Array

 */

public class Stack {
    private class Node{
        private int data;
        private Node next;
        private Node(int data){this.data = data;}
    }

    private Node head;

    public void push(int data){
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public int pop(){
        if(head == null){
            throw new IllegalStateException("Empty Stack");
        }

        int data = head.data;
        head = head.next;
        return data;

    }

    public int peek(){
        return head.data;
    }

    public boolean isEmpty(){
        return head == null;
    }

}
