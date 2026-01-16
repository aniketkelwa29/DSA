package linkedListImplementation.Lists;

import java.lang.*;

class New
{
    String data;
    New next;

    New(String data)
    {
        this.data = data;
        this.next = null;
    }
}
class LinkedList{
    New head = null;

    void add(String data)
    {

        New newNode = new New(data);
        if(head == null){
            head = newNode;
        }
        else
        {
            newNode.next = head;
            head = newNode;
        }
    }
    void getData()
    {
        New current = head;
        while(current!=null){
            System.out.print(current.data+"->");
            current = current.next;
        }
        System.out.println("null");
    }
}

class String_to_LinkedList {

    public static void check(String str){
        LinkedList l1=  new LinkedList();
        LinkedList l2=  new LinkedList();
        LinkedList l3=  new LinkedList();
        for(int i =0 ; i<str.length();i++){
            int a = str.codePointAt(i);
            if((a>= 65 && a<= 90) || (a>= 97 && a<= 122 ))
            {
                l1.add(Character.toString(str.charAt(i)));             }
            else if(a>= 48 && a<= 57)
            {
                l2.add(Character.toString(str.charAt(i)));

            }
            else if((a>= 32 && a<= 47 ||a>= 58 && a<=59))
            {
                l3.add(Character.toString(str.charAt(i)));

            }
        }
        l1.getData();
        l2.getData();
        l3.getData();
    }
    public static void main(String[] args)
    {
        String str = "woejf#$%24ioq39202384@oijojf";

        check(str);

    }
}
