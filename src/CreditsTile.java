/**
 * This class inherits the Tile class. This class is is will play the credits
 * when interacted with in Area.
 */
public class CreditsTile extends Tile{
    
    /**
     * Constructs a new Credits Tile with the character icon " C ".
     */
    public CreditsTile() {
        super(" C ", "Spirtes/Blank.png");
    }

    /**
     * Displays the credits for the game.
     */
    public void playCredits() {
        System.out.println("---- Elden Rogue ----");
        System.out.println("    Kevin Harder     ");
        System.out.println("    Carl Marinas     ");
    }

}