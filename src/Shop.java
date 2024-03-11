import java.util.Scanner;

public class Shop {

    private Weapon weapon;
    private Inventory inventory;
    Scanner shc = new Scanner(System.in);

    public Shop() {

    }

    public void shopScreen() {
        int opChoice;
        do {
            System.out.println("Welcome to the Shop!\n");
            System.out.println("What type of weapon would you like to buy?\n");
            System.out.println("\n[1] SWORDS\n");
            System.out.println("[2] KATANAS\n");
            System.out.println("[3] WHIPS\n");
            System.out.println("[4] GREATSWORDS\n");
            System.out.println("[5] STAVES\n");
            System.out.println("[6] SEALS\n");
            System.out.println("[7] EXIT SHOP\n");

            opChoice = shc.nextInt();

            switch (opChoice) {
                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                default:
                    break;
            }
        } while (opChoice > 7 && opChoice < 1);

    }

    public void createWeapons() {

    }

    public void purchaseWeapon() {

    }

    public void showSwords() {

    }

    public void showKatanas() {

    }

    public void showWhips() {

    }

    public void showGreatSwords() {

    }

    public void showStaves() {

    }

    public void showSeals() {

    }
}
