public class CharCreateModel {
    private Character character;
    private CharCreate charCreate;

    public CharCreateModel(Character character, CharCreate charCreate) {
        this.character = character;
        this.charCreate = charCreate;
    }

    public void setName(String name) {
        charCreate.setCharName(name);
    }
}
