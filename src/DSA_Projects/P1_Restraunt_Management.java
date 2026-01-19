package DSA_Projects;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.System.exit;


class TokenSystem {
    int tokenNumber;
    TokenSystem front = null;
    TokenSystem rear = null;
    TokenSystem next = null;
    int count = 0;

    TokenSystem(int tokenNumber) {
        this.tokenNumber = tokenNumber;
    }

    void orderRecieved(int tokenNumber) {
        TokenSystem newNode = new TokenSystem(tokenNumber);
//        System.out.println("test1");
        count++;
        if (front == null) {
            front = newNode;
            rear = newNode;
            System.out.println("New Order recieved !! \n  serve at the table no. " + tokenNumber);
            System.out.println("number of orders to serve are  : " + count);
            return;
        }
        rear.next = newNode;
        rear = newNode;

        System.out.println("New Order recieved !! \n  serve at the table no. " + tokenNumber);
        System.out.println("number of orders to serve are  : " + count);
    }

    void orderServed() {
        if (front == null && rear == null) {
            System.out.println("Not any order is pending right now : ");
        }

        System.out.println("order served at the table number : " + front.tokenNumber);
        front = front.next;
        count--;
    }

    void getTokens() {
        TokenSystem current = front;
        while (current != rear.next) {
            System.out.print(current.tokenNumber + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    void firstToServe() {
        System.out.println("Order to serve first at the Table no. : " + front.tokenNumber);
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
        getHistory();
    }

    void getHistory() {
        OrderHistory current = head;
        while (current != null) {
            System.out.println("Most Recent bill  is : "+current.Data);
            current = current.next;
        }
    }

}

class Dishes {

    OrderHistory orderHistory = new OrderHistory(0);
    int orderId = 1000;
      TokenSystem tokenSystem =  new TokenSystem(orderId)  ;
    HashMap<String, Integer> breakfast = new HashMap<>();
    HashMap<String, Integer> lunch = new HashMap<>();
    HashMap<String, Integer> dinner = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    public Dishes() {
        loadMenu();
    }

    public void loadMenu() {

        breakfast.put("Idli", 60);
        breakfast.put("Dosa", 70);
        breakfast.put("Poha", 25);
        breakfast.put("Samosa", 25);


        lunch.put("Veg Thali", 80);
        lunch.put("Daal Rice", 65);
        lunch.put("Paneer curry", 109);


        dinner.put("sabzi & chapati", 70);
        dinner.put("Fried rice", 65);
        dinner.put("Veg Biryani", 109);
    }

    public void breakfastMenu() {
        System.out.println("----------BREAKFAST MENU-----------");
        for (Map.Entry<String, Integer> n : breakfast.entrySet()) {
            System.out.println(n.getKey() + " -> " + n.getValue());
        }
    }

    public void lunchMenu() {
        System.out.println("----------LUNCH MENU-----------");
        for (Map.Entry<String, Integer> m : lunch.entrySet()) {
            System.out.println(m.getKey() + " -> " + m.getValue());
        }
    }

    public void dinnerMenu() {
        System.out.println("----------DINNER MENU-----------");
        for (Map.Entry<String, Integer> o : dinner.entrySet()) {
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
        orderId++;
        tokenSystem.orderRecieved(orderId);
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
            if (breakfast.containsKey(dish)) {
                int price = breakfast.get(dish);
                int total = price * quantity;
                grandTotal += total;
                System.out.println(dish + " | ₹" + price + " x " + quantity + " = ₹" + total);
            } else if (lunch.containsKey(dish)) {
                int price = lunch.get(dish);
                int total = price * quantity;
                grandTotal += total;
                System.out.println(dish + " | ₹" + price + " x " + quantity + " = ₹" + total);
            } else if (dinner.containsKey(dish)) {
                int price = dinner.get(dish);
                int total = price * quantity;
                grandTotal += total;
                System.out.println(dish + " | ₹" + price + " x " + quantity + " = ₹" + total);
            } else {

                System.out.println(dish + " : Not Available");
            }
        }
        System.out.println("-----------------------------");
        System.out.println("Grand Total: ₹" + grandTotal);
          tokenSystem.orderServed();
        System.out.println("Do you want to see the bill history ? (yes/no) ");
        String choice = sc.nextLine();
        if(choice.equals("yes"))
          orderHistory.History(grandTotal);
        else if (choice.equals("no")){
            System.out.println("!! Thankyou for having a meal !!");
        }

//        restraunt.Reception();
    }

}

class Restraunt {
    Dishes dishes = new Dishes();
    Scanner sc = new Scanner(System.in);

    public void orderConfirmation() {
        System.out.println("Do you want to order something from this menu  :- yes/no ");
        String m = sc.nextLine();
        if (m.equals("yes")) {

            dishes.orders();

        } else if (m.equals("no")) {
            System.out.println("!! Thankyou for visiting !!");
        } else {
            System.out.println("!! Invalid Input !!");
        }
    }
    public void Reception() {

        Restraunt restraunt = new Restraunt();
        System.out.println("!!----Welcome to our Restraunt----!!");


        Boolean b = false;
        do {
            System.out.println("Do you wants to have a meal :  yes/no : ");
            String userChoice = sc.nextLine().trim();
            if (userChoice.equals("yes")) {

                Boolean r = false;
                do {
                    System.out.println("Which type of meal do you prefer  " +
                            "\n ----------BREAKFAST----------- " +
                            "\n " + "----------LUNCH----------- " +
                            "\n" + "----------DINNER-----------  ");
                    String c = sc.nextLine();
                    if (c.equals("breakfast")) {
                        dishes.breakfastMenu();
                        restraunt.orderConfirmation();
                        r = true;
                    } else if (c.equals("lunch")) {
                        dishes.lunchMenu();
                        orderConfirmation();
                        r = true;
                    } else if (c.equals("dinner")) {
                        dishes.dinnerMenu();
                        orderConfirmation();
                        r = true;
                    } else {
                        System.out.println("! Invalid Input !");
                    }
                } while (r != true);
                b = true;
            } else if (userChoice.equals("no")) {
                System.out.println("!! Thankyou - visit Again !!");
                b = true;
            } else {
                System.out.println("userInput is not valid ");
            }
        } while (b != true);
    }
}

public class P1_Restraunt_Management {
    public static void main(String[] args) {
        Restraunt r = new Restraunt();
        r.Reception();
    }
}
