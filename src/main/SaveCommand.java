public class SaveCommand implements ICommand {
    public String getKeyword() { return "save"; }
    public String getHelpText() { return "Sauvegarde la partie."; }

    public void execute(String args, Game game) {
        game.getSaveSystem().save();
    }
}

