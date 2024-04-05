/** 
 * This class, TheEldenBeast extends Boss. It creates a Boss object
 * of the name The Elden Beast.
 */
public class TheEldenBeast extends Boss{
    public TheEldenBeast() {
        super("The Elden Beast");
        statistics(800, 250, 500, 0.25, 0.50, 0.40);
        setBSprite("BattleSprites/EldenBeast.png");
    }
}
