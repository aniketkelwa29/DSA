package linkedListImplementation.Advance;

import java.util.Scanner;
import static java.lang.System.exit;

class NodeQ {
    int data;
    NodeQ next;

    NodeQ(int data) {
        this.data = data;
    }
}

class LLQueue {
    NodeQ front = null;
    NodeQ rear = null;
    int count = 0;
    final int SIZE = 6;

    boolean isEmpty() {
        if (front == null) {
            System.out.println("Queue is Empty.");
            return true;
        }
        return false;
    }

    boolean isFull() {
        if (count == SIZE) {
            System.out.println("!! No empty space available in the queue !!");
            return true;
        }
        return false;
    }

    void enqueue(int data) {
        if (isFull()) return;

        NodeQ newNode = new NodeQ(data);
        if (front == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        count++;
    }

    void dequeue() {
        if (isEmpty()) return;
        front = front.next;
        count--;
        if (front == null) rear = null;
    }

    void displayQueue() {
        if (isEmpty()) return;

        NodeQ current = front;
        System.out.print("Front -> ");
        while (current != null) {
            System.out.print("[" + current.data + "]" + " -> ");
            current = current.next;
        }
        System.out.println("Rear");
        System.out.println("Total elements: " + count);
    }

    void peekFront() {
        if (isEmpty()) return;
        System.out.println("Front element: " + front.data);
    }

    void peekRear() {
        if (isEmpty()) return;
        System.out.println("Rear element: " + rear.data);
    }

    void clearQueue() {
        front = rear = null;
        count = 0;
        System.out.println("Queue cleared successfully!");
    }

    void findPositionOfData(int data) {
        if (isEmpty()) return;
        int pos = 1;
        NodeQ current = front;
        boolean found = false;
        while (current != null) {
            if (current.data == data) {
                System.out.println("Data " + data + " found at position: " + pos);
                found = true;
                break;
            }
            pos++;
            current = current.next;
        }
        if (!found) System.out.println("Data not found in the queue.");
    }

    void encodeQueue() {
        if (isEmpty()) return;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter key to encrypt queue: ");
        int key = sc.nextInt();

        NodeQ current = front;
        while (current != null) {
            current.data = current.data ^ key;
            current = current.next;
        }
        System.out.println("Queue encrypted successfully!");
    }

    void decodeQueue() {
        if (isEmpty()) return;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter key to decrypt queue: ");
        int key = sc.nextInt();

        NodeQ current = front;
        while (current != null) {
            current.data = current.data ^ key;
            current = current.next;
        }
        System.out.println("Queue decrypted successfully!");
    }
}

class ControlsQ {
    Scanner sc = new Scanner(System.in);
    LLQueue q1;

    ControlsQ(LLQueue q1) {
        this.q1 = q1;
    }

    void controlEnqueue() {
        System.out.print("Enter data to enqueue: ");
        int data = sc.nextInt();
        q1.enqueue(data);
    }

    void controlDequeue() {
        q1.dequeue();
    }

    void controlDisplay() {
        q1.displayQueue();
    }

    void controlPeekFront() {
        q1.peekFront();
    }

    void controlPeekRear() {
        q1.peekRear();
    }

    void controlClear() {
        q1.clearQueue();
    }

    void controlFindPosition() {
        System.out.print("Enter data to find position: ");
        int data = sc.nextInt();
        q1.findPositionOfData(data);
    }

    void controlEncrypt() {
        q1.encodeQueue();
    }

    void controlDecrypt() {
        q1.decodeQueue();
    }
}
public class Queue_LinkedList_Advanced {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LLQueue queue = new LLQueue();
        ControlsQ control = new ControlsQ(queue);

        while (true) {
            System.out.println("""
==================================================
                 Queue Using Linked List
==================================================

  [1]  Enqueue (Insert)              [6]  Peek Front
  [2]  Dequeue (Remove)              [7]  Peek Rear
  [3]  Display Queue                 [8]  Clear Queue
  [4]  Find Position of Data         [9]  Encrypt Queue
  [5]  Check if Empty/Full          [10]  Decrypt Queue
-----------------------------------------------
                       [11] Exit
==================================================

 Tip: Use the number keys to choose your action.
 Thank you for using the Queue Program!
==================================================
""");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> control.controlEnqueue();
                case 2 -> control.controlDequeue();
                case 3 -> control.controlDisplay();
                case 4 -> control.controlFindPosition();
                case 5 -> {
                    queue.isEmpty();
                    queue.isFull();
                }
                case 6 -> control.controlPeekFront();
                case 7 -> control.controlPeekRear();
                case 8 -> control.controlClear();
                case 9 -> control.controlEncrypt();
                case 10 -> control.controlDecrypt();
                case 11 -> {
                    System.out.println("!! Thank You !!");
                    exit(0);
                }
                default -> System.out.println("Invalid choice, try again.");
            }
        }
    }
}
