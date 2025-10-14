package io.github.AnnaB05.monsterArena.gacha;

import io.github.AnnaB05.monsterArena.model.*;
import java.util.List;
import java.util.Random;

/**
 * Service for handling gacha mechanics, including pulling monsters from a pool based on rarity.
 */
public class GachaService {
    private final Random rng = new Random();
    private final List<Species> pool;

    public GachaService(List<Species> pool) {
        this.pool = pool;
    }

    public MonsterInstance pullMonster() {
        double roll = rng.nextDouble();
        for (Rarity rarity : Rarity.values()) {
            if (roll <= rarity.getPullChance()) {
                Species chosen = pool.stream()
                        .filter(s -> s.rarity() == rarity)
                        .findAny()
                        .orElse(pool.get(0));
                return new MonsterInstance(chosen);
            }
        }
        return new MonsterInstance(pool.get(0));
    }
}

