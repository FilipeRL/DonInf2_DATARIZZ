public class MoveCommand implements ICommand {
    public String getKeyword() { return "move"; }
    public String getHelpText() { return "Déplace le joueur (north, south, east, west)"; }
 
    public void execute(String args, Game game) {
        int r = game.getPlayer().getRow();
        int c = game.getPlayer().getCol();
        switch (args.toLowerCase()) {
            case "north": r--; break;
            case "south": r++; break;
            case "east":  c++; break;
            case "west":  c--; break;
            default:
                System.out.println("Direction inconnue.");
                return;
        }
        Location next = game.getWorldMap().getLocation(r, c);
        if (next == null) {
            System.out.println("impossible to move there");
        } else if (!next.isOpen()) {
            System.out.println("zone locked");
        } else {
            game.getPlayer().setPosition(r, c, game);
            System.out.println(next.getDescription());
        }
    }
}