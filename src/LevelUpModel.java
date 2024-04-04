public class LevelUpModel {
    private Character character;
    private int runeCost;

    /**
     * Constructs a LevelUpModel with the specified character.
     * 
     * @param character The character associated with the leveling up process.
     */
    public LevelUpModel(Character character) {
        this.character = character;
    }

    /**
     * Retrieves the name of the character.
     * 
     * @return The name of the character.
     */
    public String getName() {
        return character.getName();
    }

    /**
     * Retrieves the level of the character.
     * 
     * @return The level of the character.
     */
    public String getLevel() {
        return String.valueOf(character.getLevel());
    }

    /**
     * Retrieves the number of runes owned by the character.
     * 
     * @return The number of runes owned by the character.
     */
    public String getRunes() {
        return String.valueOf(character.getRunes());
    }

    /**
     * Calculates the rune cost required for upgrading stats based on character
     * level.
     * 
     * @return The rune cost for upgrading stats.
     */
    public String getRuneCost() {
        return String.valueOf((character.getLevel() * 100) / 2);
    }

    /**
     * Calculates the rune cost required for upgrading stats based on character
     * level.
     * 
     * @return The rune cost for upgrading stats.
     */
    public int getruneCost() {
        return (character.getLevel() * 100) / 2;
    }

    /**
     * Retrieves the statistic of the character
     * 
     * @return The rune cost for upgrading stats.
     */
    public String getStat(int i) {
        return String.valueOf(character.getStats(i));
    }

    /**
     * Retrieves the job class of the character
     * 
     * @return The rune cost for upgrading stats.
     */
    public String getJob() {
        return character.getJob();
    }

    /**
     * Attempts to upgrade a selected stat of the character.
     * 
     * @param lvlupchoice The choice of the stat to upgrade.
     * @return True if the stat was successfully upgraded, false otherwise.
     */

    public boolean upgradeStat(int lvlupchoice) {

        int upgraded;
        runeCost = getruneCost();
        switch (lvlupchoice) {
            case 1:
                if (character.getRunes() >= runeCost && character.getStats(0) < 50) {
                    System.out.print("\033\143");
                    upgraded = character.getStats(0) + 1;
                    character.setStats(upgraded, 0);
                    character.setRunes(character.getRunes() - runeCost);
                    character.levelUp();
                    System.out.println("SUCCESSFULLY UPGRADED");
                    return true;
                } else if (character.getStats(0) == 50)
                    System.out.println("MAX LEVEL REACHED");
                else
                    System.out.println("NOT ENOUGH RUNES");
                break;
            case 2:
                if (character.getRunes() >= runeCost && character.getStats(1) < 50) {
                    upgraded = character.getStats(1) + 1;
                    character.setStats(upgraded, 1);
                    character.setRunes(character.getRunes() - runeCost);
                    character.levelUp();
                    System.out.println("SUCCESSFULLY UPGRADED");
                    return true;
                } else if (character.getStats(1) == 50)
                    System.out.println("MAX LEVEL REACHED");
                else
                    System.out.println("NOT ENOUGH RUNES");
                break;
            case 3:
                if (character.getRunes() >= runeCost && character.getStats(2) < 50) {
                    upgraded = character.getStats(2) + 1;
                    character.setStats(upgraded, 2);
                    character.setRunes(character.getRunes() - runeCost);
                    character.levelUp();
                    System.out.println("SUCCESSFULLY UPGRADED");
                    return true;
                } else if (character.getStats(2) == 50)
                    System.out.println("MAX LEVEL REACHED");
                else
                    System.out.println("NOT ENOUGH RUNES");
                break;
            case 4:
                if (character.getRunes() >= runeCost && character.getStats(3) < 50) {
                    upgraded = character.getStats(3) + 1;
                    character.setStats(upgraded, 3);
                    character.setRunes(character.getRunes() - runeCost);
                    character.levelUp();
                    System.out.println("SUCCESSFULLY UPGRADED");
                    return true;
                } else if (character.getStats(3) == 50)
                    System.out.println("MAX LEVEL REACHED");
                else
                    System.out.println("NOT ENOUGH RUNES");
                break;
            case 5:
                if (character.getRunes() >= runeCost && character.getStats(4) < 50) {
                    upgraded = character.getStats(4) + 1;
                    character.setStats(upgraded, 4);
                    character.setRunes(character.getRunes() - runeCost);
                    character.levelUp();
                    System.out.println("SUCCESSFULLY UPGRADED");
                    return true;
                } else if (character.getStats(4) == 50)
                    System.out.println("MAX LEVEL REACHED");
                else
                    System.out.println("NOT ENOUGH RUNES");
                break;
            case 6:
                if (character.getRunes() >= runeCost && character.getStats(5) < 50) {
                    upgraded = character.getStats(5) + 1;
                    character.setStats(upgraded, 5);
                    character.setRunes(character.getRunes() - runeCost);
                    character.levelUp();
                    System.out.println("SUCCESSFULLY UPGRADED");
                    return true;
                } else if (character.getStats(5) == 50)
                    System.out.println("MAX LEVEL REACHED");
                else
                    System.out.println("NOT ENOUGH RUNES");
                break;
            case 7:
                // lobbyScreen(character);
                break;

        }
        return false;
    }

    /**
     * Retrieves the character associated with this LevelUpModel.
     * 
     * @return The character associated with this LevelUpModel.
     */
    public Character getCharacter() {
        return this.character;
    }

}