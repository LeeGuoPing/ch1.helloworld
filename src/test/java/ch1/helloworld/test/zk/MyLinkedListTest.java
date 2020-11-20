package ch1.helloworld.test.zk;

import org.junit.Test;

/**
 * 单链表测试类
 *
 * @author liguoping
 * @since 2020/11/20 9:34
 */
public class MyLinkedListTest {


    @Test
    public void get(){
        MyDoubleLinkedList linkedList = new MyDoubleLinkedList();
        linkedList.addAtTail(10);
        linkedList.addAtHead(5);
        linkedList.addAtHead(4);
        linkedList.addAtHead(3);
        linkedList.addAtHead(2);
        linkedList.addAtHead(1);
        linkedList.addAtTail(6);
        linkedList.addAtTail(7);
        linkedList.deleteAtIndex(0);
        linkedList.deleteAtIndex(1);
        linkedList.deleteAtIndex(5);
        print(linkedList);
    }

    private void print(MyDoubleLinkedList linkedList) {
        int size = linkedList.getSize();
        for (int i = 0; i < size; i++) {
            System.out.print(linkedList.get(i)+" --> ");
        }
    }
}
