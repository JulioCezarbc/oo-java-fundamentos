package application;

import chess.ChessPosition;
import chess.Color;
import chess.chessMatch;
import chess.chessPiece;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class UI {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BLACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BLACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BLACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BLACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BLACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BLACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BLACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BLACKGROUND = "\u001B[47m";

    public static void clearScreen(){
        out.print("\033[H\033[2J");
        out.flush();
    }
    public static void printMatch(chessMatch chessMatch, List<chessPiece> captured){
        printBoard(chessMatch.getPieces());
        out.println();

        printCapturedPiece(captured);
        out.println();

        if (!chessMatch.getCheckMate()){
            out.println(ANSI_CYAN + "Turno: " + ANSI_PURPLE +chessMatch.getTurn() + ANSI_RESET);
            out.println(ANSI_CYAN + "esperando player: " +  ANSI_PURPLE + chessMatch.getCurrentPlayer() + ANSI_RESET);

            if (chessMatch.getCheck()){
                out.println(ANSI_CYAN + "Voce está em " + ANSI_GREEN + "CHECK" + ANSI_RESET );
             }
        }
        else {
            out.println(ANSI_GREEN + "CHECKMATE" + ANSI_RESET);
            out.println(ANSI_GREEN + "Vencedor: " + ANSI_RESET + chessMatch.getCurrentPlayer() );
        }
    }
    public static void printBoard(chessPiece[][] pieces){
        out.println(ANSI_PURPLE + "  a b c d e f g h" + ANSI_RESET);
        for (int i =0; i<pieces.length; i++){
            out.print(ANSI_PURPLE + (8-i) + " " + ANSI_RESET);
            for (int j = 0; j < pieces.length; j++){
                printPiece(pieces[i][j], false);
            }
            out.println();
        }
        out.println(ANSI_PURPLE + "  a b c d e f g h" + ANSI_RESET);
    }
    public static void printBoard(chessPiece[][] pieces, boolean[][] possibleMoves){
        out.println(ANSI_PURPLE + "  a b c d e f g h" + ANSI_RESET);
        for (int i =0; i<pieces.length; i++){
            out.print(ANSI_PURPLE + (8-i) + " " + ANSI_RESET);
            for (int j = 0; j < pieces.length; j++){
                printPiece(pieces[i][j], possibleMoves[i][j]);
            }
            out.println();
        }
        out.println(ANSI_PURPLE +  "  a b c d e f g h" + ANSI_RESET);
    }
    private static void printPiece(chessPiece piece, boolean background){
        if(background){
            out.print(ANSI_BLUE_BLACKGROUND);
        }else
            out.print(ANSI_RESET);

        if (piece == null){
            out.print("-" + ANSI_RESET);
        }
        else {
            if (piece.getColor() == Color.RED) out.print(ANSI_RED + piece + ANSI_RESET);
            else out.print(ANSI_YELLOW + piece + ANSI_RESET);
        }
        out.print(" ");
    }
    public static ChessPosition readChessPosition(Scanner entrada){
        try {
            String s = entrada.nextLine();
            char column = s.charAt(0);
            int row = Integer.parseInt(s.substring(1));
            return new ChessPosition(column,row);
    }catch (RuntimeException e) {
            throw new InputMismatchException(ANSI_CYAN + "error ao ler a posição! " + ANSI_RESET);
        }
    }
    private static void printCapturedPiece(List<chessPiece> captured){
        List<chessPiece> red = captured.stream().filter(x -> x.getColor() == Color.YELLOW).toList();
        List<chessPiece> yellow = captured.stream().filter(x -> x.getColor() == Color.RED).toList();

        out.println(ANSI_CYAN + "Peças capturadas: " + ANSI_RESET);

        out.print(ANSI_RED +"RED: ");
        out.print(ANSI_RED);
        out.println(Arrays.toString(red.toArray()));
        out.print(ANSI_RESET);

        out.print(ANSI_YELLOW +"YELLOW: ");
        out.print(ANSI_YELLOW);
        out.println(Arrays.toString(yellow.toArray()));
        out.print(ANSI_RESET);
    }
}
