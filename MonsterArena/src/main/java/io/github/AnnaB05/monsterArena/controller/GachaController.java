package io.github.AnnaB05.monsterArena.controller;

import io.github.AnnaB05.monsterArena.model.*;
import io.github.AnnaB05.monsterArena.gacha.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gacha")
public class GachaController {
    private final PlayerProfile player = new PlayerProfile();
    private final RegionService regionService = new RegionService();

    @PostMapping("/pull")
    public MonsterInstance pull(@RequestParam Region region) {
        List<Species> pool = regionService.getAvailableMonsters(region);
        GachaService gacha = new GachaService(pool);
        MonsterInstance result = gacha.pullMonster();
        player.addMonster(result);
        return result;
    }
}

