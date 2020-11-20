package ch1.helloworld.test.zk;

/**
 * 双链表实现版本
 *
 * @author liguoping
 * @since 2020/11/20 13:57
 */
public class MyDoubleLinkedList {

    /**
     * 根节点, 作为链表的起始节点
     */
    private final Node root = new Node(0,null,null);

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
    public MyDoubleLinkedList() {
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index) {
        if(index < 0 || index >= size){
            return -1;
        }
        // root->1->2
        Node node = root.next;
        while(index > 0){
            node = node.next;
            index--;
        }
        return node.getVal();
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val) {
        // root->1->2, val = 3
        Node node = new Node(val,null,null);
        // 1
        Node next = root.next;
        // root->3
        root.next = node;
        // root->3->1->2
        node.pre = root;
        node.next = next;

        if(next != null){
            next.pre = node;
        }else{
            tail = node;
        }
        size++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val) {
        Node node = new Node(val,null,null);
        if(tail == null){
            root.next = node;
            node.pre = root;
            tail = node;
        }else{
            tail.next = node;
            node.pre = tail;
            tail = node;
        }
        size++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val) {
        if(index == size){
            addAtTail(val);
            return;
        }
        if(index < 0){
            addAtHead(val);
            return;
        }
        if(index < size){
            Node current = root;
            while(index > 0){
                current = current.next;
                index--;
            }
            Node node = new Node(val,null,null);
            Node next = current.next;
            current.next = node;
            node.pre = current;
            node.next = next;
            next.pre = node;
            size++;
        }
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size){
            return;
        }

        if(index == size - 1){
            Node pre = tail.pre;
            pre.next = null;
            tail = pre;
            size--;
            return;
        }

        Node current = root;
        while(index > 0){
            current = current.next;
            index--;
        }

        current.next = current.next.next;
        current.next.pre = current;
        size--;
    }

    static class Node {

        private Node pre;

        private Node next;

        private Integer val;

        Node(Integer val,Node pre,Node next){
            this.val = val;
            this.pre = pre;
            this.next = next;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Integer getVal() {
            return val;
        }

        public void setVal(Integer val) {
            this.val = val;
        }
    }

    public int getSize(){
        return size;
    }


}
