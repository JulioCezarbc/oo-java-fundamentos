package application;

import chess.ChessException;
import chess.ChessPosition;
import chess.chessMatch;
import chess.chessPiece;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        chessMatch chessMatch = new chessMatch();
        List<chessPiece> captured = new ArrayList<>();

        while (!chessMatch.getCheckMate()){
            try {
                UI.clearScreen();
                UI.printMatch(chessMatch, captured);
                System.out.println();
                System.out.print(UI.ANSI_CYAN + "Source: " + UI.ANSI_RESET);
                ChessPosition source = UI.readChessPosition(entrada);

                boolean[][] possibleMoves = chessMatch.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(chessMatch.getPieces(), possibleMoves);

                System.out.println();
                System.out.print(UI.ANSI_CYAN + "Target: " + UI.ANSI_RESET);
                ChessPosition target = UI.readChessPosition(entrada);

                chessPiece capturedPiece = chessMatch.performChessMove(source, target);

                if (capturedPiece != null) captured.add(capturedPiece);
            }
            catch (ChessException | InputMismatchException e ){
                System.out.println(e.getMessage());
                entrada.nextLine();
            }
        }
        UI.printMatch(chessMatch,captured);
    }
}
