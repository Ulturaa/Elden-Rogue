/**
 * The { Entity} class serves as a super class for representing entities in a game.
 * It includes common attributes such as a name, HP, and an array of statistics.
 * 
 */
import javax.swing.ImageIcon;
import java.util.Random;

public abstract class Entity {

    /**
     * name     is the name of the entity.
     * HP       is the health points of the entity.
     * Atk      is the range for the entity's attack.
     * PhysD    is the Physical defense value.
     * SorcD    is the Sorcery defense value.
     * IncaD    is the Incantation defense value.
     * sprite   is the image/picture of the enemy.
     */
    //private final ImageIcon sprite;
    private final String name;
    private int HP;
    private int Atk[];
    private double PhysD;
    private double SorcD;
    private double IncaD;
    

    /**
     * Constructs a new {Entity} with the specified name and hit points.
     * 
     * @param name The name of the entity.
     * @param HP The hit points of the entity.
     */
    public Entity(String name, int HP) {
        this.name = name;
        this.HP = HP;
        this.Atk = new int[2]; // 0 = lb, 1 = ub
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
     * Sets the Attack range of the entity.
     * 
     * @param lb The lower bounds value for attack.
     * @param lb The upper bounds value for attack.
     */
    public void setAtk(int lb, int ub) {
        this.Atk[0] = lb;
        this.Atk[1] = ub;
    } 

    /**
     * Sets the Defenses of the entity.
     * 
     * @param PhysD    is the Physical defense value.
     * @param SorcD    is the Sorcery defense value.
     * @param IncaD    is the Incantation defense value.
     */
    public void setDef(double PhysD, double SorcD, double IncaD) {
        this.PhysD = PhysD;
        this.SorcD = SorcD;
        this.IncaD = IncaD;
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
     * Gets the Physical defense of the entity.
     * 
     * @return The Physical defense value of the entity.
     */
    public double getPhysD() {
        return this.PhysD;
    }

    /**
     * Gets the Sorcery defense of the entity.
     * 
     * @return The Sorery defense value of the entity.
     */
    public double getSorcD() {
        return this.SorcD;
    }

    /**
     * Gets the Incantation defense of the entity.
     * 
     * @return The Incntation defense value of the entity.
     */
    public double getIncaD() {
        return this.IncaD;
    }

    /**
     * Rolls for the attack of the enemy.
     * A random number is generated within a range then is multiplied by the area num.
     * 
     * @return the rolled attack value.
     */
    public int rollAttack(int areaNum) {
        return areaNum * (new Random().nextInt(Atk[1]-Atk[0]) + Atk[0]);
    }

    /**
     * Abstract class for enemy and boss to create.
     * Abstract because the formula differs between enemy and boss.
     * 
     * @return the droped runes when defeated.
     */
    public abstract int dropRunes(int roll);
}
