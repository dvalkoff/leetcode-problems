package best.interview.questions.easy;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode b1 = new ListNode(3);
        ListNode b2 = new ListNode(4);
        ListNode b3 = new ListNode(5);
        ListNode c1 = new ListNode(6);
        ListNode c2 = new ListNode(7);
        ListNode c3 = new ListNode(8);
        a1.next = a2;
        a2.next = c1;

        c1.next = c2;
        c2.next = c3;

        b1.next = b2;
        b2.next = b3;
        b3.next = c1;

        var intersectionOfTwoLinkedLists = new IntersectionOfTwoLinkedLists();
        System.out.println(intersectionOfTwoLinkedLists.getIntersectionNodeNaive(a1, b1));
        System.out.println(intersectionOfTwoLinkedLists.getIntersectionNode(a1, b1));
    }

    public ListNode getIntersectionNodeNaive(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.add(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        short aSize = getSize(headA);
        short bSize = getSize(headB);

        ListNode longest;
        ListNode shortest;
        if (aSize > bSize) {
            longest = headA;
            shortest = headB;
        } else {
            longest = headB;
            shortest = headA;
        }

        for (short i = 0; i < Math.abs(aSize - bSize) && longest != null; i++) {
            longest = longest.next;
        }

        while (longest != null && shortest != null) {
            if (longest == shortest) {
                return longest;
            }
            longest = longest.next;
            shortest = shortest.next;
        }
        return null;
    }

    short getSize(ListNode node) {
        short size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }
}
