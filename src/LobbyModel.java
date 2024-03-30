public class LobbyModel {
    private Character character;

    public LobbyModel(Character character) {
        this.character = character;
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
}
