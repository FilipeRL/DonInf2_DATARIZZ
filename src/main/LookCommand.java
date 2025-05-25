public class LookCommand implements ICommand {
    public String getKeyword() { return "look"; }
    public String getHelpText() { return "Affiche ce qu’il y a dans la zone actuelle."; }
 
    public void execute(String args, Game game) {
        int r = game.getPlayer().getRow();
        int c = game.getPlayer().getCol();
        Location loc = game.getWorldMap().getLocation(r, c);
        System.out.println(loc.getDescription());
    }
}