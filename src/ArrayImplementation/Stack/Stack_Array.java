package ArrayImplementation.Stack;


import java.lang.*;

class Stack {
    int top = -1;
    int MAX = 5;
    int[] arr = new int[MAX];

    boolean isEmpty() {
        if (top == top - 1) {
            System.out.println("!! Stack underflow !!");
            return true;
        }
        return false;
    }

    boolean isFull() {
        if (top == MAX - 1) {
            System.out.println("!! Stack overflow !!");
            return true;
        }
        return false;
    }

    void getData() {
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

    void push(int data) {
        if (!isFull()) {
            top++;
            arr[top] = data;
        }
    }

    void pop() {
        if (!isEmpty()) {
            top--;
        }
    }

    int peek() {
        return top;
    }

}

class Stack_Array {
    public static void main(String[] args) {

        Stack s1 = new Stack();
        s1.push(10);
        s1.push(20);
        s1.push(30);
        s1.pop();
        s1.push(40);
        s1.getData();
    }
}