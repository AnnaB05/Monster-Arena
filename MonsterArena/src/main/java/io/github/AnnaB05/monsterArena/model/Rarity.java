package io.github.AnnaB05.monsterArena.model;

/**
 * Enum representing the rarity levels of monsters, each with an associated color and pull chance.
 */
public enum Rarity {
    COMMON("Gray", 0.50),
    UNCOMMON("Green", 0.25),
    RARE("Blue", 0.15),
    SUPER_RARE("Purple", 0.07),
    EPIC("Gold", 0.02),
    LEGENDARY("Red", 0.01);

    private final String color;
    private final double pullChance;

    Rarity(String color, double pullChance) {
        this.color = color;
        this.pullChance = pullChance;
    }

    public String getColor() { return color; }
    public double getPullChance() { return pullChance; }
}

