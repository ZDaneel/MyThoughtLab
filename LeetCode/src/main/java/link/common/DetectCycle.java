package link.common;

/**
 * @author leenadz
 * @since 2024-10-11 22:31
 */
public class DetectCycle {
    public static void main(String[] args) {
        int[] list = {3, 2, 0, -4};
        ListNode head = ListNode.list2link(list);
        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        System.out.println(tail);
        tail.next = head.next;
        //System.out.println(head);
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;
        }
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
