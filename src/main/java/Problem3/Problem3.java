package Problem3;

import Problem1.LinkedListStack;
import Problem1.Stack;
import Problem2.ListNode;

import java.io.PrintStream;

public class Problem3 {
    private static LinkedListStack stack = new LinkedListStack();

    public static void printListInReverse(ListNode list, PrintStream print) {

        /*while(list.next != null){
            stack.push(list.val);
            list = list.next;
        }
        //stack.push(list.val);
        for(int i=0; i <= stack.size(); i++){
            print.println(stack.pop());
        }*/
        ListNode ptr = list;
        while (ptr.next != null)
        {
            stack.push(ptr.val);
            ptr = ptr.next;
        }
        // Pop from stack and replace
        // current nodes value'
        list = ptr;
        while (stack.size() != 0)
        {
            ptr.next = (ListNode) stack.peek();
            ptr = ptr.next;
            stack.pop();
        }
        ptr.next = null;

        while (list != null)
        {
            print.println(list.val);
            list = list.next;
        }
    }
    }
