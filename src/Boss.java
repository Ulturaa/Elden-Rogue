import java.util.Random;

public class Boss extends Entity {


    public Boss(String name) { // add String spritePath
        super(name);
    }

    public void statistics(int hp, int atkLb, int atkUb, double pD, double sD, double iD) {
        setHP(hp);
        setStats(pD, 0);
        setStats(sD, 1);
        setStats(iD, 2);
        setATK(new Random().nextInt(atkUb - atkLb) + atkLb + 1);
    }

    /**
     * Computes for the runes when entity is defeated.
     * 
     * @return the computed runes.
     */
    public int dropRunes(int roll) {
        return getHP() * 5;
    }
}
