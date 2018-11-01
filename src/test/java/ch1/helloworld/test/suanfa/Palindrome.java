package ch1.helloworld.test.suanfa;

import org.junit.Before;
import org.junit.Test;

/**
 * @author liguoping
 * @version 1.0
 * @description 回文字 123321
 * @time 2018/11/1 19:36
 */
public class Palindrome {
    ListNode head = new ListNode(1);


    @Before
    public void init() {
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(1);
    }

    @Test
    public void test01() {
        palindrome();

    }

    private boolean palindrome() {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;   // 原来的指针
            slow.next = prev;   // 改变指针
            prev = slow;
            slow = next;
        }

        if (fast != null) {  // 因为fast步进长度是2,判断总数为奇数才会这样.
            slow = slow.next;
        }

        while (slow != null && prev != null) {
            if (slow.val != prev.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }
        return true;
    }

}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
