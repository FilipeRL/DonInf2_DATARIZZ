public class InventoryCommand implements ICommand {
    @Override
    public String getKeyword() {
        return "inventory"; // ou "inv" si tu préfères une version courte
    }

    @Override
    public String getHelpText() {
        return "Affiche les objets dans votre inventaire.";
    }

    @Override
    public void execute(String args, Game game) {
        if (game.getPlayer().getItemInInventory().isEmpty()) {
            System.out.println("Votre inventaire est vide.");
        } else {
            System.out.println("Inventaire :");
            for (Item item : game.getPlayer().getItemInInventory()) {
                System.out.println("- " + item.getName() + ": " + item.getDescription());
            }
        }
    }
}
