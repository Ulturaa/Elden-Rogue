import java.util.Scanner;
import java.util.Random;

public class Battle {
    private Character character;
    private boolean playerTurn;
    private Enemy enemy;

    private int areaNum;
    private double enemyHP;

    private double pDamage;
    private double sDamage;
    private double iDamage;

    private double dodgeRate;

    private boolean isBattle;

    Scanner bc = new Scanner(System.in);

    public Battle(Character character, Enemy enemy, int areaNum) {
        this.character = character;
        this.enemy = enemy;
        this.areaNum = areaNum;
    }

    public void battleScreen() {

        System.out.println(character.getJob() + " : " + character.getName());

        System.out.println("HP:  " + character.getStats(0));

        // System.out.println("SPRITE");

        System.out.println("\n\nENEMY:" + enemy.getName());
        System.out.println("HP:  " + enemy.getHP());
        // System.out.println("SPRITE");
        System.out.println("\n\n");
        System.out.println("system messages here");

    }

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
                        System.out.println("[2] INCANTATION");
                        aOp = bc.nextInt();
                        switch (aOp) {
                            case 1:
                                enemyHP -= this.pDamage;
                                enemy.setHP(enemyHP);
                                System.out.println("PHYSICAL attack! damage dealt: " + pDamage);
                                break;
                            case 2:
                                enemyHP -= this.sDamage;
                                enemy.setHP(enemyHP);
                                System.out.println("SORCERY attack! damage dealt: " + sDamage);
                                break;
                            case 3:
                                enemyHP -= this.iDamage;
                                enemy.setHP(enemyHP);
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
                        int health = character.getStats(0);
                        health -= enemy.getATK() * areaNum;
                        character.setStats(health, 0);
                        System.out.println("DODGE FAILED! Enemy has attacked!");
                        if (character.getStats(0) <= 0) {
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

    public void battleSequence() {
        int maxHP;
        int battleChoice;
        int battleCounter = 0;
        int playerHP;

        playerTurn = true;
        isBattle = true;

        if (character.getWeapon() != null && battleCounter == 0) {
            maxHP = 100 * ((character.getStats(0) + character.getWeapon().getWeaponStat(0)) / 2);
            pDamage = (character.getStats(3) + character.getWeapon().getWeaponStat(3)) * (1 - enemy.getStats(0));
            sDamage = (character.getStats(4) + character.getWeapon().getWeaponStat(4)) * (1 - enemy.getStats(1));
            iDamage = (character.getStats(5) + character.getWeapon().getWeaponStat(5)) * (1 - enemy.getStats(2));
            character.setStats(maxHP, 0);
            dodgeRate = (20 + ((character.getStats(1) + character.getWeapon().getWeaponStat(1)) / 2)) / 100;

        } else if (character.getWeapon() == null && battleCounter == 0) {
            maxHP = 100 * (character.getStats(0) / 2);
            pDamage = (character.getStats(3)) * (1 - enemy.getStats(0));
            sDamage = (character.getStats(4)) * (1 - enemy.getStats(1));
            iDamage = (character.getStats(5)) * (1 - enemy.getStats(2));
            character.setStats(maxHP, 0);
            dodgeRate = (20 + ((character.getStats(1)) / 2)) / 100;

        } else if (character.getWeapon() != null && battleCounter > 0) {
            pDamage = (character.getStats(3) + character.getWeapon().getWeaponStat(3)) * (1 - enemy.getStats(0));
            sDamage = (character.getStats(4) + character.getWeapon().getWeaponStat(4)) * (1 - enemy.getStats(1));
            iDamage = (character.getStats(5) + character.getWeapon().getWeaponStat(5)) * (1 - enemy.getStats(2));
            dodgeRate = (20 + ((character.getStats(1) + character.getWeapon().getWeaponStat(1)) / 2)) / 100;
        } else {
            pDamage = (character.getStats(3)) * (1 - enemy.getStats(0));
            sDamage = (character.getStats(4)) * (1 - enemy.getStats(1));
            iDamage = (character.getStats(5)) * (1 - enemy.getStats(2));
            dodgeRate = (20 + ((character.getStats(1)) / 2)) / 100;
        }

        playerHP = character.getStats(0);
        enemyHP = enemy.getHP() * areaNum;

        while (isBattle) {
            if (playerTurn) {
                battleScreen();

                // randomize attack here
                enemy.randAttack(enemy.getType());
                System.out.println("\nINCOMING ENEMY DMG:" + enemy.getATK() + "\n");

                battleOptions();
                // battleChoice = bc.nextInt();
                if (enemy.getHP() <= 0) {
                    isBattle = false;
                    System.out.println("ENEMY FELLED");
                }
            } else {

                playerHP -= enemy.getATK() * areaNum;
                character.setStats(playerHP, 0);
                System.out.println("Enemy has attacked!");
                if (character.getStats(0) <= 0) {
                    isBattle = false;
                    System.out.println("YOU DIED");
                }
                playerTurn = true;
            }
        }
        battleCounter += 1;
    }
}
