public class LobbyModel {
    private Character character;
    private Inventory inventory;
    private Shop shop;

    public LobbyModel(Character character) {
        this.character = character;
        this.inventory = new Inventory();
        this.shop = new Shop();
    }

    public String getName() {
        return character.getName();
    }

    public String getJob() {
        return character.getJob();
    }

    public String getLevel() {
        return String.valueOf(character.getLevel());
    }

    public String getRunes() {
        return String.valueOf(character.getRunes());
    }

    public Inventory getInventory() {
        return this.inventory;
    }

    public Character getCharacter() {
        return this.character;
    }

    public Shop getShop() {
        return this.shop;
    }
}
