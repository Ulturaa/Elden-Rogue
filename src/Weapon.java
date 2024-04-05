public class Weapon {

    private String name;
    private int[] weaponStats = new int[6];
    private int runeCost;

    /**
     * Constructor for the weapon class
     * 
     * 
     * @param name     is the name of the weapon
     * @param runeCost is how much the weapon costs
     */
    public Weapon(String name, int runeCost) {

        this.name = name;
        this.runeCost = runeCost;
        for (int i = 0; i < 5; i++)
            weaponStats[i] = 0;
    }

    /**
     * Other constructor of the weapons that has stats
     * 
     * @param statHP  health
     * @param statEND endurance
     * @param statDEX dexterity
     * @param statSTR strength
     * @param statINT intelligence
     * @param statFTH faith
     */
    public Weapon(String name, int runeCost, int statHP, int statEND, int statDEX, int statSTR, int statINT,
            int statFTH) {
        this.name = name;
        this.runeCost = runeCost;
        this.weaponStats[0] = statHP;
        this.weaponStats[1] = statEND;
        this.weaponStats[2] = statDEX;
        this.weaponStats[3] = statSTR;
        this.weaponStats[4] = statINT;
        this.weaponStats[5] = statFTH;
    }

    /**
     * Setter for weapon stats
     * 
     */
    public void setWeaponStat(int i, int stats) {
        this.weaponStats[i] = stats;
    }

    /**
     * Getter for weapon stats
     */
    public int getWeaponStat(int i) {
        return this.weaponStats[i];
    }

    /**
     * Getter for the weapon's name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter for the weapon's rune cost
     */
    public int getRuneCost() {
        return this.runeCost;
    }

    // FOR REFERENCE
    // INDEX 0 - HP
    // INDEX 1 - END
    // INDEX 2 - DEX
    // INDEX 3 - STR
    // INDEX 4 - INT
    // INDEX 5 - FTH
}
