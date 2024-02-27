public class FastTravelTile extends Tile{
    private boolean isEnabled;

    public FastTravelTile(boolean enabled) {
        super(" ^ ");
        if(enabled == false)
            isEnabled = false;
        else
            isEnabled = true; 
    }

    public boolean getIsEnabled() {
        return isEnabled;
    }

    public void Enable() {
        isEnabled = true;
    }
}