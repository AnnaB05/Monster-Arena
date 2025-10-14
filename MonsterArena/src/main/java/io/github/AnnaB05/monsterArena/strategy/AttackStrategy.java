package io.github.AnnaB05.monsterArena.strategy;


/**
 * CURRENTLY NOT IN USE
 * IN THE FUTURE: I would like for monsters to be able to swap out attack strategies dynamically
 * might implement that to go with Auto Battler mode in the future
 */

import io.github.AnnaB05.monsterArena.model.Monster;

/**
 * Defines a contract for attack behaviors and allows for plug-in attack strategies (basic/special/random)
 */

public interface AttackStrategy {
    void execute(Monster attacker, Monster defender);

    public class BasicAttackStrategy implements AttackStrategy {
        public void execute(Monster attacker, Monster defender) {
            attacker.basicAttack(defender);
        }
    }
}
