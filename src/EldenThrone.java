/** 
 * This class, Elden Throne extends area. It creates a class called Elden Throne 
 * and creates the arraymap based on the level design.
 */

public class EldenThrone extends Area {
    /**
     * This is the constructor of Elden Throne. When a new 
     * Stormveil Caslte is created it generates the whole map including
     * the different floors and tiles.
     * 
     * @param character     Character passed to be used as a reference for the functions of differnt tiles.
     */
    public EldenThrone(Character character) {
        super(3, "Elden Throne", character, 3, 1);

        // Create floor object //
        Floor f1 = new Floor(3, 9);
        // Add tiles //
        f1.setTile(0,1,new DoorTile("up"));  // door //
        f1.setTile(4,1,new SpawnTile());
        f1.setTile(8,1,new FastTravelTile(true));  // fast travel //
        f1.setTile(8,1,new PlayerTile());  // player //

        // Create floor object //
        Floor f2 = new Floor(7, 7);
        // Add tiles //
        f2.setTile(0,3,new DoorTile("up"));  // door //
        f2.setTile(6,3,new DoorTile("down"));  // door //
        BossTile bt = new BossTile();
        bt.setSprite("Spirtes/EldenBeast.png");
        f2.setTile(3,3, bt);
        f2.setTile(0,0,new BoarderTile());
        f2.setTile(0,6,new BoarderTile());
        f2.setTile(6,0,new BoarderTile());
        f2.setTile(6,6,new BoarderTile());
        f2.setTile(6,3,new PlayerTile());  // player //

        // Create floor object //
        Floor f3 = new Floor(3, 9);
        // Add tiles //
        f3.setTile(8,1,new DoorTile("down"));  // door //
        f3.setTile(1,0,new SpawnTile());
        f3.setTile(1,2,new SpawnTile());
        f3.setTile(3,0,new SpawnTile());
        f3.setTile(3,2,new SpawnTile());
        f3.setTile(5,0,new SpawnTile());
        f3.setTile(5,2,new SpawnTile());
        f3.setTile(7,0,new SpawnTile());
        f3.setTile(7,2,new SpawnTile());
        f3.setTile(0,1,new CreditsTile());
        f3.setTile(8,1,new PlayerTile());  // player //

        // Add the floors to the array //
        addFloor(f1, 2, 0);
        addFloor(1, 0, f2);
        addFloor(0, 0, f3);
    }
}
