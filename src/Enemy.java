import java.util.Random;

/**
 * Enemy class represents an enemy entity in a game. The class extends the
 * entity class.
 * It inherits the name and hp from entity.
 * 
 * The class inherits from the Entity class, which
 * provides a general structure for game entities.
 */
public class Enemy extends Entity {

    /**
     * name type String. Is the name of the Entity obj.
     * HP type Integer. It is the HP of the Entity.
     */
    // private String name;
    private int type;
    // private int HP;
    // private int ATK;
    // private double[] stats;

    /**
     * Constructs a new Enemy object with the specified name and health.
     * 
     * The constructor calls the constructor of the superclass Entity with the
     * provided name and HP
     * 
     * @param name The name of the enemy.
     * @param HP   The health of the enemy.
     */
    public Enemy(int eType, int aNum) {
        super();
        this.type = eType;
        // this.HP = 0;
        // this.ATK = 0;
        // this.stats = new double[3];
        for (int i = 0; i < 2; i++)
            stats[i] = 0;

        statistics(eType);

        switch (aNum) {
            case 1:
                switch (type) {
                    case 1:
                        this.name = "Godrick Soldier";
                        break;
                    case 2:
                        this.name = "Godrick Archer";
                        break;
                    case 3:
                        this.name = "Godrick Knight";
                        break;
                }
                break;
            case 2:
                switch (type) {
                    case 1:
                        this.name = "Living Jar";
                        break;
                    case 2:
                        this.name = "Glintstone Sorcerer";
                        break;
                    case 3:
                        this.name = "Battlemage";
                        break;
                }
                break;
            default:
                this.name = "Missing no."; // In the case of an invalid input
        }
    }

    public int getType() {
        return this.type;
    }

    public void statistics(int type) {
        if (this.type == type) {
            Random random = new Random();

            switch (this.type) {
                case 1:
                    this.HP = random.nextInt(30 - 20 + 1) + 20;
                    // this.ATK = random.nextInt(80 - 70 + 1) + 1;
                    this.stats[0] = 0.20;
                    this.stats[1] = 0.15;
                    this.stats[2] = 0.10;
                    break;
                case 2:
                    this.HP = random.nextInt(35 - 25 + 1) + 25;
                    // this.ATK = random.nextInt(130 - 120 + 1) + 1;
                    this.stats[0] = 0.50;
                    this.stats[1] = 0.15;
                    this.stats[2] = 0.20;
                    break;
                case 3:
                    this.HP = random.nextInt(80 - 70 + 1) + 70;
                    // this.ATK = random.nextInt(130 - 120 + 1) + 1;
                    this.stats[0] = 0.50;
                    this.stats[1] = 0.15;
                    this.stats[2] = 0.20;
                    break;
            }

        }
    }

    public void randAttack(int type) {
        if (this.type == type) {
            Random random = new Random();

            switch (this.type) {
                case 1:
                    this.ATK = random.nextInt(80 - 70 + 1) + 70;
                    break;
                case 2:
                    this.ATK = random.nextInt(120 - 110 + 1) + 110;
                    break;
                case 3:
                    this.ATK = random.nextInt(130 - 120 + 1) + 120;
                    break;
            }

        }
    }

    /**
     * Computes for the runes when entity is defeated.
     * 
     * @return the computed runes.
     */
    public int dropRunes() {
        return (int)getHP() * 2;
    }

}