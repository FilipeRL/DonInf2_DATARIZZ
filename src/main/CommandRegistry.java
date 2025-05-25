import java.util.HashMap;

import java.util.Map;
 
public class CommandRegistry {

    private Map<String, ICommand> commands = new HashMap<>();
 
    public void registerCommand(String keyword, ICommand command) {

        commands.put(keyword.toLowerCase(), command);

    }
 
    public ICommand getCommand(String keyword) {

        return commands.get(keyword.toLowerCase());

    }
 
    public Map<String, ICommand> getAllCommands() {

        return commands.values();

    }

}
 