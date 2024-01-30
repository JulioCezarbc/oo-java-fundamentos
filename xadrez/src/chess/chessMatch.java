package chess;
import boardGame.Board;
import boardGame.Piece;
import boardGame.Position;
import chess.Piece.*;

import java.util.ArrayList;
import java.util.List;



public class chessMatch {
    private Board board;
    private int turn;
    private Color currentPlayer;
    private boolean check;
    private List<Piece> piecesOnTheBoard = new ArrayList<>();
    private List<Piece> capturedPieces = new ArrayList<>();
    private boolean checkMate;
    public chessMatch(){
        board = new Board(8,8);
        turn = 1;
        currentPlayer = Color.RED;
        initialSetup();
    }
    public boolean getCheck(){
        return check;
    }
    public boolean getCheckMate(){
        return checkMate;
    }
    public int getTurn(){
        return turn;
    }
    public Color getCurrentPlayer(){
        return currentPlayer;
    }

    public chessPiece [][] getPieces(){
        chessPiece[][] mat = new chessPiece[board.getRows()][board.getColumns()];
        for (int i=0; i<board.getRows(); i++){
            for (int j = 0; j<board.getColumns(); j++){
                mat[i][j] = (chessPiece) board.piece(i,j);
            }
        }
        return mat;
    }
    public boolean[][] possibleMoves(ChessPosition sourcePosition){
        Position position = sourcePosition.toPosition();
        validateSourcePosition(position);
        return board.piece(position).possibleMove();
    }
    public chessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition){
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        validateTargetPosition(source,target);
        Piece capturedPiece = makeMove(source, target);

        if (testCheck(currentPlayer)){
            undoMove(source,target,capturedPiece);
            throw new ChessException("Voce nao pode se colocar em check");
        }
        check = testCheck(opponent(currentPlayer));

        if (testCheckMate(opponent(currentPlayer))){
            checkMate = true;
        }
        else{
            nextTurn();
        }
        return (chessPiece) capturedPiece;
    }
    private void validateSourcePosition(Position position){
        if (!board.thereIsAPiece(position)) throw new ChessException("Não existe peça nesta posição! ");
        if (currentPlayer != ((chessPiece)board.piece(position)).getColor())
            throw new ChessException("A peça escolhida nao é sua");

        if (!board.piece(position).isThereAnyPossibleMove()) throw new ChessException("Não existe movimentos possiveis");
    }

    private void validateTargetPosition(Position source, Position target){
        if (!board.piece(source).possibleMove(target)){
            throw new ChessException("A peça escolhida nao pode ir para o destino selecionado");
        }
    }
    private Piece makeMove(Position source, Position target){
        chessPiece p = (chessPiece) board.removePiece(source);
        p.increaseMoveCount();
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p,target);

        if (capturedPiece != null) {
            piecesOnTheBoard.remove(capturedPiece);
            capturedPieces.add(capturedPiece);
        }
        //especial move
        if (p instanceof King && target.getColumn() == source.getColumn() +2){
            Position sourceT = new Position(source.getRow(), source.getColumn()+3);
            Position targetT = new Position(source.getRow(), source.getColumn()+1);
            chessPiece rook = (chessPiece)board.removePiece(sourceT);
            board.placePiece(rook, targetT);
            rook.increaseMoveCount();
        }
        //grande
        if (p instanceof King && target.getColumn() == source.getColumn() -2){
            Position sourceT = new Position(source.getRow(), source.getColumn()-4);
            Position targetT = new Position(source.getRow(), source.getColumn()-1);
            chessPiece rook = (chessPiece)board.removePiece(sourceT);
            board.placePiece(rook, targetT);
            rook.increaseMoveCount();
        }
        return capturedPiece;
    }

    private void undoMove(Position source,Position target, Piece capturedPiece){
        chessPiece p = (chessPiece) board.removePiece(target);
        p.decreaseMoveCount();
        board.placePiece(p, source);

        if (capturedPiece != null){
            board.placePiece(capturedPiece,target);
            capturedPieces.remove(capturedPiece);
            piecesOnTheBoard.add(capturedPiece);
        }
        //especial move
        if (p instanceof King && target.getColumn() == source.getColumn() +2){
            Position sourceT = new Position(source.getRow(), source.getColumn()+3);
            Position targetT = new Position(source.getRow(), source.getColumn()+1);
            chessPiece rook = (chessPiece)board.removePiece(targetT);
            board.placePiece(rook, sourceT);
            rook.decreaseMoveCount();

        }
        //grande
        if (p instanceof King && target.getColumn() == source.getColumn() -2){
            Position sourceT = new Position(source.getRow(), source.getColumn()-4);
            Position targetT = new Position(source.getRow(), source.getColumn()-1);
            chessPiece rook = (chessPiece)board.removePiece(targetT);
            board.placePiece(rook, sourceT);
            rook.decreaseMoveCount();

        }
    }
    private void nextTurn(){
        turn++;
        currentPlayer = (currentPlayer == Color.RED) ? Color.YELLOW : Color.RED;
    }
    private Color opponent(Color color){
        return (color ==Color.YELLOW) ? Color.RED : Color.YELLOW;
    }

    private chessPiece king(Color color){
        List<Piece> list = piecesOnTheBoard.stream().filter(x ->((chessPiece) x).getColor() == color).toList();
        for (Piece p : list){
            if (p instanceof King){
                return (chessPiece) p;
            }
        }
        throw new IllegalStateException("Não existe o rei " + color + " no tabuleiro! ");
    }
    private boolean testCheck(Color color) {
        Position kingPosition = king(color).getChessPosition().toPosition();
        List<Piece> opponentPiecs = piecesOnTheBoard.stream().filter(x -> ((chessPiece) x).getColor() == opponent(color)).toList();
        for (Piece p : opponentPiecs){
            boolean[][] mat = p.possibleMove();
            if (mat[kingPosition.getRow()][kingPosition.getColumn()]){
                return true;
            }
        }
        return false;
    }
    private boolean testCheckMate(Color color){
        if (!testCheck(color)){
            return false;
        }
        List<Piece> list = piecesOnTheBoard.stream().filter(x -> ((chessPiece)x).getColor() == color).toList();
        for (Piece p : list){
            boolean[][] mat = p.possibleMove();
            for (int i = 0; i<board.getRows(); i++){
                for (int j = 0; j<board.getColumns(); j++){
                    if (mat[i][j] ) {
                        Position source = ((chessPiece)p).getChessPosition().toPosition();
                        Position target = new Position(i,j);
                        Piece capturedPiece = makeMove(source,target);
                        boolean testCheck = testCheck(color);
                        undoMove(source,target,capturedPiece);
                        if (!testCheck){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
    private void placeNewPiece(char column, int row, chessPiece piece){
        board.placePiece(piece,new ChessPosition(column,row).toPosition());
        piecesOnTheBoard.add(piece);
    }
    private void initialSetup(){
        placeNewPiece('a', 1, new Rook(board,Color.RED));
        placeNewPiece('b', 1, new Knight(board,Color.RED));
        placeNewPiece('g', 1, new Knight(board,Color.RED));
        placeNewPiece('h', 1, new Rook(board,Color.RED));
        placeNewPiece('c', 1, new Bishop(board,Color.RED));
        placeNewPiece('f', 1, new Bishop(board,Color.RED));
        placeNewPiece('e', 1, new King(board,Color.RED, this));
        placeNewPiece('d', 1, new Queen(board,Color.RED));
        placeNewPiece('a',2, new Pawn(board,Color.RED));
        placeNewPiece('b',2, new Pawn(board,Color.RED));
        placeNewPiece('c',2, new Pawn(board,Color.RED));
        placeNewPiece('d',2, new Pawn(board,Color.RED));
        placeNewPiece('e',2, new Pawn(board,Color.RED));
        placeNewPiece('f',2, new Pawn(board,Color.RED));
        placeNewPiece('g',2, new Pawn(board,Color.RED));
        placeNewPiece('h',2, new Pawn(board,Color.RED));

        placeNewPiece('e', 8,new King(board,Color.YELLOW, this));
        placeNewPiece('d', 8,new Queen(board,Color.YELLOW));
        placeNewPiece('a', 8,new Rook(board,Color.YELLOW));
        placeNewPiece('b', 8,new Knight(board,Color.YELLOW));
        placeNewPiece('g', 8,new Knight(board,Color.YELLOW));
        placeNewPiece('c', 8,new Bishop(board,Color.YELLOW));
        placeNewPiece('f', 8,new Bishop(board,Color.YELLOW));
        placeNewPiece('h', 8,new Rook(board,Color.YELLOW));
        placeNewPiece('a',7, new Pawn(board,Color.YELLOW));
        placeNewPiece('b',7, new Pawn(board,Color.YELLOW));
        placeNewPiece('c',7, new Pawn(board,Color.YELLOW));
        placeNewPiece('d',7, new Pawn(board,Color.YELLOW));
        placeNewPiece('e',7, new Pawn(board,Color.YELLOW));
        placeNewPiece('f',7, new Pawn(board,Color.YELLOW));
        placeNewPiece('g',7, new Pawn(board,Color.YELLOW));
        placeNewPiece('h',7, new Pawn(board,Color.YELLOW));
    }
}
