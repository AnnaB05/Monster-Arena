package io.github.AnnaB05.monsterArena.economy;

import io.github.AnnaB05.monsterArena.model.*;

/**
 * class to handle player's monsters
 */
public class InventoryService {
    public void upgradeMonster(PlayerProfile player, MonsterInstance monster) {
        if (player.spendCoins(100)) {
            monster.gainExperience(100);
        } else {
            System.out.println("Not enough coins to upgrade!");
        }
    }
}
