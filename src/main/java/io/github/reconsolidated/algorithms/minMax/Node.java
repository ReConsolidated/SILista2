package io.github.reconsolidated.algorithms.minMax;

import io.github.reconsolidated.reversi.Board;
import io.github.reconsolidated.reversi.BoardElement;
import io.github.reconsolidated.reversi.Move;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Node {
    Board board;
    BoardElement element;
    boolean isMaxPlayer;
    double score;
    List<Node> children = new ArrayList<>();
    Move moveThatLedHere;

    public Node(Board board, BoardElement playerElement, boolean isMaxPlayer, Move move) {
        this.board = board;
        this.element = playerElement;
        this.isMaxPlayer = isMaxPlayer;
        this.moveThatLedHere = move;
    }

    public Node getBestChild() {
        Node bestNode = null;
        for (Node node : children) {
            if (bestNode == null) {
                bestNode = node;
            } else {
                if (node.getScore() > bestNode.getScore()) {
                    bestNode = node;
                }
            }
        }
        return bestNode;
    }
}
