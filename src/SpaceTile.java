/**
 * This class extends tile. Space tile represents a blank tile within Floor.
 */
public class SpaceTile extends Tile {
    
    /**
     * This constructs the space tile calling the super() of Tile.
     * It sets the String Icon as "   ".
     */
    public SpaceTile() {
        super("   ", "Spirtes/Tile.png");
    }
}
