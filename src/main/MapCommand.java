import utils.Array2Dprinter;
 
public class MapCommand implements ICommand {
    public String getKeyword() { return "map"; }
    public String getHelpText() { return "Affiche la carte du monde."; }
 
    public void execute(String args, Game game) {
        Array2Dprinter.print2DArray(game.getWorldMap().getGrid(), 0, 0);
    }
}