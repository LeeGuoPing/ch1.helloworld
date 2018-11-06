package ch1.helloworld.test.suanfa.beauty.seven;

import org.junit.Test;

/**
 * @author liguoping
 * @version 1.0
 * @description 1) 反转链表
 * 2) 检测环
 * 3) 两个有序的链表合并
 * 4) 删除倒数第K个节点
 * 5) 求链表的中间结点
 * @time 2018/11/2 16:05
 */
public class LinkedListAlgo {


    @Test
    public void reverseTest() {
        Node head = new Node(1, null);
        head.next = new Node(2, null);
        print(head);
        Node rNode = reverse(head);
        System.out.println("++++反转链表+++");
        print(rNode);
    }

    @Test
    public void checkCircleTest() {
        Node one = new Node(1, null);
        Node two = new Node(2, null);
        Node three = new Node(3, null);
        Node four = new Node(4, null);
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = two;

        boolean hasCircle = checkCircle(one);
        System.out.println(hasCircle);
    }

    @Test
    public void mergeTest() {
        Node one = new Node(1, null);
        Node two = new Node(2, null);
        Node three = new Node(3, null);
        Node four = new Node(4, null);
        Node five = new Node(5, null);

        one.next = three;
        three.next = five;
        two.next = four;

        Node list1 = one;
        Node list2 = two;

        print(list1);
        print(list2);
        Node mergeList = merge(list1, list2);
        print(mergeList);
    }

    @Test
    public void deleteLastKTest() {
        Node one = new Node(1, null);
        Node two = new Node(2, null);
        Node three = new Node(3, null);
        Node four = new Node(4, null);
        Node five = new Node(5, null);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;

        int k = 5;
        Node node = deleteLastKTest(one, k);
        print(node);
    }

     @Test
    public void middleNodeTest() {
        Node one = new Node(1, null);
        Node two = new Node(2, null);
        Node three = new Node(3, null);
        Node four = new Node(4, null);
        Node five = new Node(5, null);
        Node six = new Node(6,null);

        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;

        Node node = middleNode(one);
         System.out.println(node.data);
    }

    /**
     *  返回中间节点
     * @param list
     * @return
     */
    private Node middleNode(Node list) {
        if(list==null){
            return null;
        }
        Node fast = list;
        Node slow = list;
        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    /**
     * 删除倒数第k个数据
     *
     * @param list
     * @param k
     */
    private Node deleteLastKTest(Node list, int k) {
        int i = 1;
        Node slow = list;
        Node fast = list;
        while (fast != null && i < k) {
            fast = fast.next;
            i++;
        }

        if (fast == null) {
            return list;
        }

        Node pre = null;
        while (fast.next != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }


        if (pre == null) {
            list = list.next;
        } else {
            pre.next = pre.next.next;
        }
        return list;


    }

    /**
     * 合并两个有序链表
     *
     * @param list1 链表1
     * @param list2 链表2
     * @return 合并后的链表
     */
    private Node merge(Node list1, Node list2) {
        Node head;

        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.data < list2.data) {
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }

        Node current = head;
        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;

        }
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return head;
    }

    /**
     * 检测链表中是否存在环
     *
     * @param head
     * @return
     */
    private boolean checkCircle(Node head) {
        if (head == null) {
            return false;
        }

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }


    public static void print(Node list) {
        while (list != null) {
            System.out.print(list.data);
            list = list.next;
        }

        System.out.println("======================");
    }

    /**
     * 反转链表
     *
     * @param list 入参链表
     * @return 反转链表
     */
    public static Node reverse(Node list) {
        Node prev = null;
        Node current = list;
        Node head = null;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            if (next == null) {
                head = current;
            }
            current = next;
        }
        return head;

    }


    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }
}
