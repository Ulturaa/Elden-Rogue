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

    public String getCharName() {
        return charCreate.getCharName();
    }

    public void setCharacterName() {
        character.setName(charCreate.getCharName());
    }

    public String getCharacterName() {
        return character.getName();
    }

    public void setStats(String jobClass) {
        charCreate.setStats(jobClass, character);
    }

    public void setJobClass(String jobClass) {
        character.setJob(jobClass);
    }

    public String getLevel() {
        return String.valueOf(character.getLevel());
    }

    public String getJobClass() {
        return character.getJob();
    }

    public String getstat(int i) {
        return String.valueOf(character.getStats(i));
    }

    public Character getCharacter() {
        return this.character;
    }
}
