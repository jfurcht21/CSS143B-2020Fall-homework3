package Problem3;

import Problem1.LinkedListStack;
import Problem1.Stack;
import Problem2.ListNode;

import java.io.PrintStream;

public class Problem3 {
    private static LinkedListStack stack = new LinkedListStack();

    public static void printListInReverse(ListNode list, PrintStream print) {

        while(list.next != null){
            stack.push(list.next.val);
            list = list.next;
        }
        int num = stack.size();
        for(int i=0; i < num; i++){
            print.println(stack.pop());
        }
    }
}
