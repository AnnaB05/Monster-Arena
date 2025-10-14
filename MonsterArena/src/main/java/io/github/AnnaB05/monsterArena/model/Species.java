package io.github.AnnaB05.monsterArena.model;
/**
Represents a species of monster with its attributes. provides blueprints for monsters before instancing them.
 */
public record Species(
        String name,
        ElementType type,
        Rarity rarity,
        int baseHealth,
        int baseAttack,
        int baseDefense
) {}

