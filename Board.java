package ticTacToe;

import static ticTacToe.Mark.*;

public class Board {
    private Mark[][] boardSurface = {{E, E, E}, {E, E, E}, {E, E, E}};

    public Board() {
    }

    public void displayBoardSurface() {
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(" ");
                System.out.print(boardSurface[i][j]);
                System.out.print(" ");
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public Mark[][] getBoardSurface() {
        return boardSurface;
    }

   private  boolean isWinnerOnRowZero() {
        boolean isX = boardSurface[0][0] == X && boardSurface[0][1] == X && boardSurface[0][2] == X;
        boolean isO = boardSurface[0][0] == O && boardSurface[0][1] == O && boardSurface[0][2] == O;
        if (isX || isO){return  true;}
        else {return false;}

    }
    private boolean isWinnerOnRowOne() {
        boolean isX = boardSurface[1][0] == X && boardSurface[1][1] == X && boardSurface[1][2] == X;
        boolean isO = boardSurface[1][0] == O && boardSurface[1][1] == O && boardSurface[1][2] == O;
        if (isX || isO){return  true;}
        else {return false;}

    }
   private boolean isWinnerOnRowTwo() {
        boolean isX = boardSurface[2][0] == X && boardSurface[2][1] == X && boardSurface[2][2] == X;
        boolean isO = boardSurface[2][0] == O && boardSurface[2][1] == O && boardSurface[2][2] == O;
        if (isX || isO){return  true;}
        else {return false;}
    }
    private boolean isWinnerOnColumnZero() {
        boolean isX = boardSurface[0][0] == X && boardSurface[1][0] == X && boardSurface[2][0] == X;
        boolean isO = boardSurface[0][0] == O && boardSurface[1][0] == O && boardSurface[2][0] == O;
        if (isX || isO){return  true;}
        else {return false;}

    }
   private boolean isWinnerOnColumnOne() {
        boolean isX = boardSurface[0][1] == X && boardSurface[1][1] == X && boardSurface[2][1] == X;
        boolean isO = boardSurface[0][1] == O && boardSurface[1][1] == O && boardSurface[2][1] == O;
        if (isX || isO) {
            return true;
        } else {
            return false;
        }

    }
   private boolean isWinnerOnColumnTwo() {
        boolean isX = boardSurface[0][2] == X && boardSurface[1][2] == X && boardSurface[2][2] == X;
        boolean isO = boardSurface[0][2] == O && boardSurface[1][2] == O && boardSurface[2][2] == O;
        if (isX || isO) {
            return true;
        } else {
            return false;
        }

    }
    private boolean isWinnerOnRowODiagonal() {
        boolean isX = boardSurface[0][0] == X && boardSurface[1][1] == X && boardSurface[2][2] == X;
        boolean isO = boardSurface[0][0] == O && boardSurface[1][1] == O && boardSurface[2][2] == O;
        if (isX || isO) {
            return true;
        } else {
            return false;
        }

    }
   private boolean isWinnerOnRow2Diagonal() {
        boolean isX = boardSurface[2][0] == X && boardSurface[1][1] == X && boardSurface[0][2] == X;
        boolean isO = boardSurface[2][0] == O && boardSurface[1][1] == O && boardSurface[0][2] == O;
        if (isX || isO) {
            return true;
        } else {
            return false;
        }

    }
    public boolean isAWinner(){

        if(isWinnerOnRowZero()){ return true;}
        else if (isWinnerOnRowOne()){ return true;}
        else if(isWinnerOnRowTwo()){ return true;}
        else if(isWinnerOnColumnZero()) {return true;}
        else if(isWinnerOnColumnOne()) {return true;}
        else if(isWinnerOnColumnTwo()){ return true;}
        else if(isWinnerOnRowODiagonal()){ return true;}
        else if(isWinnerOnRow2Diagonal()) {return true;}
        else {
            return false;
        }
    }
    private  boolean isCellEmpty(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(boardSurface[i][j]== E){
                    return true;
                }

            }

        }return false;
    }


    public boolean isATie() {
        if (!isCellEmpty() && !isAWinner()) {return true;}
        else{
            return false;
        }

    }
}