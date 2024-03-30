import javax.swing.ImageIcon;

/**
 * This is a Tile class. Tiles are the objects to be used
 * to create floors.
 */
public abstract class Tile {

    /**
     * icon     The string display for the object.
     */
    private String icon;
    private ImageIcon sprite;

    /**
     * This is the constructor for a class tile. It takes in a 
     * String called Icon and assigns it to the icon attribute.
     * 
     * @param icon  The string display of the tile.
     */
    public Tile(String icon, String path) {
        this.icon = icon;
        this.sprite = new ImageIcon(path);
    }

    /**
     * Sets the Sprite.
     * To be used by the boss.
     * 
     */
    public void setSprite(String path) {
        this.sprite = new ImageIcon(path);
    }

    /**
     * This method gets/returns the Icon from the icon attribute.
     * 
     * @return Icon - A string
     */
    public String getIcon() {
        return icon;
    }

    /**
     * This method gets/returns the Sprite from the sprite attribute.
     * 
     * @return Sprite - picture of the object
     */
    public ImageIcon getSprite() {
        return sprite;
    }
}
