package link.common;

/**
 * @author leenadz
 * @since 2024-09-30 13:30
 */
public class ListNode {
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
        StringBuilder sb = new StringBuilder();
        ListNode current = this;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        return sb.toString();
    }


    static ListNode getListNode() {
        ListNode head = new ListNode(1);
        ListNode node = head;
        for (int i = 2; i < 5; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        return head;
    }
}

