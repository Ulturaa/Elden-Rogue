import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleScreenController {
    private TitleScreenView tsv;
    private TitleScreenModel tsm;

    private Character character;
    private CharCreate charCreate;

    /**
     * This is the constructor for the Titlescreen Conroller. This MVC system for Titlescreen.
     * 
     * @param tsv           The Title Screen View for visuals.
     * @param tsm           The Title Screen Model for data.
     * @param character     The character object.
     * 
     */
    public TitleScreenController(TitleScreenView tsv, TitleScreenModel tsm, Character character,
            CharCreate charCreate) {
        this.tsv = tsv;
        this.tsm = tsm;
        this.charCreate = charCreate;
        this.character = character;

        this.tsv.StartBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tsv.closeFrame();
                CharCreateView ccv = new CharCreateView();
                CharCreateModel ccm = new CharCreateModel(character, charCreate);
                CharCreateController ccc = new CharCreateController(ccm, ccv);
                System.out.println("To Character Creation.");

            }
        });

        this.tsv.ExitBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
