import java.util.Random;

public class BattleModel {
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

    public BattleModel(Character character, Entity entity) {
        this.character = character;
        this.entity = entity;

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
    }

    public void Attack(int aOp) {
        int enemyHP = 0;
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
    }

    public boolean Dodge() {
        Random random = new Random();
        int rand = random.nextInt(100 - 1 + 1) + 1;
        if (rand <= dodgeRate) {
            System.out.println("DODGE SUCCESS! ENEMY ATTACK EVADED!");
            return true;
        } else {
            int health = character.getCurrHP();
            health -= entity.getATK();
            character.setCurrHP(health);
            System.out.println("DODGE FAILED! Enemy has attacked!");
            return false;
        }
    }

    public double rollEntityAttack() {
        if(entity instanceof Enemy){
            Enemy e = (Enemy) entity;
            e.randAttack();
            entity.setATK(e.getATK());
        } else {
            Boss b = (Boss) entity;
            b.randAttack();
            entity.setATK(b.getATK());
        }

        return entity.getATK();
    }

    /**
     * This method returns the character.
     * 
     * @return charcter
     */
    public Character getCharacter() {
        return this.character;
    }

    /**
     * This method returns the Entity enemy.
     * 
     * @return enemy
     */
    public Entity getEntity() {
        return this.entity;
    }
}
