package xyz.gvital;

final class Main {
    private Main() {
        throw new IllegalStateException("Utility class");
    }

    public static void main(String[] args) {
        // 1
        @SuppressWarnings("magicnumber")
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(reverseList(head));

        // 2
        String input = "([]{}[])";
        System.out.println(isClosed(input));
    }

    // Given the head of a singly linked list, reverse the list, and return the reversed list.
    // https://leetcode.com/problems/reverse-linked-list/
    static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}
