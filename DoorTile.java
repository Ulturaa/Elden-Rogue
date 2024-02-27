public class DoorTile extends Tile{
    private final String going;

    public DoorTile(String going) {
        super(" | ");
        this.going = going;   
    }

    public String getGoing() {
        return going;
    }
}
