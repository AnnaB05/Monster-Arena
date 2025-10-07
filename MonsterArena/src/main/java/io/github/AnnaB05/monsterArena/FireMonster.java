package io.github.AnnaB05.monsterArena;

/**
 * A class representing a Fire-type Monster with a strong Flame Burst attack.
 * Inherits from the base Monster class.
 */
public class FireMonster extends Monster {
    public FireMonster(String name, int maxHealth, int attack, int defense) {
        super(
                name,
                ElementType.FIRE,
                maxHealth,
                attack,
                defense
        );
    }

    @Override
    public void specialAttack(Monster opponent) {
        System.out.printf("%s unleashes a FLAME BURST on %s! 🔥%n", getName(), opponent.getName());
        double multiplier = getType().effectivenessAgainst(opponent.getType());
        int damage = (int) Math.max(1, (attackPower() * 1.5 * multiplier) - 3);
        opponent.takeDamage(damage);
        System.out.printf("%s takes %d damage!%n", opponent.getName(), damage);
    }

}
