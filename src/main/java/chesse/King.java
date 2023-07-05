package chesse;

import static chesse.HelperUser.checkPosition;

public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkPosition(line) && checkPosition(column) && checkPosition(toLine) && checkPosition(toColumn)) {
            if (Math.abs(line - toLine) > 1 || Math.abs(column - toColumn) > 1) return false;

            if (isUnderAttack(chessBoard, toLine, toColumn)) return false;

            if (chessBoard.board[toLine][toColumn] != null) {
                return !chessBoard.board[toLine][toColumn].getColor().equals(color);
            }

            return true;
        } else return false;
    }


    public boolean isUnderAttack(ChessBoard chessBoard, int line, int column) {
        boolean isUnderAttack = false;
        for (int i = 0; i < 8; i++ ){
            for(int j = 0; i < 8; i++){
                if(chessBoard.board[i][j] != null){
                    if(!(chessBoard.board[i][j].getColor().equals(color))){
                        if(chessBoard.board[i][j].canMoveToPosition(chessBoard, i, j, line, column)){
                            isUnderAttack = true;
                        }
                    }
                }
            }
        }
        return isUnderAttack;
    }

    @Override
    public String getSymbol() {
        return "K";
    }


}
