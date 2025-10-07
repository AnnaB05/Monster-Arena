package io.github.AnnaB05.monsterArena;

/**
 * Defines a contract for attack behaviors
 * Allows for plug-in attack strategies (basic/special/random)
 */

public interface AttackStrategy {
    void execute(Monster attacker, Monster defender);

    public class BasicAttackStrategy implements AttackStrategy {
        public void execute(Monster attacker, Monster defender) {
            attacker.basicAttack(defender);
        }
    }
}
