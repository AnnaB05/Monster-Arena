package io.github.AnnaB05.monsterArena;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Monster fire = new MonsterBuilder()
                .setName("Infernos")
                .setType(ElementType.FIRE)
                .setMaxHealth(120)
                .setAttack(30)
                .setDefense(8)
                .build();
        Monster water = new MonsterBuilder()
                .setName("Tsunami")
                .setType(ElementType.WATER)
                .setMaxHealth(110)
                .setAttack(22)
                .setDefense(10)
                .build();
        //run battle
        Battle arena = new Battle();
        BattleResult result = arena.fight(fire, water);

        System.out.printf("%nFinal Result: %s defeated %s in %d rounds.%n",
                result.winner().getName(), result.loser().getName(), result.totalRounds());
    }
}