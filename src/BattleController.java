import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class BattleController {
    private BattleView bv;
    private BattleModel bm;
    private AreaView av;

    public BattleController(BattleView bv, BattleModel bm, AreaView av){ 
        this.bv = bv;
        this.bm = bm;
        this.av = av;

        this.bv.atkBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] aOpt = {"Physical", "Sorcery", "Incantation"};
                int sel = JOptionPane.showOptionDialog(null, "Select attack:", "ATTACK", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, aOpt, -1);
                switch(sel){ 
                    case 0: 
                        bv.setEventLbl("You dealt physical damage.");
                        bm.Attack(sel);
                        break;
                    case 1: 
                        bv.setEventLbl("You dealt sorcery damage.");
                        bm.Attack(sel);
                        break;
                    case 2:
                        bv.setEventLbl("You dealt incantation damage.");
                        bm.Attack(sel);
                        break;
                    default:
                        System.out.println("Nothing happened.");
                        bv.setEventLbl("");
                }
                bv.updateLabels();
            }
        });

        this.bv.dgeBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bv.setEventLbl("You dodged.");
            }
        });


    }
    public static void main(String[] args) {
        BattleView bv;
        //new BattleView(new Enemy(2, 1), new Character());
        
        //new BattleView(new RennalaQueenOfTheFullMoon(), new Character());
        //new BattleView(new GodrickTheGrafted(), new Character());
        BattleModel bm = new BattleModel(new Character(), new RennalaQueenOfTheFullMoon());
        bv = new BattleView(new RennalaQueenOfTheFullMoon(), new Character());
        AreaView av = new AreaView(new StormveilCastle(new Character()));
        av.closeArea();
        new BattleController(bv, bm, av);
        
    }
}
