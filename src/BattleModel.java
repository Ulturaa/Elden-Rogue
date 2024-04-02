import java.util.Random;

public class BattleModel {
    private Character character;
    private Entity entity;

    private boolean playerTurn;

    private int areaNum;
    private double enemyHP;
    private int playerHP;

    private double pDamage;
    private double sDamage;
    private double iDamage;

    private double dodgeRate;

    public BattleModel(Character character, Entity entity, int areaNum) {
        this.character = character;
        this.entity = entity;
        this.areaNum = areaNum;
        this.dodgeRate = 0.0;

        if (character.getWeapon() != null && character.getBattleCount() > 0) {
            pDamage = (character.getStats(3) + character.getWeapon().getWeaponStat(3)) * (1 - entity.getStats(0));
            sDamage = (character.getStats(4) + character.getWeapon().getWeaponStat(4)) * (1 - entity.getStats(1));
            iDamage = (character.getStats(5) + character.getWeapon().getWeaponStat(5)) * (1 - entity.getStats(2));
            this.dodgeRate = ((20 + ((character.getStats(1) + character.getWeapon().getWeaponStat(1)) / 2)) / 100.0);
            System.out.println("Dodge rate = (20 + ((" + character.getStats(1) + " " + character.getWeapon().getWeaponStat(1) + " / 2)) / 100");
        } else {
            pDamage = (character.getStats(3)) * (1 - entity.getStats(0));
            sDamage = (character.getStats(4)) * (1 - entity.getStats(1));
            iDamage = (character.getStats(5)) * (1 - entity.getStats(2));
            this.dodgeRate = (20 + ((character.getStats(1)) / 2)) / 100.0;
        }

        playerHP = character.getCurrHP();

        if(entity instanceof Enemy){
            this.enemyHP = entity.getHP() * areaNum;
        } else {
            this.enemyHP = entity.getHP();
        }
        rollEntityAttack();
        System.out.println(enemyHP);
    }

    public double Attack(int aOp) {
        switch (aOp) {
            case 0:
                enemyHP -= this.pDamage;
                entity.setHP(enemyHP);
                System.out.println("PHYSICAL attack! damage dealt: " + pDamage);

                character.setCurrHP(character.getCurrHP() - (int)entity.getATK());
                return pDamage;
            case 1:
                enemyHP -= this.sDamage;
                entity.setHP(enemyHP);
                System.out.println("SORCERY attack! damage dealt: " + sDamage);

                character.setCurrHP(character.getCurrHP() - (int)entity.getATK());
                return sDamage;
            case 2:
                enemyHP -= this.iDamage;
                entity.setHP(enemyHP);
                System.out.println("INCANTATION attack! damage dealt: " + iDamage);

                character.setCurrHP(character.getCurrHP() - (int)entity.getATK());
                return iDamage;
            default:
                return 0;
        }
    }

    public boolean Dodge() {
        Random random = new Random();
        Double rand = (random.nextInt(100 - 1) + 1)/100.0;
        System.out.println("Rand: " + rand + " Dodge rate: " + this.dodgeRate);
        if (rand <= this.dodgeRate) {
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
    
    public boolean hasPlayerDied() {
        if(character.getCurrHP() <= 0)
            return true;
        else
            return false;
    }

    public boolean hasEntityDied() {
        if(entity.getHP() <= 0)
            return true;
        else
            return false;
    }
}
