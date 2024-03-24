public class Battle {
    private Character character;

    public Battle(Character character) {
        this.character = character;
    }

    public void battleScreen() {
        System.out.println(character.getName());
        System.out.println(character.getStats(0));
        // System.out.println("SPRITE");

    }
}
