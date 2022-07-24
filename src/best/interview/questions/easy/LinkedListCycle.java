package best.interview.questions.easy;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public static void main(String[] args) {
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        ListNode test1 = generateTest1();
        System.out.println(linkedListCycle.hasCycleNaive(test1));
        System.out.println(linkedListCycle.hasCycle(test1));

        ListNode test2 = generateTest2();
        System.out.println(linkedListCycle.hasCycleNaive(test2));
        System.out.println(linkedListCycle.hasCycle(test2));

        ListNode test3 = new ListNode(1);
        System.out.println(linkedListCycle.hasCycleNaive(test3));
        System.out.println(linkedListCycle.hasCycle(test3));

        ListNode test4 = generateTest4();
        System.out.println(linkedListCycle.hasCycleNaive(test4));
        System.out.println(linkedListCycle.hasCycle(test4));

        ListNode test5 = generateTest5();
        System.out.println(linkedListCycle.hasCycleNaive(test5));
        System.out.println(linkedListCycle.hasCycle(test5));
    }

    public boolean hasCycle(ListNode head) {
        while (head != null) {
            if (head.val == Integer.MAX_VALUE) {
                return true;
            }
            head.val = Integer.MAX_VALUE;
            head = head.next;
        }

        return false;
    }

    public boolean hasCycleNaive(ListNode head) {
        Set<ListNode> traversed = new HashSet<>();
        while (head != null) {
            if (traversed.contains(head)) {
                return true;
            }
            traversed.add(head);
            head = head.next;
        }
        return false;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    private static ListNode generateTest1() {
        ListNode three = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode zero = new ListNode(0);
        ListNode minusFour = new ListNode(-4);
        three.next = two;
        two.next = zero;
        zero.next = minusFour;
        minusFour.next = two;
        return three;
    }

    private static ListNode generateTest2() {
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        one.next = two;
        two.next = one;
        return one;
    }

    private static ListNode generateTest4() {
        ListNode three = new ListNode(3);
        ListNode two = new ListNode(2);
        ListNode zero = new ListNode(0);
        ListNode minusFour = new ListNode(-4);
        three.next = two;
        two.next = zero;
        zero.next = minusFour;
        return three;
    }


    private static ListNode generateTest5() {
        int[] arr = {-21,10,17,8,4,26,5,35,33,-7,-16,27,-12,6,29,-12,5,9,20,14,14,2,13,-24,21,23,-21,5};

        ListNode prev = new ListNode(arr[0]);
        ListNode head = prev;
        for (int i = 1; i < arr.length; i++) {
            ListNode listNode = new ListNode(arr[i]);
            prev.next = listNode;
            prev = listNode;
        }
        return head;
    }
}
