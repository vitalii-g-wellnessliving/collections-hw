package xyz.gvital;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

final class Main {
  private Main() {
    throw new IllegalStateException("Utility class");
  }

  public static void main(String[] args) {
    // 1
    @SuppressWarnings("magicnumber")
    ListNode head = new ListNode(new int[] { 1, 2, 3, 4, 5 });
    System.out.println(reverseList(head));

    // 2
    String input = "([]{}[])";
    System.out.println(isClosed(input));

    // 3
    @SuppressWarnings("magicnumber")
    int[] nums = { 0, 1, 0, 3, 12 };
    moveZeroes(nums);
    System.out.println(Arrays.toString(nums));
  }

  // Given the head of a singly linked list, reverse the list, and return the
  // reversed list.
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

  // Given an integer array nums, move all 0's to the end of it while maintaining
  // the relative order of the non-zero elements.
  // https://leetcode.com/problems/move-zeroes/
  private static void moveZeroes(int[] nums) {
    int i = 0;
    for (int j = 0; j < nums.length; j++) {
      if (nums[j] != 0) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        i++;
      }
    }
  }
}
