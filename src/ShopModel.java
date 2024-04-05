public class ShopModel {
    private Character character;
    private Inventory inventory;
    private Shop shop;

    /**
     * Constructs a ShopModel with the given character, inventory, and shop.
     *
     * @param character The character interacting with the shop
     * @param inventory The inventory associated with the character
     * @param shop      The shop containing available weapons
     */
    public ShopModel(Character character, Inventory inventory, Shop shop) {
        this.character = character;
        this.inventory = inventory;
        this.shop = shop;
    }

    /**
     * Retrieves the weapon option based on the specified category and index.
     *
     * @param k The category of the weapon (e.g., sword, katana, whip)
     * @param i    The index of the weapon option within the specified category
     * @return The weapon option corresponding to the specified category and index
     */
    public Weapon getWeaponOption(int k, int i) {
        return shop.getWeapons(k, i);
    }

    /**
     * Attempts to make a purchase from the shop.
     *
     * @param k The category of the weapon to purchase
     * @param i    The index of the weapon option within the specified category
     * @return True if the purchase was successful, false otherwise
     */
    public boolean shopIt(int k, int i) {
        return shop.modifiedShop(k, i, character, inventory);
    }

}
