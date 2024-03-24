public class Boss extends Entity {

    public Boss(String name, int HP) { // add String spritePath
        super(name, HP);
        }
    }

    public int dropRunes(int roll) {
        return getHP() * 5;
    }
}
