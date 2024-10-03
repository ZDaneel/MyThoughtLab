package link.common;

/**
 * @author leenadz
 * @since 2024-10-01 18:00
 */
public class RemoveNthFromEnd {
    public static void main(String[] args) {
        ListNode head = ListNode.getListNode();
        System.out.println(head);
        System.out.println(new RemoveNthFromEnd().removeNthFromEnd(head, 4));
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
