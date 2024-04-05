import java.util.ArrayList;

public class CreditsModel {
    private ArrayList<String> devs;

    /**
     * This is the constructor for the class Creduts. 
     * 
     * Here located is the list of developers who worked on the program.
     */
    public CreditsModel() {
        devs = new ArrayList<>();
        devs.add("Harder, Kevin");
        devs.add("Mariñas, Carl Mervyn");
    }

    /**
     * This method gets the Developer name list.
     * 
     * @return  The devs object;
     */
    public ArrayList<String> getDevs() {
        return devs;
    }
}
