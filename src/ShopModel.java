public class ShopModel {
    private Character character;
    private Inventory inventory;
    private Shop shop;

    public ShopModel(Character character, Inventory inventory, Shop shop) {
        this.character = character;
        this.inventory = inventory;
        this.shop = shop;
    }

    public Weapon getWeaponOption(int k, int i) {
        return shop.getWeapons(k, i);
    }

    public boolean shopIt(int k, int i) {
        return shop.modifiedShop(k, i, character, inventory);
    }

}
