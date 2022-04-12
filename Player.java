public class Player {
    private String name;
    private int totalWins;
    private XOPiece.XO XOSelect;

    public Player(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getTotalWins() {
        return totalWins;
    }

    public void setTotalWins(int totalWins) {
        this.totalWins = totalWins;
    }

    public void setPlayerCode(XOPiece.XO XOChoice)
    {
        XOSelect = XOChoice;
    }

    public XOPiece getPlayerCode() {
        return new XOPiece(XOSelect);
    }

    public String toString() {
        String valueToReturn = "Name: " + this.name + "\t Total Wins:" + getTotalWins();
        return valueToReturn;
    }
}
