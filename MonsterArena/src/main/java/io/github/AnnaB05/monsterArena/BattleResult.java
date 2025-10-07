package io.github.AnnaB05.monsterArena;

/**
 * record to store the outcome of a battle
 */

public record BattleResult(Monster winner, Monster loser, int totalRounds) {

}
