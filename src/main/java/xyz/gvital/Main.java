package xyz.gvital;

import java.util.HashMap;
import java.util.Stack;

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

    // checks if the input string has valid sequence of brackets
    // https://leetcode.com/problems/valid-parentheses
    private static boolean isClosed(String input) {
        HashMap<Character, Character> brackets = new HashMap<>();
        brackets.put('(', ')');
        brackets.put('[', ']');
        brackets.put('{', '}');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            Character c = input.charAt(i);
            if (brackets.containsKey(c)) {
                stack.push(c);
            } else if (brackets.containsValue(c) && !stack.isEmpty() && brackets.get(stack.peek()) == c) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

}
