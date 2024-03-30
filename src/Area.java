import java.util.Random;

/**
 * 
 */
public class Area {
    private Floor[][] floors;
    private String areaName;
    private int areaNum;
    private Character character;
    private int playerInX;
    private int playerInY;

    /**
     * This is the constructor for the class Area. This initalizes the attributes of
     * area.
     * 
     * @param areaNum   The area numer
     * @param areaName  The name of the area
     * @param character The character object created by the player.
     * @param floorY    The number of levels with respect to the Y axis.
     * @param floorX    The number of levels with respect to the X axis.
     */
    public Area(int areaNum, String areaName, Character character, int floorY, int floorX) {
        this.areaNum = areaNum;
        this.areaName = areaName;
        this.character = character;
        this.playerInX = 1;
        this.playerInY = 1;
        this.floors = new Floor[floorY][floorX];
    }

    /**
     * This method adds a floor object to the floor array address at [Y][X]
     * 
     * @param y     Y index of the floor
     * @param x     X index of the floor
     * @param floor Floor object to be added into the array
     */
    protected void addFloor(int y, int x, Floor floor) {
        floors[y][x] = floor;
    }

    /**
     * This method adds a floor object to the floor array address at [Y][X].
     * This method is an overload of the previous instance. This is to set given
     * floor as the main/starting floor of the player.
     * 
     * @param floor Floor object to be added
     * @param y     Y index in the array
     * @param x     X index in the array
     */
    protected void addFloor(Floor floor, int y, int x) {
        this.playerInX = x + 1;
        this.playerInY = y + 1;
        floors[y][x] = floor;
    }

    /**
     * This method pinrts the play area. It displays the current floor as well as
     * the
     * player's current health and number of runes.
     */
    public void printArea() {
        System.out.println(areaName + "\n");
        System.out.println("HP: " + character.getStats(0) + " Runes: " + character.getRunes() + "\n");
        floors[playerInY - 1][playerInX - 1].printFloor();
    }

    /**
     * This method calls a method from floor to move the player.
     * 
     * @param input Inputed character for moving the player (W,A,S,D).
     */
    public void movePlayer(char input) {
        floors[playerInY - 1][playerInX - 1].movePlayer(input);
    }

    /**
     * This method is the interact function within area. It gets the instance of
     * currTile
     * correspondingly execute code depending on the Tile.
     * 
     * @return true if the inteacted tile was a enabled fast travel tile.
     */
    public boolean interact() {
        Tile currTile = floors[playerInY - 1][playerInX - 1].getCurrTile();
        if (currTile instanceof FastTravelTile) {
            FastTravelTile ft = (FastTravelTile) currTile;
            if (ft.getIsEnabled() == true) {
                System.out.println("-- Fast Traveling --");
                // increase value of # dungeon clered //
                return true;
                // Return to lobby //
            } else {
                System.out.println("-- This is locked. Defeat the boss of the dungeon. --");
            }
        } else if (currTile instanceof DoorTile) {
            moveToFloor();
        } else if (currTile instanceof SpawnTile) {
            SpawnTile st = (SpawnTile) currTile;
            if (st.getIsEnabled() == true) {
                if (st.TileEvent() == false) {
                    int eType = new Random().nextInt(3 - 1 + 1) + 1;
                    Enemy enemy = new Enemy(eType, areaNum);
                    int runeDrop = enemy.dropRunes();
                    
                    Battle battle = new Battle(character, enemy, areaNum);
                    if (battle.battleSequence() == false) {
                        return true;
                    } else {
                        System.out.println("Enemy " + enemy.getName() + " has dropped " + runeDrop + " runes.");
                        character.setRunes(character.getRunes() + runeDrop);
                    }

                } else {
                    int runes = new Random().nextInt(150 - 50) + 50;
                    System.out.println("-- A treasure chest has appeared! --");
                    System.out.println("-- You found " + runes + " runes! --");
                    character.setRunes(character.getRunes() + runes);
                }
            } else
                System.out.println("-- You have already been here --");
        } else if (currTile instanceof BossTile) {
            BossTile bt = (BossTile) currTile;
            if (bt.getIsEnabled() == true) {
                // Begin a bossfight //
                Boss boss = null;
                switch (areaNum) {
                    case 1:
                        boss = new GodrickTheGrafted(); break;
                    case 2:
                        boss = new RennalaQueenOfTheFullMoon(); break;
                    case 3:
                        boss = new TheEldenBeast(); break;
                }
                int runeDrop = boss.dropRunes();
                Battle battle = new Battle(character, boss, areaNum);

                if (battle.battleSequence() == false) {
                    return true;
                } else {
                    System.out.println("Enemy " + boss.getName() + " has dropped " + runeDrop + " runes.");
                    character.setRunes(character.getRunes() + runeDrop);
                }

                System.out.println("-- The boss lies here --");
                System.out.println("-- For MCO1 the boss is defeated --");
                int BossHP = 200; // Temporary
                int BossRunes = BossHP * 5;
                System.out.println("-- You gained " + BossRunes + " runes for defeating the boss! --");
                character.setRunes(character.getRunes() + BossRunes);
                // !!!!!! Implement a better way to enable the tile !!!!!! //
                floors[playerInY - 1][playerInX - 1].SlayedBoss();
                character.addAreaClear(areaNum);
            } else {
                System.out.println("-- The boss has already been slain --");
            }
        } else if (currTile instanceof CreditsTile) {
            CreditsTile ct = (CreditsTile) currTile;
            System.out.println("-- Play the credits --");
            ct.playCredits();
            // Play credits //
        } else
            System.out.println("-- Nothing happened --");

        return false;
    }

    /**
     * This method allows the player to move from one floor to another. This is done
     * by
     * getting the direction of the getGoing() method of DoorTIle and updating the
     * current
     * floor of the player.
     */
    private void moveToFloor() {
        DoorTile door = (DoorTile) getFloors().getCurrTile();
        if (door.getGoing() == "up")
            playerInY -= 1;
        else if (door.getGoing() == "down")
            playerInY += 1;
        else if (door.getGoing() == "right")
            playerInX += 1;
        else if (door.getGoing() == "left")
            playerInX -= 1;
    }

    /**
     * This method gets the Y index of the player.
     * 
     * @return an integer of the player's current Y position
     */
    public int getPlayerInY() {
        return this.playerInY;
    }

    /**
     * This method gets the X index of the player.
     * 
     * @return an integer of the player's current X position
     */
    public int getPlayerInX() {
        return this.playerInY;
    }

    /**
     * This method returns the name of the Area.
     * 
     * @return String areaName
     */
    public String getAreaName() {
        return this.areaName;
    }

    /**
     * This method returns the number of the Area.
     * 
     * @return int areaNum
     */
    public int getAreaNum() {
        return this.areaNum;
    }

    /**
     * This method returns the Floor array of the Area.
     * 
     * @return Floor[] floors
     */
    public Floor getFloors() {
        return this.floors[playerInY - 1][playerInX - 1];
    }
}
