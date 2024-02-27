import java.util.Scanner;

public class TestDriver {
    public static void main(String[] args) {

        Character chara = new Character();
        Area a1 = new StormveilCastle(chara);
        

        Scanner sc = new Scanner(System.in);
        char in = ' ';
        boolean returnToLobby = false;

        // Game game = new Game();
        // game.TitleScreen();
        do {
            try {
                a1.printArea();
                in = sc.next(".").charAt(0);
                System.out.print("\033\143");

                if (in == 'e')
                    returnToLobby = a1.interact();
                else
                    a1.movePlayer(in);

            } catch (Exception e) {
                sc.next();
                System.out.print("\033\143");
                System.out.println("Invalid input");
            }
        } while (returnToLobby == false);
    }
}
