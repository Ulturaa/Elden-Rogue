/**
 * The { Entity} class serves as a super class for representing entities in a game.
 * It includes common attributes such as a name, HP, and an array of statistics.
 * 
 */
public class Entity {

    /**
     * name     is the name of the entity.
     * HP       is the health points of the entity.
     */
    protected String name;

    /**
     * The health points (HP) of the entity.
     */
    protected int HP;

    /**
     * An array holding five integer values representing stats of the entity.
     */
    protected int[] stats = new int[5];

    /**
     * Constructs a new {Entity} with the specified name and hit points.
     * 
     * @param name The name of the entity.
     * @param HP The hit points of the entity.
     */
    public Entity(String name, int HP) {
        this.name = name;
        this.HP = HP;
    }

    /**
     * Sets the name of the entity.
     * 
     * @param name The new name for the entity.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the entity.
     * 
     * @return The name of the entity.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets a specific stat value of the entity.
     * 
     * @param stats The new stat value.
     * @param i The index of the stat in the stats array.
     */
    public void setStats(int stats, int i) {
        this.stats[i] = stats;
    }

    /**
     * Gets a specific stat value of the entity.
     * 
     * @param i The index of the stat in the stats array.
     * @return The value of the specified stat.
     */
    public int getStats(int i) {
        return this.stats[i];
    }

    /**
     * Sets the health points(HP) of the entity.
     * 
     * @param HP The new hit points value.
     */
    public void setHP(int HP) {
        this.HP = HP;
    }

    /**
     * Gets the health points (HP) of the entity.
     * 
     * @return The health points of the entity.
     */
    public int getHP() {
        return this.HP;
    }
}
