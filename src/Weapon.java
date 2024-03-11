public class Weapon {

    private String name;
    private int[] weaponStats = new int[6];
    private int runeCost;

    public Weapon(String name, int runeCost) {

        this.name = name;
        this.runeCost = runeCost;
        for (int i = 0; i < 5; i++)
            weaponStats[i] = 0;
    }

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
