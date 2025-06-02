public class LookCommand implements ICommand {
    public String getKeyword() { return "look"; }

    public String getHelpText() {
        return "Affiche ce qu’il y a dans la zone actuelle (description + objets présents).";
    }

    public void execute(String args, Game game) {
        int r = game.getPlayer().getRow();
        int c = game.getPlayer().getCol();
        Location loc = game.getWorldMap().getLocation(r, c);

        System.out.println(loc.getDescription());

        // Liste les objets dans la salle
        if (!loc.getItems().isEmpty()) {
            System.out.println("Objets visibles dans cette zone :");
            for (Item item : loc.getItems()) {
                System.out.println("- " + item.getName() + ": " + item.getDescription());
            }
        } else {
            System.out.println("Il n'y a aucun objet ici.");
        }
    }
}
