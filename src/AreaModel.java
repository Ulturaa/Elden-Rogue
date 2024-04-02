public class AreaModel {
    
    private Area area;
    private Character character;

    /**
     * This is the constructor for the class Area. This initalizes the attributes of
     * area.
     * 
     * @param area          The current area.
     * @param character     The character object
     */
    public AreaModel(Area area, Character character) {
        this.area = area;
        this.character = character;
    }

    /**
     * This method sets the character/player HP upon creation of the area.
     * 
     */
    public void setPlayerHP() {
        if(character.getWeapon() != null) {
            character.setCurrHP(100 * ((character.getStats(0) + character.getWeapon().getWeaponStat(0)) / 2));
        } else {
            character.setCurrHP(100 * (character.getStats(0) / 2)); 
        }
    }

    /**
     * This method calls a method from floor to move the player.
     * 
     * @param input Inputed character for moving the player (W,A,S,D).
     * 
     * @return      True if the valid move, else false.
     */
    public boolean movePlayer(char input) {
        return area.getFloors().movePlayer(input);
    }
    
    /**
     * This method gets the character object.
     * 
     * @return  The characer object;
     */
    public Character getCharacter() {
        return character;
    }

    /**
     * This method gets the area object.
     * 
     * @return  The area object;
     */
    public Area getArea() {
        return area;
    }

    /**
     * This method gets the current floor from area.
     * 
     * @return  The current floor;
     */
    public Floor getFloors() {
        return area.getFloors();
    }

    /**
     * This method gets the tile the player is currently on.
     * This is gotten from the current floor.
     * 
     * @return  The current tile;
     */
    public Tile getCurrTile() {
        return area.getFloors().getCurrTile();
    }
}
