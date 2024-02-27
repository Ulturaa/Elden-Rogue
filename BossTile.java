public class BossTile extends Tile{
    private boolean isEnabled;

    public BossTile() {
        super(" B ");
        isEnabled = true;   
    }

    private boolean getIsEnabled() {
        return isEnabled;
    }

    private void disable() {
        isEnabled = false;
    }
}