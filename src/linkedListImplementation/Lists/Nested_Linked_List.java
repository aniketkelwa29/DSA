package linkedListImplementation.Lists;

class InnerList {
    class Node7 {
        int data;
        Node7 next = null;

        Node7(int data) {
            this.data = data;
        }
    }

    Node7 head = null;
    int count = 0;

    void getList() {
        Node7 current = head;
        while (current != null) {
            System.out.print("[" + current.data + "]->");
            current = current.next;
        }
        System.out.println("null");
    }

    boolean isEmpty() {
        return head == null;
    }

    void insertAtFirst(int data) {
        Node7 newNode = new Node7(data);
        if (isEmpty()) {
            head = newNode;
            newNode.next = null;
        } else {
            newNode.next = head;
            head = newNode;
        }
        count++;
    }

    void deleteFromLast() {
        if (isEmpty()) {
            System.out.println("No elements present in the list");
            return;
        }
        if (head.next == null) {
            head = null;
        } else {
            Node7 current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
        count--;
    }
}

class OuterList {
    class Node8 {
        InnerList data;
        Node8 next = null;

        Node8(InnerList data) {
            this.data = data;
        }
    }

    Node8 head = null;
    int count = 0; //

    void getList() {
        Node8 current = head;
        while (current != null) {
            current.data.getList();
            current = current.next;
        }
        System.out.println("null");
    }

    boolean isEmpty() {
        return head == null;
    }

    void insertAtFirst(InnerList data) {
        Node8 newNode = new Node8(data);
        if (isEmpty()) {
            head = newNode;
            newNode.next = null;
        } else {
            newNode.next = head;
            head = newNode;
        }
        count++;
    }

    void deleteFromLast() {
        if (isEmpty()) {
            System.out.println("No elements present in the list");
            return;
        }
        if (head.next == null) {
            head = null;
        } else {
            Node8 current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
        count--;
    }
}

public class Nested_Linked_List {
    public static void main(String[] args) {
        InnerList l1 = new InnerList();
        l1.insertAtFirst(15);
        l1.insertAtFirst(10);
        l1.insertAtFirst(5);


        InnerList l2 = new InnerList();
        l2.insertAtFirst(30);
        l2.insertAtFirst(25);
        l2.insertAtFirst(20);


        InnerList l3 = new InnerList();
        l3.insertAtFirst(45);
        l3.insertAtFirst(40);
        l3.insertAtFirst(35);


        OuterList o1 = new OuterList();
        o1.insertAtFirst(l3);
        o1.insertAtFirst(l2);
        o1.insertAtFirst(l1);

        o1.getList();
    }
}
