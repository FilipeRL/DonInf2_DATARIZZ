import java.util.*;
 
public class CommandRegistry {
    private Map<String, ICommand> commands = new HashMap<>();
 
    public void registerCommand(ICommand cmd) {
        commands.put(cmd.getKeyword(), cmd);
    }
 
    public ICommand getCommand(String keyword) {
        return commands.get(keyword);
    }
 
    public Collection<ICommand> getAllCommands() {
        return commands.values();
    }
}