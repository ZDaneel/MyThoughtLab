package link.common;

/**
 * @author leenadz
 * @since 2024-09-30 14:36
 */
public class MyLinkedListInt {
    int size;
    ListNode dummyHead;

    public MyLinkedListInt() {
        size = 0;
        dummyHead = new ListNode(-1);
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode temp = dummyHead;
        for (int i = 0; i <= index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    public void addAtHead(int val) {
        ListNode addNode = new ListNode(val);
        addNode.next = dummyHead.next;
        dummyHead.next = addNode;
        ++size;
    }

    public void addAtTail(int val) {
        ListNode temp = dummyHead;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new ListNode(val);
        ++size;
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size) {
            return;
        }
        ListNode temp = dummyHead;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        ListNode addNode = new ListNode(val);
        addNode.next = temp.next;
        temp.next = addNode;
        ++size;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode temp = dummyHead;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        --size;
    }
}
