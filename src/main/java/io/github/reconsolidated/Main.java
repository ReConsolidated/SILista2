package io.github.reconsolidated;

import io.github.reconsolidated.playerHandlers.MinMaxPlayerHandler;
import io.github.reconsolidated.reversi.ReversiGame;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ReversiGame game = new ReversiGame(new MinMaxPlayerHandler(true, 6), new MinMaxPlayerHandler(true, 3));
        game.start();
    }
}
