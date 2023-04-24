package io.github.reconsolidated.playerHandlers;

import io.github.reconsolidated.reversi.Board;
import io.github.reconsolidated.reversi.BoardElement;
import io.github.reconsolidated.reversi.Move;
import io.github.reconsolidated.reversi.PlayerHandler;

import java.util.List;
import java.util.Scanner;

public class HumanPlayerHandler implements PlayerHandler {
    Scanner in = new Scanner(System.in);

    @Override
    public Move getMove(Board board, BoardElement playerElement, List<Move> availableMoves) {

        List<Move> moves = board.getAvailableMoves(playerElement);
        while (true) {
            int i = 1;
            displayBoard(board);

            for (Move move : moves) {
                System.out.println(i + ". " + move);;
                i++;
            }
            System.out.println("Your move: ");
            String input = in.nextLine();
            try {
                int moveNumber = Integer.parseInt(input);
                if (moveNumber > 0 && moveNumber <= moves.size()) {
                    return moves.get(moveNumber - 1);
                } else {
                    System.out.println("Invalid move number");
                }
            } catch (NumberFormatException ignored) {}
        }

    }

    private void displayBoard(Board board) {
        BoardElement[][] array = board.getBoard();
        String header = "  0 1 2 3 4 5 6 7";
        System.out.println(header);
        for (int i = 0; i<8; i++) {
            StringBuilder currentLine = new StringBuilder((i) + " ");
            for (int j = 0; j<8; j++) {
                String ch = array[i][j].get();
                currentLine.append(ch).append(" ");
            }
            System.out.println(currentLine);
        }
    }
}
