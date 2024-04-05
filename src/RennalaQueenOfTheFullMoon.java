/** 
 * This class, Rennala Queen of the Full Moon extends Boss. It creates a Boss object
 * of the name Rennala Queen of the Full Moon.
 */
public class RennalaQueenOfTheFullMoon extends Boss{
    public RennalaQueenOfTheFullMoon() {
        super("Rennala, Queen of the full moon");
        statistics(400, 200, 300, 0.15, 0.35, 0.25);
        setBSprite("BattleSprites/RennalaQueen.png");
    }
}
