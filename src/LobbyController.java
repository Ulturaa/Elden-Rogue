import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

        Character character = lm.getCharacter();
        //Inventory inventory = lm.getInventory();
        //InventoryModel im = new InventoryModel(character, inventory);
        //InventoryView iv = new InventoryView();
        //InventoryController ic = new InventoryController(im, iv, lv);
        //iv.setVisible(false);

        lv.composeLLabels();

        lv.setLButton("FAST TRAVEL", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<String> aList = new ArrayList<>();
                String[] aArr;
                
                aList.add("STORMVEIL CASTLE | Clears: [" + lm.getCharacter().getAreaClear(1) + "]");
                aList.add("RAYA LUCARIA ACADEMY | Clears: [" + lm.getCharacter().getAreaClear(2) + "]");

                if(lm.getCharacter().getAreaClear(1) >= 10 && lm.getCharacter().getAreaClear(2) >= 10)
                    aList.add("THE ELDEN THRONE | Clears: [" + lm.getCharacter().getAreaClear(3) + "]");
                
                aArr = new String[aList.size()];
                for(int i = 0; i < aList.size(); i++)
                    aArr[i] = aList.get(i);

                int sel = JOptionPane.showOptionDialog(null, "SELECT AREA", "", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, aArr, -1);
                System.out.println(sel);
                Area area = null;
                if(sel >= 0 && sel <=2){
                    switch(sel) {
                        case 0:
                            area = new StormveilCastle(lm.getCharacter()); break;
                        case 1:
                            area = new RayaLucaria(lm.getCharacter()); break;
                        case 2:
                            area = new EldenThrone(lm.getCharacter()); break;                           
                    }
                    AreaView av = new AreaView(area);
                    AreaModel am = new AreaModel(area, lm.getCharacter());
                    AreaController ac = new AreaController(av, am, lv);
                    lv.setVisible(false);
                } else 
                    System.out.println("back to lobby");
                
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
                //iv.setVisible(true);
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
