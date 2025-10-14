package io.github.AnnaB05.monsterArena.gacha;
/**
 * determins which monsters spawn in each region within the cave
 */

import io.github.AnnaB05.monsterArena.model.*;
import java.util.ArrayList;
import java.util.List;

public class RegionService {
    public List<Species> getAvailableMonsters(Region region) {
        List<Species> monsters = new ArrayList<>();
        switch (region) {
            case BEGINNER_CAVE -> monsters.add(new Species("Sprout", ElementType.GRASS, Rarity.COMMON, 80, 15, 10));
            case FOREST_RUINS -> monsters.add(new Species("Emberling", ElementType.FIRE, Rarity.UNCOMMON, 90, 20, 15));
            case VOLCANIC_CRATER -> monsters.add(new Species("Blazion", ElementType.FIRE, Rarity.RARE, 120, 30, 20));
            case DEEP_SEA_TRENCH -> monsters.add(new Species("Aqualith", ElementType.WATER, Rarity.SUPER_RARE, 150, 40, 30));
        }
        return monsters;
    }
}

