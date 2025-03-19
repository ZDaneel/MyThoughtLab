package link.common;

/**
 * @author leenadz
 * @since 2024-10-11 22:31
 */
public class DetectCycle {
    public static void main(String[] args) {
        // 测试用例1: 有环链表 [3,2,0,-4]，环的入口是位置1的节点(值为2)
        testCase1();

        // 测试用例2: 有环链表 [1,2]，环的入口是位置0的节点(值为1)
        testCase2();

        // 测试用例3: 无环链表 [1]
        testCase3();

        // 测试用例4: 无环链表 [1,2,3,4,5]
        testCase4();
    }

    public ListNode detectCycle (ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        do {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        while (fast != head) {
            fast = fast.next;
            head = head.next;
        }
        return head;
    }

    public ListNode detectCycle1 (ListNode head) {
        ListNode fast = head, slow = head;
        do {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);
        fast = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    private static void testCase1() {
        System.out.println("测试用例1: 有环链表 [3,2,0,-4]，环的入口是位置1的节点(值为2)");
        int[] list = {3, 2, 0, -4};
        ListNode head = createLinkedListWithCycle(list, 1);
        ListNode result = new DetectCycle().detectCycle(head);
        if (result != null) {
            System.out.println("检测到环，入口节点值为: " + result.val);
        } else {
            System.out.println("未检测到环");
        }
        System.out.println();
    }

    private static void testCase2() {
        System.out.println("测试用例2: 有环链表 [1,2]，环的入口是位置0的节点(值为1)");
        int[] list = {1, 2};
        ListNode head = createLinkedListWithCycle(list, 0);
        ListNode result = new DetectCycle().detectCycle(head);
        if (result != null) {
            System.out.println("检测到环，入口节点值为: " + result.val);
        } else {
            System.out.println("未检测到环");
        }
        System.out.println();
    }

    private static void testCase3() {
        System.out.println("测试用例3: 无环链表 [1]");
        int[] list = {1};
        ListNode head = createLinkedListWithCycle(list, -1);
        ListNode result = new DetectCycle().detectCycle(head);
        if (result != null) {
            System.out.println("检测到环，入口节点值为: " + result.val);
        } else {
            System.out.println("未检测到环");
        }
        System.out.println();
    }

    private static void testCase4() {
        System.out.println("测试用例4: 无环链表 [1,2,3,4,5]");
        int[] list = {1, 2, 3, 4, 5};
        ListNode head = createLinkedListWithCycle(list, -1);
        ListNode result = new DetectCycle().detectCycle(head);
        if (result != null) {
            System.out.println("检测到环，入口节点值为: " + result.val);
        } else {
            System.out.println("未检测到环");
        }
        System.out.println();
    }

    // 创建可能带环的链表
    private static ListNode createLinkedListWithCycle(int[] values, int pos) {
        if (values == null || values.length == 0) {
            return null;
        }

        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        ListNode cycleNode = pos == 0 ? head : null;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
            if (i == pos) {
                cycleNode = current;
            }
        }

        // 如果pos有效，创建环
        if (pos != -1 && cycleNode != null) {
            current.next = cycleNode;
        }

        return head;
    }
}
