package io.github.AnnaB05.monsterArena.controller;

import io.github.AnnaB05.monsterArena.model.*;
import io.github.AnnaB05.monsterArena.economy.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {
    private final PlayerProfile player = new PlayerProfile();
    private final InventoryService inventoryService = new InventoryService();
    private final EconomyService economyService = new EconomyService();

    @GetMapping("/profile")
    public PlayerProfile getProfile() {
        return player;
    }

    @PostMapping("/reward")
    public String reward(@RequestParam int coins, @RequestParam int gems) {
        economyService.rewardBattle(player, coins, gems);
        return "Player rewarded with " + coins + " coins and " + gems + " gems!";
    }

    @PostMapping("/upgrade/{index}")
    public String upgradeMonster(@PathVariable int index) {
        if (index >= player.getOwnedMonsters().size())
            return "Invalid monster index!";
        inventoryService.upgradeMonster(player, player.getOwnedMonsters().get(index));
        return "Monster upgraded!";
    }
}

