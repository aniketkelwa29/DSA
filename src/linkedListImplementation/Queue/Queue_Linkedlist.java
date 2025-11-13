package linkedListImplementation.Queue;
class LLQueue {

    LLQueue front = null;
    LLQueue rear = null;
    int data;
    LLQueue next = null;
    int count = 1;
    int SIZE = 6;

    boolean isEmpty() {
        if (front == null || front == rear.next) {
            System.out.println(" Queue is Empty : ");
            return true;
        }
        else
        return false;
    }

    boolean isFull() {
        if (count == SIZE) {
            System.out.println("!! No empty space available  in the queue !!");
            return true;

        }
        else return false;
    }

    void printQueue() {
        LLQueue current = front;
        while (current != null) {
            System.out.print("[" + current.data + "]" + "->");
            current = current.next;
        }
        System.out.println("null");

        System.out.println("Total number of elements present in the queue : " + count);
    }

    void Enqueue(int data) {
        LLQueue newNode = new LLQueue();
        newNode.data = data;
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

public class Queue_Linkedlist {
    public static void main(String[] args) {
        LLQueue l1 = new LLQueue();
        l1.Enqueue(5);
        l1.Enqueue(10);
        l1.Enqueue(15);


        l1.printQueue();
        l1.Dequeue();
        l1.printQueue();
    }
}
