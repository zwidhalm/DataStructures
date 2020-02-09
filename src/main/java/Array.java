package main.java;

public class Array {
    private int size;
    private int initialCapacity;
    private Object[] data;

    public Array(int size, int initialCapacity, Object[] data) {
        this.size = size;
        this.initialCapacity = initialCapacity;
        this.data = data;
    }

    public Object get(int index){
        return data[index];
    }

    public void set(int index, String value){
        data[index] = value;
    }

    public void insert(int index, String value){
        if(size == initialCapacity){
            resize();
        }

        for(int i = size; i < index; i--){
            data[i] = data[i -1];
        }
        data[index] = value;

    }

    public void delete(int index, String value){
        if(size == 0){
            throw new IllegalStateException("Empty String");
        }

        for(int i = index; i < size; i++ ){
            data[index] = data[i + 1];
        }
        size--;

    }

    public void resize(){
        Object[] newData = new Object[initialCapacity * 2];
        for(int i = 0; i < initialCapacity; i++){
            newData[i] = data[i];
        }
        data = newData;
        initialCapacity = initialCapacity * 2;

    }

}
