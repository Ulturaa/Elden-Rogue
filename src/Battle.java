import java.util.Scanner;
import java.util.Random;

public class Battle {
    private Character character;
    private boolean playerTurn;
    private Enemy enemy;
    private Boss boss;
    private Entity entity;

    private int areaNum;
    private double enemyHP;
    // private int battleCounter;

    private double pDamage;
    private double sDamage;
    private double iDamage;

    private int defaultPlayerHP;

    private double dodgeRate;

    private boolean isBattle;

    Scanner bc = new Scanner(System.in);

    public Battle(Character character, Enemy enemy, int areaNum) {
        this.character = character;
        this.enemy = enemy;
        this.entity = enemy;
        this.areaNum = areaNum;
        defaultPlayerHP = character.getStats(0);

    }

    // public Battle(Character character, Boss boss, int areaNum) {
    // this.character = character;
    // this.boss = boss;
    // this.areaNum = areaNum;

    // }

    public Battle(Character character, Entity entity, int areaNum) {
        this.character = character;
        this.entity = entity;
        this.areaNum = areaNum;
        defaultPlayerHP = character.getStats(0);
    }

    public void battleScreen() {

        System.out.println("BATTLE COUNT:" + character.getBattleCount());
        System.out.println(character.getJob() + " : " + character.getName());

        System.out.println("HP:  " + character.getStats(0));

        // System.out.println("SPRITE");

        System.out.println("\n\nENEMY:" + entity.getName());
        System.out.println("HP:  " + entity.getHP());
        // System.out.println("SPRITE");
        System.out.println("\n\n");
        // System.out.println("system messages here");

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
                        int health = character.getStats(0);
                        health -= entity.getATK() * areaNum;
                        character.setStats(health, 0);
                        System.out.println("DODGE FAILED! Enemy has attacked!");
                        if (character.getStats(0) <= 0) {
                            System.out.println(defaultPlayerHP);
                            character.setStats(defaultPlayerHP, 0);
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

    public boolean battleSequence() {
        int maxHP;
        int playerHP;
        Random random = new Random();

        playerTurn = true;
        isBattle = true;

        System.out.println(defaultPlayerHP);
        if (character.getWeapon() != null && character.getBattleCount() == 0) {
            maxHP = 100 * ((character.getStats(0) + character.getWeapon().getWeaponStat(0)) / 2);
            pDamage = (character.getStats(3) + character.getWeapon().getWeaponStat(3)) * (1 - entity.getStats(0));
            sDamage = (character.getStats(4) + character.getWeapon().getWeaponStat(4)) * (1 - entity.getStats(1));
            iDamage = (character.getStats(5) + character.getWeapon().getWeaponStat(5)) * (1 - entity.getStats(2));
            character.setStats(maxHP, 0);
            dodgeRate = (20 + ((character.getStats(1) + character.getWeapon().getWeaponStat(1)) / 2)) / 100;

        } else if (character.getWeapon() == null && character.getBattleCount() == 0) {
            maxHP = 100 * (character.getStats(0) / 2);
            pDamage = (character.getStats(3)) * (1 - entity.getStats(0));
            sDamage = (character.getStats(4)) * (1 - entity.getStats(1));
            iDamage = (character.getStats(5)) * (1 - entity.getStats(2));
            character.setStats(maxHP, 0);
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

        playerHP = character.getStats(0);
        enemyHP = entity.getHP() * areaNum;

        while (isBattle) {
            if (playerTurn) {
                battleScreen();

                // randomize attack here
                if (entity.getName() != "Godrick the Grafted" && entity.getName() != "Rennala, Queen of the full moon"
                        && entity.getName() != "The Elden Beast") {
                    enemy.randAttack(enemy.getType());
                } // else {
                  // switch (entity.getName()) {
                  // case "Godrick the Grafted":
                  // entity.setATK(random.nextInt(300 - 150 + 1) + 150);

                // break;
                // case "Rennala, Queen of the full moon":
                // break;
                // case "The Elden Beast":
                // break;
                // }

                // }

                System.out.println("\nINCOMING ENEMY DMG:" + entity.getATK() + "\n");

                battleOptions();
                // battleChoice = bc.nextInt();
                if (entity.getHP() <= 0) {
                    isBattle = false;
                    System.out.println("ENEMY FELLED");
                    character.setBattleCount(character.getBattleCount() + 1);
                    // this.battleCounter += 1;
                    return true;
                }
            } else {

                playerHP -= entity.getATK() * areaNum;
                character.setStats(playerHP, 0);
                System.out.println("Enemy has attacked!");
                if (character.getStats(0) <= 0) {
                    character.setStats(defaultPlayerHP, 0);
                    isBattle = false;
                    System.out.println("YOU DIED");
                    // battleCounter = 0;
                    character.setBattleCount(0);
                    // character.setStats(defaultPlayerHP, 0);
                    return false;
                }
                playerTurn = true;
            }
        }

        return false;
    }
}

/*
 * Notes:
 * 
 * - Add a temp holder for player health. Once player is defeated, restore
 * health to normal then exit battle.
 * If player defeats enemy, lost health is retained.
 * 
 * - Implement try catch for input mismatch.
 */