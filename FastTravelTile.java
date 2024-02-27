public class FastTravelTile extends Tile{
    private boolean isEnabled;

    public FastTravelTile() {
        super(" ^ ");
        isEnabled = false;   
    }

    public boolean getIsEnabled() {
        return isEnabled;
    }

    public void Enable() {
        isEnabled = true;
    }
}