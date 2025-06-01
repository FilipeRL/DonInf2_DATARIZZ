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

        // Game.java (inside init() method)
// ... existing location definitions and player.setPosition ...

// Add items to locations
map.getLocation(0, 0).addItem(new Item("Tapis", "Un vieux tapis poussiéreux."));
map.getLocation(1, 0).addItem(new Key("CléRouillée", "Une clé rouillée. Elle pourrait ouvrir la cave.", "cave")); // Assuming "Cave" is at 0,2
map.getLocation(1, 0).addItem(new Item("Lampe", "Une lampe à huile éteinte."));
// Add more items to other locations as desired

// Register new commands
registry.registerCommand(new TakeCommand());
registry.registerCommand(new InspectCommand());
registry.registerCommand(new UseCommand());
registry.registerCommand(new HelpCommand(registry));
registry.registerCommand(new MapCommand());
registry.registerCommand(new MoveCommand());

// ... existing System.out.println ...
 
        System.out.println("Bienvenue ! Tapez 'help' pour la liste des commandes.");
    }
 
    public Player getPlayer() { return player; }
    public WorldMap getWorldMap() { return map; }
    public CommandRegistry getRegistry() { return registry; }
}