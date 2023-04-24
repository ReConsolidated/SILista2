package io.github.reconsolidated.reversi;

import java.util.List;

public class ReversiGame {
    private final Player player1;
    private final Player player2;

    private Board currentBoard = new Board();

    public ReversiGame(PlayerHandler player1Handler, PlayerHandler player2Handler) {
        player1 = new Player(BoardElement.PLAYER1, player1Handler);
        player2 = new Player(BoardElement.PLAYER2, player2Handler);
    }

    public void start() {
        int i = 0;
        while (!currentBoard.isFinished()) {
            if (i%2 == 0) {
                List<Move> availableMoves = currentBoard.getAvailableMoves(BoardElement.PLAYER1);
                if (availableMoves.isEmpty()) {
                    break;
                }
                makeMove(player1, availableMoves);
            } else {
                List<Move> availableMoves = currentBoard.getAvailableMoves(BoardElement.PLAYER2);
                if (availableMoves.isEmpty()) {
                    break;
                }
                makeMove(player2, availableMoves);
            }
            i++;
        }
        System.out.println("Game over!");
        BoardElement winnerElement = currentBoard.getWinner();
        System.out.println(winnerElement.name() + " wins!");
    }

    private void makeMove(Player player, List<Move> availableMoves) {
        Move move = player.getMove(currentBoard, availableMoves);
        currentBoard = update(move.getBoardAfterMove());
    }

    private Board update(Board boardAfterMove) {
        return boardAfterMove;
    }
}
