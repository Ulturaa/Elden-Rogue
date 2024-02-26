public class Entity {
    protected String name;
    protected int HP;
    protected int[] stats = new int[5];

    public Entity(String name, int HP) {
        this.name = name;
        this.HP = HP;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setStats(int stats, int i) {
        this.stats[i] = stats;
    }

    public int getStats(int i) {
        return this.stats[i];
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getHP() {
        return this.HP;
    }
}
