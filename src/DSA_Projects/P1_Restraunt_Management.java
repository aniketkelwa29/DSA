package DSA_Projects;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.awt.SystemColor.menu;

class TokenSystem {
    int customersData;
    TokenSystem front = null;
    TokenSystem rear = null;
    TokenSystem next = null;
    int count = 1;

    TokenSystem(int customersData) {
        this.customersData = customersData;
    }

    void orderRecieved(int customersData) {
        TokenSystem newNode = new TokenSystem(customersData);
        if (front == null) {
            front = newNode;
            rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
        count++;
        System.out.println("New Order recieved !! \n  serve at the table no. " + customersData);
        System.out.println("number of orders to serve are  : " + count);
    }

    void orderServed() {
        if (front == null && rear == null) {
            System.out.println("Not any order is pending right now : ");
        }

        System.out.println("order served at the table number : " + front.customersData);
        front = front.next;
        count--;
    }

    void getTokens() {
        TokenSystem current = front;
        while (current != rear.next) {
            System.out.print(current.customersData + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    void firstToServe() {
        System.out.println("Order to serve first at the Table no. : " + front.customersData);
    }
}

class OrderHistory {
    int Data;
    int top = 0;
    OrderHistory next;
    OrderHistory head = null;

    OrderHistory(int recentBill) {
        this.Data = recentBill;
        this.next = null;
    }

    void History(int Data) {
        OrderHistory newBill = new OrderHistory(Data);
        newBill.Data = Data;
        newBill.next = head;
        head = newBill;
        top++;
    }

    void getHistory() {
        OrderHistory current = head;
        while (current != null) {
            System.out.println(current.Data);
            current = current.next;
        }
    }

}

class Dishes {

    HashMap<String, Integer> Menu = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    public void menu() {

        System.out.println("----------BREAKFAST MENU-----------");
        Menu.put("Idli", 60);
        Menu.put("Dosa", 70);
        Menu.put("Poha", 25);
        Menu.put("Samosa", 25);

        for (Map.Entry<String, Integer> n : Menu.entrySet()) {
            System.out.println(n.getKey() + " -> " + n.getValue());
        }
        System.out.println("----------LUNCH MENU-----------");
        Menu.put("Veg Thali", 80);
        Menu.put("Daal Rice", 65);
        Menu.put("Paneer curry", 109);
        for (Map.Entry<String, Integer> m : Menu.entrySet()) {
            System.out.println(m.getKey() + " -> " + m.getValue());
        }
        System.out.println("----------DINNER MENU-----------");
        Menu.put("sabzi & chapati", 70);
        Menu.put("Fried rice ", 65);
        Menu.put("Veg Biryani", 109);
        for (Map.Entry<String, Integer> o : Menu.entrySet()) {
            System.out.println(o.getKey() + " -> " + o.getValue());
        }
    }

    public void orders() {
        HashMap<String, Integer> order = new HashMap<>();

        System.out.println("Enter the number of items you want to order : ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter the name of the dish : ");

            String dish = sc.nextLine().trim();
            System.out.println("Enter quantity : ");
            int quantity = sc.nextInt();
            sc.nextLine();


            order.put(dish, order.getOrDefault(dish, 0) + quantity);
        }
        for (Map.Entry<String, Integer> entry : order.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
        generateBill(order);
    }

    public void generateBill(HashMap<String, Integer> bill) {
        int grandTotal = 0;
        System.out.println("-----------BILL------------");
        for (Map.Entry<String, Integer> item : bill.entrySet()) {
            String dish = item.getKey();
            int quantity = item.getValue();
            if (Menu.containsKey(dish)) {
                int price = Menu.get(dish);
                int total = price * quantity;
                grandTotal += total;
                System.out.println(dish + " | ₹" + price + " x " + quantity + " = ₹" + total);
            } else {
                System.out.println(dish + " : Not Available");
            }
        }
        System.out.println("-----------------------------");
        System.out.println("Grand Total: ₹" + grandTotal);
    }

}

class Manager {

}


public class P1_Restraunt_Management {
    public static void main(String[] args) {
        int bill = 00;
        OrderHistory or = new OrderHistory(bill);

        or.History(8231);
        or.History(98737);
        
        or.getHistory();
    }
}
