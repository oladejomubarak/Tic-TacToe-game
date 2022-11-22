package ticTacToe;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import static java.lang.System.exit;
import static ticTacToe.Mark.*;

public class TicTacToeMain {
    private static final Random random = new Random();
    private static final Scanner scanner = new Scanner(System.in);
    private static final Board board = new Board();
    private static final Player player1 = new Player(X);
    private static final Player player2 = new Player(O);
    public static void main(String[] args) {
        startGame();
    }

//    private static void startTicTacToe() {
//        startGame();
//    }

    private static void startGame() {
        boardSurfaceUpdate();
        prompt("""
                1- play with another player
                2- play with computer
                3- exit""");
        prompt("enter an option: ");
        int option= 0;
        try {
            prompt("enter a valid option: ");
            option+= scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.nextLine();
            startGame();

        }

        switch (option){
            case 1 : playWithAnotherPlayer();
            case 2 : playWithComputer();
            case 3: exit(3);
        }
    }

    private static void playWithComputer() {
        prompt("player 1 enter position");
        playerOneMove();
        prompt("player 2 enter position");
        computerMove();
        playWithComputer();
    }

    private static void computerMove() {

        try {
            int computerPosition = (1 + random.nextInt(9));
            player2.play(computerPosition, board);
            boardSurfaceUpdate();
            if(board.isAWinner()){
                prompt("computer wins");
                exit(3);
            }
            if(board.isATie()){
                prompt("is a deuce\nRestart game");
                exit(3);
            }
        } catch (TicTacToeException e) {
            prompt(e.getMessage());
            prompt("enter a valid number: ");
            computerMove();
        }
    }

    private static void boardSurfaceUpdate(){
        board.displayBoardSurface();
    }

    private static void playWithAnotherPlayer() {
        prompt("player 1, enter your position: ");
        playerOneMove();
        prompt("player 2, enter your position: ");
        playerTwoMove();
        playWithAnotherPlayer();
    }

    private static void playerTwoMove() {
        try {
            int playerTwoPosition = scanner.nextInt();
            player2.play(playerTwoPosition, board);
            boardSurfaceUpdate();
            if(board.isAWinner()){
                prompt("player 2 is a winner");
                exit(3);
            }
            if(board.isATie()){
                prompt("is a deuce\nRestart game");
                exit(3);
            }
        } catch (ArrayIndexOutOfBoundsException|InputMismatchException|TicTacToeException e) {
            prompt(e.getMessage());
            prompt("enter a valid number: ");
            scanner.nextLine();
            playerTwoMove();
        }
    }

    private static void playerOneMove() {
        try {
            int playerOnePosition = scanner.nextInt();
            player1.play(playerOnePosition, board);
            boardSurfaceUpdate();
            if(board.isAWinner()){
                prompt("player 1 is a winner");
                exit(3);
            }
            if(board.isATie()){
                prompt("It's a deuce\nRestart game");
                exit(3);
            }
        } catch (ArrayIndexOutOfBoundsException|InputMismatchException|TicTacToeException e) {
            prompt(e.getMessage());
            prompt("enter a valid number: ");
            scanner.nextLine();
            playerOneMove();
        }
    }

    private static void prompt(String promptMessage){
        System.out.println(promptMessage);
    }
//    private static int playerInput(){
//        prompt("enter position: ");
//        return scanner.nextInt();
//    }
}
