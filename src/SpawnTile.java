import java.util.Random;

/**
 * This class extends Tile. Spawn tile spawns either a Treasure or Enemy.
 */
public class SpawnTile extends Tile {
    
    /**
     * A flag indicating whether the spawn tile is enabled.
     */
    private boolean isEnabled;

    /**
     * Constructs a new Spawn Tile with the icon " S ".
     * The spawn tile is initially enabled.
     */
    public SpawnTile() {
        super(" S ", "Spirtes/Spawn.png");
        isEnabled = true;
    }

    /**
     * This method determines weither an event will spawn a treasure tile or
     * spawns an enemy. The odds of an enemy spawing is a 25% chance (1 in 4).
     * 
     * @return false if integer even == 0, else returns true
     */
    public boolean TileEvent() {
        isEnabled = false;
        int event = new Random().nextInt(4);
        if(event == 0)
            return false;
        return true;
    }

    /**
     * This method returns if the tile is enabled(true) or diabled(false)
     * 
     * @return boolean isEnabled
     */
    public boolean getIsEnabled() {
        return isEnabled;
    }
}
