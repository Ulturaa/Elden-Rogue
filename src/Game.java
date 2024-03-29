import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The {@code Game} class manages the flow and logic of the Elden Rogue game.
 * It includes methods for the title screen, character creation, and the game
 * lobby.
 * 
 *
 * @version 1.0
 * 
 */
public class Game {

    /**
     * @character The character object representing the player's in-game avatar.
     * @Create is the charcreate object for character creation
     * @lobby is the object for managing the game's lobby
     * 
     */
    private Character character;
    private CharCreate create;
    private Lobby lobby;

    /**
     * Displays the title screen of the game and handles user input for starting or
     * exiting the game.
     */

    public Game() {

    }

    public void TitleScreen() {
        int tprompt = 0;
        lobby = new Lobby(this);
        Scanner tc = new Scanner(System.in);

        do {
            try {
                System.out.println("ELDEN ROGUE\n");
                System.out.println("1 | Start");
                System.out.println("2 | Exit");
                System.out.print("- ");
                tprompt = tc.nextInt();

                switch (tprompt) {
                    case 1:
                        System.out.print("\033\143");
                        CC();
                        break;
                    case 2:
                        System.exit(0);
                        break;
                    default:
                        System.out.print("\033\143");
                        System.out.println("Invalid input");
                }
            } catch (InputMismatchException e) {
                tc.nextLine();
                System.out.print("\033\143");
                System.out.println("Invalid input");
            }

        } while (tprompt != 1 || tprompt != 2);
        tc.close();
    }

    /**
     * Handles the character creation process, allowing the player to input a name,
     * select a job class, and confirm their character.
     * 
     * @exception InputMismatchException When Integer input is given a Character or
     *                                   String.
     */
    public void CC() {
        int prompt;

        Scanner sc = new Scanner(System.in);
        create = new CharCreate();
        character = new Character();
        String charName;
        String charJob;
        Boolean loop = true;

        do {
            try {
                System.out.println("Character Creation\n");

                create.displayChar(character);
                System.out.println("\n1 | Input Name");
                System.out.println("2 | Select Job Class");
                System.out.println("3 | Confirm");
                System.out.println("4 | Back");
                System.out.print("- ");
                prompt = sc.nextInt();

                switch (prompt) {
                    case 1:
                        create.setCharName();
                        charName = create.getCharName();
                        character.setName(charName);
                        System.out.print("\033\143");
                        break;
                    case 2:
                        create.selectJob();
                        charJob = create.getCharJob();
                        character.setJob(charJob);
                        create.setStats(charJob, character);
                        System.out.print("\033\143");
                        break;
                    case 3:
                        // after confirming the game goes into lobby
                        if (create.confirm() && character.getJob() != "Jobless") {
                            System.out.println("\nConfirmed\n");
                            System.out.print("\033\143");
                            lobby.lobbyScreen(character);

                            if (lobby.returnBack()) {
                                this.TitleScreen();
                                loop = false;
                            }
                            loop = false;
                        } else {
                            System.out.print("\033\143");
                            System.out.println("\nNot confirmed.\n");
                            System.out.println("\nPlease enter a name and select a job.\n");
                        }

                        break;
                    case 4:
                        System.out.print("\033\143");
                        this.TitleScreen();
                        loop = false;
                        break;
                    default:
                        System.out.print("\033\143");
                        System.out.println("Invalid input");
                }
            } catch (InputMismatchException e) {
                sc.nextLine();
                System.out.print("\033\143");
                System.out.println("Invalid input");
            }

        } while (loop);
        sc.close();

    }

    public Character getCharacter() {
        return character;
    }

    public CharCreate getCharCreate() {
        return create;
    }
}
