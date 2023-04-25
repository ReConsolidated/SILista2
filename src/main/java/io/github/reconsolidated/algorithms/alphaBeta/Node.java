package io.github.reconsolidated.algorithms.alphaBeta;

import io.github.reconsolidated.reversi.Board;
import io.github.reconsolidated.reversi.BoardElement;
import io.github.reconsolidated.reversi.Move;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Node {
    Board board;
    BoardElement element;
    boolean isMaxPlayer;
    double score;
    Node bestChild = null;
    Move moveThatLedHere;

    public Node(Board board, BoardElement playerElement, boolean isMaxPlayer, Move move) {
        this.board = board;
        this.element = playerElement;
        this.isMaxPlayer = isMaxPlayer;
        this.moveThatLedHere = move;
    }

    public void addChild(Node node) {
        if (bestChild == null) {
            bestChild = node;
        }
        else if (node.getScore() > bestChild.getScore()) {
            bestChild = node;
        }
    }

    public Node getBestChild() {
        return bestChild;
    }
}
