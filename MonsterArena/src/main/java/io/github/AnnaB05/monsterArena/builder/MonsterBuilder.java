package io.github.AnnaB05.monsterArena.builder;

import io.github.AnnaB05.monsterArena.model.*;

/**
 * Builder class to easily create custom monsters
 */

public class MonsterBuilder {
    private String name;
    private ElementType type;
    private int maxHealth;
    private int attack;
    private int defense;

    public MonsterBuilder setName(String name) {this.name = name;return this;}
    public MonsterBuilder setType(ElementType type) {this.type = type;return this;}
    public MonsterBuilder setMaxHealth(int maxHealth) {this.maxHealth = maxHealth;return this;}
    public MonsterBuilder setAttack(int attack) {this.attack = attack;return this;}
    public MonsterBuilder setDefense(int defense) {this.defense = defense;return this;}

    public Monster build() {
        //build a simple monster subclass based on type
        return switch (type) {
            case FIRE -> new FireMonster(name);
            case WATER -> new WaterMonster(name);
            case GRASS -> new GrassMonster(name);
        };
    }


}
