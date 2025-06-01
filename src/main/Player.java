public class Player {
    private int row;
    private int col;
 
    public int getRow() { return row; }
    public int getCol() { return col; }
 
    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }
    public Item getItemInInventory(String itemName) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getItemInInventory'");
    }
    public void removeItem(Key key) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeItem'");
    }
    public void addItem(Item itemToTake) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addItem'");
    }
}