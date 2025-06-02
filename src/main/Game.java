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


// Création de la récompense
Key cleEnigme = new Key("CléEnigme", "Une clé mystérieuse obtenue après avoir résolu une énigme.", "cuisine");

// Création de l'énigme
Enigme enigme = new Enigme(
    "Je suis toujours là, parfois brillante, parfois pâle, je veille sur la nuit. Qui suis-je ?",
    "la lune",
    cleEnigme
);

// Création de la lettre contenant l'énigme
Letter lettre = new Letter("Lettre Lunaire", "Une lettre contenant une énigme étrange.", enigme);


// Add items to locations
    map.getLocation(0, 0).addItem(lettre); 
// Bureau par exemple// Add more items to other locations as desired

// Register new commands
registry.registerCommand(new ResolveCommand());
registry.registerCommand(new TakeCommand());
registry.registerCommand(new InspectCommand());
registry.registerCommand(new UseCommand());
registry.registerCommand(new HelpCommand(registry));
registry.registerCommand(new MapCommand());
registry.registerCommand(new MoveCommand());
registry.registerCommand(new LookCommand());

// ... existing System.out.println ...
 
        System.out.println("Bienvenue ! Tapez 'help' pour la liste des commandes.");
    }
 
    public Player getPlayer() { return player; }
    public WorldMap getWorldMap() { return map; }
    public CommandRegistry getRegistry() { return registry; }
}