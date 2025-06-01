// TakeCommand.java
import java.util.List;

public class TakeCommand implements ICommand {
    @Override
    public String getKeyword() {
        return "take";
    }

    @Override
    public String getHelpText() {
        return "Prend un objet de la zone actuelle.";
    }

    @Override
    public void execute(String args, Game game) {
        if (args.isEmpty()) {
            System.out.println("Usage: take <nom_objet>");
            return;
        }
        String itemName = args.toLowerCase();
        
        // Get current player location
        int r = game.getPlayer().getRow();
        int c = game.getPlayer().getCol();
        Location currentLocation = game.getWorldMap().getLocation(r, c);

        if (currentLocation == null) {
            System.out.println("Erreur: Impossible de déterminer votre emplacement actuel.");
            return;
        }

        Item itemToTake = null;
        for (Item item : currentLocation.getItems()) {
            if (item.getName().toLowerCase().equals(itemName)) {
                itemToTake = item;
                break;
            }
        }

        if (itemToTake != null) {
            currentLocation.removeItem(itemToTake);
            game.getPlayer().addItem(itemToTake);
            System.out.println("Vous avez pris le " + itemToTake.getName() + ".");
        } else {
            System.out.println("Il n'y a pas de " + itemName + " ici.");
        }
    }
}