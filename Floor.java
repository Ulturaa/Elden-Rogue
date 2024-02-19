public class Floor {
    private Tile[][][] fMap;
    private int height;
    private int width;

    public Floor(int height, int width) {
        this.height = height;
        this.width = width;
        fMap = new Tile[height][width][2];
        for(int i=0; i < height; i++) {
            for(int j=0; j < width; j++) {
                fMap[i][j][0] = new Tile(0);
                fMap[i][j][1] = new Tile(0);
            }
        }
        
    }

    public void setTile(int y, int x, int type) {
        // This function will set tiles in the correct positions wthin the floor
        if(type == 6)
            fMap[y][x][1] = new Tile(type);
        else
            fMap[y][x][0] = new Tile(type);
    }

    public void printFloor() {
        for(int i=0; i < height; i++) {
            for(int j=0; j < width; j++) {
                if(fMap[i][j][1].getTileType() == 6)
                    System.out.print(" P ");
                else {
                    switch(fMap[i][j][0].getTileType()) {
                        case 0: System.out.print("   ");
                                break;
                        case 1: System.out.print(" 0 ");
                                break;
                        case 2: System.out.print(" W ");
                                break;
                        case 3: System.out.print(" W ");
                                break;
                        case 4: System.out.print(" M ");
                                break;
                        case 5: System.out.print(" B ");
                                break;
                    }
                }
                
            }
            System.out.print("\n");
        }
    }

    public boolean movePlayer() {

        return false;
    }
}
