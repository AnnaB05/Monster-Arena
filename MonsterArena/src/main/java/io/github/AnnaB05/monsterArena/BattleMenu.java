package io.github.AnnaB05.monsterArena;

import java.util.Scanner;

/**
 * Represents the battle menu in the Monster Arena game.
 * This class will handle user interactions for initiating battles.
 */
public class BattleMenu {
    private final Scanner scanner = new Scanner(System.in);

    /**
     * Displays the battle menu and handles user input.
     */
    public int getPlayerChoice(Monster monster) {
        System.out.printf("%nYour turn, %s!%n", monster.getName());
        System.out.println("1. Basic Attack");
        System.out.println("2. Special Attack");
        System.out.println("3. Heal (Recover small amount of HP)");
        System.out.print("Choose your action: ");

        int choice;

        try {
            choice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            choice = -1; // in the case of an invalid input, basic attack will be assigned
        }

        if (choice < 1 || choice > 3) choice = 1;
        return choice;
    }

    /**
     * execute chosen action
     */
    public void executeChoice ( int choice, Monster player, Monster opponent) {
        switch (choice) {
            case 1 -> player.basicAttack(opponent);
            case 2 -> player.specialAttack(opponent);
            case 3 -> {
                player.heal(10);
                System.out.printf("%s focuses and heals 10 HP!%n", player.getName());
            }
        }
    }
}
