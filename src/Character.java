/**
 * The {Character} class represents a player character in a game.
 * It includes information such as the character's name, job, runes, level, and
 * stats.
 * 
 * <p>
 * The maximum length for the player's name is set to 25 characters.
 * </p>
 * 
 * <p>
 * The stats array holds six integer values representing different attributes of
 * the character.
 * </p>
 * 
 * 
 * @version 1.0
 */
public class Character {

    /**
     * @name is the name of the character, with a maximum length of 25 characters.
     * @job is the job or profession of the character.
     * @runes is the amount of runes the character possesses.
     * @level is the level of the Character
     * @stats is an array holding six integer values representing various stats of
     *        the character.
     * 
     */
    private String name;
    private String job;
    private int runes;
    private int level;
    private int[] stats = new int[6];

    // NEW ADDITIONS
    private Weapon weapon;

    /**
     * Constructs a new {Character} with default values.
     * The character starts with an empty name, the job "Jobless", 0 runes, level 1,
     * and all stats set to 0.
     */
    public Character() {
        this.name = "";
        this.job = "Jobless";
        this.runes = 0;
        this.level = 1;
        for (int i = 0; i < 5; i++)
            stats[i] = 0;
    }

    /**
     * Gets the name of the character.
     * 
     * @return The name of the character.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the job of the character.
     * 
     * @return The job of the character.
     */
    public String getJob() {
        return this.job;
    }

    /**
     * Gets the amount of runes the character possesses.
     * 
     * @return The amount of runes.
     */
    public int getRunes() {
        return this.runes;
    }

    /**
     * Sets the name of the character.
     * 
     * @param name The new name for the character.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the job of the character.
     * 
     * @param job The new job for the character.
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * Sets the amount of runes the character possesses.
     * 
     * @param runes The new amount of runes.
     */
    public void setRunes(int runes) {
        this.runes = runes;
    }

    /**
     * Sets a specific stat value of the character.
     * 
     * @param stats The new stat value.
     * @param i     The index of the stat in the stats array.
     */
    public void setStats(int stats, int i) {
        this.stats[i] = stats;
    }

    /**
     * Gets a stat value of the character.
     * 
     * @param i The index of the stat in the stats array.
     * @return The value of the specified stat.
     */
    public int getStats(int i) {
        return this.stats[i];
    }

    /**
     * Increases the level of the character by 1.
     */
    public void levelUp() {
        this.level += 1;
    }

    /**
     * Gets the level of the character.
     * 
     * @return The level of the character.
     */
    public int getLevel() {
        return this.level;
    }

    // NEW FUNCTIONS
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return this.weapon;
    }
}
