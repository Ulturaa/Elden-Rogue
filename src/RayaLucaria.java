public class RayaLucaria extends Area{

    public RayaLucaria(Character character) {
        super(2, "Raya Luaria", character, 2, 3);

        // Create floor object //
        Floor f1 = new Floor(5, 5);
        // Add tiles //
        f1.setTile(4,2,new DoorTile("down"));  // door //
        f1.setTile(3,1,new SpawnTile());
        f1.setTile(3,3,new SpawnTile());
        f1.setTile(0,2,new FastTravelTile(true));  // fast travel //
        f1.setTile(0,2,new PlayerTile());  // player //

        // Create floor object //
        Floor f2 = new Floor(3, 7);
        // Add tiles //
        f2.setTile(0,1,new DoorTile("up"));  // door //
        f2.setTile(3,2,new DoorTile("right"));  // door //  
        f2.setTile(1,0,new SpawnTile());
        f2.setTile(3,0,new SpawnTile());
        f2.setTile(5,0,new SpawnTile());
        f2.setTile(0,1,new PlayerTile());  // player //

        Floor f3 = new Floor(5, 7);
        // Add tiles //
        f3.setTile(0,2,new DoorTile("up"));  // door //
        f3.setTile(3,0,new DoorTile("left"));  // door //  
        f3.setTile(3,4,new DoorTile("right"));  // door //  
        f3.setTile(1,2,new SpawnTile());
        f3.setTile(5,2,new SpawnTile());
        f3.setTile(0,0,new BoarderTile());
        f3.setTile(0,4,new BoarderTile());
        f3.setTile(1,0,new BoarderTile());
        f3.setTile(1,4,new BoarderTile());
        f3.setTile(5,0,new BoarderTile());
        f3.setTile(5,4,new BoarderTile());
        f3.setTile(6,0,new BoarderTile());
        f3.setTile(6,4,new BoarderTile());
        f3.setTile(3,0,new PlayerTile());  // player //

        // Create floor object //
        Floor f4 = new Floor(7, 8);
        // Add tiles //
        f4.setTile(0,3,new FastTravelTile(false));  // fast travel //
        f4.setTile(7,3,new DoorTile("down"));  // door //
        f4.setTile(2,1,new SpawnTile());
        f4.setTile(2,3,new SpawnTile());
        f4.setTile(2,5,new SpawnTile());
        f4.setTile(4,1,new SpawnTile());
        f4.setTile(4,5,new SpawnTile());
        f4.setTile(6,1,new SpawnTile());
        f4.setTile(6,5,new SpawnTile());
        f4.setTile(4,3, new BossTile());
        f4.setTile(0,0,new BoarderTile());
        f4.setTile(0,1,new BoarderTile());
        f4.setTile(0,5,new BoarderTile());
        f4.setTile(0,6,new BoarderTile());
        f4.setTile(7,3,new PlayerTile());  // player //

        // Create floor object //
        Floor f5 = new Floor(6, 3);
        // Add tiles //
        f5.setTile(1,0,new DoorTile("left"));  // door //
        f5.setTile(0,2,new SpawnTile());
        f5.setTile(0,4,new SpawnTile());
        f5.setTile(2,2,new SpawnTile());
        f5.setTile(2,4,new SpawnTile());
        f5.setTile(1,0,new PlayerTile());  // player //

        // Add the floors to the array //
        addFloor(1, 0, f2);
        addFloor(1, 1, f3);
        addFloor(0, 1, f4);
        addFloor(1, 2, f5);
        addFloor(f1, 0, 0);
    }
}
