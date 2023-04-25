package io.github.reconsolidated;

import io.github.reconsolidated.algorithms.Algorithm;
import io.github.reconsolidated.algorithms.alphaBeta.AlphaBeta;
import io.github.reconsolidated.heuristic.NumberOfPiecesHeuristic;
import io.github.reconsolidated.heuristic.PiecesInCornersHeuristic;
import io.github.reconsolidated.playerHandlers.AlgorithmPlayerHandler;
import io.github.reconsolidated.reversi.ReversiGame;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Algorithm al1 = new AlphaBeta(6, new PiecesInCornersHeuristic());
        Algorithm al2 = new AlphaBeta(6, new NumberOfPiecesHeuristic());

        ReversiGame game = new ReversiGame(new AlgorithmPlayerHandler(al1, true), new AlgorithmPlayerHandler(al2, true));
        game.start();
    }
}
