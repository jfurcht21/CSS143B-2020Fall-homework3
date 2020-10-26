package Problem2;

import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

// all functions assume using dummy node
public class SingleLinkedList {
    // do not add member variables
    private ListNode head;
    private int size;

    public SingleLinkedList() {
        head = new ListNode();  // dummy node
    }

    // Youtube video from class helped a lot with this one.
    public SingleLinkedList(SingleLinkedList list) {
        ListNode p1 = new ListNode();
        ListNode p2 = list.head.next;
        head = p1;

        while(p2!=null){
            p1.next = new ListNode(p2.val);
            p1=p1.next;
            p2=p2.next;
        }

        size = list.size;
    }

    // Used this as main reference when I ran into blockers.
    //https://www.programcreek.com/2014/04/leetcode-remove-linked-list-elements-java/
    public int removeAll(int valueToRemove) {
        int count = 0;
        ListNode temp = new ListNode();
        temp.next = head;
        ListNode p1 = temp;

        while(p1.next != null){
            if(p1.next.val == valueToRemove){
                ListNode next = p1.next;
                p1.next = next.next;
                count++;
                size--;
            }else{
                p1 = p1.next;
            }
        }

        return count;
    }

    // Used many resources and combined the best of each one. Main resource was
    // the YouTube video made by Professor Du.
    // https://www.youtube.com/watch?v=7O_dRR8fC3w&list=PLmZYijop2pDaqxjq_0p70aoe1OgC6UiFA&index=10
    public void reverse() {
        ListNode prev = null;
        ListNode current = head.next;

        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head.next = prev;
    }

    // do not change any function below

    public SingleLinkedList(int[] data) {
        this();
        if (data == null) {
            return;
        }
        ListNode ptr = head;
        for (int datum : data) {
            ptr.next = new ListNode(datum);
            ptr = ptr.next;
            size++;
        }
    }

    // Appends the specified element to the end of this list
    public void add(int val) {
        size++;
        ListNode ptr = head;
        while (ptr.next != null) {
            ptr = ptr.next;
        }
        ptr.next = new ListNode(val);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode ptr = head.next;
        while (ptr != null) {
            builder.append(ptr.val).append(ptr.next == null ? " -> end " : " -> ");
            ptr = ptr.next;
        }
        return builder.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof SingleLinkedList)) {
            return false;
        }

        SingleLinkedList otherList = (SingleLinkedList) obj;

        if (this.size != otherList.size) {
            return false;
        }
        ListNode n1 = head.next;
        ListNode n2 = otherList.head.next;
        while (n1 != null && n2 != null) {
            if (n1.val != n2.val) {
                return false;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        return (n1 == null && n2 == null);
    }

    public int getSize() {
        return size;
    }
}
