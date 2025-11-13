package linkedListImplementation.Advance;

import java.util.Scanner;

import static java.lang.System.exit;

class NodeS {
    int data;
    NodeS next;

    NodeS(int data) {
        this.data = data;
    }
}

class LLStack {
    NodeS top = null;
    int count = 0;
    final int SIZE = 7;

    boolean isEmpty() {
        if (top == null) {
            System.out.println("Stack is Empty (Underflow)");
            return true;
        }
        return false;
    }

    boolean isFull() {
        if (count == SIZE) {
            System.out.println("Stack is Full (Overflow)");
            return true;
        }
        return false;
    }

    void push(int data) {
        if (isFull()) return;
        NodeS newNode = new NodeS(data);
        newNode.next = top;
        top = newNode;
        count++;
    }

    void pop() {
        if (isEmpty()) return;
        System.out.println("Popped: " + top.data);
        top = top.next;
        count--;
    }

    void peek() {
        if (isEmpty()) return;
        System.out.println("Top element: " + top.data);
    }

    void printStack() {
        if (isEmpty()) return;
        NodeS current = top;
        System.out.println("Current Stack (Top to Bottom):");
        while (current != null) {
            System.out.println("[" + current.data + "]");
            current = current.next;
        }
        System.out.println("Total elements: " + count);
    }

    void clearStack() {
        top = null;
        count = 0;
        System.out.println("Stack cleared successfully!");
    }

    void findDataPosition(int data) {
        if (isEmpty()) return;
        NodeS current = top;
        int pos = 1;
        boolean found = false;

        while (current != null) {
            if (current.data == data) {
                System.out.println("Data " + data + " found at position (from top): " + pos);
                found = true;
                break;
            }
            pos++;
            current = current.next;
        }
        if (!found) System.out.println("Data not found in the stack.");
    }

    void encodeStack() {
        if (isEmpty()) return;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter key to encrypt stack: ");
        int key = sc.nextInt();

        NodeS current = top;
        while (current != null) {
            current.data = current.data ^ key;
            current = current.next;
        }
        System.out.println("Stack encrypted successfully!");
    }

    void decodeStack() {
        if (isEmpty()) return;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter key to decrypt stack: ");
        int key = sc.nextInt();

        NodeS current = top;
        while (current != null) {
            current.data = current.data ^ key;
            current = current.next;
        }
        System.out.println("Stack decrypted successfully!");
    }
}

class ControlsS {
    Scanner sc = new Scanner(System.in);
    LLStack stack;

    ControlsS(LLStack stack) {
        this.stack = stack;
    }

    void controlPush() {
        System.out.print("Enter data to push: ");
        int data = sc.nextInt();
        stack.push(data);
    }

    void controlPop() {
        stack.pop();
    }

    void controlPeek() {
        stack.peek();
    }

    void controlPrint() {
        stack.printStack();
    }

    void controlClear() {
        stack.clearStack();
    }

    void controlFindData() {
        System.out.print("Enter data to find: ");
        int data = sc.nextInt();
        stack.findDataPosition(data);
    }

    void controlEncrypt() {
        stack.encodeStack();
    }

    void controlDecrypt() {
        stack.decodeStack();
    }
}

public class Stack_LinkedList_Advance {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LLStack s1 = new LLStack();
        ControlsS control = new ControlsS(s1);

        while (true) {
            System.out.println("""
                    ==================================================
                                     Stack Using Linked List
                    ==================================================
                    
                      [1]  Push (Insert)               [6]  Peek (Top Element)
                      [2]  Pop (Remove)                [7]  Clear Stack
                      [3]  Display Stack               [8]  Find Data Position
                      [4]  Check if Empty/Full         [9]  Encrypt Stack
                      [5]  Print Total Elements       [10]  Decrypt Stack
                    -----------------------------------------------
                                          [11] Exit
                    ==================================================
                    
                     Tip: Use the number keys to choose your action.
                     Thank you for using the Stack Program!
                    ==================================================
                    """);

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> control.controlPush();
                case 2 -> control.controlPop();
                case 3 -> control.controlPrint();
                case 4 -> {
                    s1.isEmpty();
                    s1.isFull();
                }
                case 5 -> System.out.println("Total elements in stack: " + s1.count);
                case 6 -> control.controlPeek();
                case 7 -> control.controlClear();
                case 8 -> control.controlFindData();
                case 9 -> control.controlEncrypt();
                case 10 -> control.controlDecrypt();
                case 11 -> {
                    System.out.println("!! Thank You !!");
                    exit(0);
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
