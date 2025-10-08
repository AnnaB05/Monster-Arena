package io.github.AnnaB05.monsterArena;

/**
 * Entry point for Monster Arena (Outcome-based results).
 * Files pulled from:
 *  - Outcome.java        → enum Outcome { WIN, DRAW }
 *  - BattleResult.java   → record BattleResult(Outcome outcome, Monster winner, Monster loser, int totalRounds)
 *  - Battle.java         → returns BattleResult with WIN or DRAW
 *  - MonsterSelector.java, BattleMenu.java (optional for interactive play)
 *  - Monster hierarchy: Monster, FireMonster, WaterMonster, GrassMonster, ElementType
 */
public class Main {
    public static void main(String[] args) {
        /** choose monsters for battle
         * MonsterSelector uses BattleMenu class to allow user to pick their monster
         * then randomly selects an opponent that is not the same type as the player's monster
         * technically the opponent
         */
        MonsterSelector selector = new MonsterSelector();
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

        // runs battle until a winner is found or a draw occurs
        Battle arena = new Battle();
        BattleResult result = arena.fight(player, opponent);

        /** clear example of polymorphism - BattleResult.outcome() returns a value from my Outcome enum file
         *  said value is then used in a switch statement to determine the result type
         *  then prints the appropriate message.
         */
        System.out.println();
        switch (result.outcome()) {
            case DRAW -> System.out.printf("⚖️  Result: Draw in %d rounds.%n", result.totalRounds());
            case WIN  -> {
                // winner/loser are non-null when outcome == WIN
                System.out.printf("🏆 Final Result: %s defeated %s in %d rounds.%n",
                        result.winner().getName(), result.loser().getName(), result.totalRounds());
            }
        }
    }
}
