/**
 * This class inherits the Tile class. This class represents a Door tile to be used
 * in the Floor class.
 */

public class DoorTile extends Tile{
    /**
     * The class adds a new attribute called going. Going represents the direction
     * of the door. This String is final and cannot be changed.
     */
    private final String going;

    /**
     * This is the constructor for DoorTile. It calls super() from the superclass tile.
     * It also assigns the going attribute.
     * 
     * @param going String of the direction of the door.
     */
    public DoorTile(String going) {
        super(" | ", "Spirtes/Door.png");
        this.going = going;   
    }

    /**
     * This method returns the variable going.
     * 
     * @return String going
     */
    public String getGoing() {
        return going;
    }
}
