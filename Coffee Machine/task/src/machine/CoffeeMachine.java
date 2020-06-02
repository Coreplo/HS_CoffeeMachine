package machine;

import java.util.Scanner;

enum machineState{
    MAIN_MENU,
    BUY,
    BUY_CHOICE,
    FILL,
    STATUS,
    TAKE,
    EXIT;
}



enum product{
    ESPRESSO(250, 0 ,16 , 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);

    int water;
    int milk;
    int coffee;
    int price;

    product(int w, int m, int c, int price){
        this.water = w;
        this.milk = m;
        this.coffee = c;
        this.price = price;
    }

    public int getWater(){
        return water;
    }
    public int getMilk(){
        return milk;
    }
    public int getCoffee(){
        return coffee;
    }
    public int getPrice(){
        return price;
    }

}

public class CoffeeMachine {

    static int availableWater = 400;
    static int availableMilk = 540;
    static int availableCoffee = 120;
    static int availableCups = 9;
    static int availableMoney = 550;

    public static void main(String[] args) {
        String action = "";
        while (action != "exit") {
            Scanner scn = new Scanner(System.in);

            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = scn.nextLine();
            System.out.println();
            switch (action) {
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill();
                    break;
                case "take":
                    take();
                    break;
                case "exit":
                    return;
                case "remaining":
                    remaining();
                    break;
                default:
                    System.out.println("this wasn't supposed to happen :( ");
            }
        }
    }

    private static void remaining() {
        System.out.println("The coffee machine has");
        System.out.println(availableWater + " of water");
        System.out.println(availableMilk + " of milk");
        System.out.println(availableCoffee + " of coffee beans");
        System.out.println(availableCups + " of disposable cups");
        System.out.println("$" + availableMoney + " of money");
        System.out.println();

    }

    private static void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        Scanner scn = new Scanner(System.in);
        String choice = scn.nextLine();

        switch (choice) {
            case "1":
                makeBeverage(250, 0, 16, 1, 4);
                break;
            case "2":
                makeBeverage(350, 75, 20, 1, 7);
                break;
            case "3":
                makeBeverage(200, 100, 12, 1, 6);
                break;
            case "back":
                return;
            default:
                System.out.println("learn to type numbers");
        }
    }

    private static void makeBeverage(int w, int m, int c, int cups, int money) {
        if (availableWater - w < 0) {
            System.out.println("Sorry, not enough water!\n");
            return;
        }
        if (availableMilk - m < 0) {
            System.out.println("I have negative milk, go figure...\n");
            return;
        }
        if (availableCoffee - c < 0) {
            System.out.println("Sorry, not enough coffee!\n");
            return;
        }
        if (availableCups - cups < 0) {
            System.out.println("Sorry, not enough disposable cups!\n");
            return;
        }
        System.out.println("I have enough resources, making you a coffee!\n");
        availableCups -= cups;
        availableWater -= w;
        availableMilk -= m;
        availableCoffee -= c;
        availableMoney += money;
    }


    private static void fill() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Write how many ml of water do you want to add: ");
        availableWater += Integer.parseInt(scn.nextLine());
        System.out.println("Write how many ml of milk do you want to add: ");
        availableMilk += Integer.parseInt(scn.nextLine());
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        availableCoffee += Integer.parseInt(scn.nextLine());
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        availableCups += Integer.parseInt(scn.nextLine());
        System.out.println();
    }

    private static void take() {
        System.out.println("I gave you $" + availableMoney);
        System.out.println();
        availableMoney = 0;
    }
}
