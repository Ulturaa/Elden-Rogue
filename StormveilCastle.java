public class StormveilCastle extends Area {
    
    
    public StormveilCastle(Character character) {
        super(1, "Stormveil Castle", character, 3, 1);

        // Create floor object //
        Floor f1 = new Floor(3, 7);
        // Add tiles //
        f1.setTile(0,1,new DoorTile("up"));  // door //
        f1.setTile(1,0,new SpawnTile());
        f1.setTile(1,2,new SpawnTile());
        f1.setTile(6,1,new FastTravelTile(true));  // fast travel //
        f1.setTile(6,1,new PlayerTile());  // player //

        // Create floor object //
        Floor f2 = new Floor(7, 7);
        // Add tiles //
        f2.setTile(0,3,new DoorTile("up"));  // door //
        f2.setTile(6,3,new DoorTile("down"));  // door //  
        f2.setTile(1,3,new SpawnTile());
        f2.setTile(3,0,new SpawnTile());
        f2.setTile(3,2,new SpawnTile());
        f2.setTile(3,3,new SpawnTile());
        f2.setTile(3,4,new SpawnTile());
        f2.setTile(3,6,new SpawnTile());
        f2.setTile(5,2,new SpawnTile());
        f2.setTile(5,4,new SpawnTile());
        f2.setTile(6,3,new PlayerTile());  // player //

        // Create floor object //
        Floor f3 = new Floor(5, 7);
        // Add tiles //
        f3.setTile(6,2,new DoorTile("down"));  // door //
        f3.setTile(0,2,new FastTravelTile(false));  // fast travel //
        f3.setTile(3,2,new BossTile());  // boss //
        f3.setTile(6,2,new PlayerTile());  // player //

        addFloor(0, 0, f3);
        addFloor(1, 0, f2);
        addFloor(f1, 2, 0);
    }
    
}
