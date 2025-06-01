import utils.IPrintable;
import java.util.HashMap; // Needed for Map
import java.util.Map;     // Needed for Map
import java.util.List;    // Needed for List
import java.util.ArrayList; // Needed for ArrayList

public class Location implements IPrintable {

    private String name;
    private String description;
    private boolean open; // true if accessible, false if locked
    private Map<String, Location> exits; // e.g., "north" -> Location object // NEW
    private List<Item> items; // Items currently in this location           // NEW

    public Location(String name, String description, boolean open) {
        this.name = name;
        this.description = description;
        this.open = open;
        this.exits = new HashMap<>();     // NEW: Initialize exits
        this.items = new ArrayList<>();   // NEW: Initialize items
    }

    public String getName() { // NEW
        return name;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) { // NEW: Added for unlocking
        this.open = open;
    }

    public String getDescription() {
        return description;
    }

    // --- Exits Management --- // NEW METHODS BELOW
    public void addExit(String direction, Location destination) {
        exits.put(direction.toLowerCase(), destination);
    }

    public Location getExit(String direction) {
        return exits.get(direction.toLowerCase());
    }

    public Map<String, Location> getExits() {
        return exits;
    }

    // --- Item Management --- // NEW METHODS BELOW
    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) { // THIS IS THE METHOD THAT WAS LIKELY UNIMPLEMENTED
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    // --- Full Description for Look Command --- // NEW
    public String getFullDescription() {
        // ... (implementation as provided before) ...
        StringBuilder sb = new StringBuilder();
        sb.append(description).append("\n");

        if (!items.isEmpty()) {
            sb.append("Vous voyez: ");
            for (int i = 0; i < items.size(); i++) {
                sb.append(items.get(i).getName());
                if (i < items.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append(".\n");
        } else {
            sb.append("Il n'y a rien d'intéressant ici.\n");
        }

        if (!exits.isEmpty()) {
            sb.append("Sorties: ");
            sb.append(String.join(", ", exits.keySet()));
            sb.append(".\n");
        } else {
            sb.append("Il n'y a pas de sorties évidentes d'ici.\n");
        }
        return sb.toString();
    }


    // Implémentation de IPrintable :
    @Override
    public String getPrintableString() {
        return open ? "O" : "X";
    }

    @Override
    public boolean isGrayedOut() {
        return !open;
    }

    @Override
    public String toString() { // NEW
        return name;
    }
}