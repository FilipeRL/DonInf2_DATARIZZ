public interface ICommand {
    
    String getKeyWord ();
    String getHelpText ();
    void execute (String arg Game game);

}