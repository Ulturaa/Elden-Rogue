/**
 * Enemy class represents an enemy entity in a game. The class extends the entity class.
 * It inherits the name and hp from entity.
 * 
 * The class inherits from the Entity class, which 
 * provides a general structure for game entities.
 */
public class Enemy extends Entity {

    private String name;
    private int HP;

    /**
     * Constructs a new Enemy object with the specified name and health.
     * 
     * The constructor calls the constructor of the superclass Entity with the 
     * provided name and HP
     * 
     * @param name The name of the enemy.
     * @param HP   The health of the enemy.
     */
    public Enemy(String name, int HP) {
        super(name, HP);
        // this.stats[0] = ;
    }

}
