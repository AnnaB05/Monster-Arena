package io.github.AnnaB05.monsterArena.economy;

import io.github.AnnaB05.monsterArena.model.PlayerProfile;

/**
 * class to handle spending of coins and gems
 */
public class EconomyService {
    public void rewardBattle(PlayerProfile player, int coins, int gems) {
        player.addCoins(coins);
        player.addGems(gems);
    }
}
