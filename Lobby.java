import java.util.InputMismatchException;
import java.util.Scanner;

public class Lobby {

    private Character character;
    private int scanL;
    private Boolean back;
    Scanner lc = new Scanner(System.in);

    public Lobby(Game game) {

    }

    public void fastTravel() {

    }

    public void lvlUp(Character character) {
        int lvlupchoice;
        int upgraded;
        int runeCost;
        do {
            do {
                System.out.println("CHOOSE THE STAT YOU WANT TO LEVEL UP\n");
                System.out.println("RUNES: " + character.getRunes() + "\n");
                System.out.println("[1]LEVEL HEALTH        " + character.getStats(0));
                System.out.println("[2]LEVEL ENDURANCE       " + character.getStats(1));
                System.out.println("[3]LEVEL DEXTERITY       " + character.getStats(2));
                System.out.println("[4]LEVEL STRENGTH        " + character.getStats(3));
                System.out.println("[5]LEVEL INTELLIGENCE        " + character.getStats(4));
                System.out.println("[6]LEVEL FAITH        " + character.getStats(5));
                System.out.println("[7]BACK \n");

                lvlupchoice = lc.nextInt();
            } while (lvlupchoice > 7 || lvlupchoice < 1);

            runeCost = (character.getLevel() * 100) / 2;
            switch (lvlupchoice) {
                case 1:
                    if (character.getRunes() >= runeCost) {
                        upgraded = character.getStats(0) + 1;
                        character.setStats(upgraded, 0);
                        character.setRunes(character.getRunes() - runeCost);
                        character.levelUp();
                        System.out.println("SUCCESSFULLY UPGRADED");
                    } else if (character.getStats(0) > 50)
                        System.out.println("MAX LEVEL REACHED");
                    else
                        System.out.println("NOT ENOUGH RUNES");
                    break;
                case 2:
                    if (character.getRunes() >= runeCost) {
                        upgraded = character.getStats(1) + 1;
                        character.setStats(upgraded, 1);
                        character.setRunes(character.getRunes() - runeCost);
                        character.levelUp();
                        System.out.println("SUCCESSFULLY UPGRADED");
                    } else if (character.getStats(1) > 50)
                        System.out.println("MAX LEVEL REACHED");
                    else
                        System.out.println("NOT ENOUGH RUNES");
                    break;
                case 3:
                    if (character.getRunes() >= runeCost) {
                        upgraded = character.getStats(2) + 1;
                        character.setStats(upgraded, 2);
                        character.setRunes(character.getRunes() - runeCost);
                        character.levelUp();
                        System.out.println("SUCCESSFULLY UPGRADED");
                    } else if (character.getStats(2) > 50)
                        System.out.println("MAX LEVEL REACHED");
                    else
                        System.out.println("NOT ENOUGH RUNES");
                    break;
                case 4:
                    if (character.getRunes() >= runeCost) {
                        upgraded = character.getStats(3) + 1;
                        character.setStats(upgraded, 3);
                        character.setRunes(character.getRunes() - runeCost);
                        character.levelUp();
                        System.out.println("SUCCESSFULLY UPGRADED");
                    } else if (character.getStats(3) > 50)
                        System.out.println("MAX LEVEL REACHED");
                    else
                        System.out.println("NOT ENOUGH RUNES");
                    break;
                case 5:
                    if (character.getRunes() >= runeCost) {
                        upgraded = character.getStats(4) + 1;
                        character.setStats(upgraded, 4);
                        character.setRunes(character.getRunes() - runeCost);
                        character.levelUp();
                        System.out.println("SUCCESSFULLY UPGRADED");
                    } else if (character.getStats(4) > 50)
                        System.out.println("MAX LEVEL REACHED");
                    else
                        System.out.println("NOT ENOUGH RUNES");
                    break;
                case 6:
                    if (character.getRunes() >= runeCost) {
                        upgraded = character.getStats(5) + 1;
                        character.setStats(upgraded, 5);
                        character.setRunes(character.getRunes() - runeCost);
                        character.levelUp();
                        System.out.println("SUCCESSFULLY UPGRADED");
                    } else if (character.getStats(5) > 50)
                        System.out.println("MAX LEVEL REACHED");
                    else
                        System.out.println("NOT ENOUGH RUNES");
                    break;
                case 7:
                    lobbyScreen(character);
                    break;
                default:
                    break;
            }
        } while (lvlupchoice < 7);
    }

    public void lobbyScreen(Character character) {
        // make another loop
        this.back = false;
        do {
            do {
                System.out.println("LOBBY\n");
                System.out.println("[1]FAST TRAVEL");
                System.out.println("[2]LEVEL UP");
                System.out.println("[5]QUIT GAME");
                System.out.println("\nWhat would you like to do?\n");
                scanL = lc.nextInt();
            } while (scanL > 5 || scanL == 4 || scanL == 3 || scanL < 1);

            switch (scanL) {
                case 1:
                    break;
                case 2:
                    lvlUp(character);
                    break;
                case 4:
                    Scanner lsc = new Scanner(System.in);
                    boolean toLobby = false;
                    Area area;
                    do{
                        area = null;
                        System.out.println("FAST TRAVEL\n");
                        System.out.println("[1] STORMVEIL CASTLE");
                        System.out.println("[2] RAYA LUCARIA ACADEMY");
                        System.out.println("[3] THE ELDEN THRONE");
                        System.out.println("[0] RETURN TO LOBBY");
                        System.out.println("\nWhere would you like to go: ");
                        try {
                            int selArea = lsc.nextInt();
                            
                            if(selArea == 0)
                                toLobby = true;
                            else {
                                switch(selArea) {
                                    case 1: 
                                        area = new StormveilCastle(character);
                                        break;
                                    case 2: 
                                        System.out.println("WIP");
                                        toLobby = true;
                                        break;
                                    case 3: 
                                         //Implement a function to get # of times a dungeon has been cleared
                                        boolean locked = true;
                                        if(locked == true) {
                                            System.out.println("WIP [LOCKED]");
                                        }
                                        else{
                                            System.out.println("WIP");
                                        }
                                        toLobby = true;
                                        break;   
                                }
                                Scanner asc = new Scanner(System.in);
                                char move;
                                boolean ft = false;
                                do {
                                    try {
                                        area.printArea();
                                        move = asc.next(".").charAt(0);
                                        System.out.print("\033\143");
                        
                                        if (move == 'e')
                                            ft = area.interact();
                                        else
                                            area.movePlayer(move);
                        
                                    } catch (Exception e) {
                                        asc.next();
                                        System.out.print("\033\143");
                                        System.out.println("Invalid input");
                                    }
                                } while (ft == false);
                                asc.close();


                            }    
                        } catch(InputMismatchException e) {
                            lsc.next();
                            System.out.print("\033\143");
                            System.out.println("Invalid input");
                        }
                    }while(toLobby == false);
                    lsc.close();
                    
                    break;
                case 5:
                    
                    this.back = true;
                    break;
                default:
                    System.out.println("Bye.");
                    break;
            }
        } while (scanL != 5);

    }

    public Boolean returnBack() {
        return this.back;
    }
}
