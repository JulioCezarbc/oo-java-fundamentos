package chess.Piece;

import boardGame.Board;
import boardGame.Position;
import chess.Color;
import chess.chessPiece;

public class Queen extends chessPiece {
    public Queen(Board board, Color color) {
        super(board, color);
    }
    @Override
    public String toString(){
        return "Q";
    }
    @Override
    public boolean[][] possibleMove() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p  = new Position(0,0);

        //cima
        p.setValues(position.getRow()-1, position.getColumn());
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat [p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow()-1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat [p.getRow()][p.getColumn()] = true;
        }

        //esquerda
        p.setValues(position.getRow(), position.getColumn() - 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat [p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn()-1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat [p.getRow()][p.getColumn()] = true;
        }

        //direita
        p.setValues(position.getRow(), position.getColumn() + 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat [p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn()+1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat [p.getRow()][p.getColumn()] = true;
        }

        //baixo
        p.setValues(position.getRow()+1, position.getColumn());
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat [p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow()+1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat [p.getRow()][p.getColumn()] = true;
        }
        //noroeste
        p.setValues(position.getRow()-1, position.getColumn() - 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat [p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() - 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat [p.getRow()][p.getColumn()] = true;
        }

        //nordeste
        p.setValues(position.getRow() -1 , position.getColumn() + 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat [p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() - 1, p.getColumn() + 1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat [p.getRow()][p.getColumn()] = true;
        }

        //sudeste
        p.setValues(position.getRow() + 1, position.getColumn() + 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat [p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow() + 1,p.getColumn()+1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat [p.getRow()][p.getColumn()] = true;
        }

        //sudoeste
        p.setValues(position.getRow()+1, position.getColumn() - 1);
        while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)){
            mat [p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow()+1, p.getColumn() -1);
        }
        if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
            mat [p.getRow()][p.getColumn()] = true;
        }

        return mat;
    }
}
