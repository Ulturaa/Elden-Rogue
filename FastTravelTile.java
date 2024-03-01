/**
 * The {FastTravelTile} class represents a tile in a  area that enables fast travel.
 * It extends the {Tile} class and includes functionality to check and control its enabled status.
 * 
 *
 * @version 1.0
 * 
 */
public class FastTravelTile extends Tile {
    
    /**
     * A flag indicating whether fast travel is enabled.
     */
    private boolean isEnabled;

    /**
     * Constructs a new {FastTravelTile} with the character representation " ^ ".
     * The tile is initially enabled or disabled based on the provided parameter.
     * 
     * @param enabled {true} if fast travel is initially enabled, {false} otherwise.
     */
    public FastTravelTile(boolean enabled) {
        super(" ^ ");
        if (enabled == false)
            isEnabled = false;
        else
            isEnabled = true; 
    }

    /**
     * Gets the current status of fast travel (enabled or disabled).
     * 
     * @return {true} if fast travel is enabled, {false} otherwise.
     */
    public boolean getIsEnabled() {
        return isEnabled;
    }

    /**
     * Enables fast travel for the tile.
     */
    public void Enable() {
        isEnabled = true;
    }
}
