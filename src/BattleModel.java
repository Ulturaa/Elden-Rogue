import java.util.Random;

public class BattleModel {
    private Character character;
    private Entity entity;

    private int areaNum;
    private double enemyHP;

    private double pDamage;
    private double sDamage;
    private double iDamage;

    private double dodgeRate;

    /**
     * Constructor for the battle model.
     * This sets up the HP, damage, and stats for the enemy(entity) and player(character).
     * 
     * 
     * @param character The player character.
     * @param entity    The enemy to be fought. (Superclass of Enemy and Boss).    
     * @param areaNum   The area number. To be used for the Enemy type.
     */
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

        if(entity instanceof Enemy){
            this.enemyHP = entity.getHP() * this.areaNum;
        } else {
            this.enemyHP = entity.getHP();
        }
        rollEntityAttack();
    }

    /**
     * Attach function for the player.
     * When the player chooses "Attack" this function is called.
     * This function subtracts the enemy's health based on the attack the player choose.
     * This function also subtratcts the enemy damage from the players health.
     * 
     * @param   aOp The attach choice of the player.
     * @return  The calculated damage based on selected.
     */
    public double Attack(int aOp) {
        switch (aOp) {
            case 0:
                enemyHP -= this.pDamage;
                entity.setHP(enemyHP);
                character.setCurrHP(character.getCurrHP() - (int)entity.getATK());
                return pDamage;
            case 1:
                enemyHP -= this.sDamage;
                entity.setHP(enemyHP);
                character.setCurrHP(character.getCurrHP() - (int)entity.getATK());
                return sDamage;
            case 2:
                enemyHP -= this.iDamage;
                entity.setHP(enemyHP);
                character.setCurrHP(character.getCurrHP() - (int)entity.getATK());
                return iDamage;
            default:
                return 0;
        }
    }

    /**
     * Dodge function for the player.
     * When the player chooses "Dodge" this function is called.
     * This function determines wether the player successfuly doges the attack
     * based on their endurace stat and weapon endurance.
     * 
     * @return  True if success, false if fail.
     */
    public boolean Dodge() {
        Random random = new Random();
        Double rand = (random.nextInt(100 - 1) + 1)/100.0;
        if (rand <= this.dodgeRate) {
            return true;
        } else {
            int health = character.getCurrHP();
            health -= entity.getATK();
            character.setCurrHP(health);
            return false;
        }
        
    }

    /**
     * Randomizes the enemy attack based on parameters.
     * This also sets the attack value of the enemy for that turn.
     * 
     * @return  The randomized attack value.
     */
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

    /**
     * Determines wether the player is dead.
     * If player currHP is <= 0, player is dead.
     * 
     * @return  True if player health <= 0, else false.
     */
    public boolean hasPlayerDied() {
        if(character.getCurrHP() <= 0)
            return true;
        else
            return false;
    }

    /**
     * Determines wether the enemy(Entity) is dead.
     * If entity hp is <= 0, player is dead.
     * 
     * @return  True if enemy health <= 0, else false.
     */
    public boolean hasEntityDied() {
        if(entity.getHP() <= 0)
            return true;
        else
            return false;
    }
}
