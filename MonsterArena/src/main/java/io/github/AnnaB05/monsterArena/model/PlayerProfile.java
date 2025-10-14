package io.github.AnnaB05.monsterArena.model;

import java.util.ArrayList;
import java.util.List;

/**
 * stores player info
 * monsters owned/coins/gems
 */
public class PlayerProfile {
    private int coins = 0;
    private int gems = 0;
    private final List<MonsterInstance> ownedMonsters = new ArrayList<>();

    public void addCoins(int amount) { coins += amount; }
    public void addGems(int amount) { gems += amount; }
    public boolean spendGems(int amount) { if (gems >= amount) { gems -= amount; return true; } return false; }
    public boolean spendCoins(int amount) { if (coins >= amount) { coins -= amount; return true; } return false; }

    public void addMonster(MonsterInstance monster) { ownedMonsters.add(monster); }
    public List<MonsterInstance> getOwnedMonsters() { return ownedMonsters; }
}

