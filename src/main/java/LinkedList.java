package main.java;

public class LinkedList {
    class Node{
        private int data;
        private Node next;

        public Node(int data){
            this.data = data;

        }

        private Node head;

        public int getFirst(){
            return head.data;
        }

        public int getLast(){
            if(head.next == null){
                return head.data;
            }
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            return current.data;

        }

        public void addFront(int data){
            Node newNode = new Node(data);
            if(head == null){
                head = newNode;
            }

            newNode.next = head;
            head = newNode;
        }

        public void addBack(int data){
            Node newNode = new Node(data);
            if(head.next == null){
                head.next = newNode;
            }
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }

        public void delete(int data){
            if(head.data == data){
                head = head.next;
            }

            Node current = head;
            while(current.next != null){
                if(current.next.data == data){
                    current.next = current.next.next;
                }
                current = current.next;
            }

        }
    }



}
