public class Floor {
    private Tile[][] fMap;
    private Tile currTile;
    private final int yBounds;
    private final int xBounds;

    public Floor(int xBounds, int yBounds) {
        this.xBounds = xBounds;
        this.yBounds = yBounds;
        fMap = new Tile[yBounds][xBounds];
        for(int i=0; i < yBounds; i++) {
            for(int j=0; j < xBounds; j++) {
                fMap[i][j] = new Tile(0);
                fMap[i][j] = new Tile(0);
            }
        }
        
    }

    public void setTile(int y, int x, int type) {
        // This function will set tiles in the correct positions wthin the floor
        if(type == 7) {
            currTile = fMap[y][x];
            fMap[y][x] = new Tile(type);
        } else
            fMap[y][x] = new Tile(type);
    }

    public void printFloor() {
        for(int i = 0; i < yBounds+(2*yBounds)+2; i++)
            System.out.print("▄");
        System.out.println();
        for(int i = 0; i < yBounds; i++) {
            System.out.print("█");
            for(int j = 0; j < xBounds; j++) {
                if(fMap[i][j].getTileType() == 6)
                    System.out.print(" P ");
                else {
                    switch(fMap[i][j].getTileType()) {
                        case 0: System.out.print("   ");
                                break;
                        case 1: System.out.print("███");
                                break;
                        case 2: System.out.print(" X ");
                                break;
                        case 3: System.out.print(" ^ ");
                                break;
                        case 4: System.out.print(" | ");
                                break;
                        case 5: System.out.print(" S ");
                                break;
                        case 6: System.out.print(" B ");
                                break;
                        case 7: System.out.print(" P ");
                                break;
                        case 8: System.out.print(" C ");
                                break;
                    }
                }
            }
            System.out.println("█");
        }
        for(int i = 0; i < yBounds+(2*yBounds)+2; i++)
            System.out.print("▀");
        System.out.println();
    }

    public void movePlayer(char input) {
        boolean found = false;
        int x = 0;
        int y = 0;
        for(y = 0; found == false && y < yBounds; y++) {
            for(x = 0; found == false && x < xBounds; x++){
                if(fMap[y][x].getTileType() == 7)
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

    public boolean verifyMove(int x, int y, char input) {
        if(input == 'W' || input == 'w') {
            if(y-1 < yBounds && y-1 >= 0 && fMap[y-1][x].getTileType() != 1)
                return true;
        } else if(input == 'S' || input == 's') {
            if(y+1 < yBounds && y+1 >= 0 && fMap[y+1][x].getTileType() != 1)
            return true;
        } else if(input == 'A' || input == 'a') {
            if(x-1 < yBounds && x-1 >= 0 && fMap[y][x-1].getTileType() != 1)
                return true;
        } else if(input == 'D' || input == 'd') {
            if(x+1 < yBounds && x+1 >= 0 && fMap[y][x+1].getTileType() != 1)
                return true;
        } 

        return false;
    }

    public void getPlayerPos() {
        boolean found = false;
        int x = 0;
        int y = 0;
        for(y = 0; found == false && y < yBounds; y++) {
            for(x = 0; found == false && x < xBounds; x++){
                if(fMap[y][x].getTileType() == 7){
                System.out.println("Player in " + y + " " + x);
                found = true;
                }
            }
        }
    }

    public void interact() {
        switch(currTile.getTileType()) {
            case 2: System.out.println(" This is locked. Defeat the boss of the dungeon. ");
                    break;
            case 3: System.out.println(" Fast Traveling ");
                    // Return to lobby //
                    break;
            case 4: System.out.println(" Door ");
                    // move to next floor //
                    break;
            case 5: System.out.println(" Spawn ");
                    // RNG for treasure or enemy //
                    break;
            case 6: System.out.println(" Spawn a boss ");
                    // Begin a bossfight //
                    break;
            case 8: System.out.println(" Playing the credits ");
                    // Play credits //
                    break;
            default: System.out.println(" Nothing happened ");
        }
    }
}
