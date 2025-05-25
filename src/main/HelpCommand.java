public class HelpCommand implements ICommand {
    private CommandRegistry registry;
    public HelpCommand(CommandRegistry registry) {
        this.registry = registry;
    }
    public String getKeyword() { return "help"; }
    public String getHelpText() { return "Liste les commandes disponibles."; }
 
    public void execute(String args, Game game) {
        for (ICommand cmd : registry.getAllCommands()) {
            System.out.println(cmd.getKeyword() + " - " + cmd.getHelpText());
        }
    }
}