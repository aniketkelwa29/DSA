package linkedListImplementation.Advance;
import java.util.Scanner;

import static java.lang.System.exit;

class DNode {
    int data;
    DNode prev;
    DNode next;

    DNode(int data) {
        this.data = data;
    }
}

class DoublyList {
    DNode head = null;
    int count = 0;

    boolean isEmpty() {
        if (head == null) {
            System.out.println("List is empty");
            return true;
        }
        return false;
    }

    void displayForward() {
        DNode current = head;
        while (current != null) {
            System.out.print("[" + current.data + "]<->");
            current = current.next;
        }
        System.out.println("null");
    }

    void displayBackward() {
        if (isEmpty()) return;
        DNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        while (current != null) {
            System.out.print("[" + current.data + "]<->");
            current = current.prev;
        }
        System.out.println("null");
    }

    void insertAtFirst(int data) {
        DNode newNode = new DNode(data);
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        count++;
    }

    void insertAtLast(int data) {
        if (isEmpty()) {
            insertAtFirst(data);
            return;
        }
        DNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        DNode newNode = new DNode(data);
        current.next = newNode;
        newNode.prev = current;
        count++;
    }

    void insertAtPosition(int data, int pos) {
        if (pos <= 0) {
            insertAtFirst(data);
            return;
        }
        if (pos >= count) {
            insertAtLast(data);
            return;
        }
        DNode current = head;
        for (int i = 0; i < pos - 1; i++) {
            current = current.next;
        }
        DNode newNode = new DNode(data);
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
        count++;
    }

    void deleteFromFirst() {
        if (isEmpty()) return;
        if (head.next == null) {
            head = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        count--;
    }

    void deleteFromLast() {
        if (isEmpty()) return;
        if (head.next == null) {
            head = null;
            count--;
            return;
        }
        DNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.prev.next = null;
        count--;
    }

    void deleteFromPosition(int pos) {
        if (isEmpty()) return;
        if (pos <= 0) {
            deleteFromFirst();
            return;
        }
        if (pos >= count - 1) {
            deleteFromLast();
            return;
        }
        DNode current = head;
        for (int i = 0; i < pos; i++) {
            current = current.next;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        count--;
    }

    void reverseList() {
        DNode current = head;
        DNode temp = null;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }

    void findMid() {
        if (isEmpty()) return;
        DNode slow = head;
        DNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle element: " + slow.data);
    }

    void detectCycle() {
        if (isEmpty()) return;
        DNode slow = head;
        DNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                System.out.println("Cycle detected");
                return;
            }
        }
        System.out.println("No cycle detected");
    }

    void getDataByPosition(int pos) {
        if (isEmpty()) return;
        if (pos < 0 || pos >= count) {
            System.out.println("Position not exist");
            return;
        }
        DNode current = head;
        for (int i = 0; i < pos; i++) {
            current = current.next;
        }
        System.out.println("Data at position " + pos + ": " + current.data);
    }

    void getPositionByData(int data) {
        int index = 0;
        DNode current = head;
        while (current != null) {
            if (current.data == data) {
                System.out.println("Data found at position: " + index);
                return;
            }
            index++;
            current = current.next;
        }
        System.out.println("Data not found");
    }

    void encodeList() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter encryption key: ");
        int key = sc.nextInt();
        DNode current = head;
        while (current != null) {
            current.data ^= key;
            current = current.next;
        }
    }

    void decodeList() {
        encodeList();
    }
}
class ADV_Doubly_Linked_List {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyList list = new DoublyList();

        while (true) {
            System.out.println("""
                    ================================================
                         🚀 Advanced Doubly Linked List 🚀
                    ================================================
                      [1] Insert at Start        [8] Get Data by Position
                      [2] Insert at End          [9] Find Position of Data
                      [3] Insert at Position    [10] Find Middle Element
                      [4] Delete from Start     [11] Detect Cycle
                      [5] Delete from End       [12] Reverse List
                      [6] Delete from Position  [13] Encrypt List
                      [7] Display Forward       [14] Decrypt List
                      [15] Display Backward     [16] Exit
                                                  
                    ================================================
                    """);

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> list.insertAtFirst(sc.nextInt());
                case 2 -> list.insertAtLast(sc.nextInt());
                case 3 -> list.insertAtPosition(sc.nextInt(), sc.nextInt());
                case 4 -> list.deleteFromFirst();
                case 5 -> list.deleteFromLast();
                case 6 -> list.deleteFromPosition(sc.nextInt());
                case 7 -> list.displayForward();
                case 8 -> list.getDataByPosition(sc.nextInt());
                case 9 -> list.getPositionByData(sc.nextInt());
                case 10 -> list.findMid();
                case 11 -> list.detectCycle();
                case 12 -> list.reverseList();
                case 13 -> list.encodeList();
                case 14 -> list.decodeList();
                case 15 -> list.displayBackward();
                case 16 -> exit(0);
                default -> System.out.println("Invalid choice");
            }
        }
    }
}
