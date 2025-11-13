package linkedListImplementation.Lists;

class Node2 {
    int data;
    Node2 next;

    Node2(int data) {
        this.data = data;
        this.next = this;
    }
}

class Perform_operations {
    Node2 tail = null;

    void traverse() {
        Node2 current = tail.next;
        do {
            System.out.print(current.data + "->");
            current = current.next;
        } while (current != tail.next);
        System.out.println("null");
    }

    void insertAtFirst(int data) {
        Node2 newNode = new Node2(data);
        if (tail == null) {
            System.out.println("Empty list");
            tail = newNode;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
        }
    }

    void insertAtLast(int data) {
        Node2 current = tail.next;
        Node2 newNode = new Node2(data);
        if (tail == null) {
            System.out.println("Empty list");
            tail = newNode;
        } else {
            do {
                current = current.next;
            } while (current != tail.next);
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
    }

    void insertAtPosition(int data, int pos) {
        Node2 current = tail.next;
        Node2 newNode = new Node2(data);
        if (tail == null) {
            System.out.println("Empty list");
            tail = newNode;
        } else {
            for (int i = 1; i < pos - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    void deleteFromfirst() {
        Node2 current = tail.next;
        tail.next = current.next;
        current.next = null;
    }

    void deleteFromLast() {
        Node2 current = tail.next;
        Node2 nextNode = current.next;
        do {

            current = current.next;
            nextNode = nextNode.next;

        } while (nextNode != tail);

        current.next = tail.next;
        nextNode.next = null;

        tail = current;
    }

    void deleteFromPosition(int pos) {
        Node2 current = tail.next;
        Node2 nextNode = current.next;
        if (tail == null) {
            System.out.println("list is empty !!");
        } else {
            for (int i = 1; i < pos - 1; i++) {
                current = current.next;
                nextNode = nextNode.next;
            }
            current.next = nextNode.next;
            nextNode.next = null;
        }
    }

    void reverseList() {
        if (tail == null || tail.next == tail) {
            return;
        }
        Node2 head = tail.next;
        Node2 prev = tail;
        Node2 current = head;
        Node2 nextNode;
        do {
            nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        } while (current != head);
        tail = head;
    }

}

public class Circular_List {
    public static void main(String[] args) {
        Perform_operations p1 = new Perform_operations();
        p1.insertAtFirst(40);
        p1.insertAtFirst(30);
        p1.insertAtFirst(20);
        p1.traverse();
        p1.insertAtLast(50);
        p1.traverse();
        p1.insertAtPosition(35, 3);
        p1.traverse();
        p1.deleteFromfirst();
        p1.traverse();
        p1.deleteFromLast();
        p1.traverse();
        p1.deleteFromPosition(2);
        p1.traverse();
        p1.insertAtFirst(20);
        p1.insertAtLast(50);
        p1.traverse();
        p1.reverseList();
        p1.traverse();
    }
}
