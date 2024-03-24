import java.util.Scanner;

public class Battle {
    private Character character;
    private boolean playerTurn;
    private Enemy enemy;

    private double enemyHP;

    private double pDamage;
    private double sDamage;
    private double iDamage;

    Scanner bc = new Scanner(System.in);

    public Battle(Character character, Enemy enemy) {
        this.character = character;
        this.enemy = enemy;
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
                                enemyHP = enemy.getHP();
                                enemyHP -= this.pDamage;
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            default:
                                break;
                        }
                    } while (aOp < 1 || aOp > 3);

                    break;
                case 2:
                    break;
                default:
                    break;
            }
        } while (bOp < 1 || bOp > 2);

    }

    public void battleSequence() {
        int maxHP;
        int battleChoice;

        boolean isBattle;

        playerTurn = true;
        isBattle = true;

        if (character.getWeapon() != null) {
            maxHP = 100 * ((character.getStats(0) + character.getWeapon().getWeaponStat(0)) / 2);
        } else {
            maxHP = 100 * (character.getStats(0) / 2);
        }
        character.setStats(maxHP, 0);
        int playerHP = maxHP;

        while (isBattle) {
            if (playerTurn) {
                battleScreen();
                battleOptions();
                // battleChoice = bc.nextInt();
            } else {

            }
        }
    }
}
