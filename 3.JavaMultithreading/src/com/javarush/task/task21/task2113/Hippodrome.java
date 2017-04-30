package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexanderkovalchuk on 29.04.17.
 */
public class Hippodrome {
    private static List<Horse> horses = new ArrayList<>();
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void run() throws InterruptedException {
        for (int i = 0; i < 100; i++)
        {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public void move(){
        for (Horse anHorse : horses)
            anHorse.move();
    }

    public void print(){
        for (Horse anHorse : horses)
            anHorse.print();

        for (int i = 0; i < 10; i++)
            System.out.println();
    }

    public Horse getWinner(){
        Horse winner = new Horse("winnerHorse", 0, 0);
        for (Horse horse : getHorses())
        {
            if (horse.getDistance() > winner.getDistance())
                winner = horse;
        }
        return winner;
    }

    public void printWinner(){
        System.out.printf("Winner is %s!", getWinner().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        game = new Hippodrome(horses);

        game.horses.add(new Horse("horse1", 3.0, 0.0));
        game.horses.add(new Horse("horse2", 3.0, 0.0));
        game.horses.add(new Horse("horse3", 3.0, 0.0));

        game.run();
        game.printWinner();
    }
}
