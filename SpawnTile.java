import java.util.Random;

public class SpawnTile extends Tile {
    private boolean isEnabled;
    
    public SpawnTile() {
        super(" S ");
        isEnabled = true;
    }

    public boolean TileEvent() {
        isEnabled = false;
        int event = new Random().nextInt(4);
        if(event == 0)
            return false;
        return true;
    }

    public boolean getIsEnabled() {
        return isEnabled;
    }
}
