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
    private int type;

    /**
     * Constructs a new Enemy object with the specified name and health.
     * 
     * The constructor calls the constructor of the superclass Entity with the
     * provided name and HP
     * 
     * @param eType     Enemy Type
     * @param aNum      Area num
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
        randAttack();

        switch (aNum) {
            case 1:
                switch (type) {
                    case 1:
                        this.name = "Godrick Soldier";
                        this.setBSprite("BattleSprites/GodrickSoldier.png");
                        break;
                    case 2:
                        this.name = "Godrick Archer";
                        this.setBSprite("BattleSprites/GodrickArcher.png");
                        break;
                    case 3:
                        this.name = "Godrick Knight";
                        this.setBSprite("BattleSprites/GodrickKnight.png");
                        break;
                }
                break;
            case 2:
                switch (type) {
                    case 1:
                        this.name = "Living Jar";
                        this.setBSprite("BattleSprites/LivingJar.png");
                        break;
                    case 2:
                        this.name = "Glintstone Sorcerer";
                        this.setBSprite("BattleSprites/GlintstoneSorcerer.png");
                        break;
                    case 3:
                        this.name = "Battlemage";
                        this.setBSprite("BattleSprites/Battlmage.png");
                        break;
                }
                break;
            default:
                this.name = "Missing no."; // In the case of an invalid input
        }
    }
    /**
     * Returns the type of the enemy.
     * 
     * @return the enemy type.
     */
    public int getType() {
        return this.type;
    }

    /**
     * Set up the base stats for the Enemy class based on their
     * type.
     * 
     * @param type
     */
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

    public void randAttack() {
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

    /**
     * Computes for the runes when entity is defeated.
     * 
     * @return the computed runes.
     */
    public int dropRunes() {
        return (int)getHP() * 2;
    }

}