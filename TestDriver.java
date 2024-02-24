import java.util.Scanner;
import java.util.InputMismatchException;  

public class TestDriver {
    public static void main(String[] args) {
        
        Floor floor = new Floor(5, 5);
        floor.setTile(1, 2, 7); // player
        floor.setTile(0, 2, 2);
        floor.setTile(4, 2, 2);
        floor.setTile(4, 0, 1);
        floor.setTile(4, 4, 1);
        
        Scanner sc = new Scanner(System.in);
        char in = ' '; 
        do {
            try{
                floor.getPlayerPos();
                floor.printFloor();
                in = sc.next(".").charAt(0);
                System.out.print("\033\143");

                if(in == 'x')
                    System.exit(0);
                else if(in == 'e')
                    floor.interact();
                else
                    floor.movePlayer(in);

            } catch(Exception e) {
                sc.next();
                System.out.print("\033\143");
                System.out.println("Invalid input");
            }
        } while(in !=  'q' || in != 'Q');
        
    }
}
