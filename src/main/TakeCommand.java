import java.util.List;

public class TakeCommand implements ICommand {
    @Override
    public String getKeyword() {
        return "take";
    }

    @Override
    public String getHelpText() {
        return "Prend un objet dans la zone actuelle. Si aucun nom n'est donné, prend le premier objet trouvé.";
    }

    @Override
    public void execute(String args, Game game) {
        int r = game.getPlayer().getRow();
        int c = game.getPlayer().getCol();
        Location currentLocation = game.getWorldMap().getLocation(r, c);

        if (currentLocation == null) {
            System.out.println("Erreur: Impossible de déterminer votre emplacement actuel.");
            return;
        }

        Item itemToTake = null;

        if (args == null || args.trim().isEmpty()) {
            // Aucun nom spécifié : prendre le premier item
            List<Item> items = currentLocation.getItems();
            if (!items.isEmpty()) {
                itemToTake = items.get(0);
            } else {
                System.out.println("Il n'y a rien à prendre ici.");
                return;
            }
        } else {
            // Nom spécifié : chercher l’item correspondant
            String itemName = args.toLowerCase();
            for (Item item : currentLocation.getItems()) {
                if (item.getName().toLowerCase().equals(itemName)) {
                    itemToTake = item;
                    break;
                }
            }

            if (itemToTake == null) {
                System.out.println("Il n'y a pas de " + itemName + " ici.");
                return;
            }
        }

        // Prise de l’item
        currentLocation.removeItem(itemToTake);
        game.getPlayer().addItem(itemToTake);
        System.out.println("Vous avez pris le " + itemToTake.getName() + ".");
    }
}
