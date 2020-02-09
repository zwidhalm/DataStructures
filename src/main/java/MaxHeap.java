package main.java;

import java.util.Arrays;

public class MaxHeap {
    private int capacity = 10;
    private int size = 0;

    public int[] items = new int[capacity];

    private int leftChildIndex(int parentIndex){
        return 2 * parentIndex + 1;
    }

    private int rightChildIndex(int parentIndex){
        return 2 * parentIndex + 2;
    }

    private int parentIndex(int childIndex){
        return (childIndex - 1)/2;
    }

    private boolean hasLeftChild(int index){
        return leftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index){
        return rightChildIndex(index) < size;
    }

    private boolean hasParent(int index){
        return parentIndex(index) >= 0;
    }

    private int leftChild(int index){return items[leftChildIndex(index)];}

    private int rightChild(int index){return items[rightChildIndex(index)];}

    private int parent(int index){return items[parentIndex(index)];}

    public void insert(int item){
        ensureCapacity();
        items[size] = item;// put in last spot
        size++;
        heapifyUp();
    }

    public void heapifyUp() {
        int index = size - 1;// start at last element
        //while parent nodes are < child value
        while (hasParent(index) && parent(index) < items[index]) {
            swap(parentIndex(index), index);
            index = parentIndex(index); //walk upwards to next node
        }
    }

    public void ensureCapacity(){
        if(size == capacity){
            items = Arrays.copyOf(items, capacity);
            capacity *= 2;
        }
    }

    public int extractMax(){
        if(size == 0) throw new IllegalStateException();
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    public void heapifyDown(){
        int index = 0; //start at the top

        //as long as there is child nodes
        //note; only have to check left because if there is no left, there is no right
        while(hasLeftChild(index)){

            //take the larger of the two indexes
            int smallerChildIndex = leftChildIndex(index);
            if(hasRightChild(index) && rightChild(index) > leftChildIndex(index)){
                smallerChildIndex = rightChildIndex(index);
            }

            //now compare
            //if node value is smaller than the value of two child nodes
            //then all is good, i am sorted
            if(items[index] > items[smallerChildIndex]){
                break;
            } else{
                //not in order - swap
                swap(index,smallerChildIndex);
            }

            //then we move down to smaller child
            index = smallerChildIndex;

        }
    }





}
