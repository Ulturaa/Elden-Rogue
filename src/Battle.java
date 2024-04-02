import java.util.Scanner;
import java.util.Random;

public class Battle {
    private Character character;
    private Entity entity;
    private boolean playerTurn;

    private int areaNum;
    private double enemyHP;

    private double pDamage;
    private double sDamage;
    private double iDamage;

    private double dodgeRate;

    private boolean isBattle;

    Scanner bc = new Scanner(System.in);

    /**
     * This is the constructor for the class battle. This initalizes the attributes of
     * battle.
     * 
     * @param character     The character object.
     * @param entity        The enemy/boss object.
     * @param areaNum       The number of the area. Used for class enemy stats calc.
     */
    public Battle(Character character, Entity entity, int areaNum) {
        this.character = character;
        this.entity = entity;
        this.areaNum = areaNum;
    }

    /**
     * This method prints the battle screen which include the
     * BattleCount, Character details, and Entity details.
     * 
     */
    public void battleScreen() {
        System.out.println("BATTLE COUNT:" + character.getBattleCount());
        System.out.println(character.getJob() + " : " + character.getName());
        System.out.println("HP:  " + character.getCurrHP());
        System.out.println("\n\nENEMY:" + entity.getName());
        System.out.println("HP:  " + entity.getHP());
        System.out.println("\n\n");

    }

    /**
     * This method prints the battle options Attack and Dodge.
     * After selecting the option, the computations are done for the
     * corresponding options. (Entity and Character damage/health or Character dodges/gets hit).
     * 
     */
    public void battleOptions() {
        int bOp;
        int aOp;
        do {
            System.out.println("\nWhat would you like to do?");
            System.out.println("[1] ATTACK");
            System.out.println("[2] DODGE");
            bOp = bc.nextInt();

            switch (bOp) {
                case 1:
                    do {
                        System.out.println("\nWhat attack would you like to do?");
                        System.out.println("[1] PHYSICAL");
                        System.out.println("[2] SORCERY");
                        System.out.println("[3] INCANTATION");
                        aOp = bc.nextInt();
                        switch (aOp) {
                            case 1:
                                enemyHP -= this.pDamage;
                                entity.setHP(enemyHP);
                                System.out.println("PHYSICAL attack! damage dealt: " + pDamage);
                                break;
                            case 2:
                                enemyHP -= this.sDamage;
                                entity.setHP(enemyHP);
                                System.out.println("SORCERY attack! damage dealt: " + sDamage);
                                break;
                            case 3:
                                enemyHP -= this.iDamage;
                                entity.setHP(enemyHP);
                                System.out.println("INCANTATION attack! damage dealt: " + iDamage);
                                break;
                            default:
                                break;
                        }
                    } while (aOp < 1 || aOp > 3);
                    playerTurn = false;
                    break;
                case 2:
                    Random random = new Random();
                    int rand = random.nextInt(100 - 1 + 1) + 1;
                    if (rand <= dodgeRate) {
                        System.out.println("\nDODGE SUCCESS! ENEMY ATTACK EVADED!");
                    } else {
                        int health = character.getCurrHP();
                        health -= entity.getATK();
                        character.setCurrHP(health);
                        System.out.println("DODGE FAILED! Enemy has attacked!");
                        if (character.getCurrHP() <= 0) {
                            character.setCurrHP(character.getStats(0));
                            isBattle = false;
                            System.out.println("YOU DIED");
                        }
                    }
                    playerTurn = false;
                    break;
                default:
                    break;
            }
        } while (bOp < 1 || bOp > 2);

    }

    /**
     * This method sets up the battle and battle sequence.
     * This includes the character enemy and health. Here also
     * is the logic to determine if the battle has ended (if either 
     * the player or enemy has died).
     * 
     * @return true/false   - True if entity has died, false if player has died.
     */
    public boolean battleSequence() {
        playerTurn = true;
        isBattle = true;
        int maxHP;
        int playerHP;

        if (character.getWeapon() != null && character.getBattleCount() == 0) {
            maxHP = 100 * ((character.getStats(0) + character.getWeapon().getWeaponStat(0)) / 2);
            pDamage = (character.getStats(3) + character.getWeapon().getWeaponStat(3)) * (1 - entity.getStats(0));
            sDamage = (character.getStats(4) + character.getWeapon().getWeaponStat(4)) * (1 - entity.getStats(1));
            iDamage = (character.getStats(5) + character.getWeapon().getWeaponStat(5)) * (1 - entity.getStats(2));
            character.setCurrHP(maxHP);
            dodgeRate = (20 + ((character.getStats(1) + character.getWeapon().getWeaponStat(1)) / 2)) / 100;

        } else if (character.getWeapon() == null && character.getBattleCount() == 0) {
            maxHP = 100 * (character.getStats(0) / 2);
            pDamage = (character.getStats(3)) * (1 - entity.getStats(0));
            sDamage = (character.getStats(4)) * (1 - entity.getStats(1));
            iDamage = (character.getStats(5)) * (1 - entity.getStats(2));
            character.setCurrHP(maxHP);
            dodgeRate = (20 + ((character.getStats(1)) / 2)) / 100;

        } else if (character.getWeapon() != null && character.getBattleCount() > 0) {
            pDamage = (character.getStats(3) + character.getWeapon().getWeaponStat(3)) * (1 - entity.getStats(0));
            sDamage = (character.getStats(4) + character.getWeapon().getWeaponStat(4)) * (1 - entity.getStats(1));
            iDamage = (character.getStats(5) + character.getWeapon().getWeaponStat(5)) * (1 - entity.getStats(2));
            dodgeRate = (20 + ((character.getStats(1) + character.getWeapon().getWeaponStat(1)) / 2)) / 100;
        } else {
            pDamage = (character.getStats(3)) * (1 - entity.getStats(0));
            sDamage = (character.getStats(4)) * (1 - entity.getStats(1));
            iDamage = (character.getStats(5)) * (1 - entity.getStats(2));
            dodgeRate = (20 + ((character.getStats(1)) / 2)) / 100;
        }

        playerHP = character.getCurrHP();

        if(entity instanceof Enemy){
            enemyHP = entity.getHP() * areaNum;
        } else {
            enemyHP = entity.getHP();
        }

        while (isBattle) {
            if (playerTurn) {
                battleScreen();

                if(entity instanceof Enemy){
                    Enemy e = (Enemy) entity;
                    e.randAttack();
                    entity.setATK(e.getATK());
                } else {
                    Boss b = (Boss) entity;
                    b.randAttack();
                    entity.setATK(b.getATK());
                }

                System.out.println("\nINCOMING ENEMY DMG:" + entity.getATK() + "\n");

                battleOptions();
                if (entity.getHP() <= 0) {
                    isBattle = false;
                    if(entity instanceof Enemy)
                        System.out.println("ENEMY FELLED");
                    else
                        System.out.println("GREAT ENEMY FELLED");
                    character.setBattleCount(character.getBattleCount() + 1);
                    return true;
                }
            } else {

                playerHP -= entity.getATK();
                character.setCurrHP(playerHP);
                System.out.println("Enemy has attacked!");
                if (character.getCurrHP() <= 0) {
                    character.setCurrHP(character.getStats(0));
                    isBattle = false;
                    System.out.println("YOU DIED");
                    character.setBattleCount(0);
                    return false;
                }
                playerTurn = true;
            }
        }

        return false;
    }
}