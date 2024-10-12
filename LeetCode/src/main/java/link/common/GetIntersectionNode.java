package link.common;

/**
 * @author leenadz
 * @since 2024-10-11 22:06
 */
public class GetIntersectionNode {
    public static void main(String[] args) {
        int[] listA = {4, 1, 8, 4, 5};
        int[] listB = {5, 0, 1, 8, 4, 5};
        ListNode headA = new ListNode(listA[0]);
        ListNode headB = new ListNode(listB[0]);
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        for (int i = 1; i < listA.length; i++) {
            nodeA.next = new ListNode(listA[i]);
            nodeA = nodeA.next;
        }
        for (int i = 1; i < listB.length; i++) {
            nodeB.next = new ListNode(listB[i]);
            nodeB = nodeB.next;
        }
        System.out.println(headA);
        System.out.println(headB);
        ListNode intersectionNode = new GetIntersectionNode().getIntersectionNode666(headA, headB);
        System.out.println(intersectionNode);
    }

    /**
     * 将链表A的尾节点连接到链表B的头节点，然后将链表B的尾节点连接到链表A的头节点。这样，两个链表的长度就相等了
     * 然后，我们同时遍历两个链表，直到找到相交的节点或遍历完整个链表
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        return null;
    }
    public ListNode getIntersectionNode666(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }
}
