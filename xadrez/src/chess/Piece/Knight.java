package chess.Piece;

import boardGame.Board;
import boardGame.Position;
import chess.Color;
import chess.chessPiece;

public class Knight extends chessPiece {
    public Knight(Board board, Color color) {
        super(board, color);
    }
    @Override
    public String toString( ){
        return "C";
    }

    private boolean canMove(Position position){
        chessPiece p = (chessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }
    @Override
    public boolean[][] possibleMove() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0,0);


        p.setValues(position.getRow() -1 , position.getColumn() - 2);
        if  (getBoard().positionExists(p) && canMove(p)) mat[p.getRow()][p.getColumn()] = true;


        p.setValues(position.getRow() -2 , position.getColumn() - 1);
        if  (getBoard().positionExists(p) && canMove(p)) mat[p.getRow()][p.getColumn()] = true;


        p.setValues(position.getRow() - 2, position.getColumn() +1 );
        if  (getBoard().positionExists(p) && canMove(p)) mat[p.getRow()][p.getColumn()] = true;


        p.setValues(position.getRow( ) - 1, position.getColumn() +2);
        if  (getBoard().positionExists(p) && canMove(p)) mat[p.getRow()][p.getColumn()] = true;


        p.setValues(position.getRow() +1, position.getColumn() +2);
        if  (getBoard().positionExists(p) && canMove(p)) mat[p.getRow()][p.getColumn()] = true;


        p.setValues(position.getRow() +2, position.getColumn() +1);
        if  (getBoard().positionExists(p) && canMove(p)) mat[p.getRow()][p.getColumn()] = true;


        p.setValues(position.getRow() +2, position.getColumn() -1);
        if  (getBoard().positionExists(p) && canMove(p)) mat[p.getRow()][p.getColumn()] = true;


        p.setValues(position.getRow() +1, position.getColumn() -2);
        if  (getBoard().positionExists(p) && canMove(p)) mat[p.getRow()][p.getColumn()] = true;

        return mat;
    }
}
