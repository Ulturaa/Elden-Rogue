public class Boss extends Entity {

    public Boss(String name) { // add String spritePath
        super(name);
        }
    }

    public int dropRunes(int roll) {
        return getHP() * 5;
    }
}
