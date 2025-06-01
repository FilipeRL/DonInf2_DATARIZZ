// InspectCommand.java
public class InspectCommand implements ICommand {
    @Override
    public String getKeyword() {
        return "inspect";
    }

    @Override
    public String getHelpText() {
        return "Inspecte un objet dans votre inventaire ou dans la zone actuelle.";
    }

    @Override
    public void execute(String args, Game game) {
        if (args.isEmpty()) {
            System.out.println("Usage: inspect <nom_objet>");
            return;
        }
        String itemName = args.toLowerCase();
        Item foundItem = null;

        // 1. Check player's inventory
        foundItem = game.getPlayer().getItemInInventory(itemName);

        // 2. If not found, check current location
        if (foundItem == null) {
            int r = game.getPlayer().getRow();
            int c = game.getPlayer().getCol();
            Location currentLocation = game.getWorldMap().getLocation(r, c);
            if (currentLocation != null) {
                for (Item item : currentLocation.getItems()) {
                    if (item.getName().toLowerCase().equals(itemName)) {
                        foundItem = item;
                        break;
                    }
                }
            }
        }

        if (foundItem != null) {
            System.out.println(foundItem.getName() + ": " + foundItem.getDescription());
        } else {
            System.out.println("Vous ne voyez ou n'avez pas de " + itemName + ".");
        }
    }
}