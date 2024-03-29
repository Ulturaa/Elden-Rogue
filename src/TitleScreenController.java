import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleScreenController {
    private TitleScreenView tsv;
<<<<<<< Updated upstream
    private TitleScreenModel tsm;
=======
    private TItleScreenModel tsm;
    private Character character;
    private CharCreate charCreate;

    TitleScreenController(TitleScreenView tsv, TItleScreenModel tsm, Character character, CharCreate charCreate) {
>>>>>>> Stashed changes

    public TitleScreenController(TitleScreenView tsv, TitleScreenModel tsm) {
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

    public static void main(String[] args) {
<<<<<<< Updated upstream
        TitleScreenView tsv = new TitleScreenView();
        TitleScreenModel tsm = new TitleScreenModel();
        TitleScreenController tsc = new TitleScreenController(tsv, tsm);
=======
        // new TitleScreenController(new TitleScreenView(), new TItleScreenModel());
>>>>>>> Stashed changes
    }

}
