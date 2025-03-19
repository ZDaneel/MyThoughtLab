package link.common;

/**
 * @author leenadz
 * @since 2024-10-11 22:06
 */
public class GetIntersectionNode {
    public static void main(String[] args) {
        // 测试用例 1: 有交点
        ListNode intersectionNode = new ListNode(8);
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = intersectionNode;
        headA.next.next.next = new ListNode(4);
        headA.next.next.next.next = new ListNode(5);

        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersectionNode;

        ListNode result = new GetIntersectionNode().getIntersectionNode(headA, headB);
        System.out.println("Test Case 1 Intersection Node: " + (result != null ? result.val : "null"));

        // 测试用例 2: 无交点
        headA = new ListNode(2);
        headA.next = new ListNode(6);
        headA.next.next = new ListNode(4);

        headB = new ListNode(1);
        headB.next = new ListNode(5);

        result = new GetIntersectionNode().getIntersectionNode(headA, headB);
        System.out.println("Test Case 2 Intersection Node: " + (result != null ? result.val : "null"));

        // 测试用例 3: 相同链表
        headA = new ListNode(2);
        headA.next = new ListNode(3);
        headA.next.next = new ListNode(4);

        headB = headA;  // headB与headA指向相同节点

        result = new GetIntersectionNode().getIntersectionNode(headA, headB);
        System.out.println("Test Case 3 Intersection Node: " + (result != null ? result.val : "null"));
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;
        ListNode lenHeadA = headA;
        while (lenHeadA != null) {
            lenA++;
            lenHeadA = lenHeadA.next;
        }
        ListNode lenHeadB = headB;
        while (lenHeadB != null) {
            lenB++;
            lenHeadB = lenHeadB.next;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        if (lenA > lenB) {
            for (int i = 0; i < (lenA - lenB); i++) {
                curA = curA.next;
            }
        } else {
            for (int i = 0; i < (lenB - lenA); i++) {
                curB = curB.next;
            }
        }
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }

    /**
     * 将链表A的尾节点连接到链表B的头节点，然后将链表B的尾节点连接到链表A的头节点。这样，两个链表的长度就相等了
     * 然后，我们同时遍历两个链表，直到找到相交的节点或遍历完整个链表
     */
    public ListNode getIntersectionNode666(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (A != B) {
            A = A != null ? A.next : headB;
            B = B != null ? B.next : headA;
        }
        return A;
    }
}
