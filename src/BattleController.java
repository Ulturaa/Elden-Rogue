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
                if(sel < 0 || sel > 2) {
                    System.out.println("Nothing happened");
                } else {
                    double dmg = 0;
                    switch(sel){ 
                        case 0:
                            dmg = bm.Attack(sel);
                            break;
                        case 1: 
                            dmg = bm.Attack(sel);
                            break;
                        case 2:
                            dmg = bm.Attack(sel);
                            break;
                    }
                    bv.setEventLbl("You dealt " + dmg + " damage.");
                    bm.rollEntityAttack();
                    bv.updateLabels(bm.getEntity().getHP(), bm.getEntity().getATK(), bm.getCharacter().getCurrHP());
                    if(bm.hasPlayerDied() ==  true) {
                        JOptionPane.showMessageDialog(null, "Player has died", "You died.", JOptionPane.ERROR_MESSAGE);
                        bv.Dispose();
                        av.setVisible(true);
                    }
                    if(bm.hasEntityDied() == true) {
                        if(bm.getEntity() instanceof Enemy) {
                            JOptionPane.showMessageDialog(null, "Enemy slain!", "Enemy has been felled!", JOptionPane.INFORMATION_MESSAGE);
                            //Give runes
                            bv.Dispose();
                            av.setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(null, "Enemy slain!", "Greater Enemy has been felled!", JOptionPane.INFORMATION_MESSAGE);
                            //Give runes
                            bv.Dispose();
                            av.setVisible(true);
                        }
                    }
                }
            }
        });

        this.bv.dgeBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bv.setEventLbl("You dodged.");
                if(bm.Dodge() == true) {
                    bv.setEventLbl("Dodge success! Attack evaded.");
                } else {
                    bv.setEventLbl("Dodge faled! Enemy attacked.");
                }

                bm.rollEntityAttack();
                bv.updateLabels(bm.getEntity().getHP(), bm.getEntity().getATK(), bm.getCharacter().getCurrHP());
                if(bm.hasPlayerDied() ==  true) {
                    JOptionPane.showMessageDialog(null, "Player has died", "You died.", JOptionPane.ERROR_MESSAGE);
                    bv.Dispose();
                    av.setVisible(true);
                }
            }
        });
    }
    
    public static void main(String[] args) {
        BattleView bv;
        //new BattleView(new Enemy(2, 1), new Character());
        
        //new BattleView(new RennalaQueenOfTheFullMoon(), new Character());
        //new BattleView(new GodrickTheGrafted(), new Character());
        BattleModel bm = new BattleModel(new Character(), new RennalaQueenOfTheFullMoon(), 1);
        bv = new BattleView(new RennalaQueenOfTheFullMoon(), new Character());
        AreaView av = new AreaView(new StormveilCastle(new Character()));
        av.closeArea();
        new BattleController(bv, bm, av);
        
    }
}
