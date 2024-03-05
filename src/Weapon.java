public class Weapon {

    private String name;
    private int[] weaponStats;
    private int runeCost;

    public Weapon(String name, int runeCost) {

        this.name = name;
        this.runeCost = runeCost;
        for (int i = 0; i < 5; i++)
            weaponStats[i] = 0;
    }

    public void setWeaponStat(int i, int stats) {
        this.weaponStats[i] = stats;
    }

    public int getWeaponStat(int i) {
        return this.weaponStats[i];
    }

    public String getName() {
        return this.name;
    }

    // FOR REFERENCE
    // INDEX 0 - HP
    // INDEX 1 - END
    // INDEX 2 - DEX
    // INDEX 3 - STR
    // INDEX 4 - INT
    // INDEX 5 - FTH
}
