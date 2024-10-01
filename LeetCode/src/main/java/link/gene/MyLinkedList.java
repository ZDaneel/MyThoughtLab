package link.gene;

/**
 * @author leenadz
 * @since 2024-09-30 13:28
 */
public class MyLinkedList<T> {
    int size;
    SingleListNode<T> dummyHead;

    public MyLinkedList() {
        size = 0;
        dummyHead = new SingleListNode<>(null);
    }

    // 获取第index个, 否则返回-1
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        SingleListNode<T> temp = dummyHead;
        for (int i = 0; i <= index; i++) {
            temp = temp.next;
        }
        return temp.val;
    }

    // 在链表的第一个元素之前添加一个值为 val 的节点
    public void addAtHead(T val) {
        SingleListNode<T> addNode = new SingleListNode<>(val);
        addNode.next = dummyHead.next;
        dummyHead.next = addNode;
        ++size;
    }

    // 将值为 val 的节点追加到链表的最后一个元素
    public void addAtTail(T val) {
        SingleListNode<T> temp = dummyHead;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new SingleListNode<>(val);
        ++size;
    }

    // 在链表中的第 index 个节点之前添加值为 val  的节点
    public void addAtIndex(int index, T val) {
        if (index < 0 || index > size) {
            return;
        }
        SingleListNode<T> temp = dummyHead;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        SingleListNode<T> addNode = new SingleListNode<>(val);
        addNode.next = temp.next;
        temp.next = addNode;
        ++size;
    }

    // 如果索引 index 有效，则删除链表中的第 index 个节点
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        SingleListNode<T> temp = dummyHead;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        --size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyLinkedList{size=").append(size).append(", elements=[");

        SingleListNode<T> current = dummyHead.next;
        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }

        sb.append("]}");
        return sb.toString();
    }
}
