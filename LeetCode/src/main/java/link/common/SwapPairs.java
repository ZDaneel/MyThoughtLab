package link.common;

/**
 * @author leenadz
 * @since 2024-10-01 17:15
 */
public class SwapPairs {
    public static void main(String[] args) {
//        ListNode head = ListNode.getListNode();
        ListNode head = new ListNode(1);
        System.out.println(head);
        ListNode listNode = new SwapPairs().swapPairs(head);
        System.out.println(listNode);
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            ListNode temp;
            temp = cur.next.next;
            prev.next = cur.next;
            cur.next.next = cur;
            cur.next = temp;
            prev = cur;
            cur = temp;
        }
        return dummy.next;
    }

    // 失败的递归，问题在于返回的是最后的值了
    private ListNode swap(ListNode prev, ListNode cur) {
        if (cur == null) return prev;
        ListNode temp;
        temp = cur.next.next;
        if (prev != null) prev.next = cur.next;
        cur.next.next = cur;
        cur.next = temp;
        return swap(cur, temp);
    }

    public ListNode swapPairsRe(ListNode head) {
        // base case 退出提交
        if (head == null || head.next == null) return head;
        // 获取当前节点的下一个节点
        ListNode next = head.next;
        // 进行递归
        ListNode newNode = swapPairs(next.next);
        // 这里进行交换
        next.next = head;
        head.next = newNode;

        return next;
    }
}
