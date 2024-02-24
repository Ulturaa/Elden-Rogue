import java.util.Scanner;
import java.util.InputMismatchException;  

public class TestDriver {
    public static void main(String[] args) {
        
        Floor floor = new Floor(5, 5);
        floor.setTile(1, 2, 6); // player
        floor.setTile(0, 2, 2);
        floor.setTile(4, 2, 2);
        floor.setTile(4, 0, 1);
        floor.setTile(4, 4, 1);
        floor.printFloor();
    }
}
