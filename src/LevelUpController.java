import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class LevelUpController {
    private LevelUpModel lum;
    private LevelUpView luv;
    private LobbyView lv;

    public LevelUpController(LevelUpModel lum, LevelUpView luv, LobbyView lv) {
        this.lum = lum;
        this.luv = luv;
        this.lv = lv;

        luv.setLVLLabel("CURRENT LEVEL: " + lum.getLevel());
        luv.setLVLLabel("RUNES: " + lum.getRunes());
        luv.setLVLLabel("UPGRADE RUNE COST: " + lum.getRuneCost());

        luv.setLVLLabel("LEVEL HEALTH: " + lum.getStat(0));
        luv.setLVLLabel("LEVEL ENDURANCE: " + lum.getStat(1));
        luv.setLVLLabel("LEVEL DEXTERITY: " + lum.getStat(2));
        luv.setLVLLabel("LEVEL STRENGTH: " + lum.getStat(3));
        luv.setLVLLabel("LEVEL INTELLIGENCE: " + lum.getStat(4));
        luv.setLVLLabel("LEVEL FAITH: " + lum.getStat(5));
        luv.composeLVLLabels();
        JLabel succMsg = luv.sysMessage("UPGRADE SUCCESS");
        JLabel failMsg = luv.sysMessage("UPGRADE FAIL");
        JLabel maxReach = luv.sysMessage("MAX LEVEL REACHED");
        JLabel notEnough = luv.sysMessage("NOT ENOUGH RUNES");
        luv.setLVLButton("UPGRADE HP", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("UPGRADING HEALTH");
                if (lum.upgradeStat(1)) {
                    luv.updateLabel(0, "CURRENT LEVEL: " + lum.getLevel());
                    luv.updateLabel(1, "RUNES: " + lum.getRunes());
                    luv.updateLabel(2, "UPGRADE RUNE COST: " + lum.getRuneCost());
                    luv.updateLabel(3, "LEVEL HEALTH: " + lum.getStat(0));
                    luv.setVisibleMsg(succMsg, true);
                    luv.setVisibleMsg(failMsg, false);
                    luv.setVisibleMsg(maxReach, false);
                    luv.setVisibleMsg(notEnough, false);
                } else {
                    luv.setVisibleMsg(succMsg, false);
                    luv.setVisibleMsg(failMsg, true);
                    System.out.println(lum.getStat(0));
                    if (Integer.parseInt(lum.getStat(0)) == 50) {
                        luv.setVisibleMsg(maxReach, true);
                    } else if (Integer.parseInt(lum.getRuneCost()) > Integer.parseInt(lum.getRunes())) {
                        luv.setVisibleMsg(notEnough, true);
                    }
                }

            }
        });

        luv.setLVLButton("UPGRADE END", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("UPGRADING ENDURANCE");
                if (lum.upgradeStat(2)) {
                    luv.updateLabel(0, "CURRENT LEVEL: " + lum.getLevel());
                    luv.updateLabel(1, "RUNES: " + lum.getRunes());
                    luv.updateLabel(2, "UPGRADE RUNE COST: " + lum.getRuneCost());
                    luv.updateLabel(4, "LEVEL ENDURANCE: " + lum.getStat(1));
                    luv.setVisibleMsg(succMsg, true);
                    luv.setVisibleMsg(failMsg, false);
                    luv.setVisibleMsg(maxReach, false);
                    luv.setVisibleMsg(notEnough, false);
                } else {
                    luv.setVisibleMsg(succMsg, false);
                    luv.setVisibleMsg(failMsg, true);
                    System.out.println(lum.getStat(0));
                    if (Integer.parseInt(lum.getStat(1)) == 50) {
                        luv.setVisibleMsg(maxReach, true);
                    } else if (Integer.parseInt(lum.getRuneCost()) > Integer.parseInt(lum.getRunes())) {
                        luv.setVisibleMsg(notEnough, true);
                    }
                }
            }
        });

        luv.setLVLButton("UPGRADE DEX", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("UPGRADING DEXTERITY");
                if (lum.upgradeStat(3)) {
                    luv.updateLabel(0, "CURRENT LEVEL: " + lum.getLevel());
                    luv.updateLabel(1, "RUNES: " + lum.getRunes());
                    luv.updateLabel(2, "UPGRADE RUNE COST: " + lum.getRuneCost());
                    luv.updateLabel(5, "LEVEL DEXTERITY: " + lum.getStat(2));
                    luv.setVisibleMsg(succMsg, true);
                    luv.setVisibleMsg(failMsg, false);
                    luv.setVisibleMsg(maxReach, false);
                    luv.setVisibleMsg(notEnough, false);
                } else {
                    luv.setVisibleMsg(succMsg, false);
                    luv.setVisibleMsg(failMsg, true);
                    System.out.println(lum.getStat(0));
                    if (Integer.parseInt(lum.getStat(2)) == 50) {
                        luv.setVisibleMsg(maxReach, true);
                    } else if (Integer.parseInt(lum.getRuneCost()) > Integer.parseInt(lum.getRunes())) {
                        luv.setVisibleMsg(notEnough, true);
                    }
                }
            }
        });

        luv.setLVLButton("UPGRADE STR", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("UPGRADING STRENGTH");
                if (lum.upgradeStat(4)) {
                    luv.updateLabel(0, "CURRENT LEVEL: " + lum.getLevel());
                    luv.updateLabel(1, "RUNES: " + lum.getRunes());
                    luv.updateLabel(2, "UPGRADE RUNE COST: " + lum.getRuneCost());
                    luv.updateLabel(6, "LEVEL STRENGTH: " + lum.getStat(3));
                    luv.setVisibleMsg(succMsg, true);
                    luv.setVisibleMsg(failMsg, false);
                    luv.setVisibleMsg(maxReach, false);
                    luv.setVisibleMsg(notEnough, false);
                } else {
                    luv.setVisibleMsg(succMsg, false);
                    luv.setVisibleMsg(failMsg, true);
                    System.out.println(lum.getStat(0));
                    if (Integer.parseInt(lum.getStat(3)) == 50) {
                        luv.setVisibleMsg(maxReach, true);
                    } else if (Integer.parseInt(lum.getRuneCost()) > Integer.parseInt(lum.getRunes())) {
                        luv.setVisibleMsg(notEnough, true);
                    }
                }
            }
        });

        luv.setLVLButton("UPGRADE INT", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("UPGRADING INTELLIGENCE");
                if (lum.upgradeStat(5)) {
                    luv.updateLabel(0, "CURRENT LEVEL: " + lum.getLevel());
                    luv.updateLabel(1, "RUNES: " + lum.getRunes());
                    luv.updateLabel(2, "UPGRADE RUNE COST: " + lum.getRuneCost());
                    luv.updateLabel(7, "LEVEL INTELLIGENCE: " + lum.getStat(4));
                    luv.setVisibleMsg(succMsg, true);
                    luv.setVisibleMsg(failMsg, false);
                    luv.setVisibleMsg(maxReach, false);
                    luv.setVisibleMsg(notEnough, false);
                } else {
                    luv.setVisibleMsg(succMsg, false);
                    luv.setVisibleMsg(failMsg, true);
                    System.out.println(lum.getStat(0));
                    if (Integer.parseInt(lum.getStat(4)) == 50) {
                        luv.setVisibleMsg(maxReach, true);
                    } else if (Integer.parseInt(lum.getRuneCost()) > Integer.parseInt(lum.getRunes())) {
                        luv.setVisibleMsg(notEnough, true);
                    }
                }
            }
        });

        luv.setLVLButton("UPGRADE FTH", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("UPGRADING FAITH");
                if (lum.upgradeStat(6)) {
                    luv.updateLabel(0, "CURRENT LEVEL: " + lum.getLevel());
                    luv.updateLabel(1, "RUNES: " + lum.getRunes());
                    luv.updateLabel(2, "UPGRADE RUNE COST: " + lum.getRuneCost());
                    luv.updateLabel(8, "LEVEL FAITH: " + lum.getStat(5));
                    luv.setVisibleMsg(succMsg, true);
                    luv.setVisibleMsg(failMsg, false);
                    luv.setVisibleMsg(maxReach, false);
                    luv.setVisibleMsg(notEnough, false);
                } else {
                    luv.setVisibleMsg(succMsg, false);
                    luv.setVisibleMsg(failMsg, true);
                    System.out.println(lum.getStat(0));
                    if (Integer.parseInt(lum.getStat(5)) == 50) {
                        luv.setVisibleMsg(maxReach, true);
                    } else if (Integer.parseInt(lum.getRuneCost()) > Integer.parseInt(lum.getRunes())) {
                        luv.setVisibleMsg(notEnough, true);
                    }
                }
            }
        });

        luv.setLVLButton("BACK", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("BACK TO LOBBY ");
                lv.setVisible(true);
                lv.updateLabel(0, "NAME: " + lum.getName());
                lv.updateLabel(1, "JOB CLASS: " + lum.getJob());
                lv.updateLabel(2, "LEVEL: " + lum.getLevel());
                lv.updateLabel(3, "RUNES: " + lum.getRunes());
                luv.closeFrame();
            }
        });

        // luv.compose();

        luv.composeLVLButtonlist();
    }

}
