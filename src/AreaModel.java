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

    public Character getCharacter() {
        return character;
    }
}
