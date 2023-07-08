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
        ListNode firstNode = null;
        ListNode previousNode = null;

        int overflow = 0;
        while (l1 != null && l2 != null) {
            ListNode nextNode = new ListNode();

            int sum = l1.val + l2.val + overflow;
            nextNode.val = sum % 10;
            overflow = sum / 10;

            l1 = l1.next;
            l2 = l2.next;

            if (previousNode == null) {
                firstNode = nextNode;
            } else {
                previousNode.next = nextNode;
            }
            previousNode = nextNode;
        }

        for (ListNode l : new ListNode[] {l1, l2}) {
            while (l != null) {
                ListNode nextNode = new ListNode();
                int sum = l.val + overflow;
                nextNode.val = sum % 10;
                overflow = sum / 10;
                l = l.next;

                previousNode.next = nextNode;
                previousNode = nextNode;
            }
        }

        while (overflow != 0) {
            ListNode nextNode = new ListNode();
            nextNode.val = overflow % 10;
            overflow = overflow / 10;

            previousNode.next = nextNode;
            previousNode = nextNode;
        }

        return firstNode;
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
