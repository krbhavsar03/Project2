import java.util.Random;
import java.util.Scanner;

public class TicTacToe {


    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        int row, col;
        int n = 3; //Tic Tac Toe for 3x3
        boolean playAgain = true;
        int numberOfGamesPlayed = 1;
        Player player1, player2;
        XOPiece XOPieceToSetXO;
        boolean gameWon = false; //to handle the edge case when the last move of the game results in a win

        //Please enter Player 1 name
        System.out.print("Enter Player 1 name: ");
        player1 = new Player(scnr.next());
        //Lets give X or O at random...
        int select1 = new Random().nextInt(XOPiece.XO.values().length);

        XOPieceToSetXO = new XOPiece(XOPiece.XO.values()[select1]);

        player1.setPlayerCode(XOPiece.XO.values()[select1]);
        //Please enter Player 2 name
        System.out.print("Enter Player 2 name: ");
        player2 = new Player(scnr.next());

        int select2 = 0;
        if (select1 == 0) {
            select2 = 1;
        }
        player2.setPlayerCode(XOPiece.XO.values()[select2]);

        while (playAgain) {

            SquareBoard board = new SquareBoard(n, new XOPiece());
            board.displayIntroduction();
            board.printBoardCoordinates();
            System.out.println(board.toString());
            Player currentPlayer = player1;
            //Start with Player 1..
            System.out.println(player1.getName() + " turn now");
            boolean moveComplete = true;
            boolean switchPlayer = true;
            boolean gameDone;
            while (!board.checkBoardFull() && moveComplete) {
                System.out.print("Enter a row number: ");
                row = scnr.nextInt();
                System.out.print("Enter a column number: ");
                col = scnr.nextInt();
                if (row < 0 || col < 0 || row >= n || col >= n) {
                    System.out.println("This position is off the bounds of the board! Try again.");
                } else {
                    System.out.println(XOPieceToSetXO.toString());
                    board.getPiece(row, col);
                    if (!board.setPiece(XOPieceToSetXO, row, col)) {
                        switchPlayer = false;
                        System.out.println("The row, column value is already taken..");
                    }
                    else {
                        switchPlayer = true;
                    }
                    System.out.println(board.toString());
                    moveComplete = false;
                }
                moveComplete = true;
                gameDone = board.checkWin(currentPlayer, row, col);
                if (gameDone == true) {
                    System.out.println(currentPlayer.getName() + " Congratulations, you are winner");
                    gameWon = true;
                    currentPlayer.setTotalWins(currentPlayer.getTotalWins()+1);
                    break;
                }
                if (switchPlayer) {
                    if (currentPlayer == player1) {
                        System.out.println(player2.getName() + " turn now");
                        currentPlayer = player2;
                        XOPieceToSetXO = player2.getPlayerCode();
                    } else {
                        System.out.println(player1.getName() + " turn now");
                        currentPlayer = player1;
                        XOPieceToSetXO = player1.getPlayerCode();
                    }
                }
            }//Keep playing till Board is Full
            if (board.checkBoardFull() && !gameWon) {
                System.out.println("No one wins.");
            }
            System.out.println("The game is over...Want to replay? (y/n)");
            String readValue = scnr.next();
            if (readValue.equals("y")) {
                playAgain = true;
                numberOfGamesPlayed++;
            }
            else{
                System.out.println("Thank you for playing the Game:");
                System.out.println("The total number of Games Played: " + numberOfGamesPlayed);
                System.out.println("Player " + player1.getName() + " won " + player1.getTotalWins() + " games.");
                System.out.println("Player " + player2.getName() + " won " + player2.getTotalWins() + " games.");
                playAgain = false;
            }
        }

    }

}

