public class Player {
    private int row;
    private int col;
 
    public int getRow() { return row; }
    public int getCol() { return col; }
 
    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }
}