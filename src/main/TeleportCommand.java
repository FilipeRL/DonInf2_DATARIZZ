public class TeleportCommand implements ICommand {
    @Override
    public String getKeyword() {
        return "tp";
    }

    @Override
    public String getHelpText() {
        return "Téléporte le joueur à un lieu déjà visité. Usage : tp <nom-lieu>";
    }

    @Override
    public void execute(String args, Game game) {
        if (args == null || args.isEmpty()) {
            System.out.println("Usage : tp <nom-lieu>");
            return;
        }

        if (!game.getPlayer().hasItem("Cristal")) {
            System.out.println("Vous n’avez pas le cristal de téléportation.");
            return;
        }

        String destination = args.trim().toLowerCase();
        WorldMap map = game.getWorldMap();

        for (int r = 0; r < map.getRows(); r++) {
            for (int c = 0; c < map.getCols(); c++) {
                Location loc = map.getLocation(r, c);
                if (loc != null && loc.getName().toLowerCase().equals(destination)) {
                    if (!loc.isOpen()) {
                        System.out.println("Ce lieu est verrouillé.");
                        return;
                    }
                    if (!game.getPlayer().hasVisited(loc.getName())) {
                        System.out.println("Vous n'avez jamais visité cet endroit.");
                        return;
                    }

                    game.getPlayer().setPosition(r, c, game);
                    System.out.println("Téléportation réussie vers : " + loc.getName());
                    return;
                }
            }
        }

        System.out.println("Lieu introuvable.");
    }
}
