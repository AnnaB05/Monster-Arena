package io.github.AnnaB05.monsterArena;

import java.util.Random;

/**
 * Manages battle flow between two monsters.
 * Returns a BattleResult record.
 */
public class Battle {
    private final Random rng = new Random();

    public BattleResult fight(Monster m1, Monster m2) {
        System.out.printf("🔥 %s vs %s 🌊%n%n", m1.getName(), m2.getName());

        int round = 1;
        final int MAX_ROUNDS = 10; // prevents infinite draw loop

        while (m1.isAlive() && m2.isAlive() && round <= MAX_ROUNDS) {
            System.out.printf("--- Round %d ---%n", round++);

            // Randomize who goes first this round
            if (rng.nextBoolean()) {
                m1.basicAttack(m2);
                if (m2.isAlive()) m2.specialAttack(m1);
            } else {
                m2.basicAttack(m1);
                if (m1.isAlive()) m1.specialAttack(m2);
            }

            System.out.println(m1);
            System.out.println(m2);
            System.out.println();
        }

        int roundsCompleted = round - 1;

        // Draw for if both monsters are alive after hitting MAX_ROUNDS
        if (m1.isAlive() && m2.isAlive()) {
            System.out.println("⚖️ The battle ends in a draw!");

            return new BattleResult(Outcome.DRAW,null, null, roundsCompleted);
        }

        Monster winner = m1.isAlive() ? m1 : m2;
        Monster loser  = m1.isAlive() ? m2 : m1;

        System.out.printf("🏆 Winner: %s!%n", winner.getName());
        return new BattleResult(Outcome.WIN, winner, loser, roundsCompleted);
    }
}

