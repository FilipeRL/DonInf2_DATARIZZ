import utils.IPrintable;
 
public class Location implements IPrintable {

    private String name;

    private String description;

    private boolean open;
 
    public Location(String name, String description, boolean open) {

        this.name = name;

        this.description = description;

        this.open = open;

    }
 
    public boolean isOpen() {

        return open;

    }
 
    public String getDescription() {

        return description;

    }
 
    // Implémentation de IPrintable :

    @Override

    public String getPrintableString() {

        return open ? "O" : "X";

    }
 
    @Override

    public boolean isGrayedOut() {

        return !open; // grisé si la zone est verrouillée

    }

    public void addItem(Item item) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addItem'");
    }

    public Item[] getItems() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getItems'");
    }

    public String getName() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getName'");
    }

    public void setOpen(boolean b) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setOpen'");
    }

    public void removeItem(Item itemToTake) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeItem'");
    }

}