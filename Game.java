import java.util.Scanner;

public class Game {

    public void TitleScreen() {
        int prompt;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Title Screen\n");
            System.out.println("1 | Start");
            System.out.println("2 | Exit");
            System.out.println("- ");
            prompt = sc.nextInt();

            switch (prompt) {
                case 1:
                    // starts game
                    // character creation
                    CC();
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input");
            }

        } while (prompt != 1 || prompt != 2);
        sc.close();
    }

    public void CC() {
        int prompt;

        Scanner sc = new Scanner(System.in);
        CharCreate create = new CharCreate();
        Character character = new Character();
        String charName;
        String charJob;

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

                    if (create.confirm()) {

                        System.out.println("\nConfirmed\n");
                    } else
                        System.out.println("\nNOT Confirmed\n");
                    // open the lobby
                    break;
                case 4:
                    TitleScreen();
                    break;
                default:
                    System.out.println("Invalid input");
            }

        } while (prompt != 1 || prompt != 2);
        sc.close();
    }

}