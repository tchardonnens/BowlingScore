package com.isep;

import com.isep.Bowling.Game;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        for (int i = 0; i < 10; i++) {
            game.roll(2);
            System.out.println(game.score());
        }
        System.out.println(game.score());

    }
}
