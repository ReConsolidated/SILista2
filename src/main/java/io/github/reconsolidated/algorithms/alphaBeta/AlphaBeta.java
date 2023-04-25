package io.github.reconsolidated.algorithms.alphaBeta;

import io.github.reconsolidated.algorithms.Algorithm;
import io.github.reconsolidated.heuristic.Heuristic;
import io.github.reconsolidated.algorithms.minMax.Node;
import io.github.reconsolidated.reversi.Board;
import io.github.reconsolidated.reversi.BoardElement;
import io.github.reconsolidated.reversi.Move;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class AlphaBeta implements Algorithm {
    private int maxDepth;
    private Heuristic heuristic;

    @Override
    public Move getBestMove(Board board, BoardElement playerElement) {
        Node root = new Node(board, playerElement, true, null);
        minimax(root, maxDepth, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, true);
        Node bestChild = root.getBestChild();
        return bestChild.getMoveThatLedHere();
    }

    private double minimax(Node node, int depth, double alpha, double beta, boolean maximizingPlayer) {
        if (node.getBoard().isFinished()) {
            if (node.getBoard().getWinner().equals(node.getElement())) {
                return Double.POSITIVE_INFINITY;
            } else {
                return Double.NEGATIVE_INFINITY;
            }
        }
        if (depth == 0) {
            return heuristic.score(node.getBoard(), node.getElement());
        }
        List<Move> moves = node.getBoard().getAvailableMoves(node.getElement());

        if (maximizingPlayer) {
            double maxEval = Double.NEGATIVE_INFINITY;

            for (Move move : moves) {
                Board b = move.getBoardAfterMove();
                Node child = new Node(b, node.getElement().getOpposite(), !node.isMaxPlayer(), move);
                node.addChild(child);
                double eval = minimax(child, depth - 1, alpha, beta, false);
                child.setScore(eval);
                maxEval = Math.max(maxEval, eval);
                alpha = Math.max(alpha, maxEval);
                if (beta <= alpha) {
                    break;
                }
            }
            return maxEval;
        }
        else {
            double minEval = Double.POSITIVE_INFINITY;

            for (Move move : moves) {
                Board b = move.getBoardAfterMove();
                Node child = new Node(b, node.getElement().getOpposite(), !node.isMaxPlayer(), move);
                node.addChild(child);
                double eval = minimax(child, depth - 1, alpha, beta, true);
                child.setScore(eval);
                minEval = Math.min(minEval, eval);
                beta = Math.min(beta, minEval);
                if (beta <= alpha) {
                    break;
                }
            }
            return minEval;
        }
    }


}
