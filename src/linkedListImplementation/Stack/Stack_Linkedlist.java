package linkedListImplementation.Stack;
class LLStack {
    int data;
    int top = 0;
    int SIZE = 7;
    LLStack Head = null;
    LLStack next = null;

    boolean isEmtpy() {
        if (Head == null) {
            System.out.println("Stack underflow");
            return true;
        }
        return false;
    }

    boolean isFull() {
        if (top == SIZE) {
            System.out.println("Stack overflow");
            return true;
        }
        return false;
    }

    void printStack() {
        if (!isEmtpy()) {
            LLStack current = Head;
            while (current != null) {
                System.out.println(current.data);
                current = current.next;
            }
            System.out.println("Elements present in the list : " + top);
        }
    }

    void push(int data) {
        if (!isFull()) {
            LLStack newNode = new LLStack();
            newNode.data = data;
            newNode.next = Head;
            Head = newNode;
            top++;
        }
    }

    void pop() {
        if (!isEmtpy()) {
            Head = Head.next;
            top--;
        }
    }

}

public class Stack_Linkedlist {
    public static void main(String[] args) {
        LLStack ll1 = new LLStack();
        ll1.isEmtpy();

        ll1.push(10);
        ll1.push(20);
        ll1.push(30);
        ll1.push(40);
        ll1.push(50);
        ll1.push(60);
        ll1.push(70);
        ll1.isFull();
        ll1.push(80);

        ll1.printStack();
        ll1.pop();
        ll1.printStack();
    }
}
