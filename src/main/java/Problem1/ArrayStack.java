package Problem1;

import java.util.Arrays;

public class ArrayStack<T> implements Stack<T> {
    // do not change member variables
    private T[] data;
    private int size;

    private ArrayStack() {
        data = (T[]) new Object[10];
        size = 0;
    }

    public ArrayStack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    @Override
    public boolean push(T val) {
        if(size >= data.length)
       {/*
            T[] temp = (T[]) new Object[data.length *2];
            for(int i = 0; i < temp.length - 1; i++)
            {
                temp[i] = data[i];
            }
            data = temp;*/
            data = Arrays.copyOf(data, (data.length*2));
            return false;
       }
        data[size++] = val;
        return true;
    }

    @Override
    public T pop() {
        // homework
        if(size <= 0){
            return null;
        }
        T val = data[--size];
        data[size] = null;
        return val;
    }

    @Override
    public T peek() {
        if(size < 0){
            return null;
        }

        return data[size-1];
    }

    @Override
    public int size() {
        return size;
    }
}
