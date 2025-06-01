// Item.java
public class Item {
    private String name;
    private String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    /**
     * Default use action for an item. Can be overridden by subclasses.
     * @param game The current game instance.
     */
    public void use(Game game) {
        System.out.println("Vous ne pouvez pas utiliser " + name + " comme ça.");
    }
}