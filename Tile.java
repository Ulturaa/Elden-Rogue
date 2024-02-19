public class Tile {
    private int tType;

    public Tile(int tType) {
        this.tType = tType;
    }

    public int getTileType() {
        return tType;
    }

    public boolean interact() {

        return false;
    }

    /********************
        Tile Types
     - 0 | Empty tile
     - 1 | Boarder tile
     - 2 | Warp tile
     - 3 | Treasure tile
     - 4 | Monster tile
     = 5 | Boss tile
     - 6 | Player tile
    ********************/


}
