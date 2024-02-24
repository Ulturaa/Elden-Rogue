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

    /****************************************
        Tile Types
     - 0 | Empty tile
     - 1 | Boarder tile
     - 2 | Locked Fast travel tile
     - 3 | Unlocked Fast travel tile
     - 4 | Door tile
     - 5 | Spawn tile (Treasure or Enemy)
     - 6 | Boss tile
     - 7 | Player tile
     - 8 | Credits tile
    ****************************************/


}
