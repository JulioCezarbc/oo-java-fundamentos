package chess.Piece;

import boardGame.Board;
import boardGame.Position;
import chess.Color;
import chess.chessMatch;
import chess.chessPiece;

public class King extends chessPiece {
    private chessMatch chessMatch;
    public King(Board board, Color color, chessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString( ){
        return "K";
    }

    private boolean canMove(Position position){
        chessPiece p = (chessPiece) getBoard().piece(position);
        return p == null || p.getColor() != getColor();
    }

    private boolean testRook(Position position){
        chessPiece p = (chessPiece) getBoard().piece(position);
        return p!= null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() ==0;
    }

    @Override
    public boolean[][] possibleMove() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0,0);

        //cima
        p.setValues(position.getRow() -1 , position.getColumn());
        if  (getBoard().positionExists(p) && canMove(p)) mat[p.getRow()][p.getColumn()] = true;

        //abaixo
        p.setValues(position.getRow() +1 , position.getColumn());
        if  (getBoard().positionExists(p) && canMove(p)) mat[p.getRow()][p.getColumn()] = true;

        //esquerda
        p.setValues(position.getRow(), position.getColumn() -1 );
        if  (getBoard().positionExists(p) && canMove(p)) mat[p.getRow()][p.getColumn()] = true;

        //direita

        p.setValues(position.getRow(), position.getColumn() +1);
        if  (getBoard().positionExists(p) && canMove(p)) mat[p.getRow()][p.getColumn()] = true;

        //noroeste
        p.setValues(position.getRow() -1, position.getColumn() -1);
        if  (getBoard().positionExists(p) && canMove(p)) mat[p.getRow()][p.getColumn()] = true;

        //nordeste
        p.setValues(position.getRow() -1, position.getColumn() +1);
        if  (getBoard().positionExists(p) && canMove(p)) mat[p.getRow()][p.getColumn()] = true;

        //sudoeste
        p.setValues(position.getRow() +1, position.getColumn() -1);
        if  (getBoard().positionExists(p) && canMove(p)) mat[p.getRow()][p.getColumn()] = true;

        //especial move
        if (getMoveCount() == 0 && !chessMatch.getCheck()){
            //rook pqno
            Position postT1 = new Position(position.getRow(), position.getColumn()+3);
            if (testRook(postT1)){
                Position p1 = new Position(position.getRow(), position.getColumn()+1);
                Position p2 = new Position(position.getRow(), position.getColumn()+2);
                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null){
                    mat[position.getRow()][position.getColumn()+2 ] = true;
                }
            }
            //rook grande
            Position postT2 = new Position(position.getRow(), position.getColumn() - 4);
            if (testRook(postT2)){
                Position p1 = new Position(position.getRow(), position.getColumn()-1);
                Position p2 = new Position(position.getRow(), position.getColumn()-2);
                Position p3 = new Position(position.getRow(), position.getColumn()-3);

                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null){
                    mat[position.getRow()][position.getColumn() -2 ] = true;
                }
            }
        }

        //sudeste
        p.setValues(position.getRow() +1, position.getColumn() +1);
        if  (getBoard().positionExists(p) && canMove(p)) mat[p.getRow()][p.getColumn()] = true;

        return mat;
    }
}
