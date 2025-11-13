package linkedListImplementation.Lists;
class Node1
{
    public Object temp;
    Node1 prev;
    int data;
    Node1 next;
    public Node1 (int data)
    {
        this.prev= null;
        this.data = data;
        this.next = null;
    }
}
class Perform_Doubly_linked_list
{
    Node1 head = null;

    void isEmpty(){
        if (head ==  null){
            System.out.println("List is empty");
        }
    }
    Node1 getlastnode(){

        Node1 current = head;
        Node1 previous =null;
        while(current != null) {
            previous = current;
            current = current.next;
        }
        return previous;
    }

    void traverse()
    {
        Node1 current  = head;
        while(current!= null)
        {

            System.out.print(current.data+"->");
            current = current.next;
        }
        System.out.print("null");
        System.out.println();

    }

    Node1 insertAtFirst( int data )
    {
        Node1 current = head;
        Node1 newNode = new Node1(data);
        if (head == null)
        {
            System.out.println("Empty list");
            head = newNode;
        }
        else
        {
            current.prev = newNode ;
            newNode.next = current ;
            head  = newNode;

        }
        return head;
    }
    void append(int data)
    {
        Node1 current =  head;
        Node1 newNode = new Node1(data);
        if (head == null){
            System.out.println("Empty list");
            head =newNode;
        }
        else{
            while(current.next !=null){
                current = current.next;
            }

            newNode.prev = current;
            current.next = newNode;
            newNode.next = null;

        }

    }
    void insertAtPosition(int data , int position)
    {
        Node1 current = head;
        Node1 newNode = new Node1(data);
        if (head == null)
        {
            System.out.println("Empty list");
            head = newNode;
        }
        else
        {
            for(int i=1; i<position-1 ; i++){
                current = current.next;
            }
            newNode.next =  current.next;
            current.next.prev = newNode;
            newNode.prev = current ;
            current.next  = newNode;
        }
    }
    void deleteFromFirst(){
        Node1 current = head;
        if (head == null){
            System.out.println("List is empty");
        }
        else{
            head = current.next;
            current.next.prev  = null;
            current.next = null;
        }

    }
    void deleteFromLast()
    {
        Node1 current = head;
        if (head == null)
        {
            System.out.println("List is empty");
        }
        else
        {
            while(current.next!=null)
            {
                current  = current.next;
            }

            current.prev.next = null;
            current.prev  = null;

        }

    }
    void deleteFromPosition(int position){
        Node1 current = head ;
        if (head == null)
        {
            System.out.println("List is empty");
        }
        else
        {
            for(int i  =1 ; i<position;i++){
                current  = current.next;
            }
            current.prev.next = current.next;
            current.next.prev = current.prev;
            current.next = null;
           current.prev  = null;

        }
    }
    void reverse_list(){

        Node1 current = head;
        Node1 temp=null;
        while(current!=null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
            head =temp.prev;
        }
    }

class DoublyLinkedlist
{
    public static void main(String[] args)
    {
        Perform_Doubly_linked_list d1 = new Perform_Doubly_linked_list();
        d1.insertAtFirst(10);
        d1.insertAtFirst(9);
        d1.insertAtFirst(7);
        d1.insertAtFirst(5);



        d1.traverse();
        d1.append(20);
        d1.traverse();
        d1.insertAtPosition(15 ,4 );
        d1.traverse();
        d1.deleteFromFirst();
        d1.traverse();
        d1.deleteFromLast();
        d1.traverse();
        d1.append(30);
        d1.append(40);
        d1.append(50);
        d1.traverse();
        d1.getlastnode();
        d1.deleteFromPosition(3);
        d1.traverse();
        d1.reverse_list();
        d1.traverse();
    }
}