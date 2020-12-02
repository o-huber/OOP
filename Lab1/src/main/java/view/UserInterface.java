package view;

import model.*;

import java.util.List;
import java.util.Scanner;
class UserInterface {
    private Gift gift;
    private Scanner input;

    private static UserInterface instance;
    private UserInterface(){}

    public static UserInterface getInstance() {
        if (instance == null) {
            synchronized (UserInterface.class) {
                if (instance == null) {
                    instance = new UserInterface();
                }
            }
        }
        return instance;
    }

    public void runUserInterface() {
        gift = new Gift("gift");
        input = new Scanner(System.in);
        while (true) {
            printMenu();
            int command = input.nextInt();
            if (command == 0) {
                break;
            }
            commandExecution(command);
        }

    }

    private void printMenu(){
        System.out.println("Hi, welcome to the gift. Choose the action:\n" +
                "1. Create a cookie \n" +
                "2. Create a sweet \n" +
                "3. Create a wafer \n" +
                "4. Create a chocolate \n" +
                "5. Show all items \n" +
                "6. Sort items by weight \n" +
                "7. Find items by sugar\n" +
                "8. Print total weight\n" +
                "9. Print total sugar\n" +

                "0. Exit");
    }

    private void commandExecution(int command) {
        switch (command) {
            case 1: {
                Item item = createItem(ItemType.Cookie);
                gift.addItem(item);
                break;
            }
            case 2: {
                Item item = createItem(ItemType.Sweet);
                gift.addItem(item);
                break;
            }
            case 3: {
                Item item = createItem(ItemType.Wafer);
                gift.addItem(item);
                break;
            }
            case 4: {
                Item item = createItem(ItemType.Chocolate);
                gift.addItem(item);
                break;
            }
            case 5: {
                System.out.println("All items: ");
                gift.printItems();
                break;
            }
            case 6: {
                System.out.println("Sorted items");
                gift.sortItemsByWeight();
                gift.printItems();
                break;
            }
            case 7: {
                System.out.println("Enter lower bound");
                int lowerBound = input.nextInt();
                System.out.println("Enter upper bound");
                int upperBound = input.nextInt();
                List<Item> result = gift.getItemsBySugar(lowerBound, upperBound);
                System.out.println(result);
                break;
            }
            case 8: {
                System.out.println("Total weight: ");
                System.out.println(gift.getTotalWeight());
                break;
            }
            case 9: {
                System.out.println("Total sugar: ");
                System.out.println(gift.getTotalSugar());
                break;
            }
        }
    }

    private Item createItem(ItemType type) {
        Scanner inputString = new Scanner(System.in);
        System.out.println("Choose a name for your item");
        String name = inputString.nextLine();
        System.out.println("Enter the weight");
        int payload = input.nextInt();
        System.out.println("Enter the sugar");
        int rangeOfFlight = input.nextInt();


        if (type == ItemType.Cookie) {
            return new Cookie(name,payload,rangeOfFlight);
        }
        if (type == ItemType.Sweet) {
            return new Sweet(name,payload,rangeOfFlight);
        }
        if (type == ItemType.Wafer) {
            return new Wafer(name,payload,rangeOfFlight);
        }
        else {
            return new Chocolate(name,payload,rangeOfFlight);
        }
    }
}