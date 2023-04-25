package io.github.reconsolidated.algorithms.minMax;


import io.github.reconsolidated.algorithms.Algorithm;
import io.github.reconsolidated.heuristic.Heuristic;
import io.github.reconsolidated.reversi.Board;
import io.github.reconsolidated.reversi.BoardElement;
import io.github.reconsolidated.reversi.Move;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

@AllArgsConstructor
public class MiniMax implements Algorithm {
    private int maxDepth;
    private Heuristic heuristic;

    @Override
    public Move getBestMove(Board board, BoardElement playerElement) {
        Tree tree = new Tree();
        Node root = new Node(board, playerElement, true, null);
        tree.setRoot(root);
        constructTree(root, 0);

        scoreTree(tree);
        return root.getBestChild().getMoveThatLedHere();
    }

    private void scoreTree(Tree tree) {
        scoreNode(tree.getRoot(), 0);
    }

    private void constructTree(Node parentNode, int depth) {
        if (depth >= maxDepth) {
            return;
        }
        List<Move> moves = parentNode.getBoard().getAvailableMoves(parentNode.getElement().getOpposite());

        for (Move move : moves) {
            Board b = move.getBoardAfterMove();
            Node node = new Node(b, parentNode.getElement().getOpposite(), !parentNode.isMaxPlayer(), move);
            parentNode.addChild(node);
            if (node.getBoard().getAvailableMoves(node.getElement().getOpposite()).size() > 0) {
                constructTree(node, depth + 1);
            }
        }
    }

    private boolean checkWin(Board board, BoardElement playerElement) {
        int myElementCount = 0;
        int opponentElementCount = 0;
        BoardElement oppositeElement = playerElement == BoardElement.PLAYER1 ? BoardElement.PLAYER2 : BoardElement.PLAYER1;
        BoardElement[][] boardArray = board.getBoard();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8 ; j++) {
                if (boardArray[i][j] == playerElement) {
                    myElementCount++;
                } else if (boardArray[i][j] == oppositeElement) {
                    opponentElementCount++;
                }
            }
        }
        return board.getAvailableMoves(playerElement).size() == 0 && myElementCount > opponentElementCount;
    }

    private void scoreNode(Node node, int depth) {
        if (depth >= maxDepth) {
            node.setScore(heuristic.score(node.getBoard(), node.getElement()));
            return;
        }
        List<Node> children = new ArrayList<>();//node.getChildren();
        boolean isMaxPlayer = node.isMaxPlayer;

        children.forEach(child -> {
            if (checkWin(child.getBoard(), child.getElement())) {
                child.setScore(isMaxPlayer ? 1 : -1);
            } else {
                scoreNode(child, depth+1);
            }
        });
        try {
            Node bestChild = findBestChild(isMaxPlayer, children);
            node.setScore(bestChild.getScore());
        } catch (NoSuchElementException e) {
            node.setScore(heuristic.score(node.getBoard(), node.getElement()));
        }


    }

    private Node findBestChild(boolean isMaxPlayer, List<Node> children) {
        Comparator<Node> comparator = Comparator.comparing(Node::getScore);
        return children.stream()
                .max(isMaxPlayer ? comparator : comparator.reversed())
                .orElseThrow(NoSuchElementException::new);
    }

}
