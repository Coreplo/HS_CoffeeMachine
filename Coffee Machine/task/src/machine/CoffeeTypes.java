package machine;

public enum CoffeeTypes {
    ESPRESSO(250, 0, 16, 4),
    LATTE(350, 75, 20, 7),
    CAPPUCCINO(200, 100, 12, 6);

    CoffeeTypes(int w, int m, int c, int p) {
        this.requiredWater = w;
        this.requiredMilk = m;
        this.requiredCoffee = c;
        this.price = p;
    }

    int requiredWater;
    int requiredMilk;
    int requiredCoffee;
    int price;
}