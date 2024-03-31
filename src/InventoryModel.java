import java.util.ArrayList;

public class InventoryModel {
    private Character character;
    private Inventory inventory;

    public InventoryModel(Character character, Inventory inventory) {
        this.character = character;
        this.inventory = inventory;
    }

    public String getWeaponName() {
        if (character.getWeapon() == null)
            return "None";
        else
            return character.getWeapon().getName();
    }

    public ArrayList<Weapon> getWeaponList() {
        return inventory.getWeaponList();
    }

    public void addWeapons() {// for debugging
        inventory.addWeapon();
    }

    public boolean equipWeapon(int i) {
        boolean eq = inventory.equip(i, character);
        return eq;
    }

}
