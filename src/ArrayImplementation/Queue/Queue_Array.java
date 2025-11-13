package ArrayImplementation.Queue;

class ArrQueue {
    int MAX = 6;
    int[] arr = new int[MAX];
    int front = -1;
    int rear = -1;
    int data;
    int count = 1;

    void isEmpty() {
        if (front == -1 || rear == -1 || front == rear + 1) {
            System.out.println("Queue is Empty ");
            return;
        }
    }

    void isFull() {
        if (count == MAX - 1) {
            System.out.println("Queue is full");
            return;
        }
    }

    void printQueue() {

        for (int i = front; i < MAX - 2; i++) {
            System.out.print("[" + arr[i] + "]" + "->");
        }
        System.out.println("null");

        System.out.println("elements in the queue is : " + count);
    }

    void Enqueue(int data) {
        if (front == -1) {
            front++;
            rear++;
            arr[front] = data;
            arr[rear] = data;
            return;
        }
        rear++;
        arr[rear] = data;
        count++;
    }

    void Dequeue() {
        if (front == -1 || front == rear + 1) {
            System.out.println("Queue is Empty ");
            return;
        }
        front++;
        count--;
    }

}

public class Queue_Array {
    public static void main(String[] args) {
        ArrQueue A1 = new ArrQueue();
        A1.isEmpty();
        A1.Enqueue(10);
        A1.Enqueue(20);
        A1.Enqueue(30);
        A1.Enqueue(40);
        A1.printQueue();
        A1.Dequeue();
        A1.printQueue();
    }
}
