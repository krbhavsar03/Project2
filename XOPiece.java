public class XOPiece {


    /** enumerated type that dictates the two values of
     * tic tac toe
     */
    public static enum XO {X, O}
    public String choice = "";
    /** Constructor to hold an empty piece
     * that is neither X or O. An empty
     * piece should just display 3 spaces
     */
    public XOPiece()
    {
        this.choice = "   ";
    }

    /** Constructor that creates a piece for
     * the TicTacToe board -- either an X or O
     * See sample output.
     */
    public XOPiece(XO choice)
    {
         switch (choice) {
             case O: this.choice = "-O-";break;
             case X: this.choice = "-X-";break;
             default: this.choice = "---";break;
         }
    }

    public String toString()
    {
        String returnString = choice;
        /* What should your output String look like? */
        return returnString;
    }

    /** Method that checks if one XOPiece has the same XO value.
     * If the calling object has the same internal XO value as the
     * object sent as a formal parameter.
     */
    public boolean match (XOPiece piece)
    {
        return piece.toString() == this.choice;
    }

}
