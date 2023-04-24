package io.github.reconsolidated;

import io.github.reconsolidated.playerHandlers.HumanPlayerHandler;
import io.github.reconsolidated.reversi.ReversiGame;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ReversiGame game = new ReversiGame(new HumanPlayerHandler(), new HumanPlayerHandler());
        game.start();
    }
}
