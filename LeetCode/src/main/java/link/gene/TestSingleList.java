package link.gene;

import org.junit.jupiter.api.Test;

/**
 * @author leenadz
 * @since 2024-09-30 13:25
 */
public class TestSingleList {
    @Test
    void testMyLinkedList() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        System.out.println(linkedList);
        linkedList.addAtTail(1);
        System.out.println(linkedList);
        linkedList.addAtHead(0);
        System.out.println(linkedList);
        linkedList.addAtTail(2);
        linkedList.addAtTail(3);
        System.out.println(linkedList);
        System.out.println("index=0: " + linkedList.get(0));
        System.out.println("index=2: " + linkedList.get(2));
        System.out.println("index=4: " + linkedList.get(4));
        System.out.println("index=3: " + linkedList.get(3));
        linkedList.addAtIndex(1, 10);
        System.out.println(linkedList);
        linkedList.deleteAtIndex(1);
        System.out.println(linkedList);
        linkedList.deleteAtIndex(0);
        System.out.println(linkedList);
    }

    @Test
    void testFailCase() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        System.out.println(linkedList);
        linkedList.addAtHead(7);
        linkedList.addAtHead(2);
        linkedList.addAtHead(1);
        linkedList.addAtIndex(3, 0);
        System.out.println(linkedList);
        linkedList.deleteAtIndex(2);
        System.out.println(linkedList);
        linkedList.addAtHead(6);
        linkedList.addAtTail(4);
        System.out.println(linkedList);
        System.out.println(linkedList.get(4));
    }
}
