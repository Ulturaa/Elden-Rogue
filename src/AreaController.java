import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class AreaController {

    AreaView av;
    AreaModel am;
    LobbyView lv;
    int runeDrop;

    /**
     * This is the constructor for the class Area. This sets up the MVC for
     * area.
     * 
     * @param av    The AreaView Class for view.
     * @param am    The AreaModel Class for data.
     * @param lv    The LobbyView class to coordinate with the controller in 
     *              hiding-opening/unhiding-closing lobby and area.
     */
    public AreaController(AreaView av, AreaModel am, LobbyView lv) {
        this.am = am;
        this.av = av;
        this.lv = lv;
        runeDrop = 0;
        am.setPlayerHP();
        av.updateLabels("");

        this.av.upBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(am.movePlayer('W') == true){
                    av.printArea(av.area);
                    av.updateLabels("");
                } else {
                    av.updateLabels("You hit a wall.");
                }
            }
        });

        this.av.downBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(am.movePlayer('S') == true){
                    av.printArea(av.area);
                    av.updateLabels("");
                } else {
                    av.updateLabels("You hit a wall.");
                }
            }
        });
        
        this.av.leftBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(am.movePlayer('A') == true){
                    av.printArea(av.area);
                    av.updateLabels("");
                } else {
                    av.updateLabels("You hit a wall.");
                }
            }
        });

        this.av.rightBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(am.movePlayer('D') == true){
                    av.printArea(av.area);
                    av.updateLabels("");
                } else {
                    av.updateLabels("You hit a wall.");
                }
            }
        });

        this.av.intBtnActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (am.getCurrTile() instanceof FastTravelTile) {
                    FastTravelTile ft = (FastTravelTile) am.getCurrTile();
                    if (ft.getIsEnabled() == true) {
                        JOptionPane.showMessageDialog(null, "Returning to Lobby", "", JOptionPane.PLAIN_MESSAGE);
                        ToLobby();
                    } else {
                        av.updateLabels("This is locked.\n Defeat the boss of the dungeon.");
                    }
                } else if (am.getCurrTile() instanceof DoorTile) {
                    am.getArea().moveToFloor();
                } else if (am.getCurrTile() instanceof SpawnTile) {
                    SpawnTile st = (SpawnTile) am.getCurrTile();
                    if (st.getIsEnabled() == true) {
                        if (st.TileEvent() == false) {
                            if(am.getArea().getAreaNum() == 3) {
                                av.updateLabels("No treasure was found.");
                            } else {
                                int eType = new Random().nextInt(3 - 1 + 1) + 1;
                                Enemy enemy = new Enemy(eType, am.getArea().getAreaNum());
                                runeDrop = enemy.dropRunes();
                                
                                av.setVisible(false);
                                BattleModel bm = new BattleModel(am.getCharacter(), enemy, am.getArea().getAreaNum());
                                BattleView bv = new BattleView(enemy, am.getCharacter());
                                BattleController bc = new BattleController(bv, bm, av);

                                bv.areaFrameWindowListener(new WindowAdapter() {
                                    @Override
                                    public void windowClosed(WindowEvent e) {
                                        if (bm.hasPlayerDied() == true) {
                                            ToLobby();
                                        } else {
                                            am.getCharacter().setRunes(am.getCharacter().getRunes() + runeDrop);
                                            av.updateLabels("Enemy has been felled.\n" + bm.getEntity().getName() + " has dropped " + runeDrop + " runes.");
                                        }
                                    }
                                });
                            }

                        } else {
                            int runes = new Random().nextInt(150 - 50) + 50;
                            am.getCharacter().setRunes(am.getCharacter().getRunes() + runes);
                            av.updateLabels("A treasure chest has appeared! \n" + "You found " + runes + " runes!");
                        }
                    } else
                        av.updateLabels("You have already been here");
                } else if (am.getCurrTile() instanceof BossTile) {
                    BossTile bt = (BossTile) am.getCurrTile();
                    if (bt.getIsEnabled() == true) {
                        // Begin a bossfight //
                        Boss boss = null;
                        switch (am.getArea().getAreaNum()) {
                            case 1:
                                boss = new GodrickTheGrafted(); break;
                            case 2:
                                boss = new RennalaQueenOfTheFullMoon(); break;
                            case 3:
                                boss = new TheEldenBeast(); break;
                        }
                        runeDrop = boss.dropRunes();

                        av.setVisible(false);
                        BattleModel bm = new BattleModel(am.getCharacter(), boss, am.getArea().getAreaNum());
                        BattleView bv = new BattleView(boss, am.getCharacter());
                        BattleController bc = new BattleController(bv, bm, av);


                        bv.areaFrameWindowListener(new WindowAdapter() {
                            @Override
                            public void windowClosed(WindowEvent e) {
                                if (bm.hasPlayerDied() == true) {
                                    ToLobby();
                                } else {
                                    av.updateLabels("Greater enemy has been felled.\n" + bm.getEntity().getName() + " has dropped " + runeDrop + " runes.");
                                    am.getCharacter().setRunes(am.getCharacter().getRunes() + runeDrop);
                                    am.getCharacter().addAreaClear(am.getArea().getAreaNum());
                                    am.getFloors().SlayedBoss();
                                }
                            }
                        });
                    } else {
                        av.updateLabels("The boss has already been slain.");
                    }
                } else if (am.getCurrTile() instanceof CreditsTile) {
                    CreditsTile ct = (CreditsTile) am.getCurrTile();
                    System.out.println("-- Play the credits --");
                    ct.playCredits();
                    ToLobby();
                } else
                    av.updateLabels("Nothing happened");
                
                av.printArea(av.area);
            }
        });
    }

    /**
     * This method is called to return to the lobby from area.
     * The AreaView is closed through a methd and the visibility
     * of lobby is set to true.
     * The runes label in lobby is also updated here.
     */
    public void ToLobby() {
        av.closeArea();
        lv.setVisible(true);
        lv.updateLabel(3, "RUNES: " + am.getCharacter().getRunes());
    }
}
