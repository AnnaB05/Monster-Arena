package io.github.AnnaB05.monsterArena;

import java.util.Random;

/**
 * class that manages battle flow between monsters
 * returns BattleResult record
 */
public class Battle {
    private final Random rng = new Random();

    public BattleResult fight(Monster m1, Monster m2) {
        System.out.printf("🔥 %s vs %s 🌊%n%n", m1.getName(), m2.getName());
        int round = 1;

        while (m1.isAlive() && m2.isAlive()) {
            System.out.printf("--- Round %d ---%n", round);

            if (rng.nextBoolean()) m1.specialAttack(m2);
            else m1.basicAttack(m2);

            if (!m2.isAlive()) break;

            if (rng.nextBoolean()) m2.specialAttack(m1);
            else m2.basicAttack(m1);
        }

        Monster winner = m1.isAlive() ? m1 : m2;
        Monster loser = m1.isAlive() ? m2 : m1;
        System.out.printf("🏆 Winner: %s!%n", winner.getName());
        return new BattleResult(winner, loser, round);
    }
}
