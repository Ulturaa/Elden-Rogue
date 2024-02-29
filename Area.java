import java.util.Random;

public class Area {
    private Floor[][] floors;
    private String areaName;
    private int areaNum;
    private Character character;
    private int playerInX;
    private int playerInY;


    public Area(int areaNum, String areaName, Character character, int floorY, int floorX) {
        this.areaNum = areaNum;
        this.areaName = areaName;
        this.character = character;
        this.playerInX = 1;
        this.playerInY = 1;
        this.floors = new Floor[floorY][floorX];
    }

    protected void addFloor(int y, int x, Floor floor) {
        floors[y][x] = floor;
    }

    protected void addFloor(Floor floor, int y, int x) {
        this.playerInX = x+1;
        this.playerInY = y+1;
        floors[y][x] = floor;
    }

    public void printArea(){
        System.out.println(areaName + "\n");
        System.out.println("HP: " + character.getStats(0) + " Runes: " + character.getRunes() + "\n");
        floors[playerInY-1][playerInX-1].printFloor();
    }


    /* This code works but is a lazy implementation. Will fix in the future */
    public void movePlayer(char input) {
        floors[playerInY-1][playerInX-1].movePlayer(input);
    }

    public boolean interact() {
        Tile currTile = floors[playerInY-1][playerInX-1].getCurrTile();
        if(currTile instanceof FastTravelTile){
            FastTravelTile ft = (FastTravelTile)currTile;
            if(ft.getIsEnabled() == true) {
                System.out.println("-- Fast Traveling --");
                // increase value of # dungeon clered //
                return true;
                // Return to lobby //
            } else {
                System.out.println("-- This is locked. Defeat the boss of the dungeon. --");
            }
        } else if(currTile instanceof DoorTile) {
            moveToFloor();
        } else if(currTile instanceof SpawnTile) {
            SpawnTile st = (SpawnTile)currTile;
            if(st.getIsEnabled() == true) {
                if(st.TileEvent() == false) {
                    System.out.println("-- A enemy has appeared! --");
                    System.out.println("--------- Gaooo! ---------");
                } else {
                    int runes = new Random().nextInt(150-50) + 50;
                    System.out.println("-- A treasure chest has appeared! --");
                    System.out.println("-- You found " + runes + " runes! --");
                    character.setRunes(character.getRunes() + runes);
                }
            } else
                System.out.println("-- You have already been here --");
        } else if(currTile instanceof BossTile) {
            // Begin a bossfight //
            System.out.println("-- The boss lies here --");
            System.out.println("-- For MCO1 the boss is defeated --");
            // !!!!!! Implement a better way to enable the tile !!!!!! //
            floors[playerInY-1][playerInX-1].SlayedBoss();
            
        } else if(currTile instanceof CreditsTile) {
            CreditsTile ct = (CreditsTile)currTile;
            System.out.println("-- Play the credits --");
            ct.playCredits();
            // Play credits //
        } else
            System.out.println("-- Nothing happened --");

        return false;
    }

    private void moveToFloor() {
        DoorTile door = (DoorTile)getFloors().getCurrTile();
        if(door.getGoing() == "up")
            playerInY-=1;
        else if(door.getGoing() == "down")
            playerInY+=1;
        else if(door.getGoing() == "right")
            playerInY+=1;  
        else if(door.getGoing() == "left")
            playerInY-=1;        
    }

    public int getPlayerInY() {
        return this.playerInY;
    }

    public int getPlayerInX() {
        return this.playerInY;
    }

    public String getAreaName() {
        return this.areaName;
    }

    public int getAreaNum() {
        return this.areaNum;
    }

    public Floor getFloors() {
        return this.floors[playerInY-1][playerInX-1];
    }
}
