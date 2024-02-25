public class Character {
    private String name; // Player name is 25 char max
    private String job;
    private int runes;
    private int level;
    private int[] stats = new int[6];

    public Character() {
        this.name = "";
        this.job = "Jobless";
        this.runes = 1000;
        this.level = 1;
        for (int i = 0; i < 5; i++)
            stats[i] = 0;
    }

    public String getName() {
        return this.name;
    }

    public String getJob() {
        return this.job;
    }

    public int getRunes() {
        return this.runes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setRunes(int runes) {
        this.runes = runes;
    }

    public void setStats(int stats, int i) {
        this.stats[i] = stats;
    }

    public int getStats(int i) {
        return this.stats[i];
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return this.level;
    }

}
