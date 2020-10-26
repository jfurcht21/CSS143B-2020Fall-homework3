package Problem1;

public class MinStack extends ArrayStack<Integer> {
    // okay to add member variables
    // can only use Stack interface and ArrayStack from this folder
    // do not use Java Stack
    private int min = 999999999;
    ArrayStack auxStack = new ArrayStack(size());

    public MinStack(int size) {
        super(size);
    }

    @Override
    public boolean push(Integer val) {
        if(val < min){
            min = val;
        }
        super.push(val);
        return true;
    }

    @Override
    public Integer pop() {
        int num = super.pop();
        if(this.size() == 0){
            return null;
        }
        if(super.peek() == null){
            return num;
        }
        if(num < super.peek()){
            min = super.peek();
        }
        return num;
    }

    public Integer getMin() {
        if(min == 999999999){
            return null;
        }
        if(this.size() == 0){
            return null;
        }
        return min;
    }
}

