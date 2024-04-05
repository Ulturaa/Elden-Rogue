public class LobbyModel {
    private Character character;
    private Inventory inventory;
    private Shop shop;

    /**
     * This is the constructor for the LobbyModel.
     * 
     * @param character     The character object.
     */
    public LobbyModel(Character character) {
        this.character = character;
        this.inventory = new Inventory();
        this.shop = new Shop();
    }

    /**
     * Gets the name of the character.
     * 
     * @return  String name of the character.
     */
    public String getName() {
        return character.getName();
    }

    /**
     * Gets the character's job.
     * 
     * @return  Title of the character's job.
     */
    public String getJob() {
        return character.getJob();
    }

    /**
     * Gets the current level of character.
     * 
     * @return  String level of character.
     */
    public String getLevel() {
        return String.valueOf(character.getLevel());
    }

    /**
     * Gets the ammount of runes the character has.
     * 
     * @return  String number of runes.
     */
    public String getRunes() {
        return String.valueOf(character.getRunes());
    }

    /**
     * Gets the character's inventory.
     * 
     * @return  Inventory of character.
     */
    public Inventory getInventory() {
        return this.inventory;
    }

    /**
     * Gets the character object.
     * 
     * @return  character object.
     */
    public Character getCharacter() {
        return this.character;
    }

    /**
     * Gets the shop.
     * 
     * @return  shop.
     */
    public Shop getShop() {
        return this.shop;
    }
}
