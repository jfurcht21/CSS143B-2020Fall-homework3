package Problem1;

public class MinStack extends ArrayStack<Integer> {
    // okay to add member variables
    // can only use Stack interface and ArrayStack from this folder
    // do not use Java Stack
    private int min = 999999999;

    public MinStack(int size) {
        super(size);
    }

    @Override
    public boolean push(Integer val) {
        if (val < min){
            min = val;
        }
        //MinStack[size++] = val;
        return true;
    }

    @Override
    public Integer pop() {
        // homework
        return -1; // place holder
    }

    public Integer getMin() {
        return min;
    }
}

