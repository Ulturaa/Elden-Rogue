import java.util.ArrayList;

public class InventoryModel {
    private Character character;
    private Inventory inventory;

    /**
     * Constructs an InventoryModel with the specified character and inventory.
     * 
     * @param character The character associated with the inventory.
     * @param inventory The inventory containing weapons.
     */
    public InventoryModel(Character character, Inventory inventory) {
        this.character = character;
        this.inventory = inventory;
    }

    /**
     * Retrieves the name of the currently equipped weapon.
     * 
     * @return The name of the currently equipped weapon, or "None" if no weapon is
     *         equipped.
     */
    public String getWeaponName() {
        if (character.getWeapon() == null)
            return "None";
        else
            return character.getWeapon().getName();
    }

    /**
     * Retrieves the list of weapons available in the inventory.
     * 
     * @return The list of weapons available in the inventory.
     */
    public ArrayList<Weapon> getWeaponList() {
        return inventory.getWeaponList();
    }

    // public void addWeapons() {// for debugging
    // inventory.addWeapon();
    // }

    /**
     * Attempts to equip a weapon from the inventory to the character.
     * 
     * @param i The index of the weapon to equip.
     * @return True if the weapon was successfully equipped, false otherwise.
     */

    public boolean equipWeapon(int i) {
        boolean eq = inventory.equip(i, character);
        return eq;
    }

}
