package best.interview.questions.medium;

public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,
                new ListNode(
                        9,
                        new ListNode(
                                9,
                                new ListNode(
                                        9,
                                        new ListNode(
                                                9,
                                                new ListNode(
                                                        9,
                                                        new ListNode(
                                                                9,
                                                                new ListNode(
                                                                        9,
                                                                        new ListNode(
                                                                                9,
                                                                                new ListNode(
                                                                                        9
                                                                                )
                                                                        )
                                                                )
                                                        )
                                                )
                                        )
                                )
                        )
                ));
        ListNode l2 = new ListNode(9);
        var result = addTwoNumbers(l1, l2);
        System.out.println(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long sum = addAll(addAll(0, l1), l2);


        ListNode parent = new ListNode((int) (sum % 10));
        ListNode previous = parent;
        while (sum / 10 != 0) {
            sum /= 10;
            ListNode listNode = new ListNode((int) (sum % 10));
            previous.next = listNode;
            previous = listNode;
        }

        return parent;
    }

    private static long addAll(long sum, ListNode listNode) {
        long multiplexer = 1;
        while (listNode != null) {
            sum += listNode.val * multiplexer;
            multiplexer *= 10;
            listNode = listNode.next;
        }
        return sum;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }
}
