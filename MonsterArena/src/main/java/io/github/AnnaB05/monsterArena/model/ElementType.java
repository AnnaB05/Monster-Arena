package io.github.AnnaB05.monsterArena.model;

/**
 * Enum representing the different element types for monsters.
 * Each type has specific strengths and weaknesses against other types.
 */

public enum ElementType {
    FIRE,
    WATER,
    GRASS;

    /**
     * Method Calculates the effectiveness multiplier of an attack based on the attacker's and defender's element types.
     * Switch expression to determine the multiplier of an attack based on element types.
     * Ex: FIRE is strong against GRASS (2.0), weak against WATER (0.5), and neutral against FIRE (1.0).
     */

    public double effectivenessAgainst(ElementType other) {
        return switch (this) {
            case FIRE -> (other == GRASS) ? 2.0 : (other == WATER ? 0.5 : 1.0);
            case WATER -> ( other == FIRE) ? 2.0 : (other == GRASS ? 0.5 : 1.0);
            case GRASS -> ( other == WATER) ? 2.0 : (other == FIRE ? 0.5 : 1.0);
        };
    }
}
