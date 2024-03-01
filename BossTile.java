/**
 * The {BossTile} class represents a tile in a game that serves as the boss location.
 * It extends the { Tile} class and includes functionality to enable or disable the boss tile.
 * 
 * 
 * 
 * @version 1.0
 * 
 */
public class BossTile extends Tile {
    
    /** 
     * A boolean flag indicating whether the boss tile is currently enabled.
     */
    private boolean isEnabled;

    /**
     * Constructs a new {BossTile} with the default character representation " B ".
     * The boss tile is initially enabled.
     */
    public BossTile() {
        super(" B ");
        isEnabled = true;   
    }

    /**
     * Gets the current status of the boss tile (enabled or disabled).
     * 
     * @return {true} if the boss tile is enabled, {false} otherwise.
     */
    public boolean getIsEnabled() {
        return isEnabled;
    }

    /**
     * Disables the boss tile, making it inactive.
     * Once disabled, the boss tile will no longer have its special effects or functionality.
     */
    public void Disable() {
        isEnabled = false;
    }
}
