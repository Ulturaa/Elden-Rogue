public class Floor {
    private Tile[][] fMap;
    private Tile currTile;
    private final int yBounds;
    private final int xBounds;

    /**
     * This is the constructor for the Floor class. It creates a 2D array
     * of tiles which will then be displayed on the screen. It initially
     * constructs the aray full of empy spaces.
     * 
     * @param xBounds   This is the x/width of the floor
     * @param yBounds   This is the y/Width of the year
     */
    public Floor(int xBounds, int yBounds) {
        this.xBounds = xBounds;
        this.yBounds = yBounds;
        fMap = new Tile[yBounds][xBounds];
        for(int i=0; i < yBounds; i++) {
            for(int j=0; j < xBounds; j++) {
                fMap[i][j] = new SpaceTile();
            }
        }
    }
    /**
     * This method assigns a tile based on the given parameter tile. From a given y, x, and tile,
     * it adds the specific tiles onto the floor array.
     * 
     * @param y     is the y index to be specified by the user during the creation of a floor.
     * @param x     is the x index to be specified by the user during the creation of a floor.
     * @param tile  is an object of class tile or under class tile. It is added to the 2d array.
     */
    public void setTile(int y, int x, Tile tile) {
        // This function will set tiles in the correct positions wthin the floor
        if(tile instanceof PlayerTile) {
            currTile = fMap[y][x];
            fMap[y][x] = tile;
        } else
            fMap[y][x] = tile;
    }
    /**
     * This method prints the entire floor. It also generates the boarder for better clarity of the map.
     */

    public void printFloor() {
        System.out.print("▄");
        for(int i = 0; i < xBounds; i++)
            System.out.print("▄▄▄");
        System.out.print("▄");

        System.out.println();
        for(int i = 0; i < yBounds; i++) {
            System.out.print("█");
            for(int j = 0; j < xBounds; j++) {
                System.out.print(fMap[i][j].getIcon());
            }
            System.out.println("█");
        }
        
        System.out.print("▀");
        for(int i = 0; i < xBounds; i++)
            System.out.print("▀▀▀");
            System.out.print("▀");
        System.out.println();
    }

    /**
     * This method moves the player tile's index dependin on the input char value.
     * It finds the location of a player tile within the array then verifies, through the use
     * of the VerifyMove() methid, and determines wether the desired move is valid. If true 
     * then it updates the position of the player tile.
     * 
     * @param input     This is a character input
     */
    public void movePlayer(char input) {
        boolean found = false;
        int x = 0;
        int y = 0;
        for(y = 0; found == false && y < yBounds; y++) {
            for(x = 0; found == false && x < xBounds; x++){
                if(fMap[y][x] instanceof PlayerTile)
                found = true;
            }
        }
        y -= 1;
        x -= 1;
        if(verifyMove(x, y, input) == true) {
            if(input == 'W' || input == 'w') {
                Tile temp = fMap[y][x]; // Gets the player
                fMap[y][x] = currTile;  // replaces player with current tile
                currTile = fMap[y-1][x]; // gets next tile
                fMap[y-1][x] = temp; // puts player to next tile
            } else if(input == 'S' || input == 's') {
                Tile temp = fMap[y][x]; // Gets the player
                fMap[y][x] = currTile;  // replaces player with current tile
                currTile = fMap[y+1][x]; // gets next tile
                fMap[y+1][x] = temp; // puts player to next tile
            } else if(input == 'A' || input == 'a') {
                Tile temp = fMap[y][x]; // Gets the player
                fMap[y][x] = currTile;  // replaces player with current tile
                currTile = fMap[y][x-1]; // gets next tile
                fMap[y][x-1] = temp; // puts player to next tile
            } else if(input == 'D' || input == 'd') {
                Tile temp = fMap[y][x]; // Gets the player
                fMap[y][x] = currTile;  // replaces player with current tile
                currTile = fMap[y][x+1]; // gets next tile
                fMap[y][x+1] = temp; // puts player to next tile
            } 
        } else {
            System.out.println("Out of bounds");
        }
    }

    /**
     * This function determines wether an action is out of bounds or hits a boarder tile.
     * 
     * 
     * @param x     x position of the player.
     * @param y     x position of the player.
     * @param input The char input of the desired direction.
     * @return      True if I the desired move is valid, else false.
     */
    private boolean verifyMove(int x, int y, char input) {
        if(input == 'W' || input == 'w') {
            if(y-1 < yBounds && y-1 >= 0 && !(fMap[y-1][x] instanceof BoarderTile))
                return true;
        } else if(input == 'S' || input == 's') {
            if(y+1 < yBounds && y+1 >= 0 && !(fMap[y+1][x] instanceof BoarderTile))
            return true;
        } else if(input == 'A' || input == 'a') {
            if(x-1 < yBounds && x-1 >= 0 && !(fMap[y][x-1] instanceof BoarderTile))
                return true;
        } else if(input == 'D' || input == 'd') {
            if(x+1 < yBounds && x+1 >= 0 && !(fMap[y][x+1] instanceof BoarderTile))
                return true;
        } 

        return false;
    }
    
    /**
     * This method enables fast travel tile and disables the
     * boss tile within the boss room. This function is only called
     * when the conditions within the Area class are satisfied
     * (When the boss is defeated, call this function in area).
     */
    public void SlayedBoss() {
        int i=0;
            while((fMap[0][i] instanceof FastTravelTile) == false)
                i++;
        FastTravelTile ft = (FastTravelTile)fMap[0][i];
        ft.Enable();
        BossTile bt = (BossTile)currTile;
        bt.Disable();
    }

    /**
     * This method cets the currTile variable to be used within the
     * area method.
     * 
     * @return currentTile
     */
    public Tile getCurrTile(){
        return currTile;
    }
}
