package link.common;

import static link.common.ListNode.getListNode;

/**
 * @author leenadz
 * @since 2024-09-30 15:06
 */
public class ReverseList {
    public static void main(String[] args) {
        ListNode head = initLinkedList();
        System.out.println(head);
        System.out.println();
        ListNode listNode = new ReverseList().reverseList(head);
        System.out.println(listNode);
    }

    private static ListNode initLinkedList() {
        return getListNode();
    }

    public ListNode reverseList(ListNode head){
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newList = reverseList(head.next);
        System.out.println(head);
        System.out.println(newList);
        System.out.println();
        head.next.next = head;
        head.next = null;
        return newList;
    }

    public ListNode reverseList2(ListNode head) {
        return reverse(null, head);
    }

    private ListNode reverse(ListNode prev, ListNode cur) {
        if (cur == null) return prev;
        ListNode temp;
        temp = cur.next;
        cur.next = prev;
        return reverse(cur, temp);
    }
}
