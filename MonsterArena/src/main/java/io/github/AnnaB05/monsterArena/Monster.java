package io.github.AnnaB05.monsterArena;

import java.util.Objects;

/**
 * Abstract base class for all monsters in the arena
 * Each monster has a name, type, health, attack, and defense stats
 * Provides methods for basic attacks, taking damage, healing, and checking if alive
 * Each subclass must implement its own special attack
 * technically I could make the variables protected instead of private with getters but I need more practice with encapsulation
 * Also could have made all of the variables final but I want to leave my options open for modification later on
 */
public abstract class Monster {
    private final int id;
    private String name;
    private ElementType type;
    private int maxHealth;
    private int currentHealth;
    private int attack;
    private int defense;

    private static int NEXT_ID = 1;

    protected Monster(String name, ElementType type, int maxHealth, int attack, int defense) {
        this.id = NEXT_ID++;
        this.name = name;
        this.type = type;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth; // Start with full health
        this.attack = attack;
        this.defense = defense;
    }

    /**
     * Each monster has its own special attack
     */
    public abstract void specialAttack(Monster opponent);

    /**
     * method to perform basic attacks for all monsters
     * Calculates effectiveness multiplier based on monster types
     * Multiplies that multiplier by the attacking monster's attack stat to calculate raw damage.
     * Subtracts opponent's defense from raw damage to ensure all attacks deal at least 1 dmg.
     * takeDamage applies the dmg to opponent
     * print statement describes attack, dmg dealt, and multiplier applied
     *
     */
    public void basicAttack(Monster opponent) {
        double multiplier = type.effectivenessAgainst(opponent.type);
        int rawDamage = (int) Math.round(attack * multiplier);
        int damage = Math.max(1, rawDamage - opponent.defense);
        opponent.takeDamage(damage);
        System.out.printf("%s attacks %s for %d damage (x%.1f)%n", name, opponent.name, damage, multiplier);
    }

    /**
     * Reduces monster's health by a given amount
     */
    public void takeDamage(int damage) {
        currentHealth -= damage;
        if (currentHealth < 0) {
            currentHealth = 0;
        }
        System.out.printf("%s takes %d damage! (%d HP left)%n", name, damage, currentHealth);
    }

    public int attackPower() { return attack; }

    /**
     * heals monster by a certain amount (special attacks)
     */
    public void heal(int amount) {
        currentHealth = Math.min(maxHealth, currentHealth + amount);
        System.out.printf("%s heals %d HP! (%d/%d)%n", name , amount, currentHealth, maxHealth);
    }

    /**
     * Checks if monster is still alive
     */
    public boolean isAlive() {
        return currentHealth > 0;
    }

    // getters
    public String getName() {return name;}
    public ElementType getType() {return type;}
    public int getCurrentHealth() {return currentHealth;}

    /** extra getters for UI/logging/tests */
    public int getMaxHealth() {return maxHealth;}
    public int getAttack() {return attack;}
    public int getDefense() {return defense;}


    /** String representation of the monster's current state
     */
    @Override
    public String toString() {
        return String.format("%s [%s] HP: %d/%d (ATK: %d, DEF: %d)", name, type, currentHealth, maxHealth, attack, defense);
    }

    /** Equals method to compare monsters based on their unique ID
     * Two monsters are considered equal if they have the same ID
     * Ensures that monsters with identical attributes are still treated as distinct entities
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Monster)) return false;
        Monster monster = (Monster) o;
        return id == monster.id;
    }

    /** Hash code based on unique ID
     * Ensures each monster has a unique hash code for use in hash-based collections.
     * Uses the same identifier (id) as equals method to maintain consistency between the 2 methods.
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
