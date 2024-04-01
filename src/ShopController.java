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

    public ShopController(ShopModel sm, ShopView sv, LobbyView lv) {
        this.sm = sm;
        this.sv = sv;
        this.lv = lv;

        sv.setWPanel();// panel 1
        sv.setSwordScroll();
        sv.addScrolltoPanel(0, 1);
        sv.setVisibleSwordScroll(0, false);
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
                sv.setVisibleSwordScroll(0, true);

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
