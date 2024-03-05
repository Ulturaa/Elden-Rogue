import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    private Character character;
    private Weapon weapon;
    private ArrayList<Weapon> weaponList = new ArrayList<>();
    private Weapon equippedWeapon;

    Scanner ic = new Scanner(System.in);
    Scanner wc = new Scanner(System.in);
    private int iChoice;
    private int wChoice;

    public Inventory() {

    }

    public void addWeapon(/* Weapon weapon */) {
        weapon = new Weapon("Sword", 3000);
        this.weaponList.add(weapon);
    }

    public void equipWeapon(int i, Character character) {
        if (character.getStats(2) >= this.weaponList.get(i).getWeaponStat(2)) {
            this.equippedWeapon = this.weaponList.get(i);
            character.setWeapon(this.equippedWeapon);
        } else
            System.out.println("DEXTERITY IS TOO LOW EQUIP A DIFFERENT WEAPON");
    }

    public Weapon getEquippedWeapon(int i) {
        return this.equippedWeapon;
    }

    public void inventoryScreen(Character character) {
        do {
            System.out.println("\nINVENTORY\n");
            System.out.println("[1]SELECT WEAPON");
            System.out.println("[2]BACK");
            iChoice = ic.nextInt();

            switch (iChoice) {
                case 1:
                    selectWeapon(character);
                    addWeapon();
                    break;
                case 2:
                    break;
                default:
                    break;
            }

        } while (iChoice > 2 || iChoice < 1);

    }

    public void selectWeapon(Character character) {
        for (int i = 0; i < this.weaponList.size(); i++) {
            System.out.println("[" + i + "]" + this.weaponList.get(i).getName());
            System.out.println("WEAPON DEXTERITY:    " + this.weaponList.get(i).getWeaponStat(2));
            System.out.println("WEAPON HEALTH:       " + this.weaponList.get(i).getWeaponStat(0));
            System.out.println("WEAPON ENDURANCE:    " + this.weaponList.get(i).getWeaponStat(1));
            System.out.println("WEAPON STRENGTH:     " + this.weaponList.get(i).getWeaponStat(3));
            System.out.println("WEAPON INTELLIGENCE: " + this.weaponList.get(i).getWeaponStat(4));
            System.out.println("WEAPON FAITH:        " + this.weaponList.get(i).getWeaponStat(5));
        }
        if (this.weaponList.size() == 0) {
            System.out.println("No weapons, Please purchase a weapon.");
        }
        wChoice = wc.nextInt();
        equipWeapon(wChoice, character);
    }
}
