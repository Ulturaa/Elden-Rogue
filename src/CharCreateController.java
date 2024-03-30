import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

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
        ccv.setCCLabel("STRENGTH:");
        ccv.setCCLabel("INTELLIGENCE:");
        ccv.setCCLabel("FAITH:");

        ccv.composeCCLabels();

        ccv.setCCButton("Input Name", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("FOR INPUTTING NAME");
                String pName = null;
                boolean runit = true;

                ccv.getuserNameInput();
                System.out.println(ccv.getnameInput());
                pName = ccv.getnameInput();
                ccm.setName(pName);
                ccm.setCharacterName();
                pName = ccm.getCharacterName();
                ccv.updateLabel(0, "NAME: " + pName);

            }
        });

        ccv.setCCButton("Select Job Class", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // System.out.println("To Character Creation.");
                ccv.showJobchoices();
                String job = ccv.getSelectedJob();
                System.out.println(job);
                ccm.setJobClass(job);
                ccm.setStats(ccm.getJobClass());

                ccv.updateLabel(1, "JOB CLASS: " + ccm.getJobClass());
                ccv.updateLabel(2, "LEVEL: " + ccm.getLevel());
                ccv.updateLabel(3, "HP: " + ccm.getstat(0));
                ccv.updateLabel(4, "ENDURANCE: " + ccm.getstat(1));
                ccv.updateLabel(5, "DEXTERITY: " + ccm.getstat(2));
                ccv.updateLabel(6, "STRENGTH: " + ccm.getstat(3));
                ccv.updateLabel(7, "INTELLIGENCE: " + ccm.getstat(4));
                ccv.updateLabel(8, "FAITH: " + ccm.getstat(5));
            }
        });

        ccv.setCCButton("Confirm", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Confirming");
                JLabel sysMessage = new JLabel();

                if (ccm.getCharacterName() == "" || ccm.getLevel() == "1") {
                    sysMessage = ccv.sysMessage("Please input BOTH NAME AND JOB CLASS");
                    System.out.println("Please input BOTH NAME AND JOB CLASS");
                } else {
                    ccv.clearSysMessage(sysMessage);
                    // go to lobby
                }
            }
        });

        ccv.setCCButton("Back", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ccv.closeFrame();
                Game game = new Game();
                // game.TitleScreen();
                game.cc();
                Character character = game.getCharacter();
                CharCreate charCreate = game.getCharCreate();
                TitleScreenModel tsm = new TitleScreenModel();
                TitleScreenView tsv = new TitleScreenView();
                TitleScreenController tsc = new TitleScreenController(tsv, tsm, character,
                        charCreate);
            }
        });

        ccv.composeCCButtonList();

    }

    // public static void main(String[] args) {
    // new CharCreateController(new CharCreateModel(), new CharCreateView());
    // }
}
