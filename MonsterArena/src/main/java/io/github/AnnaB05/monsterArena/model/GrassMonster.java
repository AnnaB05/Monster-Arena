package io.github.AnnaB05.monsterArena.model;

/**
 * A class representing a grass-type that can drain enemy health.
 * Inherits from the base Monster class.
 */

public class GrassMonster extends Monster {
    public GrassMonster(String name) {
        super(
                name,
                ElementType.GRASS,
                110,
                30,
                30
        );
    }


    /** Special attack method that deals damage based on type effectiveness and heals the GrassMonster.
         * Print message for VINE DRAIN attack
         * Dmg multiplier calculation based on monster type effectiveness
         * Fixed formula for dmg calculations to ensure at least 1 dmg is done
         * Applies dmg to opponent
         * Heals GrassMonster by 5 HP
         * Print statement describes life drain amount from opponent
     */
    @Override
    public void specialAttack(Monster opponent) {
        System.out.printf("%s uses VINE DRAIN! 🌿%n", getName());
        double multiplier = getType().effectivenessAgainst(opponent.getType());
        int damage = (int) Math.max(1, (attackPower() * 1.1 * multiplier) - 4);
        opponent.takeDamage(damage);
        heal(5);
        System.out.printf("%s drains %d HP from %s!%n", getName(), 5, opponent.getName());
    }

}
