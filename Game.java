import java.util.Scanner;

public class Game {
    
}

public void TitleScreen() {
    int prompt;
    Scanncer sc = new Scanner(System.in)

    do {
        System.out.println("Title Screen\n");
        System.out.println("1 | Start");
        System.out.println("2 | Exit");
        System.out.println("- ");
        prompt = sc.nextInt;

        switch(prompt) {
            case 1: CC; break;
            case 2: Exit(); break;
            default: Sytem.out.println("Invalid input")
        }

    } while(prompt != 1 || prompt != 2);
}

public void CC() {
    int prompt;
    Scanncer sc = new Scanner(System.in)

    do {
        System.out.println("CC\n");
        System.out.println("1 | Input Name");
        System.out.println("2 | Select Job Class");
        System.out.println("3 | Confirm");
        System.out.println("4 | Back");
        System.out.println("- ");
        prompt = sc.nextInt;

        switch(prompt) {
            case 1: SetName(); break;
            case 2: SelJob(); break;
            case 3: System.out.println("Confirmed"); break;
            default: Sytem.out.println("Invalid input");
        }

    } while(prompt != 1 || prompt != 2);
}


