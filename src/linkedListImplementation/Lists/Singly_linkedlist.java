package linkedListImplementation.Lists;
import java.util.Scanner;
import static java.lang.System.exit;

class Node {
    int data;
    Node next;

    void getList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }

    Node insertAtStart(int data, Node head) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = head;
        head = newNode;
        return head;
    }

    Node insertAtEnd(int data, Node head) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        return head;
    }

    Node insertAtPos(int data, Node head, int pos) {
        Node newNode = new Node();
        newNode.data = data;
        if (pos == 1 || head == null) {
            newNode.next = head;
            head = newNode;
            return head;
        }
        Node current = head;
        for (int i = 1; i < pos - 1 && current.next != null; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        return head;
    }

    void getPosition(Node head, int data) {
        int count = 1;
        boolean found = false;
        Node current = head;
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

    void getDataByPos(Node head, int pos) {
        int count = 1;
        Node current = head;
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

    Node deleteFromStart(Node head) {
        if (head == null) {
            System.out.println("List is empty");
            return null;
        }
        head = head.next;
        return head;
    }

    Node deleteFromEnd(Node head) {
        if (head == null) {
            System.out.println("List is empty");
            return null;
        }
        if (head.next == null) {
            return null;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        current.next = null;
        return head;
    }

    Node deleteFromPos(Node head, int pos) {
        if (head == null) {
            System.out.println("List is empty");
            return null;
        }
        if (pos == 1) {
            return head.next;
        }
        Node current = head;
        for (int i = 1; i < pos - 1 && current.next != null; i++) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        } else {
            System.out.println("Position not exist");
        }
        return head;
    }
}

class Singly_Linkedlist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        Node list = new Node();

        while (true) {
            System.out.println("\n--- Singly Linked List Menu ---");
            System.out.println("1. Insert at Start");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete from Start");
            System.out.println("5. Delete from End");
            System.out.println("6. Delete from Position");
            System.out.println("7. Display List");
            System.out.println("8. Get Data by Position");
            System.out.println("9. Find Position of Data");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter data to insert at start: ");
                    int data1 = sc.nextInt();
                    head = list.insertAtStart(data1, head);
                    break;
                case 2:
                    System.out.print("Enter data to insert at end: ");
                    int data2 = sc.nextInt();
                    head = list.insertAtEnd(data2, head);
                    break;
                case 3:
                    System.out.print("Enter data to insert: ");
                    int data3 = sc.nextInt();
                    System.out.print("Enter position: ");
                    int pos1 = sc.nextInt();
                    head = list.insertAtPos(data3, head, pos1);
                    break;
                case 4:
                    head = list.deleteFromStart(head);
                    break;
                case 5:
                    head = list.deleteFromEnd(head);
                    break;
                case 6:
                    System.out.print("Enter position to delete: ");
                    int pos2 = sc.nextInt();
                    head = list.deleteFromPos(head, pos2);
                    break;
                case 7:
                    System.out.println("Current Linked List:");
                    list.getList(head);
                    break;
                case 8:
                    System.out.print("Enter position: ");
                    int pos3 = sc.nextInt();
                    list.getDataByPos(head, pos3);
                    break;
                case 9:
                    System.out.print("Enter data to find position: ");
                    int data4 = sc.nextInt();
                    list.getPosition(head, data4);
                    break;
                case 10:
                    System.out.println("!! Thank You !!");
                    exit(0);
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }
    }
}