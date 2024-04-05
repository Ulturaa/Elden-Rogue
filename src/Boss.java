import java.util.Random;

public class Boss extends Entity {

    private int atkUb;
    private int atkLb;

    public Boss(String name) { // add String spritePath
        super(name);
    }

    /**
     * Set up the base stats for the Boss object from a variety
     * of parameters.
     * 
     * @param hp        base HP
     * @param atkLb     Attack lowerbound
     * @param atkUb     Attack Upperbound
     * @param pD        Physical Defense
     * @param sD        Sorcery Defense
     * @param iD        Incantation Defense
     */
    public void statistics(int hp, int atkLb, int atkUb, double pD, double sD, double iD) {
        setHP(hp);
        setStats(pD, 0);
        setStats(sD, 1);
        setStats(iD, 2);
        this.atkUb = atkUb;
        this.atkLb = atkLb;
        randAttack();
    }

    public void randAttack() {
        setATK(new Random().nextInt(this.atkUb - this.atkLb) + this.atkLb + 1);
    }

    /**
     * Computes for the runes when entity is defeated.
     * 
     * @return the computed runes.
     */
    public int dropRunes() {
        return (int)getHP() * 5;
    }
}