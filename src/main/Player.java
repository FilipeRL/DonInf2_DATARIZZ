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

    public List<Item> getItemInInventory() {
    return inventory;
    }

    public void addItem(Item item) {
    inventory.add(item);
    }

    public void removeItem(Item item) {
    inventory.remove(item);
    }
    
    public Item getItemInInventory(String name) {
    for (Item item : inventory) {
        if (item.getName().toLowerCase().equals(name.toLowerCase())) {
            return item;
        }
    }
    return null;
}
}