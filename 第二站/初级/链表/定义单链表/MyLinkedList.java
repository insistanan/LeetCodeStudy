package 第二站.初级.链表.定义单链表;


/**
 * 构建一个简单的单链表
 * @author insis
 * @date 2023/03/11
 */
public class MyLinkedList {
    private int size;
    //聚合/关联Node
    private Node head;

    public int getSize() {
        return size;
    }


    public Node getHead() {
        return head;
    }


    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.size = 0;
        this.head = null;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index < 0 || index >= size || head == null) {
            return -1;
        }
        Node temp = this.head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp.getVal();
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.setNext(this.head);
        this.head = node;
        size++;
    }
    public void addAtHeadN(Node node) {
        node.setNext(this.head);
        this.head = node;
        size++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if (size == 0) {
            this.head = new Node(val);
            head.setNext(null);
            size++;
        }else {
            Node temp = this.head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            Node tail = new Node(val);
            tail.setNext(null);
            temp.setNext(tail);
            size++;
        }
    }
    public void addAtTailN(Node node) {
        if (size == 0) {
            this.head = node;
            head.setNext(null);
            size++;
        }else {
            Node temp = this.head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            node.setNext(null);
            temp.setNext(node);
            size++;
        }
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > this.size) {
            return;
        }
        if (index <= 0) {
            addAtHead(val);
            return;
        }
        if (index == this.size) {
            addAtTail(val);
            return;
        }

        Node temp = this.head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.getNext();
        }
        Node insertNode = new Node(val);
        insertNode.setNext(temp.getNext());
        temp.setNext(insertNode);
        size++;
    }
    public void addAtIndexN(int index, Node node) {
        if (index > this.size) {
            return;
        }
        if (index <= 0) {
            addAtHeadN(node);
            return;
        }
        if (index == this.size) {
            addAtTailN(node);
            return;
        }

        Node temp = this.head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.getNext();
        }
        node.setNext(temp.getNext());
        temp.setNext(node);
        size++;
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= this.size) {
            return;
        }
        if (index == 0) {
            if (size != 1) {
                Node temp = this.head.getNext();
                this.head =temp;
                size--;
                return;
            }else {
                this.head = null;
                size--;
                return;
            }
        }
        Node temp = this.head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.getNext();
        }
        Node deleteNode = temp.getNext();
        temp.setNext(deleteNode.getNext());
        size--;
    }


}
