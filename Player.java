import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Player {
    private int money = 0;
    private boolean inShop = false;
    private boolean inCave = false;
    private boolean win = false;
    private int shopTier = 0;

    public Player() { }

    public void startGame() {
        Scanner scan = new Scanner(System.in);
        while (!win) {
            if (!inShop && !inCave) {
                System.out.println("Current balance: " + money + "$");
                System.out.println("1: Enter a cave");
                System.out.println("2: Enter the shop");
                System.out.println("Other: Leave the town.");
                System.out.print("Select an option: ");
                String enterOption = scan.nextLine();
                if (enterOption.equals("1")) {
                    enterCave();
                    inCave = true;
                } else if (enterOption.equals("2")) {
                    enterShop();
                    inShop = true;
                } else {
                    System.out.println("You left the town.");
                    win = true;
                }
            }
        }

    }

    public void enterCave() {
        Cave darkCave = new Cave((int) (Math.random() * 4) + 1);
        ArrayList<Crystal> crystalOptions = darkCave.getCrystals();
        for (int i = 1; i <= crystalOptions.size(); i++) {
            Crystal crystal = crystalOptions.get(i - 1);
            System.out.println("Crystal " + i + ": " + ((1000 - crystal.getOdds()) / 10.0) + "% success chance, Worth " + crystal.getValue() + "$");
        }
        Scanner miner = new Scanner(System.in);
        int selection = 1000;
        while (selection > crystalOptions.size() || selection <= 0) {
            try {
                selection = miner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Select a valid crystal.");
                selection = 1000;
                miner.nextLine();
            }

        }
        int mineCondition = crystalOptions.get(selection-1).mine();
        if (mineCondition == -1) {
            System.out.println("The crystal broke.");
        } else {
            System.out.println("You successfully mined the crystal!");
            money += mineCondition;
            System.out.println("Current balance: " + money + "$");
        }
        inCave = false;
        System.out.println("-------------------------");
        startGame();
    }
    public void enterShop() {
        Scanner shopScan = new Scanner(System.in);
        inShop = true;
        Shop stuff = new Shop(shopTier, money);
        System.out.println("Would you like to buy something (1), switch the shop tier for $10000 (2), or go back (else)?");
        int shopOption = shopScan.nextInt();
        if (shopOption == 1) {
            while (inShop) {
                int buyValue = stuff.buy();
                if (buyValue < 4) {
                    System.out.println("You bought your dream item!");
                    win = true;
                    System.exit(0);
                } else if (buyValue == 4) {
                    inShop = false;
                    startGame();
                } else {
                    System.out.println("You cannot buy that item.");
                }
            }
        } else if (shopOption == 2) {
            if (money >= 10000) {
                shopTier = stuff.switchShop();
                money -= 10000;
            } else {
                System.out.println("You do not have enough money.");
            }
            enterShop();
        } else {
            inShop = false;
            startGame();
        }

    }
}
