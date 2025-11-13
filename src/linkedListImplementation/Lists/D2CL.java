package linkedListImplementation.Lists;

class Node4 {
    Node4 prev;
    int data;
    Node4 next;

    public Node4(int data) {
        this.prev = this;
        this.data = data;
        this.next = this;
    }
}

class performList {
    Node4 tail = null;

    Node4 createHead() {
        Node4 head = tail.next;
        return head;
    }

    void printList() {
        Node4 head = createHead();
        int length = getLength();
        System.out.println("Head : " + head.data);
        System.out.println("Tail : " + tail.data);
        System.out.println("Length :" + length);
    }

    int getLength() {
        Node4 current = createHead();
        int length = 0;
        do {
            current = current.next;
            length++;
        } while (current != tail.next);
        return length;
    }

    void traverse() {
        Node4 current = tail.next;
        do {
            System.out.print(current.data + "->");
            current = current.next;
        } while (current != tail.next);
        System.out.println("null");
    }

    void insertAtFirst(int data) {
        Node4 newNode = new Node4(data);

        if (tail == null) {  // Empty list
            tail = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        } else {
            Node4 current = createHead(); // current first node
            newNode.next = current;
            newNode.prev = tail;
            current.prev = newNode;
            tail.next = newNode;
            // no need to move tail because we are inserting at head
        }
    }

    void insertAtLast(int data) {
        Node4 head = tail.next;
        Node4 current = createHead();
        Node4 newNode = new Node4(data);
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
            getLength();
        }
    }

    void insertAtPosition(int data, int pos) {
//        Node4 head = tail.next;
        int length = getLength();
        Node4 current = createHead();
        Node4 newNode = new Node4(data);
        if (tail == null) {
            tail = newNode;
            newNode.next = newNode;
            newNode.prev = newNode;
        }
        if (pos == 1) {
            insertAtFirst(data);
        } else if (pos >= length) {
            System.out.print("Inserting at the last node : ");
            insertAtLast(data);
        } else {
            for (int i = 1; i < pos; i++) {
                current = current.next;
            }
            newNode.prev = current.prev;
            newNode.next = current.prev.next;
            newNode.prev.next = newNode;
            current.prev = newNode;

        }
    }

    void deleteFromFirst() {

        Node4 head = tail.next;
        Node4 current = head;
        if (tail == null) {
            System.out.println("list is Empty");
        } else {
            current.next.prev = tail;
            current.prev.next = current.next;

        }
    }

    void deleteFromLast() {

        Node4 head = tail.next;
        Node4 current = tail;
        if (tail == null) {
            System.out.println("list is Empty");
        } else {
            tail = current.prev;
            current.prev.next = current.next;
            head.prev = current.prev;
            current.prev = null;
            current.next = null;

        }
    }

    void deleteFromPosition(int pos) {
   int length = getLength();
        Node4 head = tail.next;
        Node4 current = head;
        if (tail == null) {
            System.out.println("list is Empty");
        }
        if(pos == 1){
            deleteFromFirst();
        }
        else if(pos == length){
            deleteFromLast();
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

}

class D2CL {
    public static void main(String[] args) {
        performList d2 = new performList();
        d2.insertAtFirst(15);
        d2.insertAtFirst(10);
        d2.insertAtFirst(5);
        d2.traverse();
        d2.getLength();
        d2.insertAtLast(20);
        System.out.println(d2.tail.data);
        System.out.println(d2.tail.prev.data);
        d2.traverse();
        d2.getLength();
        d2.insertAtPosition(25, 5);
        d2.traverse();
        d2.deleteFromFirst();
        d2.deleteFromLast();
        d2.deleteFromPosition(2);
        d2.traverse();
        d2.printList();
    }
}
