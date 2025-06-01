import utils.Array2Dprinter; // Note the lowercase 'p'

public class MapCommand implements ICommand {
    public String getKeyword() { return "map"; }
    public String getHelpText() { return "Affiche la carte du monde."; }

    public void execute(String args, Game game) {
        int playerRow = game.getPlayer().getRow();
        int playerCol = game.getPlayer().getCol();

        // Call print2DArray with highlight coordinates and then print the result
        String mapString = Array2Dprinter.print2DArray(game.getWorldMap().getGrid(), playerRow, playerCol);
        System.out.println(mapString);
    }
}