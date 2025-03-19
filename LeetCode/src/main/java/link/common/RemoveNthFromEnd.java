package link.common;

import java.awt.*;

/**
 * @author leenadz
 * @since 2024-10-01 18:00
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        //ListNode head = ListNode.getListNode();
        ListNode head = new ListNode(1);
        System.out.println(head);
        System.out.println(new RemoveNthFromEnd().removeNthFromEnd1(head, 1));
    }

    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummyNode = new ListNode();
        dummyNode.next = head;
        ListNode slow = dummyNode;
        ListNode fast = slow;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummyNode.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) return null;
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null) return head.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
