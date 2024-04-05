public class CharCreateModel {
    private Character character;
    private CharCreate charCreate;

    /**
     * This is the constructor for the CharCreateModel class
     *
     * @param character  is the character object
     * @param charCreate is the charCreate object used for creating the character
     * 
     */
    public CharCreateModel(Character character, CharCreate charCreate) {
        this.character = character;
        this.charCreate = charCreate;
    }

    /**
     * This function sets the name of the character
     */
    public void setName(String name) {
        charCreate.setCharName(name);
    }

    /**
     * Getter for the created name
     * 
     * @return the value returned by the Charcreate function
     */
    public String getCharName() {
        return charCreate.getCharName();
    }

    /**
     * Setter for the name of the actual character object
     * 
     */
    public void setCharacterName() {
        character.setName(charCreate.getCharName());
    }

    /**
     * Getter fore the character's name
     * 
     * @return the character's name
     */
    public String getCharacterName() {
        return character.getName();
    }

    /**
     * Setter for the character's statistics
     * Takes the jobclass and character object
     */
    public void setStats(String jobClass) {
        charCreate.setStats(jobClass, character);
    }

    /**
     * Setter for the character's job class
     * 
     */
    public void setJobClass(String jobClass) {
        character.setJob(jobClass);
    }

    /**
     * Getter for the character's level
     * 
     * @return level of character
     */
    public String getLevel() {
        return String.valueOf(character.getLevel());
    }

    /**
     * Getter of character's job class from actual character object
     * 
     * @return job class of character
     */
    public String getJobClass() {
        return character.getJob();
    }

    /**
     * Getter of statistic of character
     * 
     * @return the statistic depending on index
     * 
     */
    public String getstat(int i) {
        return String.valueOf(character.getStats(i));
    }

    /**
     * Getter for character object
     * 
     * @return character object
     */
    public Character getCharacter() {
        return this.character;
    }
}
