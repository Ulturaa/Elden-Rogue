/**
 * This is a Tile class. Tiles are the objects to be used
 * to create floors.
 */
public abstract class Tile {

    /**
     * icon     The string display for the object.
     */
    private String icon;

    /**
     * This is the constructor for a class tile. It takes in a 
     * String called Icon and assigns it to the icon attribute.
     * 
     * @param icon  The string display of the tile.
     */
    public Tile(String icon) {
        this.icon = icon;
    }

    /**
     * This method gets/returns the Icon from the icon attribute.
     * 
     * @return Icon - A string
     */
    public String getIcon() {
        return icon;
    }
}
