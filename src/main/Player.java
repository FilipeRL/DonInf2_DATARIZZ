import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    private int row;
    private int col;
    private List<Item> inventory = new ArrayList<>();
    private Set<String> visited = new HashSet<>();

 
    public int getRow() { return row; }
    public int getCol() { return col; }
 
    public void setPosition(int row, int col, Game game) {
    this.row = row;
    this.col = col;

    Location loc = game.getWorldMap().getLocation(row, col);
    if (loc != null) {
        visited.add(loc.getName().toLowerCase());
    }
}

    public boolean hasVisited(String locationName) {
    return visited.contains(locationName.toLowerCase());
    }

    public boolean hasItem(String itemName) {
    for (Item item : inventory) {
        if (item.getName().equalsIgnoreCase(itemName)) return true;
    }
    return false;
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