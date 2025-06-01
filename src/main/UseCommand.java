// UseCommand.java

public class UseCommand implements ICommand {
    @Override
    public String getKeyword() {
        return "use";
    }

    @Override
    public String getHelpText() {
        return "Utilise un objet de votre inventaire (e.g., use key).";
    }

    @Override
    public void execute(String args, Game game) {
        if (args.isEmpty()) {
            System.out.println("Usage: use <nom_objet>");
            return;
        }
        String itemName = args.toLowerCase();
        Item itemToUse = game.getPlayer().getItemInInventory(itemName);

        if (itemToUse != null) {
            itemToUse.use(game); // Polymorphic call to the item's use method
        } else {
            System.out.println("Vous n'avez pas de " + itemName + " dans votre inventaire.");
        }
    }
}