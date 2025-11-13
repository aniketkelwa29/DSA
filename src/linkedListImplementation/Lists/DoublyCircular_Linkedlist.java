package linkedListImplementation.Lists;
class Node3 {
    Node3 prev;
    int data;
    Node3 next;

    public Node3(int data) {
        this.prev = this;
        this.data = data;
        this.next = this;
    }

}

class Doubly_Circular {
    Node3 tail = null;

    void createHead() {
        Node3 head = tail.next;
    }

    void traverse() {
        Node3 current = tail.next;
        do {
            System.out.print(current.data + "->");
            current = current.next;
        } while (current != tail.next);
        System.out.println("null");
    }

    void insertAtFirst(int data) {
        Node3 newNode = new Node3(data);

        if (tail == null) {  // Empty list
            tail = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            Node3 head = tail.next; // current first node
            newNode.next = head;
            newNode.prev = tail;
            head.prev = newNode;
            tail.next = newNode;
            // no need to move tail because we are inserting at head
        }
    }

    void insertAtLast(int data) {
        Node3 head = tail.next;
        Node3 current = head;
        Node3 newNode = new Node3(data);
        if (tail == null) {
            tail = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            do {
                current = current.next;
            } while (current != tail);
            newNode.prev = current;
            newNode.next = head;
            current.next.prev = newNode;
            newNode.prev.next = newNode;
            tail = newNode;
        }
    }

    void insertAtPosition(int data, int pos) {
        Node3 head = tail.next;
        Node3 current = head;
        Node3 newNode = new Node3(data);
        if (tail == null) {
            tail = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            for (int i = 1; i < pos; i++) {
                current = current.next;
            }
            if (pos == 1) {
                insertAtFirst(data);
            } else {
                newNode.prev = current.prev;
                newNode.next = current.prev.next;
                newNode.prev.next = newNode;
                current.prev = newNode;
            }
        }
    }

    void deleteFromFirst() {
        Node3 head = tail.next;
        Node3 current = head;
        if (tail == null) {
            System.out.println("list is Empty");
        } else {
            current.next.prev = tail;
            current.prev.next = current.next;
        }
    }

    void deleteFromLast() {
        Node3 head = tail.next;
        Node3 current = tail;
        if (tail == null) {
            System.out.println("list is Empty");
        } else {
            tail = current.prev;
            current.prev.next = current.next;
            head.prev = current.prev;
            current.prev = null;
            current.next = null;
            System.out.print(tail.prev.data+"->");
            System.out.print(tail.data+"->");
            System.out.println(tail.next.data);
        }
    }

    void deleteFromPosition(int pos) {
        Node3 head = tail.next;
        Node3 current = head;
        if (tail == null) {
            System.out.println("list is Empty");
        }
        else {
            for (int i = 1; i < pos; i++) {
                current = current.next;
            }
            current.next.prev = current.prev;
            current.prev.next = current.next;
            current.prev = null;
            current.next = null;
        }
    }
    void Reverse_List(){
        Node3 head= tail.next;
        Node3 current = head;

        Node3 temp ;
        if(tail == null){
            System.out.println("No any data found in the list");
        }
        else{
            do{
              temp = current.prev ;
              current.prev = current.next;
              current.next = temp;
              current = current.prev;
            }while(current!=head);
            temp = head;
            head = tail;
            tail = temp;
        }

    }
}

class DoublyCircular_Linkedlist {
    public static void main(String[] args) {
        Doubly_Circular d1 = new Doubly_Circular();
        d1.insertAtFirst(15);
        d1.insertAtFirst(10);
        d1.insertAtFirst(5);
//        d1.traverse();
        d1.insertAtLast(20);
//        d1.traverse();
        d1.insertAtLast(25);
        d1.insertAtLast(30);
//        d1.traverse();
        d1.insertAtPosition(13, 3);
        d1.insertAtPosition(23, 6);
        d1.insertAtPosition(27, 8);
        d1.traverse();
        d1.deleteFromFirst();
        d1.traverse();
        System.out.print(d1.tail.prev.data+"->");
        System.out.print(d1.tail.data+"->");
        System.out.println(d1.tail.next.data);
        d1.deleteFromLast();
        d1.deleteFromLast();
        d1.traverse();
        d1.deleteFromPosition(5);
        d1.traverse();
        d1.Reverse_List();
        d1.traverse();

    }
}