import java.util.Scanner;

public class Shop {
    private int tier = 0;
    private int balance;
    private int phonePrice =  Integer.MAX_VALUE;
    private int carPrice =  Integer.MAX_VALUE;
    private int housePrice =  Integer.MAX_VALUE;
    private int mansionPrice =  Integer.MAX_VALUE;

    public Shop(int tier, int balance) {
        this.tier = tier;
        this.balance = balance;
    }

    public int buy() {
        Scanner buyScan = new Scanner(System.in);
        if (tier == 0) {
            System.out.println("Phone: $999");
            phonePrice = 999;
        } else if (tier == 1) {
            System.out.println("Phone: $899");
            System.out.println("Car: $67000");
            phonePrice = 899;
            carPrice = 67000;
        } else if (tier == 2) {
            System.out.println("Phone: $899");
            System.out.println("Car: $60000");
            System.out.println("House: $1000000");
            phonePrice = 899;
            carPrice = 60000;
            housePrice = 1000000;
        } else if (tier == 3) {
            System.out.println("Phone: $899");
            System.out.println("Car: $60000");
            System.out.println("House: $850000");
            System.out.println("Mansion: $20000000");
            phonePrice = 899;
            carPrice = 60000;
            housePrice = 8500000;
            mansionPrice = 200000000;
        }
        String input = buyScan.nextLine();
        while (!(input.equalsIgnoreCase("phone") || (input.equalsIgnoreCase("car")) || (input.equalsIgnoreCase("house")) || (input.equalsIgnoreCase("mansion")) || (input.equalsIgnoreCase("exit")))) {
            System.out.println("Type either \"Phone\", \"Car\", \"House\", \"Mansion\", or \"exit\"");
            input = buyScan.nextLine();
        }
        if (input.equalsIgnoreCase("phone") && balance > phonePrice) {
            return 0;
        } else if (input.equalsIgnoreCase("car") && balance > carPrice) {
            return 1;
        } else if (input.equalsIgnoreCase("house") && balance > housePrice) {
            return 2;
        } else if (input.equalsIgnoreCase("mansion") && balance > mansionPrice) {
            return 3;
        } else if (input.equalsIgnoreCase("exit")) {
            return 4;
        } else {
            return 5;
        }
    }

    public int switchShop() {
        int tier = (int) (Math.random()*4);
        System.out.println("The shop is now a tier " + tier + " shop!");
        return tier;
    }

}
