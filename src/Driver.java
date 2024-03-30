/**
 * This class is the driver to initialize the whole game.
 * 
 * @author Carl Mervyn Marinas
 * @author Kevin Harder
 * @version 1.0
 */
public class Driver {

    /**
     * The main method that initiates the game by creating a Gmae object
     * and displaying the title screen.
     * 
     * @param args args.
     */
    public static void main(String[] args) {
        Game game = new Game();
        game.TitleScreen();

        //Character character = game.getCharacter();
        //CharCreate charCreate = game.getCharCreate();

        //TitleScreenController tsc = new TitleScreenController(new TitleScreenView(), new TItleScreenModel(), character,charCreate);
    }
}