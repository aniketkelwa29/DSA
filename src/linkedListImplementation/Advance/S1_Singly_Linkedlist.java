package linkedListImplementation.Advance;

import java.util.Scanner;

import static java.lang.System.exit;

class Node5 {
    int data;
    Node5 next;

    Node5(int data) {
        this.data = data;
    }
}

class SinglyList {
    int count = 0;
    Node5 head = null;

    void getList() {
        Node5 current = head;
        while (current != null) {
            System.out.print("[" + current.data + "]" + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    boolean isEmpty() {
        if (head == null) {
            System.out.println("List is Empty");
            return true;
        }
        return false;
    }

    void insertAtFirst(int data) {
        Node5 newNode = new Node5(data);
        if (isEmpty()) {
            head = newNode;
            newNode.next = null;
        } else {
            newNode.next = head;
            head = newNode;
        }
        count++;
    }

    void insertAtEnd(int data) {
        Node5 current = head;
        Node5 newNode = new Node5(data);
        if (isEmpty()) {
            insertAtFirst(data);
            return;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = null;
        }
        count++;
    }

    void insertAtPosition(int data, int pos) {
        Node5 current = head;
        Node5 newNode = new Node5(data);
        if (isEmpty()) {
            insertAtFirst(data);
            return;
        }
        if (pos <= 0) {
            insertAtFirst(data);
            return;
        }
        if (pos > count) {
            insertAtEnd(data);
            return;
        }
        for (int i = 1; i < pos - 1; i++) {
            current = current.next;
        }
        System.out.println("data at position" + current.data);
        newNode.next = current.next;
        current.next = newNode;
        count++;
    }

    void deleteFromFirst() {
        if (isEmpty()) {
            System.out.println("No any elements present in the list ");
            return;
        }
        head = head.next;
        count--;
    }

    void deleteFromLast() {
        if (isEmpty()) {
            System.out.println("No any elements present in the list ");
            return;
        }
        if (head.next == null) {
            head = null;
            count--;
            return;
        }
        Node5 current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        count--;
    }

    void deleteFromPosition(int pos) {
        if (isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        if (pos <= 0) {
            deleteFromFirst();
            return;
        }
        if (pos >= count - 1) {
            deleteFromLast();
            return;
        }
        Node5 current = head;
        for (int i = 0; i < pos - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        count--;
    }

    void reverseList() {
        Node5 current = head;
        Node5 prev = null;
        Node5 next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    void findMidTerm() {
        Node5 tortois;
        Node5 hare;
        Node5 current = head;
        tortois = hare = current;
        if (head == null) {
            System.out.println("list is empty ");
            return;
        }
        while (hare != null && hare.next != null) {
            tortois = tortois.next;
            hare = hare.next.next;
        }
        System.out.println("middle element  : " + tortois.data);
    }

    void detectCycle() {
        Node5 tortois;
        Node5 hare;
        Node5 current = head;
        tortois = hare = current;
        boolean hasCycle = false;
        if (head == null) {
            System.out.println("list is empty ");
            return;
        }
        while (hare != null && hare.next != null) {
            tortois = tortois.next;
            hare = hare.next.next;
            if (hare == tortois) {
                hasCycle = true;
                break;
            }
        }
        if (hasCycle) {
            System.out.println("Cycle detected in our list");
        } else {
            System.out.println("No any cycle detected");
        }
    }

    void getDataByPos(int pos) {
        int count = 1;
        Node5 current = head;
        while (current != null && count < pos) {
            current = current.next;
            count++;
        }
        if (current == null) {
            System.out.println("Position not exist");
        } else {
            System.out.println("Data at position " + pos + " is: " + current.data);
        }
    }

    void getPosition(int data) {
        int count = 1;
        boolean found = false;
        Node5 current = head;
        while (current != null) {
            if (current.data == data) {
                System.out.println("Data " + data + " found at position: " + count);
                found = true;
                break;
            }
            count++;
            current = current.next;
        }
        if (!found) {
            System.out.println("Data not found in the list");
        }
    }

    void encodeList() {
        Scanner sc = new Scanner(System.in);
        Node5 current = head;
        System.out.print("Enter key to encrypt the list : ");
        int key = sc.nextInt();

        while (current != null) {
            current.data = current.data ^ key;
            current = current.next;
        }
    }

    void decodeList() {
        Scanner sc = new Scanner(System.in);
        Node5 current = head;
        System.out.print("Enter key  to decode the list : ");
        int key = sc.nextInt();

        while (current != null) {
            current.data = current.data ^ key;
            current = current.next;
        }
    }
}

class ControlsL {

    Scanner sc = new Scanner(System.in);
    SinglyList l1;

    ControlsL(SinglyList l1) {
        this.l1 = l1;
    }

    void controlInsertAtFirst() {
        System.out.print("Enter data to insert at start: ");
        int data1 = sc.nextInt();
        l1.insertAtFirst(data1);
    }

    void controlInsertAtLast() {
        System.out.print("Enter data to insert at end: ");
        int data2 = sc.nextInt();
        l1.insertAtEnd(data2);
    }

    void controlInsertAtPosition() {
        System.out.print("Enter data to insert: ");
        int data3 = sc.nextInt();
        System.out.print("Enter position: ");
        int pos1 = sc.nextInt();
        l1.insertAtPosition(data3, pos1);
    }

    void controlDeleteFromFirst() {
        l1.deleteFromFirst();
    }

    void controlDeleteFromLast() {
        l1.deleteFromLast();
    }

    void controlDeleteFromPosition() {
        System.out.print("Enter position to delete: ");
        int pos2 = sc.nextInt();
        l1.deleteFromPosition(pos2);
    }

    void controlListprinter() {
        System.out.println("Current Linked List:");
        l1.getList();
    }

    void controlGetDataByPosition() {
        System.out.print("Enter position: ");
        int pos3 = sc.nextInt();
        l1.getDataByPos(pos3);
    }

    void controlfindPositionOfdata() {
        System.out.print("Enter data to find position: ");
        int data4 = sc.nextInt();
        l1.getPosition(data4);
    }

    void controlfindMidTerm() {
        System.out.println("Find mid term value ");
        l1.findMidTerm();
    }

    void controldetectCycle() {
        System.out.println("Detect cycle in the list ");
        l1.detectCycle();
    }

    void controlReversalOfList() {
        System.out.println("Reversing the list ");
        l1.reverseList();
    }

    void controlEncryption() {
        System.out.println("Encrypt list : ");
        l1.encodeList();
    }

    void controlDecryption() {
        System.out.println("Decrypt the list : ");
        l1.decodeList();

    }

}

class S1_Singly_Linkedlist {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyList s1 = new SinglyList();
        ControlsL controls = new ControlsL(s1);
        while (true) {


            System.out.println("""
                    ==================================================
                                  🚀 Singly Linked List Menu 🚀
                    ==================================================
                    
                      [1]  Insert at Start              [7]  Display List
                      [2]  Insert at End                [8]  Get Data by Position
                      [3]  Insert at Position           [9]  Find Position of Data
                      [4]  Delete from Start           [10]  Find Mid Value
                      [5]  Delete from End             [11]  Detect Cycle
                      [6]  Delete from Position        [12]  Reverse List
                      [13] Encrypt List                [14] Decrypt List
                    --------------------------------------------------
                                         [15] Exit
                    ==================================================
                    
                    💡 Tip: Use the number keys to choose your action!
                    ✨ Thank you for using the Singly Linked List Program! ✨
                    --------------------------------------------------
                            Created with ❤️  by a Java Program
                    ==================================================
                    """);


            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    controls.controlInsertAtFirst();
                    break;
                case 2:
                    controls.controlInsertAtLast();
                    break;
                case 3:
                    controls.controlInsertAtPosition();
                    break;
                case 4:
                    controls.controlDeleteFromFirst();
                    break;
                case 5:
                    controls.controlDeleteFromLast();
                    break;
                case 6:
                    controls.controlDeleteFromPosition();
                    break;
                case 7:
                    controls.controlListprinter();
                    break;
                case 8:
                    controls.controlGetDataByPosition();
                    break;
                case 9:
                    controls.controlfindPositionOfdata();
                    break;
                case 10:
                    controls.controlfindMidTerm();
                    break;
                case 11:
                    controls.controldetectCycle();
                    break;
                case 12:
                    controls.controlReversalOfList();
                    break;
                case 13:
                    controls.controlEncryption();
                    break;
                case 14:
                    controls.controlDecryption();
                    break;
                case 15:
                    System.out.println("!! Thank You !!");
                    exit(0);
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}