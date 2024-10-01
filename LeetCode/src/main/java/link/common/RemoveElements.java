package link.common;

import static link.common.ListNode.getListNode;

/**
 * @author leenadz
 * @since 2024-09-30 13:32
 */
public class RemoveElements {
    public static void main(String[] args) {
        ListNode head = initLinkedList();
        System.out.println(head.toString());
        ListNode listNode = new RemoveElements().removeElements(head, 2);
        System.out.println(listNode.toString());
    }

    private static ListNode initLinkedList() {
        return getListNode();
    }

    // recursion 解法
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements(head.next, val);
        if (head.val == val) {
            return head.next;
        } else {
            return head;
        }
    }
}
