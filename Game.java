
import java.util.Scanner;

public class Game {

    private Character character;
    private CharCreate create;
    private Lobby lobby;
    // Lobby lobby = new Lobby(this);

    public void TitleScreen() {
        int tprompt;
        // Scanner sc = new Scanner(System.in);
        lobby = new Lobby(this);
        Scanner tc = new Scanner(System.in);

        do {
            System.out.println("ELDEN ROGUE\n");
            System.out.println("1 | Start");
            System.out.println("2 | Exit");
            System.out.println("- ");
            tprompt = tc.nextInt();

            switch (tprompt) {
                case 1:
                    CC();// character creation

                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input");
            }

        } while (tprompt != 1 || tprompt != 2);
        tc.close();
    }

    public void CC() {
        int prompt;

        Scanner sc = new Scanner(System.in);
        create = new CharCreate();
        character = new Character();
        String charName;
        String charJob;
        Boolean loop = true;

        do {
            System.out.println("Character Creation\n\n");

            create.displayChar(character);
            System.out.println("\n1 | Input Name");
            System.out.println("2 | Select Job Class");
            System.out.println("3 | Confirm");
            System.out.println("4 | Back");
            System.out.println("- ");
            prompt = sc.nextInt();

            switch (prompt) {
                case 1:
                    create.setCharName();
                    charName = create.getCharName();
                    character.setName(charName);
                    break;
                case 2:
                    create.selectJob();
                    charJob = create.getCharJob();
                    character.setJob(charJob);
                    create.setStats(charJob, character);
                    break;
                case 3:
                    // after confirming the game goes into lobby
                    if (create.confirm() && character.getJob() != "Jobless") {

                        System.out.println("\nConfirmed\n");
                        lobby.lobbyScreen(character);

                        if (lobby.returnBack()) {
                            this.TitleScreen();
                            loop = false;
                        }
                        loop = false;
                    } else {
                        System.out.println("\nNOT Confirmed\n");
                        System.out.println("\nPlease input a name and choose a JOB CLASS\n");
                    }

                    break;
                case 4:
                    this.TitleScreen();
                    loop = false;
                    break;
                default:
                    System.out.println("Invalid input");
            }

        } while (loop);
        sc.close();
    }

}