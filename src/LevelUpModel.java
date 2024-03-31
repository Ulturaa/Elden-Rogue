public class LevelUpModel {
    private Character character;
    private int runeCost;

    public LevelUpModel(Character character) {
        this.character = character;
    }

    public String getName() {
        return character.getName();
    }

    public String getLevel() {
        return String.valueOf(character.getLevel());
    }

    public String getRunes() {
        return String.valueOf(character.getRunes());
    }

    public String getRuneCost() {
        return String.valueOf((character.getLevel() * 100) / 2);
    }

    public int getruneCost() {
        return (character.getLevel() * 100) / 2;
    }

    public String getStat(int i) {
        return String.valueOf(character.getStats(i));
    }

    public String getJob() {
        return character.getJob();
    }

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

    public Character getCharacter() {
        return this.character;
    }

}