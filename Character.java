public class Character {
    private String name; //Player name is 25 char max
    private String job;

    public Character() {
        this.character = "";
        thi.job = "Jobless";
    }

    public String getName() {
        return this.name;
    }

    public String getJob() {
        return this.job;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
