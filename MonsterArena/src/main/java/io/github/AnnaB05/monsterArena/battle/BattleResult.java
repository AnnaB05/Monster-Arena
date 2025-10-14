package io.github.AnnaB05.monsterArena.battle;

import io.github.AnnaB05.monsterArena.model.Monster;
import io.github.AnnaB05.monsterArena.model.Outcome;

/**
 * record to store the outcome of a battle
 */

public record BattleResult(Outcome outcome, Monster winner, Monster loser, int totalRounds) {

}
