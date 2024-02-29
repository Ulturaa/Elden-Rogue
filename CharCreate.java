import java.util.Scanner;
import java.util.ArrayList;

public class CharCreate {
    private String name;
    private int index;
    // private Character character;

    ArrayList<String> jobList = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    Scanner jc = new Scanner(System.in);

    public CharCreate() {

        jobList.add("Vagabond");
        jobList.add("Samurai");
        jobList.add("Warrior");
        jobList.add("Hero");
        jobList.add("Astrologer");
        jobList.add("Prophet");
    }

    public void setCharName() {
        String scname;

        System.out.println("Please Input the name of your character:");
        scname = sc.nextLine();

        if (scname.length() > 25) {
            scname = scname.substring(0, 25);
        }

        this.name = scname;

        System.out.println("Welcome!  " + this.name);

    }

    public void selectJob() {
        int jChoice;
        do {
            System.out.println("Please Select your Job Class");
            System.out.println("[1] Vagabond");
            System.out.println("[2] Samurai");
            System.out.println("[3] Warrior");
            System.out.println("[4] Hero");
            System.out.println("[5] Astrologer");
            System.out.println("[6] Prophet");
            jChoice = jc.nextInt();
        } while (jChoice > 6 || jChoice < 1);
        this.index = jChoice - 1;
        System.out.println("You are a " + this.jobList.get(this.index));

    }

    public String getCharJob() {
        return this.jobList.get(this.index);
    }

    public Boolean confirm() {
        if (this.name != null) {
            return true;
        }
        return false;
    }

    public String getCharName() {
        return this.name;
    }

    public void displayChar(Character character) {
        System.out.println("CHARACTER\n");

        System.out.println("NAME:" + character.getName());

        System.out.println("JOB CLASS:" + character.getJob());

        System.out.println("HP:" + character.getStats(0));
        System.out.println("ENDURANCE:" + character.getStats(1));
        System.out.println("DEXTERITY:" + character.getStats(2));
        System.out.println("STRENGTH:" + character.getStats(3));
        System.out.println("INTELLIGENCE:" + character.getStats(4));
        System.out.println("FAITH:" + character.getStats(5));

    }

    public void setStats(String jobClass, Character character) {
        switch (jobClass) {
            case "Vagabond":
                character.setStats(15, 0);
                character.setStats(11, 1);
                character.setStats(13, 2);
                character.setStats(14, 3);
                character.setStats(9, 4);
                character.setStats(9, 5);
                break;
            case "Samurai":
                character.setStats(12, 0);
                character.setStats(13, 1);
                character.setStats(15, 2);
                character.setStats(12, 3);
                character.setStats(9, 4);
                character.setStats(8, 5);
                break;
            case "Warrior":
                character.setStats(11, 0);
                character.setStats(11, 1);
                character.setStats(16, 2);
                character.setStats(10, 3);
                character.setStats(10, 4);
                character.setStats(8, 5);
                break;
            case "Hero":
                character.setStats(14, 0);
                character.setStats(12, 1);
                character.setStats(9, 2);
                character.setStats(16, 3);
                character.setStats(7, 4);
                character.setStats(8, 5);
                break;
            case "Astrologer":
                character.setStats(9, 0);
                character.setStats(9, 1);
                character.setStats(12, 2);
                character.setStats(8, 3);
                character.setStats(16, 4);
                character.setStats(7, 5);
                break;
            case "Prophet":
                character.setStats(10, 0);
                character.setStats(8, 1);
                character.setStats(10, 2);
                character.setStats(11, 3);
                character.setStats(7, 4);
                character.setStats(16, 5);
                break;
            default:
                break;
        }
    }

    // FOR REFERENCE
    // INDEX 0 - HP
    // INDEX 1 - END
    // INDEX 2 - DEX
    // INDEX 3 - STR
    // INDEX 4 - INT
    // INDEX 5 - FTH
}