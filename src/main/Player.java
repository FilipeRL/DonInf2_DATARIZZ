import java.util.ArrayList;
import java.util.List;

public class Player {
    private int row;
    private int col;
    private List<Item> inventory = new ArrayList<>();

 
    public int getRow() { return row; }
    public int getCol() { return col; }
 
    public void setPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public List<Item> getInventory() {
    return inventory;
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