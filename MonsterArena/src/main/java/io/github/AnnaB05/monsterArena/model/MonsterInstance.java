package io.github.AnnaB05.monsterArena.model;

/**
 * represents an actual monster owned by a player
 * Includes methods for leveling up and evolving monsters
 */
public class MonsterInstance {
    private final Species species;
    private int level;
    private int stars; // 1 to 3 star evolutions
    private int experience;

    public MonsterInstance(Species species) {
        this.species = species;
        this.level = 1;
        this.stars = 1;
        this.experience = 0;
    }

    public Species getSpecies() { return species; }
    public int getLevel() { return level; }
    public int getStars() { return stars; }

    public void gainExperience(int amount) {
        experience += amount;
        if (experience >= level * 100) {
            experience -= level * 100;
            level++;
            System.out.printf("%s leveled up to %d!%n", species.name(), level);
        }
    }

    public void evolve() {
        if (stars < 3) {
            stars++;
            System.out.printf("%s evolved to %d stars!%n", species.name(), stars);
        }
    }
}
