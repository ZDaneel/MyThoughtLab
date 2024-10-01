package link.gene;

/**
 * @author leenadz
 * @since 2024-09-30 13:24
 */
public class SingleListNode<T> {
    T val;
    SingleListNode<T> next;

    SingleListNode(T x) {
        val = x;
    }

    public SingleListNode(T val, SingleListNode<T> next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "SingleListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
