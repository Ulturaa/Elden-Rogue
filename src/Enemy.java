/**
 * Enemy class represents an enemy entity in a game. The class extends the entity class.
 * It inherits the name and hp from entity.
 * 
 * The class inherits from the Entity class, which 
 * provides a general structure for game entities.
 */
public class Enemy extends Entity{

    private int type;
    /**
     * Constructs a new Enemy object with the specified name and health.
     * 
     * The constructor calls the constructor of the superclass Entity with the 
     * provided name and HP
     * 
     * @param name The name of the enemy.
     * @param HP   The health of the enemy.
     */
    public Enemy(String name, int HP, int type) { // add String spritePath
        super(name, HP);
        this.type = type;
        switch (type) {
            case 1: setDef(0.20, 0.15, 0.10);
                break;
            case 2: setDef(0.50, 0.15, 0.25);
                break;
            case 3: setDef(0.20, 0.50, 0.25);
                break;
            default: setDef(0.25, 0.25, 0.20);
        }
    }

    public int getType(){
        return type;
    }

    public int dropRunes(int roll) {
        return getHP() * 2;
    }

}
