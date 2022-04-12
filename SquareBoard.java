public class SquareBoard {
    int size;
    XOPiece[][] board;


    /**
     * Constructor that creates an n x n board of
     * XOPieces and each XOPiece is set to an initial Token
     */
    public SquareBoard(int n, XOPiece e)
    {
        board = new XOPiece[n][n];
        size = n;
        for (int i = 0; i < n; i++){
            for (int j= 0; j < n ; j++) {
                board[i][j] = e;
            }
        }

    }

    /**
     * String representation of the board
     * showing the contents of each space
     */
    public String toString()
    {
        /* FIX ME */
        String valueToPrint = new String();
        for (int i = 0; i < board.length; i++){
            for (int j= 0; j < board[i].length ; j++) {
                valueToPrint += "["+ board[i][j] + "] ";
            }
            valueToPrint += "\n";
        }
        return valueToPrint;
    }

    /**
     * Method that prints out the board with
     * the coordinates of each slot
     * to show the users how to identify each slot
     */
    public void printBoardCoordinates()
    {
        for (int i=0; i<board.length; i++)
        {
            for (int j=0; j<board[i].length; j++)
            {
                System.out.print("["+i+","+j+"] ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Sets a Token on the board with coordinates (i,j)
     */
    public boolean setPiece(XOPiece t, int i, int j)
    {
        /* To check if value already existing */
        XOPiece isAlreadySet = getPiece(i,j);
        if (isAlreadySet.toString() == "   ")
        {
            board[i][j] = t;
            return true;}
        else
            return false;
    }

    /**
     * Gets an item on the board with coordinates (i,j)
     */
    public XOPiece getPiece(int i, int j)
    {
        return board[i][j];
    }

    /**
     * Check if the board is full
     */
    public boolean checkBoardFull(){
        boolean isBoardFull = true;
        for (int i=0; i<board.length; i++)
        {
            for (int j=0; j<board[i].length; j++)
            {
                if (getPiece(i,j).toString() == "   ")
                    isBoardFull = false;
            }
        }
        return isBoardFull;
    }
    public void displayIntroduction()
    {
        System.out.println("Welcome to Tic-Tac-Toe classic game..");
        System.out.println("The game is played on board 3x3, with 2 players.");
        System.out.println("Will take 2 players name, and will start selecting each player in order");
        System.out.println("The player needs to select the coordinates, the coordinates will be displayed first for the user to see the location");

    }

    public boolean checkWin(Player currentPlayer,int row, int col){
        //Logic to check the board winner....
        XOPiece playerXO = currentPlayer.getPlayerCode();
        //row check
        for (int i = 0; i < 3; i++)
            if (match(board[0][i], board[1][i]) && match(board[1][i], board[2][i]))
                return true;
        //column check
        for (int i = 0; i < 3; i++)
            if (match(board[i][0], board[i][1]) && match(board[i][1], board[i][2]))
                    return true;
        //Diagonal 1 check
        if (match(board[0][0],board[1][1]) && match(board[1][1],board[2][2]))
            return true;
        //Diagonal 1 check
        if (match(board[2][0],board[1][1]) && match(board[1][1],board[0][2]))
            return true;
        return false;
    }

    public boolean match (XOPiece piece1,XOPiece piece2 )
    {
        if ((piece1.toString() == piece2.toString()) && (piece1.toString() != "   "))
            return true;
        else
            return false;
    }
}
