package io.github.AnnaB05.monsterArena;


/**
 * A class representing a water-type that can self-heal as it attacks.
 * Inherits from the base Monster class.
 */
public class WaterMonster extends Monster {
    public WaterMonster(String name, int maxHealth, int attack, int defense) {
        super(
                name,
                ElementType.WATER,
                maxHealth,
                attack, defense
        );
    }


    /**
     * Special attack  method that deals damage based on type effectiveness and heals the WaterMonster.
     * Print message for special attack
     * Dmg multiplier based on type effectiveness
     * Fixed formula for dmg calculations ensure at least 1 dmg is done
     * Applies dmg to opponent
     * Heals WaterMonster by 10 HP
     * Print statement describes dmg dealt and healing done
     */
    @Override
    public void specialAttack(Monster opponent) {
        System.out.printf("%s uses TIDAL HEAL! 🌊%n", getName());
        double multiplier = getType().effectivenessAgainst(opponent.getType());
        int damage = (int) Math.max(1, (attackPower() * 1.2 * multiplier) - 5);
        opponent.takeDamage(damage);
        heal(10);
        System.out.printf("%s deals %d damage and heals 10 HP!%n", getName(), damage);
    }
}
