package io.github.AnnaB05.monsterArena.app;

import io.github.AnnaB05.monsterArena.battle.BattleMenu;
import io.github.AnnaB05.monsterArena.model.Monster;
import io.github.AnnaB05.monsterArena.battle.MonsterSelector;

/**
 * Entry point for Monster Arena (Outcome-based results).
 * Files pulled from:
 *  - Outcome.java        → enum Outcome { WIN, DRAW }
 *  - BattleResult.java   → record BattleResult(Outcome outcome, Monster winner, Monster loser, int totalRounds)
 *  - Battle.java         → returns BattleResult with WIN or DRAW
 *  - MonsterSelector.java, BattleMenu.java (optional for interactive play)
 *  - Monster hierarchy: Monster, FireMonster, WaterMonster, GrassMonster, ElementType
 */
public class ConsoleMain {
    public static void main(String[] args) {
        /** Monster Selection
         * MonsterSelector uses BattleMenu class to allow user to pick their monster
         * then randomly selects an opponent that is not the same type as the player's monster
         * technically the opponent
         */
        MonsterSelector selector = new MonsterSelector();
        BattleMenu menu = new BattleMenu();
        Monster player   = selector.choosePlayerMonster();
        Monster opponent = selector.chooseOpponent(player);

        /** print statements to display matchup info
         * uses Monster.toString() method to display monster stats
         * how can I make this look cooler?
         */
        System.out.println();
        System.out.printf("🔥 %s VS %s 🌊%n", player.getName(), opponent.getName());
        System.out.println("Your Monster:   " + player);
        System.out.println("Opponent:       " + opponent);
        System.out.println();

        /** MANUAL BATTLE */
        int round = 1;
        int MAX_ROUNDS = 20; // to prevent infinite battles
        while (player.isAlive() && opponent.isAlive() && round <= MAX_ROUNDS) {
            System.out.printf("--- Round %d ---%n", round++);

            //player's turn
            int choice = menu.getPlayerChoice(player);
            menu.executeChoice(choice, player, opponent);
            if (!opponent.isAlive()) break;

            /** Simple "Ai" Opponent
             * randomly chooses between basic attack and special attack (1 or 2)
             * Eventually I want to add logic to choose based on health, type advantage, etc. to make things more realistic
             */
            System.out.printf ("%n%s's turn!%n", opponent.getName());
            int aiChoice = (int) (Math.random() * 2) +1; // 1 = basic attack, 2 = special
            menu.executeChoice(aiChoice, opponent, player);
            if (!player.isAlive()) break;

            System.out.println();
        }

        /** print battle result
         * checks if both monsters are alive (draw), if player is alive (win), or if opponent is alive (loss)
         * then prints appropriate message
         */
        System.out.println();
        if (player.isAlive() && opponent.isAlive()) {
            System.out.println("⚖️  The battle ended in a draw!");
        } else if (player.isAlive()) {
            System.out.printf("🏆 You won! %s defeated %s!%n", player.getName(), opponent.getName());
        } else {
            System.out.printf("💀 You lost! %s was defeated by %s!%n", player.getName(), opponent.getName());
        }

        /** AUTO BATTLE AND POLYMORPHISM EXAMPLE BELOW */
        /** Battle
         * couldn't figure out why the game was auto battling without user input
         * turns out I was calling the wrong method -.-'
         * commented out the auto-battle method call below but leaving it for reference
         * un-comment 39-41 & 47-55 to see the auto-battle in action
         */
        // runs battle until a winner is found or a draw occurs
        //Battle arena = new Battle();
        //BattleResult result = arena.fight(player, opponent);

        /** clear example of polymorphism - BattleResult.outcome() returns a value from my Outcome enum file
         *  said value is then used in a switch statement to determine the result type
         *  then prints the appropriate message.
         */
//        System.out.println();
//        switch (result.outcome()) {
//            case DRAW -> System.out.printf("⚖️  Result: Draw in %d rounds.%n", result.totalRounds());
//            case WIN  -> {
//                // winner/loser are non-null when outcome == WIN
//                System.out.printf("🏆 Final Result: %s defeated %s in %d rounds.%n",
//                        result.winner().getName(), result.loser().getName(), result.totalRounds());
//            }
//        }
    }
}
