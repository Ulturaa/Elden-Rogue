public class AreaModel {
    
    private Area area;
    private Character character;

    public AreaModel(Area area, Character character) {
        this.area = area;
        this.character = character;
    }

    public boolean movePlayer(char input) {
        return area.getFloors().movePlayer(input);
    }

    public void interact() {
        area.interact();
    }

    public Area getArea() {
        return area;
    }

    public Floor getFloors() {
        return area.getFloors();
    }

    public Tile getCurrTile() {
        return area.getFloors().getCurrTile();
    }

    public void setPlayerHP() {
        if(character.getWeapon() != null) {
            character.setCurrHP(100 * ((character.getStats(0) + character.getWeapon().getWeaponStat(0)) / 2));
        } else {
            character.setCurrHP(100 * (character.getStats(0) / 2)); 
        }
    }

    public Character getCharacter() {
        return character;
    }
}
