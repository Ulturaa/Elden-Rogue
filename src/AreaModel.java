public class AreaModel {
    
    private Area area;
    private Character character;
    public AreaModel() {
    }

    public void movePlayer(char input) {
        area.movePlayer(input);
    }

    public void interact() {
        
    }

    public Area getArea() {
        return area;
    }

    public Character getCharacter() {
        return character;
    }
}
