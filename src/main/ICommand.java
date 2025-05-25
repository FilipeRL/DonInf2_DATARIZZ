public interface ICommand {
    String getKeyword();
    String getHelpText();
    void execute(String args, Game game);
}