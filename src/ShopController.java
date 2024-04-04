import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ShopController {
    private ShopModel sm;
    private ShopView sv;
    private LobbyView lv;

    /**
     * Constructs the ShopController class
     * 
     * @param sm is the model
     * @param sv is the view
     * @param lv is the lobby view
     */
    public ShopController(ShopModel sm, ShopView sv, LobbyView lv) {
        this.sm = sm;
        this.sv = sv;
        this.lv = lv;

        sv.setWPanel();// panel 0
        sv.setScroll();// scroll 0 start here
        sv.setScroll();// 1
        sv.setScroll();// 2
        sv.setScroll();// 3
        sv.setScroll();// 4
        sv.setScroll();// 5
        String swordText = "";

        for (int i = 1; i <= 4; i++) {

            swordText += "RUNE COST: " + sm.getWeaponOption(1, i).getRuneCost() + "\n" + "WEAPON NAME: "
                    + sm.getWeaponOption(1, i).getName()
                    + "\n" + "DEX REQUIREMENT: " + sm.getWeaponOption(1, i).getWeaponStat(2) + "\n"
                    + "HP: " + sm.getWeaponOption(1, i).getWeaponStat(0)
                    + "\n" + "END: " + sm.getWeaponOption(1, i).getWeaponStat(1) + "\n" + "STR: "
                    + sm.getWeaponOption(1, i).getWeaponStat(3) + "\n"
                    + "INT: " + sm.getWeaponOption(1, i).getWeaponStat(4)
                    + "\n" + "FTH: " + sm.getWeaponOption(1, i).getWeaponStat(5) + "\n\n";

        }
        sv.setWeaponImage("Weapons/ShortSword.png", sm.getWeaponOption(1, 1).getName());
        sv.setWeaponImage("Weapons/RogerRapier.png", sm.getWeaponOption(1, 2).getName());
        sv.setWeaponImage("Weapons/CodedSword.png", sm.getWeaponOption(1, 3).getName());
        sv.setWeaponImage("Weapons/SwordofNightandFlame.png", sm.getWeaponOption(1, 4).getName());

        sv.addImagetoPanel(0, 0);
        sv.addImagetoPanel(0, 1);
        sv.addImagetoPanel(0, 2);
        sv.addImagetoPanel(0, 3);
        sv.setWText(swordText);// text 0
        sv.addTexttoScroll(0, 0);
        sv.addScrolltoPanel(0, 0);
        sv.setVisibleScroll(0, false);// scroll 0 end here

        // scroll 1 start here

        sv.setSwordButton(sm.getWeaponOption(1, 1).getName(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sm.shopIt(1, 1)) {
                    System.out.println("Weapon purchased");
                    sv.setVisibleLabel(0, true);

                } else {
                    sv.setVisibleLabel(1, true);
                }

            }
        });

        sv.setSwordButton(sm.getWeaponOption(1, 2).getName(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sm.shopIt(1, 2)) {
                    System.out.println("Weapon purchased");
                    sv.setVisibleLabel(0, true);

                } else {
                    sv.setVisibleLabel(1, true);
                }
            }
        });

        sv.setSwordButton(sm.getWeaponOption(1, 3).getName(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sm.shopIt(1, 3)) {
                    System.out.println("Weapon purchased");
                    sv.setVisibleLabel(0, true);

                } else {
                    sv.setVisibleLabel(1, true);
                }
            }
        });

        sv.setSwordButton(sm.getWeaponOption(1, 4).getName(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sm.shopIt(1, 4)) {
                    System.out.println("Weapon purchased");
                    sv.setVisibleLabel(0, true);

                } else {
                    sv.setVisibleLabel(1, true);
                }
            }
        });

        sv.setSwordButton("BACK", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("sword screen");
                sv.setPanelVisible(0, false);
                sv.setSButtonvisbility(0, true);
                sv.setSButtonvisbility(1, true);
                sv.setSButtonvisbility(2, true);
                sv.setSButtonvisbility(3, true);
                sv.setSButtonvisbility(4, true);
                sv.setSButtonvisbility(5, true);
                sv.setSButtonvisbility(6, true);
                sv.setVisibleLabel(0, false);
            }
        });

        sv.addtoPanel(0, 1);
        sv.setWPanel();// panel 1

        // scroll 1 start here
        String katanaText = "";
        for (int i = 1; i <= 4; i++) {

            katanaText += "RUNE COST: " + sm.getWeaponOption(2, i).getRuneCost() + "\n" + "WEAPON NAME: "
                    + sm.getWeaponOption(2, i).getName()
                    + "\n" + "DEX REQUIREMENT: " + sm.getWeaponOption(2, i).getWeaponStat(2) + "\n"
                    + "HP: " + sm.getWeaponOption(2, i).getWeaponStat(0)
                    + "\n" + "END: " + sm.getWeaponOption(2, i).getWeaponStat(1) + "\n" + "STR: "
                    + sm.getWeaponOption(2, i).getWeaponStat(3) + "\n"
                    + "INT: " + sm.getWeaponOption(2, i).getWeaponStat(4)
                    + "\n" + "FTH: " + sm.getWeaponOption(2, i).getWeaponStat(5) + "\n\n";

        }

        sv.setWeaponImage("Weapons/Uchigatana.png", sm.getWeaponOption(2, 1).getName());
        sv.setWeaponImage("Weapons/Moonveil.png", sm.getWeaponOption(2, 2).getName());
        sv.setWeaponImage("Weapons/RiversofBlood.png", sm.getWeaponOption(2, 3).getName());
        sv.setWeaponImage("Weapons/HandofMalenia.png", sm.getWeaponOption(2, 4).getName());

        sv.addImagetoPanel(1, 4);
        sv.addImagetoPanel(1, 5);
        sv.addImagetoPanel(1, 6);
        sv.addImagetoPanel(1, 7);
        sv.setWText(katanaText);// text 1
        sv.addTexttoScroll(1, 1);
        sv.addScrolltoPanel(1, 1);
        sv.setVisibleScroll(1, false);// scroll 1 end here

        sv.setKatanaButton(sm.getWeaponOption(2, 1).getName(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sm.shopIt(2, 1)) {
                    System.out.println("Weapon purchased");
                    sv.setVisibleLabel(0, true);

                } else {
                    sv.setVisibleLabel(1, true);
                }

            }
        });

        sv.setKatanaButton(sm.getWeaponOption(2, 2).getName(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sm.shopIt(2, 2)) {
                    System.out.println("Weapon purchased");
                    sv.setVisibleLabel(0, true);

                } else {
                    sv.setVisibleLabel(1, true);
                }

            }
        });

        sv.setKatanaButton(sm.getWeaponOption(2, 3).getName(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sm.shopIt(2, 3)) {
                    System.out.println("Weapon purchased");
                    sv.setVisibleLabel(0, true);

                } else {
                    sv.setVisibleLabel(1, true);
                }

            }
        });

        sv.setKatanaButton(sm.getWeaponOption(2, 4).getName(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sm.shopIt(2, 4)) {
                    System.out.println("Weapon purchased");
                    sv.setVisibleLabel(0, true);

                } else {
                    sv.setVisibleLabel(1, true);
                }

            }
        });

        sv.setKatanaButton("BACK", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("sword screen");
                sv.setPanelVisible(1, false);
                sv.setSButtonvisbility(0, true);
                sv.setSButtonvisbility(1, true);
                sv.setSButtonvisbility(2, true);
                sv.setSButtonvisbility(3, true);
                sv.setSButtonvisbility(4, true);
                sv.setSButtonvisbility(5, true);
                sv.setSButtonvisbility(6, true);
                sv.setVisibleLabel(0, false);
            }
        });
        sv.addtoPanel(1, 2);
        sv.setWPanel();// panel 2

        // scroll 2 start here
        String whipText = "";
        for (int i = 1; i <= 4; i++) {

            whipText += "RUNE COST: " + sm.getWeaponOption(3, i).getRuneCost() + "\n" + "WEAPON NAME: "
                    + sm.getWeaponOption(3, i).getName()
                    + "\n" + "DEX REQUIREMENT: " + sm.getWeaponOption(3, i).getWeaponStat(2) + "\n"
                    + "HP: " + sm.getWeaponOption(3, i).getWeaponStat(0)
                    + "\n" + "END: " + sm.getWeaponOption(3, i).getWeaponStat(1) + "\n" + "STR: "
                    + sm.getWeaponOption(3, i).getWeaponStat(3) + "\n"
                    + "INT: " + sm.getWeaponOption(3, i).getWeaponStat(4)
                    + "\n" + "FTH: " + sm.getWeaponOption(3, i).getWeaponStat(5) + "\n\n";

        }

        sv.setWeaponImage("Weapons/Whip.png", sm.getWeaponOption(3, 1).getName());
        sv.setWeaponImage("Weapons/Urumi.png", sm.getWeaponOption(3, 2).getName());
        sv.setWeaponImage("Weapons/ThornedWhip.png", sm.getWeaponOption(3, 3).getName());
        sv.setWeaponImage("Weapons/Hoslow'sPetalWhip.png", sm.getWeaponOption(3, 4).getName());

        sv.addImagetoPanel(2, 8);
        sv.addImagetoPanel(2, 9);
        sv.addImagetoPanel(2, 10);
        sv.addImagetoPanel(2, 11);
        sv.setWText(whipText);// text 2
        sv.addTexttoScroll(2, 2);
        sv.addScrolltoPanel(2, 2);
        sv.setVisibleScroll(2, false);// scroll 2 end here

        sv.setWhipButton(sm.getWeaponOption(3, 1).getName(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sm.shopIt(3, 1)) {
                    System.out.println("Weapon purchased");
                    sv.setVisibleLabel(0, true);

                } else {
                    sv.setVisibleLabel(1, true);
                }
            }
        });

        sv.setWhipButton(sm.getWeaponOption(3, 2).getName(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sm.shopIt(3, 2)) {
                    System.out.println("Weapon purchased");
                    sv.setVisibleLabel(0, true);

                } else {
                    sv.setVisibleLabel(1, true);
                }

            }
        });

        sv.setWhipButton(sm.getWeaponOption(3, 3).getName(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sm.shopIt(3, 3)) {
                    System.out.println("Weapon purchased");
                    sv.setVisibleLabel(0, true);

                } else {
                    sv.setVisibleLabel(1, true);
                }

            }
        });

        sv.setWhipButton(sm.getWeaponOption(3, 4).getName(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sm.shopIt(3, 4)) {
                    System.out.println("Weapon purchased");
                    sv.setVisibleLabel(0, true);

                } else {
                    sv.setVisibleLabel(1, true);
                }

            }
        });

        sv.setWhipButton("BACK", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("sword screen");
                sv.setPanelVisible(2, false);
                sv.setSButtonvisbility(0, true);
                sv.setSButtonvisbility(1, true);
                sv.setSButtonvisbility(2, true);
                sv.setSButtonvisbility(3, true);
                sv.setSButtonvisbility(4, true);
                sv.setSButtonvisbility(5, true);
                sv.setSButtonvisbility(6, true);
                sv.setVisibleLabel(0, false);
            }
        });
        sv.addtoPanel(2, 3);
        sv.setWPanel();// panel 3

        // scroll 3 start here
        String greatSwordText = "";
        for (int i = 1; i <= 4; i++) {

            greatSwordText += "RUNE COST: " + sm.getWeaponOption(4, i).getRuneCost() + "\n" + "WEAPON NAME: "
                    + sm.getWeaponOption(4, i).getName()
                    + "\n" + "DEX REQUIREMENT: " + sm.getWeaponOption(4, i).getWeaponStat(2) + "\n"
                    + "HP: " + sm.getWeaponOption(4, i).getWeaponStat(0)
                    + "\n" + "END: " + sm.getWeaponOption(4, i).getWeaponStat(1) + "\n" + "STR: "
                    + sm.getWeaponOption(4, i).getWeaponStat(3) + "\n"
                    + "INT: " + sm.getWeaponOption(4, i).getWeaponStat(4)
                    + "\n" + "FTH: " + sm.getWeaponOption(4, i).getWeaponStat(5) + "\n\n";

        }

        sv.setWeaponImage("Weapons/Claymore.png", sm.getWeaponOption(4, 1).getName());
        sv.setWeaponImage("Weapons/StarscourgeGreatsword.png", sm.getWeaponOption(4, 2).getName());
        sv.setWeaponImage("Weapons/InseperableSword.png", sm.getWeaponOption(4, 3).getName());
        sv.setWeaponImage("Weapons/MalekithBlackBlade.png", sm.getWeaponOption(4, 4).getName());

        sv.addImagetoPanel(3, 12);
        sv.addImagetoPanel(3, 13);
        sv.addImagetoPanel(3, 14);
        sv.addImagetoPanel(3, 15);
        sv.setWText(greatSwordText);// text 3
        sv.addTexttoScroll(3, 3);
        sv.addScrolltoPanel(3, 3);
        sv.setVisibleScroll(3, false);// scroll 3 end here

        sv.setGreatSwordButton(sm.getWeaponOption(4, 1).getName(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sm.shopIt(4, 1)) {
                    System.out.println("Weapon purchased");
                    sv.setVisibleLabel(0, true);

                } else {
                    sv.setVisibleLabel(1, true);
                }

            }
        });

        sv.setGreatSwordButton(sm.getWeaponOption(4, 2).getName(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sm.shopIt(4, 2)) {
                    System.out.println("Weapon purchased");
                    sv.setVisibleLabel(0, true);

                } else {
                    sv.setVisibleLabel(1, true);
                }

            }
        });

        sv.setGreatSwordButton(sm.getWeaponOption(4, 3).getName(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sm.shopIt(4, 3)) {
                    System.out.println("Weapon purchased");
                    sv.setVisibleLabel(0, true);

                } else {
                    sv.setVisibleLabel(1, true);
                }

            }
        });

        sv.setGreatSwordButton(sm.getWeaponOption(4, 4).getName(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sm.shopIt(4, 4)) {
                    System.out.println("Weapon purchased");
                    sv.setVisibleLabel(0, true);

                } else {
                    sv.setVisibleLabel(1, true);
                }

            }
        });

        sv.setGreatSwordButton("BACK", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("sword screen");
                sv.setPanelVisible(3, false);
                sv.setSButtonvisbility(0, true);
                sv.setSButtonvisbility(1, true);
                sv.setSButtonvisbility(2, true);
                sv.setSButtonvisbility(3, true);
                sv.setSButtonvisbility(4, true);
                sv.setSButtonvisbility(5, true);
                sv.setSButtonvisbility(6, true);
                sv.setVisibleLabel(0, false);
            }
        });

        sv.addtoPanel(3, 4);
        sv.setWPanel();// panel 4

        // scroll 4 start here
        String staffText = "";
        for (int i = 1; i <= 4; i++) {

            staffText += "RUNE COST: " + sm.getWeaponOption(5, i).getRuneCost() + "\n" + "WEAPON NAME: "
                    + sm.getWeaponOption(5, i).getName()
                    + "\n" + "DEX REQUIREMENT: " + sm.getWeaponOption(5, i).getWeaponStat(2) + "\n"
                    + "HP: " + sm.getWeaponOption(5, i).getWeaponStat(0)
                    + "\n" + "END: " + sm.getWeaponOption(5, i).getWeaponStat(1) + "\n" + "STR: "
                    + sm.getWeaponOption(5, i).getWeaponStat(3) + "\n"
                    + "INT: " + sm.getWeaponOption(5, i).getWeaponStat(4)
                    + "\n" + "FTH: " + sm.getWeaponOption(5, i).getWeaponStat(5) + "\n\n";

        }
        sv.setWeaponImage("Weapons/AstrologerStaff.png", sm.getWeaponOption(5, 1).getName());
        sv.setWeaponImage("Weapons/AlbinauricStaff.png", sm.getWeaponOption(5, 2).getName());
        sv.setWeaponImage("Weapons/StaffoftheGuilty.png", sm.getWeaponOption(5, 3).getName());
        sv.setWeaponImage("Weapons/CarianRegalScepter.png", sm.getWeaponOption(5, 4).getName());

        sv.addImagetoPanel(4, 16);
        sv.addImagetoPanel(4, 17);
        sv.addImagetoPanel(4, 18);
        sv.addImagetoPanel(4, 19);
        sv.setWText(staffText);// text 4
        sv.addTexttoScroll(4, 4);
        sv.addScrolltoPanel(4, 4);
        sv.setVisibleScroll(4, false);// scroll 4 end here
        sv.setStaffButton(sm.getWeaponOption(5, 1).getName(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sm.shopIt(5, 1)) {
                    System.out.println("Weapon purchased");
                    sv.setVisibleLabel(0, true);

                } else {
                    sv.setVisibleLabel(1, true);
                }

            }
        });
        sv.setStaffButton(sm.getWeaponOption(5, 2).getName(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sm.shopIt(5, 2)) {
                    System.out.println("Weapon purchased");
                    sv.setVisibleLabel(0, true);

                } else {
                    sv.setVisibleLabel(1, true);
                }

            }
        });

        sv.setStaffButton(sm.getWeaponOption(5, 3).getName(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sm.shopIt(5, 3)) {
                    System.out.println("Weapon purchased");
                    sv.setVisibleLabel(0, true);

                } else {
                    sv.setVisibleLabel(1, true);
                }

            }
        });

        sv.setStaffButton(sm.getWeaponOption(5, 4).getName(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sm.shopIt(5, 4)) {
                    System.out.println("Weapon purchased");
                    sv.setVisibleLabel(0, true);

                } else {
                    sv.setVisibleLabel(1, true);
                }

            }
        });

        sv.setStaffButton("BACK", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("sword screen");
                sv.setPanelVisible(4, false);
                sv.setSButtonvisbility(0, true);
                sv.setSButtonvisbility(1, true);
                sv.setSButtonvisbility(2, true);
                sv.setSButtonvisbility(3, true);
                sv.setSButtonvisbility(4, true);
                sv.setSButtonvisbility(5, true);
                sv.setSButtonvisbility(6, true);
                sv.setVisibleLabel(0, false);
            }
        });

        sv.addtoPanel(4, 5);
        sv.setWPanel();// panel 5

        // scroll 5 start here
        String sealText = "";
        for (int i = 1; i <= 4; i++) {

            sealText += "RUNE COST: " + sm.getWeaponOption(6, i).getRuneCost() + "\n" + "WEAPON NAME: "
                    + sm.getWeaponOption(6, i).getName()
                    + "\n" + "DEX REQUIREMENT: " + sm.getWeaponOption(5, i).getWeaponStat(2) + "\n"
                    + "HP: " + sm.getWeaponOption(6, i).getWeaponStat(0)
                    + "\n" + "END: " + sm.getWeaponOption(6, i).getWeaponStat(1) + "\n" + "STR: "
                    + sm.getWeaponOption(6, i).getWeaponStat(3) + "\n"
                    + "INT: " + sm.getWeaponOption(6, i).getWeaponStat(4)
                    + "\n" + "FTH: " + sm.getWeaponOption(6, i).getWeaponStat(5) + "\n\n";

        }

        sv.setWeaponImage("Weapons/FingerSeal.png", sm.getWeaponOption(6, 1).getName());
        sv.setWeaponImage("Weapons/GodSlayerSeal.png", sm.getWeaponOption(6, 2).getName());
        sv.setWeaponImage("Weapons/GoldenOrderSeal.png", sm.getWeaponOption(6, 3).getName());
        sv.setWeaponImage("Weapons/DragonCommunionSeal.png", sm.getWeaponOption(6, 4).getName());

        sv.addImagetoPanel(5, 20);
        sv.addImagetoPanel(5, 21);
        sv.addImagetoPanel(5, 22);
        sv.addImagetoPanel(5, 23);
        sv.setWText(sealText);// text 5
        sv.addTexttoScroll(5, 5);
        sv.addScrolltoPanel(5, 5);
        sv.setVisibleScroll(5, false);// scroll 5 end here

        sv.setSealButton(sm.getWeaponOption(6, 1).getName(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sm.shopIt(6, 1)) {
                    System.out.println("Weapon purchased");
                    sv.setVisibleLabel(0, true);

                } else {
                    sv.setVisibleLabel(1, true);
                }

            }
        });

        sv.setSealButton(sm.getWeaponOption(6, 2).getName(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sm.shopIt(6, 2)) {
                    System.out.println("Weapon purchased");
                    sv.setVisibleLabel(0, true);

                } else {
                    sv.setVisibleLabel(1, true);
                }

            }
        });

        sv.setSealButton(sm.getWeaponOption(6, 3).getName(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sm.shopIt(6, 3)) {
                    System.out.println("Weapon purchased");
                    sv.setVisibleLabel(0, true);

                } else {
                    sv.setVisibleLabel(1, true);
                }
                ;

            }
        });

        sv.setSealButton(sm.getWeaponOption(6, 4).getName(), new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (sm.shopIt(6, 4)) {
                    System.out.println("Weapon purchased");
                    sv.setVisibleLabel(0, true);

                } else {
                    sv.setVisibleLabel(1, true);
                }

            }
        });

        sv.setSealButton("BACK", new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("sword screen");
                sv.setPanelVisible(5, false);
                sv.setSButtonvisbility(0, true);
                sv.setSButtonvisbility(1, true);
                sv.setSButtonvisbility(2, true);
                sv.setSButtonvisbility(3, true);
                sv.setSButtonvisbility(4, true);
                sv.setSButtonvisbility(5, true);
                sv.setSButtonvisbility(6, true);
                sv.setVisibleLabel(0, false);
            }
        });
        sv.addtoPanel(5, 6);

        sv.setSLabel("Weapon Successfully Purchased! added to Inventory.");// label 0
        sv.setSLabel("NOT ENOUGH RUNES!");// label 1

        sv.composeSLabels();
        sv.setVisibleLabel(0, false);
        sv.setVisibleLabel(1, false);
        sv.composeWPanellist();

        // MAIN SHOP BUTTONS
        sv.setSButton("SWORDS", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("SWORDS");
                sv.setPanelVisible(0, true);
                sv.setSButtonvisbility(0, false);
                sv.setSButtonvisbility(1, false);
                sv.setSButtonvisbility(2, false);
                sv.setSButtonvisbility(3, false);
                sv.setSButtonvisbility(4, false);
                sv.setSButtonvisbility(5, false);
                sv.setSButtonvisbility(6, false);
                sv.setVisibleScroll(0, true);

            }
        });

        sv.setSButton("KATANAS", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("KATANAS");

                sv.setPanelVisible(1, true);
                sv.setSButtonvisbility(0, false);
                sv.setSButtonvisbility(1, false);
                sv.setSButtonvisbility(2, false);
                sv.setSButtonvisbility(3, false);
                sv.setSButtonvisbility(4, false);
                sv.setSButtonvisbility(5, false);
                sv.setSButtonvisbility(6, false);
                sv.setVisibleScroll(1, true);
            }
        });

        sv.setSButton("WHIPS", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("WHIPS");
                sv.setPanelVisible(2, true);
                sv.setSButtonvisbility(0, false);
                sv.setSButtonvisbility(1, false);
                sv.setSButtonvisbility(2, false);
                sv.setSButtonvisbility(3, false);
                sv.setSButtonvisbility(4, false);
                sv.setSButtonvisbility(5, false);
                sv.setSButtonvisbility(6, false);
                sv.setVisibleScroll(2, true);
            }
        });

        sv.setSButton("GREATSWORDS", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("GREATSWORDS");
                sv.setPanelVisible(3, true);
                sv.setSButtonvisbility(0, false);
                sv.setSButtonvisbility(1, false);
                sv.setSButtonvisbility(2, false);
                sv.setSButtonvisbility(3, false);
                sv.setSButtonvisbility(4, false);
                sv.setSButtonvisbility(5, false);
                sv.setSButtonvisbility(6, false);
                sv.setVisibleScroll(3, true);
            }
        });

        sv.setSButton("STAVES", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("STAVES");
                sv.setPanelVisible(4, true);
                sv.setSButtonvisbility(0, false);
                sv.setSButtonvisbility(1, false);
                sv.setSButtonvisbility(2, false);
                sv.setSButtonvisbility(3, false);
                sv.setSButtonvisbility(4, false);
                sv.setSButtonvisbility(5, false);
                sv.setSButtonvisbility(6, false);
                sv.setVisibleScroll(4, true);
            }
        });

        sv.setSButton("SEALS", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("SEALS");
                sv.setPanelVisible(5, true);
                sv.setSButtonvisbility(0, false);
                sv.setSButtonvisbility(1, false);
                sv.setSButtonvisbility(2, false);
                sv.setSButtonvisbility(3, false);
                sv.setSButtonvisbility(4, false);
                sv.setSButtonvisbility(5, false);
                sv.setSButtonvisbility(6, false);
                sv.setVisibleScroll(5, true);
            }
        });

        sv.setSButton("EXIT SHOP", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("exiting shop");
                lv.setVisible(true);
                sv.setVisible(false);
            }
        });

        sv.composeSButtonlist();
        // sv.composeWFramelist();
    }
}
