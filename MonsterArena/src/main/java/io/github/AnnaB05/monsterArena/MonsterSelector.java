package io.github.AnnaB05.monsterArena;

import java.util.Scanner;

/**
 * class allows players to select 1 of 3 monster types
 */
public class MonsterSelector {
    private final Scanner scanner = new Scanner(System.in);

    public Monster choosePlayerMonster() {
        System.out.println("Choose your monster:");
        System.out.println("1. Infernos (Fire Type)");
        System.out.println("2. Tsunami (Water Type)");
        System.out.println("3. Verdant (Grass Type)");
        System.out.println("Enter choice: ");

        int choice;

        /**
         * defaults to 1 (Infernos) in case of invalid input
         * */
        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            choice = 1;
        }

        /**
         * switch expression to "create" monster based on user input or default to Infernos
         */
        return switch (choice) {
            case 1 -> new FireMonster("Infernos");
            case 2 -> new WaterMonster("Tsunami");
            case 3 -> new GrassMonster("Verdant");
            default -> new FireMonster("Infernos");
        };
    }

    /**
     * selects opponent at random
     */
    public Monster chooseOpponent(Monster playerMonster) {
        return switch (playerMonster.getType()) {
            case FIRE -> new WaterMonster("Tsunami");
            case WATER -> new GrassMonster("Verdant");
            case GRASS -> new FireMonster("Infernos");
        };
    }
}
