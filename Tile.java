public class Tile {
    private String icon;

    public Tile(String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

    /****************************************
        Tile Types
     - 0 | Empty tile /
     - 1 | Boarder tile /
     - 2 | Locked Fast travel tile /
     - 3 | Unlocked Fast travel tile /
     - 4 | Door tile (add direction) / 

     - 5 | Emabled Spawn tile (Treasure or Enemy)
     - 6 | Disabled Spawn tile (Treasure got or Enemy defeated)

     - 7 | Boss tile
     - 8 | Player tile
     - 9 | Credits tile
    ****************************************/


}
