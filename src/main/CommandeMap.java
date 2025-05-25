import utils.Array2DPrinter;
 
public class MapCommand implements ICommand {
    public String getKeyword() { return "map"; }
    public String getHelpText() { return "Affiche la carte du monde."; }
 
    public void execute(String args, Game game) {
        Array2DPrinter.print2DArray(game.getWorldMap().getGrid());
    }
}