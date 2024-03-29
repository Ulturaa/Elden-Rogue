import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharCreateController {

    private CharCreateModel ccm;
    private CharCreateView ccv;

    public CharCreateController(CharCreateModel ccm, CharCreateView ccv) {
        this.ccm = ccm;
        this.ccv = ccv;

        ccv.setCCLabel("NAME:");
        ccv.setCCLabel("JOB CLASS:");
        ccv.setCCLabel("LEVEL:");
        ccv.setCCLabel("HP:");
        ccv.setCCLabel("ENDURANCE:");
        ccv.setCCLabel("DEXTERITY:");
        ccv.setCCLabel("INTELLIGENCE:");
        ccv.setCCLabel("FAITH:");

        ccv.composeCCLabels();

        ccv.setCCButton("Input Name", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("FOR INPUTTING NAME");
                String pName = ccv.createAndGetInput();
                ccm.setName(pName);
            }
        });

        ccv.setCCButton("Select Job Class", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println("To Character Creation.");
            }
        });

        ccv.setCCButton("Confirm", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println("To Character Creation.");
            }
        });

        ccv.setCCButton("Back", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println("To Character Creation.");
            }
        });

        ccv.composeCCButtonList();

    }

    // public static void main(String[] args) {
    // new CharCreateController(new CharCreateModel(), new CharCreateView());
    // }
}
