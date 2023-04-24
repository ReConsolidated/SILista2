package io.github.reconsolidated.minMax;

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
}
