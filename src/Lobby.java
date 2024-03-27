import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The {@code Lobby} class represents the lobby screen in the Elden Rogue game.
 * It provides options for fast travel, leveling up, and quitting the game.
 * 
 *
 * @version 1.0
 */
public class Lobby {

    // private Character character;
    private int scanL;
    private Boolean back;
    private Inventory inventory;
    private Shop shop;

    /**
     * The scanner for taking input from the user.
     */
    Scanner lc = new Scanner(System.in);
    Scanner asc = new Scanner(System.in);

    /**
     * Constructs a new {@code Lobby} instance.
     * 
     * @param game The {@code Game} instance associated with the lobby.
     */
    public Lobby(Game game) {
        inventory = new Inventory();
        // inventory.addWeapon();
        shop = new Shop();
    }

    /**
     * Handles the process of leveling up the character's stats.
     * 
     * @param character The character whose stats are being leveled up.
     * 
     * @exception InputMismatchException When Integer input is given a Character or
     *                                   String.
     */
    public void lvlUp(Character character) {
        int lvlupchoice = 0;
        int upgraded;
        int runeCost;
        do {
            do {
                try {
                    System.out.println("CHOOSE THE STAT YOU WANT TO LEVEL UP\n");
                    System.out.println("CURRENT LEVEL: " + character.getLevel() + "\n");
                    System.out.println("RUNES: " + character.getRunes() + "\n");

                    System.out.println("[1]LEVEL HEALTH          " + character.getStats(0));
                    System.out.println("[2]LEVEL ENDURANCE       " + character.getStats(1));
                    System.out.println("[3]LEVEL DEXTERITY       " + character.getStats(2));
                    System.out.println("[4]LEVEL STRENGTH        " + character.getStats(3));
                    System.out.println("[5]LEVEL INTELLIGENCE    " + character.getStats(4));
                    System.out.println("[6]LEVEL FAITH           " + character.getStats(5));
                    System.out.println("[7]BACK \n");

                    lvlupchoice = lc.nextInt();
                    System.out.print("\033\143");

                    runeCost = (character.getLevel() * 100) / 2;
                    switch (lvlupchoice) {
                        case 1:
                            if (character.getRunes() >= runeCost && character.getStats(0) < 50) {
                                System.out.print("\033\143");
                                upgraded = character.getStats(0) + 1;
                                character.setStats(upgraded, 0);
                                character.setRunes(character.getRunes() - runeCost);
                                character.levelUp();
                                System.out.println("SUCCESSFULLY UPGRADED");
                            } else if (character.getStats(0) == 50)
                                System.out.println("MAX LEVEL REACHED");
                            else
                                System.out.println("NOT ENOUGH RUNES");
                            break;
                        case 2:
                            if (character.getRunes() >= runeCost && character.getStats(1) < 50) {
                                upgraded = character.getStats(1) + 1;
                                character.setStats(upgraded, 1);
                                character.setRunes(character.getRunes() - runeCost);
                                character.levelUp();
                                System.out.println("SUCCESSFULLY UPGRADED");
                            } else if (character.getStats(1) == 50)
                                System.out.println("MAX LEVEL REACHED");
                            else
                                System.out.println("NOT ENOUGH RUNES");
                            break;
                        case 3:
                            if (character.getRunes() >= runeCost && character.getStats(2) < 50) {
                                upgraded = character.getStats(2) + 1;
                                character.setStats(upgraded, 2);
                                character.setRunes(character.getRunes() - runeCost);
                                character.levelUp();
                                System.out.println("SUCCESSFULLY UPGRADED");
                            } else if (character.getStats(2) == 50)
                                System.out.println("MAX LEVEL REACHED");
                            else
                                System.out.println("NOT ENOUGH RUNES");
                            break;
                        case 4:
                            if (character.getRunes() >= runeCost && character.getStats(3) < 50) {
                                upgraded = character.getStats(3) + 1;
                                character.setStats(upgraded, 3);
                                character.setRunes(character.getRunes() - runeCost);
                                character.levelUp();
                                System.out.println("SUCCESSFULLY UPGRADED");
                            } else if (character.getStats(3) == 50)
                                System.out.println("MAX LEVEL REACHED");
                            else
                                System.out.println("NOT ENOUGH RUNES");
                            break;
                        case 5:
                            if (character.getRunes() >= runeCost && character.getStats(4) < 50) {
                                upgraded = character.getStats(4) + 1;
                                character.setStats(upgraded, 4);
                                character.setRunes(character.getRunes() - runeCost);
                                character.levelUp();
                                System.out.println("SUCCESSFULLY UPGRADED");
                            } else if (character.getStats(4) == 50)
                                System.out.println("MAX LEVEL REACHED");
                            else
                                System.out.println("NOT ENOUGH RUNES");
                            break;
                        case 6:
                            if (character.getRunes() >= runeCost && character.getStats(5) < 50) {
                                upgraded = character.getStats(5) + 1;
                                character.setStats(upgraded, 5);
                                character.setRunes(character.getRunes() - runeCost);
                                character.levelUp();
                                System.out.println("SUCCESSFULLY UPGRADED");
                            } else if (character.getStats(5) == 50)
                                System.out.println("MAX LEVEL REACHED");
                            else
                                System.out.println("NOT ENOUGH RUNES");
                            break;
                        case 7:
                            lobbyScreen(character);
                            break;

                    }
                } catch (InputMismatchException e) {
                    lc.nextLine();
                    System.out.print("\033\143");
                    System.out.println("Invalid Input");
                }

            } while (lvlupchoice > 7 || lvlupchoice < 1);

        } while (lvlupchoice < 7);
    }

    /**
     * Displays the lobby screen and handles player interactions.
     * 
     * @param character The character associated with the lobby.
     * 
     * @exception InputMismatchException If asking for an int then given a string or
     *                                   char.
     */
    public void lobbyScreen(Character character) {
        // make another loop
        this.back = false;
        do {
            do {
                try {
                    System.out.println("LOBBY\n");
                    System.out.println("[1]FAST TRAVEL");
                    System.out.println("[2]LEVEL UP");
                    System.out.println("[3]INVENTORY");
                    System.out.println("[4]SHOP");
                    System.out.println("[5]QUIT GAME");
                    System.out.print("\nWhat would you like to do: ");
                    scanL = lc.nextInt();
                    System.out.print("\033\143");

                    switch (scanL) {
                        case 1:
                            boolean toLobby = false;

                            Area area = null;
                            do {
                                System.out.println("FAST TRAVEL\n");
                                System.out.println("[1] STORMVEIL CASTLE        Clears: [" + character.getAreaClear(1) + "]");
                                System.out.println("[2] RAYA LUCARIA ACADEMY    Clears: [" + character.getAreaClear(2) + "]");
                                if(character.getAreaClear(1) >= 10 && character.getAreaClear(2) >= 10)
                                    System.out.println("[3] THE ELDEN THRONE        Clears: [" + character.getAreaClear(3) + "]");
                                System.out.println("[0] RETURN TO LOBBY");
                                System.out.print("\nTravel to where: ");
                                try {
                                    int selArea = lc.nextInt();

                                    if (selArea >= 0 && selArea <= 3) {
                                        switch (selArea) {
                                            case 0:
                                                toLobby = true;
                                                break;
                                            case 1:
                                                area = new StormveilCastle(character);
                                                break;
                                            case 2:
                                                area = new RayaLucaria(character);
                                                break;
                                            case 3:
                                                if (character.getAreaClear(1) >= 10 && character.getAreaClear(2) >= 10) {
                                                    System.out.println("WIP [LOCKED]");
                                                } else {
                                                    System.out.println("WIP");
                                                }
                                                toLobby = true;
                                                break;
                                        }
                                        System.out.print("\033\143");
                                        char move;
                                        while (toLobby == false) {
                                            try {
                                                area.printArea();
                                                System.out.println("Action: ");
                                                move = asc.next(".").charAt(0);
                                                System.out.print("\033\143");

                                                if (move == 'e' || move == 'E')
                                                    toLobby = area.interact();
                                                else if (move == 'W' || move == 'w' || move == 'A' || move == 'a'
                                                        || move == 'S' || move == 's' || move == 'D' || move == 'd') {
                                                    area.movePlayer(move);
                                                } else {
                                                    System.out.print("\033\143");
                                                    System.out.println("Invalid input!\n");
                                                }
                                            } catch (InputMismatchException e) {
                                                asc.nextLine();
                                                System.out.print("\033\143");
                                                System.out.println("Invalid input!\n");
                                            }
                                        }
                                    } else {
                                        System.out.print("\033\143");
                                        System.out.println("Invalid input!\n");
                                    }
                                } catch (InputMismatchException e) {
                                    lc.nextLine();
                                    System.out.print("\033\143");
                                    System.out.println("Invalid input!\n");
                                }
                            } while (toLobby == false);
                            break;
                        case 2:
                            lvlUp(character);
                            break;
                        case 3:

                            inventory.inventoryScreen(character);
                            break;
                        case 4:
                            shop.shopScreen(inventory, character);
                            break;
                        case 5:
                            System.out.println("Bye.");
                            this.back = true;
                            break;
                        default:
                            System.out.println("Invalid input!\n");
                            break;
                    }
                } catch (InputMismatchException e) {
                    lc.nextLine();
                    System.out.print("\033\143");
                    System.out.println("Invalid input!\n");
                }
            } while (scanL > 5 || scanL < 1);
        } while (scanL != 5);

    }

    /**
     * Checks if the player wants to return to the previous screen.
     * 
     * @return {true} if the player wants to go back, {false} otherwise.
     */
    public Boolean returnBack() {
        return this.back;
    }
}
