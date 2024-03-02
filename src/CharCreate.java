import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 * The CharCreate class facilitates the creation of a character in a game.
 * It allows the player to set the character's name, select a job class, and displays and sets character statistics.
 * 
 * It includes methods for setting the character's name, selecting a job class, confirming character creation,
 * getting character information, displaying character details, and setting initial statistics based on the chosen job class.
 * 
 * The class utilizes a list of predefined job classes and handles user input with exception handling.
 */
public class CharCreate {
    
    /**
     * @name is the name of the character.
     * @index is the index representing the selected job class in the jobList.
     * @jobList is the list of Job Classes
     */
    private String name;
    private int index;
    private ArrayList<String> jobList = new ArrayList<>();

    /**
     * Scanner object for general input.
     */
    private Scanner sc = new Scanner(System.in);

    /**
     * Scanner object for job class selection.
     */
    private Scanner jc = new Scanner(System.in);

    /**
     * Constructs a new {CharCreate} object and initializes the list of job classes.
     */
    public CharCreate() {
        jobList.add("Vagabond");
        jobList.add("Samurai");
        jobList.add("Warrior");
        jobList.add("Hero");
        jobList.add("Astrologer");
        jobList.add("Prophet");
    }

    /**
     * Sets the name of the character based on user input.
     */
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

    /**
     * Allows the player to select a job class from the predefined list.
     * 
     * @exception InputMismatchException excemption when an Integer input is given a Character or String.
     */
    public void selectJob() {
        int jChoice = 0;
        
        do {
            try{
                System.out.print("\033\143");
                System.out.println("Please Select your Job Class");
                System.out.println("[1] Vagabond");
                System.out.println("[2] Samurai");
                System.out.println("[3] Warrior");
                System.out.println("[4] Hero");
                System.out.println("[5] Astrologer");
                System.out.println("[6] Prophet");
                jChoice = jc.nextInt();

            }catch(InputMismatchException e){
                jc.nextLine();
                System.out.print("\033\143");
                System.out.println("Invalid input");
            }
            
        } while (jChoice > 6 || jChoice < 1);
        this.index = jChoice - 1;
        System.out.println("You are a " + this.jobList.get(this.index));
    }

    /**
     * Gets the selected job class.
     * 
     * @return The selected job class.
     */
    public String getCharJob() {
        return this.jobList.get(this.index);
    }

    /**
     * Confirms whether the character has been created.
     * 
     * @return {@code true} if the character has been created, {@code false} otherwise.
     */
    public Boolean confirm() {
        return this.name != null;
    }

    /**
     * Gets the name of the character.
     * 
     * @return The name of the character.
     */
    public String getCharName() {
        return this.name;
    }

    /**
     * Displays the details of the character, including name, job class, and statistics.
     * 
     * @param character The character to be displayed.
     */
    public void displayChar(Character character) {
        System.out.print("\033\143");
        System.out.println("CHARACTER\n");

        System.out.println("NAME:" + character.getName());
        System.out.println("JOB CLASS:" + character.getJob() + "\n");

        System.out.println("HP:            " + character.getStats(0));
        System.out.println("ENDURANCE:     " + character.getStats(1));
        System.out.println("DEXTERITY:     " + character.getStats(2));
        System.out.println("STRENGTH:      " + character.getStats(3));
        System.out.println("INTELLIGENCE:  " + character.getStats(4));
        System.out.println("FAITH:         " + character.getStats(5));
    }

    /**
     * Sets the initial statistics of the character based on the chosen job class.
     * 
     * @param jobClass The chosen job class.
     * @param character The character whose stats will be set.
     */
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