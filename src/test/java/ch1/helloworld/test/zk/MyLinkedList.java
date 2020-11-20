package ch1.helloworld.test.zk;

/**
 * 单链表实现
 *
 * @author liguoping
 * @since 2020/11/20 9:14
 */
public class MyLinkedList {

    /**
     * 根节点, 作为链表的起始节点
     */
    private final Node root = new Node();

    /**
     * 尾节点
     */
    private Node tail;

    /**
     * 不包含根节点的数量
     */
    private int size;

    /**
     * Initialize your data structure here.
     */
    public MyLinkedList() {
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        // 检查边界条件
        if (index >= size || index < 0) {
            return -1;
        }

        // 如果是尾节点直接返回
        if (index == size - 1) {
            return tail.getVal();
        }

        // 遍历链表查找元素
        Node node = root;
        while (index >= 0) {
            node = node.next;
            index--;
        }
        return node.getVal();
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        // root -> firstNode, root -> node -> firstNode
        // 真正意义上的首个节点
        Node firstNode = root.getNext();
        Node node = new Node(val);
        root.next = node;
        node.next = firstNode;

        // 如果原来没有尾节点,维护当前加入的节点为尾节点
        if(tail == null){
            tail = node;
        }

        // 链表数量加一
        size++;

    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        // tail 不存在的特殊情况处理
        if(tail == null){
            tail = new Node(val);
            root.next = tail;
        }else {
            // root-->1-->2 root-->1-->2-->3
            Node node = new Node(val);
            tail.next = node;
            tail = node;
        }
        size++;

    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {

        if (index == size) {
            // 如果 index 等于链表的长度，则该节点将附加到链表的末尾
            addAtTail(val);
            return;
        }

        if (index < 0) {
            // 如果index小于0，则在头部插入节点
            addAtHead(val);
        }

        // root->1->2->4
        // index = 0,val = 3, root->3->1->2->4
        // index = 1,val = 3, root->1->3->2->4
        // index = 2,val = 3, root->1->2->3->4
        if (index < size) {
            // 1
            Node current = root.next;
            // root
            Node last = root;
            while (index > 0) {
                // 1 2
                last = current;
                // 2 4
                current = current.next;
                index--;
            }
            Node node = new Node(val);
            last.next = node;
            node.next = current;
            size++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        int indexCopy = index;
        // root->1->2->4
        // index = 0, root->2->4
        // index = 1, root->1->4
        // index = 2, root->1->2 维护尾节点

        // 1
        Node current = root.next;
        // root
        Node last = root;
        while (index > 0) {
            // 1 2
            last = current;
            // 2 4
            current = current.next;
            index--;
        }
        last.next = current.next;
        if (indexCopy == size - 1) {
            tail = last;
        }

        size--;

    }

    static class Node {

        public Node() {

        }

        public Node(int val) {
            this.val = val;
        }

        int val;

        Node next;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public int getSize(){
        return size;
    }

}
