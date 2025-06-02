public class Key extends Item {
    private String unlocksLocationName; // Le nom de la salle que la clé déverrouille

    public Key(String name, String description, String unlocksLocationName) {
        super(name, description);
        this.unlocksLocationName = unlocksLocationName.toLowerCase(); // Pour comparaison insensible à la casse
    }

    public String getUnlocksLocationName() {
        return unlocksLocationName;
    }

    @Override
    public void use(Game game) {
        WorldMap map = game.getWorldMap();
        Location locationToUnlock = null;

        // Recherche de la salle à déverrouiller
        for (int r = 0; r < map.getGrid().length; r++) {
            for (int c = 0; c < map.getGrid()[r].length; c++) {
                Location loc = (Location) map.getLocation(r, c); // Cast si nécessaire
                if (loc != null && loc.getName().toLowerCase().equals(unlocksLocationName)) {
                    locationToUnlock = loc;
                    break;
                }
            }
            if (locationToUnlock != null) break;
        }

        if (locationToUnlock == null) {
            System.out.println("Cette clé ne correspond à aucune salle connue.");
            return;
        }

        if (!locationToUnlock.isOpen()) {
            locationToUnlock.setOpen(true); // Ouvre la salle
            System.out.println("Vous avez utilisé la " + getName() + " et déverrouillé " + locationToUnlock.getName() + " !");
            game.getPlayer().removeItem(this); // Clé consommée
        } else {
            System.out.println(locationToUnlock.getName() + " est déjà déverrouillée.");
        }
    }
}
