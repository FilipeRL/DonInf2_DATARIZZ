public class Game {
    private Player player;
    private WorldMap map;
    private CommandRegistry registry;
 
    public Game() {
        player = new Player();
        map = new WorldMap(3, 3);
        registry = new CommandRegistry();
    }
 
    public void init() {
        map.addLocation(new Location("Entrée", "Vous êtes à l’entrée.", true), 0, 0);
        map.addLocation(new Location("Hall", "Un grand hall poussiéreux.", true), 0, 1);
        map.addLocation(new Location("Cave", "Une cave sombre et verrouillée.", false), 0, 2);
        map.addLocation(new Location("Salon", "Un salon confortable.", true), 1, 0);
        map.addLocation(new Location("Cuisine", "Une cuisine abandonnée.", false), 1, 1);
        map.addLocation(new Location("Bureau", "Un bureau silencieux.", true), 1, 2);
 
        player.setPosition(0, 0);
 
        registry.registerCommand(new MoveCommand());
        registry.registerCommand(new MapCommand());
        registry.registerCommand(new LookCommand());
        registry.registerCommand(new HelpCommand(registry));
 
        System.out.println("Bienvenue ! Tapez 'help' pour la liste des commandes.");
    }
 
    public Player getPlayer() { return player; }
    public WorldMap getWorldMap() { return map; }
    public CommandRegistry getRegistry() { return registry; }
}