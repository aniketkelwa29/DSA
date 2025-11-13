package linkedListImplementation.Queue;

class Node9 {
    int data;
    Node9 next = null;

    Node9(int data) {
        this.data = data;
    }
}

class LinkedList {
    Node9 head = null;

    int count = 0;

    void getList() {
        Node9 current = head;
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
        Node9 newNode = new Node9(data);
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
            Node9 current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
        count--;
    }
}

class Node10 {
    LinkedList reference;
    Node10 next = null;

    Node10(LinkedList reference) {
        this.reference = reference;
    }
}

class Queue {
    Node10 front = null;
    Node10 rear = null;
    int count = 0;
    int SIZE = 6;

    boolean isEmpty() {
        if (front == null || front == rear.next) {
            System.out.println(" Queue is Empty : ");
            return true;
        } else
            return false;
    }

    boolean isFull() {
        if (count == SIZE) {
            System.out.println("!! No empty space available  in the queue !!");
            return true;

        } else return false;
    }

    void printQueue() {
        Node9 current1 = null;
        int sum = 0;
        Node10 current = front;
        while (current != null) {

            current1 = current.reference.head;
            while (current1 != null) {
                System.out.print("[" + current1.data + "]" + "->");

                current1 = current1.next;
                sum++;
            }
            System.out.println("null");
            System.out.println();
            current = current.next;
        }

        System.out.println("Total number of elements present in the queue : " + count);
    }

    void Enqueue(LinkedList reference) {
        Node10 newNode = new Node10(reference);
        newNode.reference = reference;
        if (front == null) {
            front = newNode;
            rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
        count++;
    }

    void Dequeue() {
        if (front == null || front == rear.next) {
            System.out.println("Queue is Empty : ");
            return;
        }
        front = front.next;
        count--;
    }

}

public class LinkedList_in_Queue {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.insertAtFirst(15);
        l1.insertAtFirst(10);
        l1.insertAtFirst(5);
        LinkedList l2 = new LinkedList();
        l2.insertAtFirst(30);
        l2.insertAtFirst(25);
        l2.insertAtFirst(20);
        LinkedList l3 = new LinkedList();
        l3.insertAtFirst(45);
        l3.insertAtFirst(40);
        l3.insertAtFirst(35);
        LinkedList l4 = new LinkedList();
        l4.insertAtFirst(60);
        l4.insertAtFirst(55);
        l4.insertAtFirst(50);
        Queue q1 = new Queue();
        q1.Enqueue(l1);
        q1.Enqueue(l2);
        q1.Enqueue(l3);
        q1.Enqueue(l4);
        q1.printQueue();
    }
}
