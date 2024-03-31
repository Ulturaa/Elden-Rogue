import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JPanel;

public class InventoryController {
    private InventoryModel im;
    private InventoryView iv;
    private LobbyView lv;
    private int index;
    private String selectedWeapon;
    private boolean pressed;

    public InventoryController(InventoryModel im, InventoryView iv, LobbyView lv) {
        this.im = im;
        this.iv = iv;
        this.lv = lv;

        iv.setILabel("Currently Equipped Weapon: " + im.getWeaponName());

        iv.composeILabels();

        im.addWeapons();

        ArrayList<Weapon> weaponList = im.getWeaponList();
        iv.createFlowLayoutPanel();
        buttonLoop(weaponList);

        iv.composeICButtonlist();
        iv.setVisiblepanel(false);

        iv.setIButton("Select Weapon", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                iv.removeButtons();
                iv.refresh();
                System.out.println("SELECT");
                for (Object item : weaponList) {
                    System.out.println(item);
                }

                System.out.println("smo");
                buttonLoop(weaponList);
                iv.composeICButtonlist();
                iv.setVisiblepanel(true);

                // iv.scrollPane();
                iv.setIButtonvisbility(0, false);
                String weaponLabel = "";

                // iv.setWText(weaponLabel);

                iv.refresh();

            }
        });

        iv.setIButton("BACK", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("BACK TO LOBBY");
                lv.setVisible(true);
                iv.closeFrame();

            }
        });
        iv.composeIButtonlist();
    }

    public void buttonAdder(ArrayList<Weapon> weaponList) {

        Iterator<Weapon> i = weaponList.iterator();

        while (i.hasNext()) {
            iv.setIButton("weapon", new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("SELECT");

                }
            });
        }
    }

    public void buttonLoop(ArrayList<Weapon> weaponList) {
        for (int i = 0; i < weaponList.size(); i++) {
            String weaponName = weaponList.get(i).getName();
            // weaponLabel += weaponList.get(i).getName() + "\n";
            final int index = i;

            iv.setICButton(weaponName, new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    System.out.println("WEAPONS");
                    selectedWeapon = weaponName;

                    System.out.println("WEAPON CLICKED " + weaponName);
                    System.out.println("Index: " + index);
                    if (im.equipWeapon(index)) {
                        System.out.println(weaponList.get(index).getName());
                        for (Object item : weaponList) {
                            System.out.println(item);
                        }
                        iv.updateLabel(0, "Currently Equipped Weapon: " + im.getWeaponName());
                        iv.setIButtonvisbility(0, true);
                        iv.setVisiblepanel(false);
                        // iv.refresh();
                        lv.setVisible(true);

                        // weaponList.clear();
                        iv.closeFrame();

                    }

                }

            });

        }
    }
}
