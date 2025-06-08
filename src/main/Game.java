public class Game {
    private Player player;
    private WorldMap map;
    private CommandRegistry registry;
    private SaveSystem saveSystem;
 
    public Game(SaveSystem saveSystem) {
        this.saveSystem = saveSystem;
        this.player = new Player();
        this.map = new WorldMap(4, 3);
        this.registry = new CommandRegistry();
    }
 
    public void init() {
        map.addLocation(new Location("Entree", "Vous êtes à l’entrée.", true), 0, 0);
        map.addLocation(new Location("Hall", "Un grand hall poussiéreux.", true), 0, 1);
        map.addLocation(new Location("Cave", "Une cave sombre et verrouillée.", false), 0, 2);
        map.addLocation(new Location("Salon", "Un salon confortable.", true), 1, 0);
        map.addLocation(new Location("Cuisine", "Une cuisine abandonnée.", false), 1, 1);
        map.addLocation(new Location("Bureau", "Un bureau silencieux.", true), 1, 2);
        map.addLocation(new Location("Bibliotheque", "Une vieille bibliothèque pleine de livres poussiéreux.", true), 2, 0);
        map.addLocation(new Location("Laboratoire", "Un ancien laboratoire, des fioles traînent encore.", false), 2, 1);
        map.addLocation(new Location("Jardin", "Un petit jardin intérieur, calme et verdoyant.", true), 2, 2);
        map.addLocation(new Location("Grenier", "Un grenier sombre, plein de toiles d’araignée.", false),3, 0);
        map.addLocation(new Location("Chambre", "Une chambre abandonnée, le lit est encore fait.",  true), 3,  1);
        map.addLocation(new Location("Observatoire", "Une grande pièce avec un télescope pointé vers le ciel.", true),  3,  2);

 
        player.setPosition(0, 0, this);


// Création de la récompense
Key cleEnigme = new Key("CleEnigme", "Une clé mystérieuse obtenue après avoir résolu une énigme.", "cuisine");
Key cleFeu = new Key("CleFlamme", "Une clé brûlante, chaude au toucher.", "grenier");
Key cleTemps = new Key("CleDuTemps", "Une clé ancienne marquée d'une horloge.", "Laboratoire");
Key cleOmbre = new Key("CleOmbre", "Une clé noire, presque invisible dans la lumière.", "cave");

// Création de l'énigme
Enigme enigmelettre = new Enigme(
    "Je suis toujours là, parfois brillante, parfois pâle, je veille sur la nuit. Qui suis-je ?",
    "la lune",
    cleEnigme
);

Enigme enigmeFeu = new Enigme(
    "Je danse sans pieds, je m’élève sans ailes, je peux tout détruire ou réchauffer. Qui suis-je ?",
    "le feu",
    cleFeu
);

Enigme enigmeTemps = new Enigme(
    "Je ne peux être vu, mais je fais vieillir tout ce que je touche. Je cours sans jambes. Qui suis-je ?",
    "le temps",
    cleTemps
);

Enigme enigmeOmbre = new Enigme(
    "Je te suis partout, mais je disparais dans l'obscurité totale. Qui suis-je ?",
    "l'ombre",
    cleOmbre
);




// Création de la lettre contenant l'énigme
Letter lettre = new Letter("Lettre Lunaire", "Une lettre contenant une énigme étrange.", enigmelettre);
Letter lettreFeu = new Letter("LettreFlamme", "Une lettre brûlée sur les bords.", enigmeFeu);
Letter lettreTemps = new Letter("LettreDuTemps", "Une lettre ancienne avec une horloge dessinée.", enigmeTemps);
Letter lettreOmbre = new Letter("LettreOmbre", "Une lettre noire à peine lisible.", enigmeOmbre);


// Add items to locations
    map.getLocation(0, 0).addItem(lettre); 
    map.getLocation(1, 0).addItem(lettreFeu); 
    map.getLocation(0, 2).addItem(lettreTemps); 
    map.getLocation(3, 2).addItem(lettreOmbre);
    map.getLocation(0, 0).addItem(new TeleportCrystal()); // Jardin ou autre zone


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
registry.registerCommand(new InventoryCommand());
registry.registerCommand(new SaveCommand());
registry.registerCommand(new TeleportCommand());



// ... existing System.out.println ...
 
        System.out.println("Bienvenue ! Tapez 'help' pour la liste des commandes.");
    }

    public void runCommand(String line, boolean record) {
    String[] parts = line.split(" ", 2);
    String keyword = parts[0];
    String args = parts.length > 1 ? parts[1] : "";

    ICommand command = registry.getCommand(keyword);
    if (command != null) {
        command.execute(args, this);
        if (record && !keyword.equals("save")) {
            saveSystem.record(line);
            }
        } else {
        System.out.println("Commande inconnue.");
        }
    }

    public SaveSystem getSaveSystem() { return saveSystem; }
    public Player getPlayer() { return player; }
    public WorldMap getWorldMap() { return map; }
    public CommandRegistry getRegistry() { return registry; }
}