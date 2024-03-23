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
        this.equippedWeapon = null;
    }

    // public void addWeapon(/* Weapon weapon */) {// for debugging
    // Weapon weapon1 = new Weapon("Sword", 3000);
    // Weapon weapon2 = new Weapon("Katana", 3000);
    // Weapon weapon3 = new Weapon("Whip", 3000);
    // this.weaponList.add(weapon1);
    // this.weaponList.add(weapon2);
    // this.weaponList.add(weapon3);
    // }

    public void addWeapon(Weapon weapon) {
        this.weaponList.add(weapon);
    }

    public void equipWeapon(int i, Character character) {
        if (this.equippedWeapon == null) {
            if (character.getStats(2) >= this.weaponList.get(i).getWeaponStat(2)) {
                this.equippedWeapon = this.weaponList.get(i);
                System.out.println(this.equippedWeapon.getName());
                character.setWeapon(this.equippedWeapon);
                this.weaponList.remove(i);
                System.out.println("EQUIPPED WEAPON: " + character.getWeapon().getName());
            } else
                System.out.println("DEXTERITY IS TOO LOW EQUIP A DIFFERENT WEAPON");
        } else {
            if (character.getStats(2) >= this.weaponList.get(i).getWeaponStat(2)) {
                Weapon weaponHolder;

                weaponHolder = this.equippedWeapon;
                this.equippedWeapon = this.weaponList.get(i);
                character.setWeapon(this.equippedWeapon);
                this.weaponList.remove(i);
                addWeapon(weaponHolder);
                System.out.println("EQUIPPED WEAPON: " + character.getWeapon().getName());
            } else
                System.out.println("DEXTERITY IS TOO LOW EQUIP A DIFFERENT WEAPON");

        }

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

                    break;
                case 2:
                    break;
                default:
                    break;
            }

        } while (iChoice > 2 || iChoice < 1);

    }

    public void selectWeapon(Character character) {
        if (this.equippedWeapon != null) {
            System.out.println("CURRENTLY EQUIPPED WEAPON: " + this.equippedWeapon.getName());
            // System.out.println("CURRENTLY EQUIPPED WEAPON: " +
            // character.getWeapon().getName());
        } else {
            System.out.println("CURRENTLY EQUIPPED WEAPON: NONE");
        }
        for (int i = 0; i < this.weaponList.size(); i++) {
            System.out.println("[" + (i + 1) + "]" + this.weaponList.get(i).getName());
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
        if (this.weaponList.size() != 0) {
            System.out.print("Select your weapon: ");
            wChoice = wc.nextInt();
            equipWeapon(wChoice - 1, character);
        }

    }
}
