import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Dimension;
import java.awt.Image;

/**
 * This is a Tile class. Tiles are the objects to be used
 * to create floors.
 */
public abstract class Tile extends JLabel{

    /**
     * icon     The string display for the object.
     */
    private String iconT;
    private ImageIcon sprite;

    /**
     * This is the constructor for a class tile. It takes in a 
     * String called Icon and assigns it to the icon attribute.
     * 
     * @param icon  The string display of the tile.
     */
    public Tile(String icon, String path) {
        this.iconT = icon;
        this.sprite = new ImageIcon(path);
        //this.setIcon(new ImageIcon(sprite.getImage().getScaledInstance(75,75,Image.SCALE_SMOOTH)));
        this.setIcon(sprite);
        this.setPreferredSize(new Dimension(75,75));
        this.setHorizontalAlignment(JLabel.CENTER);
        this.setVerticalAlignment(JLabel.CENTER);
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
    public String getIconT() {
        return iconT;
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
