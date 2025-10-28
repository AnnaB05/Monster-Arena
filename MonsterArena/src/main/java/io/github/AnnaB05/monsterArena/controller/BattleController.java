package io.github.AnnaB05.monsterArena.controller;

import io.github.AnnaB05.monsterArena.battle.*;
import io.github.AnnaB05.monsterArena.model.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/battle")
public class BattleController {

    @PostMapping("/start")
    public String startBattle(@RequestParam String playerName, @RequestParam String opponentName) {
        Monster player = new FireMonster(playerName);
        Monster opponent = new WaterMonster(opponentName);
        Battle battle = new Battle();
        BattleResult result = battle.fight(player, opponent);
        return String.format("Winner: %s after %d rounds!", result.winner().getName(), result.totalRounds());
    }
}
