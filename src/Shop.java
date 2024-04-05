import java.util.Scanner;

public class Shop {

    // private Weapon weapon;
    // private Inventory inventory;

    private Weapon sword1;
    private Weapon sword2;
    private Weapon sword3;
    private Weapon sword4;

    private Weapon katana1;
    private Weapon katana2;
    private Weapon katana3;
    private Weapon katana4;

    private Weapon whip1;
    private Weapon whip2;
    private Weapon whip3;
    private Weapon whip4;

    private Weapon greatsword1;
    private Weapon greatsword2;
    private Weapon greatsword3;
    private Weapon greatsword4;

    private Weapon staff1;
    private Weapon staff2;
    private Weapon staff3;
    private Weapon staff4;

    private Weapon seal1;
    private Weapon seal2;
    private Weapon seal3;
    private Weapon seal4;

    Scanner shc = new Scanner(System.in);
    Scanner wc = new Scanner(System.in);

    /**
     *
     * Constructor for the Shop object
     * 
     * Creates the weapon objects that are purchaseable and useable by the player
     * 
     */
    public Shop() {
        createWeapons();
    }

    /**
     * 
     * Shop screen function for the text based output
     * 
     * 
     * @param inventory is the inventory object
     * @param character is the character object
     * 
     */
    public void shopScreen(Inventory inventory, Character character) {
        int opChoice;
        int wChoice;

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
                    do {
                        showWeapon(sword1, 1);
                        showWeapon(sword2, 2);
                        showWeapon(sword3, 3);
                        showWeapon(sword4, 4);
                        System.out.println("\n[5]BACK\n");
                        System.out.println("\n Select the Weapon you want (or go back):");
                        wChoice = wc.nextInt();
                        switch (wChoice) {
                            case 1:
                                if (character.getRunes() >= sword1.getRuneCost()) {
                                    purchaseWeapon(inventory, sword1);
                                    System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                                } else {
                                    System.out.println("\nNOT ENOUGH RUNES");
                                }

                                break;
                            case 2:
                                if (character.getRunes() >= sword2.getRuneCost()) {
                                    purchaseWeapon(inventory, sword2);
                                    System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                                } else {
                                    System.out.println("\nNOT ENOUGH RUNES");
                                }
                                break;
                            case 3:
                                if (character.getRunes() >= sword3.getRuneCost()) {
                                    purchaseWeapon(inventory, sword3);
                                    System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                                } else {
                                    System.out.println("\nNOT ENOUGH RUNES");
                                }
                                break;
                            case 4:
                                if (character.getRunes() >= sword4.getRuneCost()) {
                                    purchaseWeapon(inventory, sword4);
                                    System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                                } else {
                                    System.out.println("\nNOT ENOUGH RUNES");
                                }
                                break;
                            case 5:

                                opChoice = 8;

                                System.out.println(opChoice);
                                break;
                            default:
                                break;
                        }
                    } while (wChoice > 5 || wChoice < 1);

                    break;
                case 2:
                    do {
                        showWeapon(katana1, 1);
                        showWeapon(katana2, 2);
                        showWeapon(katana3, 3);
                        showWeapon(katana4, 4);
                        System.out.println("\n[5]BACK\n");
                        System.out.println("\n Select the Weapon you want (or go back):");
                        wChoice = wc.nextInt();
                        switch (wChoice) {
                            case 1:
                                if (character.getRunes() >= katana1.getRuneCost()) {
                                    purchaseWeapon(inventory, katana1);
                                    System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                                } else {
                                    System.out.println("\nNOT ENOUGH RUNES");
                                }

                                break;
                            case 2:
                                if (character.getRunes() >= katana2.getRuneCost()) {
                                    purchaseWeapon(inventory, katana2);
                                    System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                                } else {
                                    System.out.println("\nNOT ENOUGH RUNES");
                                }
                                break;
                            case 3:
                                if (character.getRunes() >= katana3.getRuneCost()) {
                                    purchaseWeapon(inventory, katana3);
                                    System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                                } else {
                                    System.out.println("\nNOT ENOUGH RUNES");
                                }
                                break;
                            case 4:
                                if (character.getRunes() >= katana4.getRuneCost()) {
                                    purchaseWeapon(inventory, katana4);
                                    System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                                } else {
                                    System.out.println("\nNOT ENOUGH RUNES");
                                }
                                break;
                            case 5:

                                opChoice = 8;

                                System.out.println(opChoice);
                                break;
                            default:
                                break;
                        }
                    } while (wChoice > 5 || wChoice < 1);
                    break;
                case 3:
                    do {
                        showWeapon(whip1, 1);
                        showWeapon(whip2, 2);
                        showWeapon(whip3, 3);
                        showWeapon(whip4, 4);
                        System.out.println("\n[5]BACK\n");
                        System.out.println("\n Select the Weapon you want (or go back):");
                        wChoice = wc.nextInt();
                        switch (wChoice) {
                            case 1:
                                if (character.getRunes() >= whip1.getRuneCost()) {
                                    purchaseWeapon(inventory, whip1);
                                    System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                                } else {
                                    System.out.println("\nNOT ENOUGH RUNES");
                                }

                                break;
                            case 2:
                                if (character.getRunes() >= whip2.getRuneCost()) {
                                    purchaseWeapon(inventory, whip2);
                                    System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                                } else {
                                    System.out.println("\nNOT ENOUGH RUNES");
                                }
                                break;
                            case 3:
                                if (character.getRunes() >= whip3.getRuneCost()) {
                                    purchaseWeapon(inventory, whip3);
                                    System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                                } else {
                                    System.out.println("\nNOT ENOUGH RUNES");
                                }
                                break;
                            case 4:
                                if (character.getRunes() >= whip4.getRuneCost()) {
                                    purchaseWeapon(inventory, whip4);
                                    System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                                } else {
                                    System.out.println("\nNOT ENOUGH RUNES");
                                }
                                break;
                            case 5:

                                opChoice = 8;

                                System.out.println(opChoice);
                                break;
                            default:
                                break;
                        }
                    } while (wChoice > 5 || wChoice < 1);
                    break;
                case 4:
                    do {
                        showWeapon(greatsword1, 1);
                        showWeapon(greatsword2, 2);
                        showWeapon(greatsword3, 3);
                        showWeapon(greatsword4, 4);
                        System.out.println("\n[5]BACK\n");
                        System.out.println("\n Select the Weapon you want (or go back):");
                        wChoice = wc.nextInt();
                        switch (wChoice) {
                            case 1:
                                if (character.getRunes() >= greatsword1.getRuneCost()) {
                                    purchaseWeapon(inventory, greatsword1);
                                    System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                                } else {
                                    System.out.println("\nNOT ENOUGH RUNES");
                                }

                                break;
                            case 2:
                                if (character.getRunes() >= greatsword2.getRuneCost()) {
                                    purchaseWeapon(inventory, greatsword2);
                                    System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                                } else {
                                    System.out.println("\nNOT ENOUGH RUNES");
                                }
                                break;
                            case 3:
                                if (character.getRunes() >= greatsword3.getRuneCost()) {
                                    purchaseWeapon(inventory, greatsword3);
                                    System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                                } else {
                                    System.out.println("\nNOT ENOUGH RUNES");
                                }
                                break;
                            case 4:
                                if (character.getRunes() >= greatsword4.getRuneCost()) {
                                    purchaseWeapon(inventory, greatsword4);
                                    System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                                } else {
                                    System.out.println("\nNOT ENOUGH RUNES");
                                }
                                break;
                            case 5:

                                opChoice = 8;

                                System.out.println(opChoice);
                                break;
                            default:
                                break;
                        }
                    } while (wChoice > 5 || wChoice < 1);
                    break;
                case 5:
                    do {
                        showWeapon(staff1, 1);
                        showWeapon(staff2, 2);
                        showWeapon(staff3, 3);
                        showWeapon(staff4, 4);
                        System.out.println("\n[5]BACK\n");
                        System.out.println("\n Select the Weapon you want (or go back):");
                        wChoice = wc.nextInt();
                        switch (wChoice) {
                            case 1:
                                if (character.getRunes() >= staff1.getRuneCost()) {
                                    purchaseWeapon(inventory, staff1);
                                    System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                                } else {
                                    System.out.println("\nNOT ENOUGH RUNES");
                                }

                                break;
                            case 2:
                                if (character.getRunes() >= staff2.getRuneCost()) {
                                    purchaseWeapon(inventory, staff2);
                                    System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                                } else {
                                    System.out.println("\nNOT ENOUGH RUNES");
                                }
                                break;
                            case 3:
                                if (character.getRunes() >= staff3.getRuneCost()) {
                                    purchaseWeapon(inventory, staff3);
                                    System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                                } else {
                                    System.out.println("\nNOT ENOUGH RUNES");
                                }
                                break;
                            case 4:
                                if (character.getRunes() >= staff4.getRuneCost()) {
                                    purchaseWeapon(inventory, staff4);
                                    System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                                } else {
                                    System.out.println("\nNOT ENOUGH RUNES");
                                }
                                break;
                            case 5:

                                opChoice = 8;

                                System.out.println(opChoice);
                                break;
                            default:
                                break;
                        }
                    } while (wChoice > 5 || wChoice < 1);
                    break;
                case 6:
                    do {
                        showWeapon(seal1, 1);
                        showWeapon(seal2, 2);
                        showWeapon(seal3, 3);
                        showWeapon(seal4, 4);
                        System.out.println("\n[5]BACK\n");
                        System.out.println("\n Select the Weapon you want (or go back):");
                        wChoice = wc.nextInt();
                        switch (wChoice) {
                            case 1:
                                if (character.getRunes() >= seal1.getRuneCost()) {
                                    purchaseWeapon(inventory, seal1);
                                    System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                                } else {
                                    System.out.println("\nNOT ENOUGH RUNES");
                                }

                                break;
                            case 2:
                                if (character.getRunes() >= seal2.getRuneCost()) {
                                    purchaseWeapon(inventory, seal2);
                                    System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                                } else {
                                    System.out.println("\nNOT ENOUGH RUNES");
                                }
                                break;
                            case 3:
                                if (character.getRunes() >= seal3.getRuneCost()) {
                                    purchaseWeapon(inventory, seal3);
                                    System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                                } else {
                                    System.out.println("\nNOT ENOUGH RUNES");
                                }
                                break;
                            case 4:
                                if (character.getRunes() >= seal4.getRuneCost()) {
                                    purchaseWeapon(inventory, seal4);
                                    System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                                } else {
                                    System.out.println("\nNOT ENOUGH RUNES");
                                }
                                break;
                            case 5:

                                opChoice = 8;

                                System.out.println(opChoice);
                                break;
                            default:
                                break;
                        }
                    } while (wChoice > 5 || wChoice < 1);
                    break;
                case 7:
                    break;
                default:
                    break;
            }
        } while (opChoice > 7 || opChoice < 1);

    }

    /**
     * 
     * Creates the weapon objects that are purchaseable and useable by the player
     * 
     * 
     */
    public void createWeapons() {

        // SWORDS
        sword1 = new Sword("Short Sword", 1000, 0, 15, 13, 15, 15, 15);
        sword2 = new Sword("Roger's Rapier", 2000, 10, 25, 18, 35, 35, 35);
        sword3 = new Sword("Coded Sword", 4000, 20, 35, 21, 40, 40, 40);
        sword4 = new Sword("Sword of Night and Flame", 8000, 30, 45, 25, 55, 55, 55);

        // KATANAS
        katana1 = new Katana("Uchigatana", 1875, 20, 35, 15, 30, 0, 0);
        katana2 = new Katana("Moonveil", 3750, 30, 40, 20, 45, 0, 0);
        katana3 = new Katana("Rivers of Blood", 7500, 40, 45, 25, 60, 0, 0);
        katana4 = new Katana("Hand of Malenia", 15000, 50, 50, 30, 75, 0, 0);

        // WHIPS
        whip1 = new Whip("Whip", 1500, 15, 60, 20, 30, 0, 0);
        whip2 = new Whip("Urumi", 3000, 20, 70, 25, 40, 10, 0);
        whip3 = new Whip("Thorned Whip", 5000, 30, 80, 30, 50, 0, 40);
        whip4 = new Whip("Hoslow's Petal Whip", 10000, 35, 90, 35, 55, 20, 20);

        // GREATSWORDS
        greatsword1 = new GreatSword("Claymore", 3000, 15, 10, 9, 20, 0, 0);
        greatsword2 = new GreatSword("Starscourge GreatSword", 6000, 20, 15, 14, 40, 0, 20);
        greatsword3 = new GreatSword("Inseparable Sword", 12000, 25, 20, 19, 70, 60, 60);
        greatsword4 = new GreatSword("Maliketh's Black Blade", 24000, 30, 25, 24, 80, 40, 60);

        // STAVES
        staff1 = new Staff("Astrologer's Staff", 2000, 5, 20, 12, 5, 25, 15);
        staff2 = new Staff("Albinauric Staff", 4000, 10, 30, 14, 10, 45, 35);
        staff3 = new Staff("Staff of the Guilty", 8000, 15, 40, 16, 15, 65, 60);
        staff4 = new Staff("Carian Regal Scepter", 16000, 25, 50, 18, 20, 85, 75);

        // SEALS
        seal1 = new Seal("Finger Seal", 2500, 10, 45, 10, 0, 15, 20);
        seal2 = new Seal("GodSlayer's Seal", 5000, 15, 50, 12, 0, 35, 40);
        seal3 = new Seal("Golden Order Seal", 10000, 20, 55, 14, 0, 65, 65);
        seal4 = new Seal("Dragon Communion Seal", 15000, 25, 60, 18, 0, 75, 80);
    }

    /**
     * 
     * Function for purchasing weapons
     * 
     * @param inventory is the inventory object
     * @param weapon    is the weapon object to be purchased
     */
    public void purchaseWeapon(Inventory inventory, Weapon weapon) {
        inventory.addWeapon(weapon);
    }

    /**
     * 
     * Function that applies the logic of the shop to be used in the MVC structure
     * it is a modified version of the Shop screen function and is going to be
     * called
     * in the Shop model
     * 
     * @param opChoice  is the weapon category
     * @param wChoice   is tha actual weapon choice of the playher
     * @param character is the the character object
     * @param inventory is the inventory object
     * 
     */
    public boolean modifiedShop(int opChoice, int wChoice, Character character, Inventory inventory) {

        switch (opChoice) {
            case 1:

                showWeapon(sword1, 1);
                showWeapon(sword2, 2);
                showWeapon(sword3, 3);
                showWeapon(sword4, 4);
                System.out.println("\n[5]BACK\n");
                System.out.println("\n Select the Weapon you want (or go back):");
                // wChoice = wc.nextInt();
                switch (wChoice) {
                    case 1:
                        if (character.getRunes() >= sword1.getRuneCost()) {
                            purchaseWeapon(inventory, sword1);
                            System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                            return true;
                        } else {
                            System.out.println("\nNOT ENOUGH RUNES");
                        }

                        break;
                    case 2:
                        if (character.getRunes() >= sword2.getRuneCost()) {
                            purchaseWeapon(inventory, sword2);
                            System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                            return true;
                        } else {
                            System.out.println("\nNOT ENOUGH RUNES");
                        }
                        break;
                    case 3:
                        if (character.getRunes() >= sword3.getRuneCost()) {
                            purchaseWeapon(inventory, sword3);
                            System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                            return true;
                        } else {
                            System.out.println("\nNOT ENOUGH RUNES");
                        }
                        break;
                    case 4:
                        if (character.getRunes() >= sword4.getRuneCost()) {
                            purchaseWeapon(inventory, sword4);
                            System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                            return true;
                        } else {
                            System.out.println("\nNOT ENOUGH RUNES");
                        }
                        break;
                    // case 5:

                    // opChoice = 8;

                    // System.out.println(opChoice);
                    // break;
                    default:
                        break;
                }

                break;
            case 2:

                showWeapon(katana1, 1);
                showWeapon(katana2, 2);
                showWeapon(katana3, 3);
                showWeapon(katana4, 4);
                System.out.println("\n[5]BACK\n");
                System.out.println("\n Select the Weapon you want (or go back):");
                // wChoice = wc.nextInt();
                switch (wChoice) {
                    case 1:
                        if (character.getRunes() >= katana1.getRuneCost()) {
                            purchaseWeapon(inventory, katana1);
                            System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                            return true;
                        } else {
                            System.out.println("\nNOT ENOUGH RUNES");

                        }

                        break;
                    case 2:
                        if (character.getRunes() >= katana2.getRuneCost()) {
                            purchaseWeapon(inventory, katana2);
                            System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                            return true;
                        } else {
                            System.out.println("\nNOT ENOUGH RUNES");
                        }
                        break;
                    case 3:
                        if (character.getRunes() >= katana3.getRuneCost()) {
                            purchaseWeapon(inventory, katana3);
                            System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                            return true;
                        } else {
                            System.out.println("\nNOT ENOUGH RUNES");
                        }
                        break;
                    case 4:
                        if (character.getRunes() >= katana4.getRuneCost()) {
                            purchaseWeapon(inventory, katana4);
                            System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                            return true;
                        } else {
                            System.out.println("\nNOT ENOUGH RUNES");
                        }
                        break;
                    // case 5:

                    // opChoice = 8;

                    // System.out.println(opChoice);
                    // break;
                    default:
                        break;
                }

                break;
            case 3:

                showWeapon(whip1, 1);
                showWeapon(whip2, 2);
                showWeapon(whip3, 3);
                showWeapon(whip4, 4);
                System.out.println("\n[5]BACK\n");
                System.out.println("\n Select the Weapon you want (or go back):");
                // wChoice = wc.nextInt();
                switch (wChoice) {
                    case 1:
                        if (character.getRunes() >= whip1.getRuneCost()) {
                            purchaseWeapon(inventory, whip1);
                            System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                            return true;
                        } else {
                            System.out.println("\nNOT ENOUGH RUNES");
                        }

                        break;
                    case 2:
                        if (character.getRunes() >= whip2.getRuneCost()) {
                            purchaseWeapon(inventory, whip2);
                            System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                            return true;
                        } else {
                            System.out.println("\nNOT ENOUGH RUNES");
                        }
                        break;
                    case 3:
                        if (character.getRunes() >= whip3.getRuneCost()) {
                            purchaseWeapon(inventory, whip3);
                            System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                            return true;
                        } else {
                            System.out.println("\nNOT ENOUGH RUNES");
                        }
                        break;
                    case 4:
                        if (character.getRunes() >= whip4.getRuneCost()) {
                            purchaseWeapon(inventory, whip4);
                            System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                            return true;
                        } else {
                            System.out.println("\nNOT ENOUGH RUNES");
                        }
                        break;
                    // case 5:

                    // opChoice = 8;

                    // System.out.println(opChoice);
                    // break;
                    default:
                        break;
                }

                break;
            case 4:

                showWeapon(greatsword1, 1);
                showWeapon(greatsword2, 2);
                showWeapon(greatsword3, 3);
                showWeapon(greatsword4, 4);
                System.out.println("\n[5]BACK\n");
                System.out.println("\n Select the Weapon you want (or go back):");
                // wChoice = wc.nextInt();
                switch (wChoice) {
                    case 1:
                        if (character.getRunes() >= greatsword1.getRuneCost()) {
                            purchaseWeapon(inventory, greatsword1);
                            System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                            return true;
                        } else {
                            System.out.println("\nNOT ENOUGH RUNES");
                        }

                        break;
                    case 2:
                        if (character.getRunes() >= greatsword2.getRuneCost()) {
                            purchaseWeapon(inventory, greatsword2);
                            System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                            return true;
                        } else {
                            System.out.println("\nNOT ENOUGH RUNES");
                        }
                        break;
                    case 3:
                        if (character.getRunes() >= greatsword3.getRuneCost()) {
                            purchaseWeapon(inventory, greatsword3);
                            System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                            return true;
                        } else {
                            System.out.println("\nNOT ENOUGH RUNES");
                        }
                        break;
                    case 4:
                        if (character.getRunes() >= greatsword4.getRuneCost()) {
                            purchaseWeapon(inventory, greatsword4);
                            System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                            return true;
                        } else {
                            System.out.println("\nNOT ENOUGH RUNES");
                        }
                        break;
                    // case 5:

                    // opChoice = 8;

                    // System.out.println(opChoice);
                    // break;
                    default:
                        break;
                }

                break;
            case 5:

                showWeapon(staff1, 1);
                showWeapon(staff2, 2);
                showWeapon(staff3, 3);
                showWeapon(staff4, 4);
                System.out.println("\n[5]BACK\n");
                System.out.println("\n Select the Weapon you want (or go back):");
                // wChoice = wc.nextInt();
                switch (wChoice) {
                    case 1:
                        if (character.getRunes() >= staff1.getRuneCost()) {
                            purchaseWeapon(inventory, staff1);
                            System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                            return true;
                        } else {
                            System.out.println("\nNOT ENOUGH RUNES");
                        }

                        break;
                    case 2:
                        if (character.getRunes() >= staff2.getRuneCost()) {
                            purchaseWeapon(inventory, staff2);
                            System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                            return true;
                        } else {
                            System.out.println("\nNOT ENOUGH RUNES");
                        }
                        break;
                    case 3:
                        if (character.getRunes() >= staff3.getRuneCost()) {
                            purchaseWeapon(inventory, staff3);
                            System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                            return true;
                        } else {
                            System.out.println("\nNOT ENOUGH RUNES");
                        }
                        break;
                    case 4:
                        if (character.getRunes() >= staff4.getRuneCost()) {
                            purchaseWeapon(inventory, staff4);
                            System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                            return true;
                        } else {
                            System.out.println("\nNOT ENOUGH RUNES");
                        }
                        break;
                    // case 5:

                    // opChoice = 8;

                    // System.out.println(opChoice);
                    // break;
                    default:
                        break;
                }

                break;
            case 6:

                showWeapon(seal1, 1);
                showWeapon(seal2, 2);
                showWeapon(seal3, 3);
                showWeapon(seal4, 4);
                System.out.println("\n[5]BACK\n");
                System.out.println("\n Select the Weapon you want (or go back):");
                // wChoice = wc.nextInt();
                switch (wChoice) {
                    case 1:
                        if (character.getRunes() >= seal1.getRuneCost()) {
                            purchaseWeapon(inventory, seal1);
                            System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                            return true;
                        } else {
                            System.out.println("\nNOT ENOUGH RUNES");
                        }

                        break;
                    case 2:
                        if (character.getRunes() >= seal2.getRuneCost()) {
                            purchaseWeapon(inventory, seal2);
                            System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                            return true;
                        } else {
                            System.out.println("\nNOT ENOUGH RUNES");
                        }
                        break;
                    case 3:
                        if (character.getRunes() >= seal3.getRuneCost()) {
                            purchaseWeapon(inventory, seal3);
                            System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                            return true;
                        } else {
                            System.out.println("\nNOT ENOUGH RUNES");
                        }
                        break;
                    case 4:
                        if (character.getRunes() >= seal4.getRuneCost()) {
                            purchaseWeapon(inventory, seal4);
                            System.out.println("\nWeapon Successfully Purchased! added to Inventory.");
                            return true;
                        } else {
                            System.out.println("\nNOT ENOUGH RUNES");
                        }
                        break;
                    // case 5:

                    // opChoice = 8;

                    // System.out.println(opChoice);
                    // break;
                    default:
                        break;
                }

                break;
            case 7:
                break;
            default:
                break;
        }
        return false;
    }

    /**
     * Display function that shows the weapons for the text based output
     * 
     * 
     */
    public void showWeapon(Weapon weapon, int i) {
        System.out.println("SELECT YOUR WEAPON");
        System.out.println("SWORDS\n");
        System.out.println("\n[" + i + "]" + weapon.getName());
        System.out.println("RUNE COST:" + weapon.getRuneCost() + "\n");
        System.out.println("WEAPON IMAGE");
        System.out.println("WEAPON DEXTERITY REQUIREMENT:    " + weapon.getWeaponStat(2));
        System.out.println("WEAPON HEALTH:                   " + weapon.getWeaponStat(0));
        System.out.println("WEAPON ENDURANCE:                " + weapon.getWeaponStat(1));
        System.out.println("WEAPON STRENGTH:                 " + weapon.getWeaponStat(3));
        System.out.println("WEAPON INTELLIGENCE:             " + weapon.getWeaponStat(4));
        System.out.println("WEAPON FAITH                     " + weapon.getWeaponStat(5));

    }

    /**
     * Getter for the weapons to be used in MVC
     * 
     * @param k is the weapon type index
     * @param i is the actual weapon index
     */
    public Weapon getWeapons(int k, int i) {
        switch (k) {
            case 1:
                switch (i) {
                    case 1:
                        return sword1;
                    case 2:
                        return sword2;
                    case 3:
                        return sword3;
                    case 4:
                        return sword4;
                }

                break;
            case 2:
                switch (i) {
                    case 1:
                        return katana1;
                    case 2:
                        return katana2;
                    case 3:
                        return katana3;
                    case 4:
                        return katana4;
                }
                break;
            case 3:
                switch (i) {
                    case 1:
                        return whip1;
                    case 2:
                        return whip2;
                    case 3:
                        return whip3;
                    case 4:
                        return whip4;
                }
                break;
            case 4:
                switch (i) {
                    case 1:
                        return greatsword1;
                    case 2:
                        return greatsword2;
                    case 3:
                        return greatsword3;
                    case 4:
                        return greatsword4;
                }
                break;
            case 5:
                switch (i) {
                    case 1:
                        return staff1;
                    case 2:
                        return staff2;
                    case 3:
                        return staff3;
                    case 4:
                        return staff4;
                }
                break;

            case 6:

                switch (i) {
                    case 1:
                        return seal1;
                    case 2:
                        return seal2;
                    case 3:
                        return seal3;
                    case 4:
                        return seal4;
                }
                break;
        }
        return null;
    }
}
