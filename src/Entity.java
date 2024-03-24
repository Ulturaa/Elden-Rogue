
/**
 * The { Entity} class serves as a super class for representing entities in a
 * game.
 * It includes common attributes such as a name, HP, and an array of statistics.
 * 
 */
import javax.swing.ImageIcon;
import java.util.Random;

public abstract class Entity {

    /**
     * name is the name of the entity.
     * HP is the health points of the entity.
     * Atk is the range for the entity's attack.
     * stats An array holding 3 double values representing defense stats of the
     * entity.
     * sprite is the image/picture of the enemy.
     */
    protected String name;
    protected int HP;
    protected int ATK;
    protected double[] stats;

    /**
     * Constructs a new {Entity}.
     * 
     */
    public Entity() {
        stats = new double[3];
    }

    /**
     * Constructs a new {Entity} with the specified name and hit points.
     * 
     * @param name The name of the entity.
     */
    public Entity(String name) {
        this.name = name;
        stats = new double[3];
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
     * Sets the Attack points(ATK) of the entity.
     * 
     * @param ATK The new attack value.
     */
    public void setATK(int ATK) {
        this.ATK = ATK;
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
     * Gets the health points (HP) of the entity.
     * 
     * @return The health points of the entity.
     */
    public int getHP() {
        return this.HP;
    }

    /**
     * Gets the attack of the entity.
     * 
     * @return The attack of the entity.
     */
    public int getATK() {
        return this.ATK;
    }

    /**
     * Sets a specific stat value of the entity.
     * 
     * @param stats The new stat value.
     * @param i     The index of the stat in the stats array.
     */
    public void setStats(double stats, int i) {
        this.stats[i] = stats;
    }

    /**
     * Gets a specific stat value of the entity.
     * 
     * @param i The index of the stat in the stats array.
     * @return The value of the specified stat.
     */
    public double getStats(int i) {
        return this.stats[i];
    }

    /**
     * Sets the name and stats for the entity
     * Abstract class to be set by the boss and enemy classes.
     * 
     */
    // public abstract void statistics(int type);

    /**
     * Computes for the runes when entity is defeated.
     * Abstract because the formula differs between enemy and boss.
     * 
     * @return the droped runes when defeated.
     */
    public abstract int dropRunes(int roll);
}