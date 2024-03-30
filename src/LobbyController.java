import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class LobbyController {
    private LobbyModel lm;
    private LobbyView lv;

    public LobbyController(LobbyModel lm, LobbyView lv) {
        this.lm = lm;
        this.lv = lv;

        lv.setLLabel("NAME: " + lm.getName());
        lv.setLLabel("JOB CLASS: " + lm.getJob());
        lv.setLLabel("LEVEL: " + lm.getLevel());
        lv.setLLabel("RUNES: " + lm.getRunes());

        lv.composeLLabels();

        lv.setLButton("FAST TRAVEL", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("FAST TRAVELING");
            }
        });

        lv.setLButton("LEVEL UP", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("LEVEL UP SCREEN");
                lv.setVisible(false);
                Character character = lm.getCharacter();

                LevelUpView luv = new LevelUpView();
                LevelUpModel lum = new LevelUpModel(character);
                LevelUpController luc = new LevelUpController(lum, luv, lv);
            }
        });

        lv.setLButton("INVENTORY", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("OPENING INVENTORY");
                lv.setVisible(false);
                InventoryModel im = new InventoryModel();
                InventoryView iv = new InventoryView();
                InventoryController ic = new InventoryController(im, iv);
            }
        });

        lv.setLButton("SHOP", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ENTERING SHOP");
            }
        });

        lv.setLButton("QUIT GAME", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("QUITTING");
            }
        });

        lv.composeLButtonlist();
    }
}
