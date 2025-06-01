// Key.java
// Make sure this is in the same package as Item, or import Item appropriately
public class Key extends Item {
    private String unlocksLocationName; // The name of the location this key unlocks

    public Key(String name, String description, String unlocksLocationName) {
        super(name, description);
        this.unlocksLocationName = unlocksLocationName.toLowerCase(); // Store lowercase for easy comparison
    }

    public String getUnlocksLocationName() {
        return unlocksLocationName;
    }

    @Override
    public void use(Game game) {
        // Find the location by name in the WorldMap
        Location locationToUnlock = null;
        WorldMap map = game.getWorldMap();
        for (int r = 0; r < map.getGrid().length; r++) {
            for (int c = 0; c < map.getGrid()[r].length; c++) {
                Location loc = (Location) map.getLocation(r, c); // Cast needed as getGrid() returns IPrintable
                if (loc != null && loc.getName().toLowerCase().equals(unlocksLocationName)) {
                    locationToUnlock = loc;
                    break;
                }
            }
            if (locationToUnlock != null) break;
        }


        if (locationToUnlock != null && !locationToUnlock.isOpen()) {
            locationToUnlock.setOpen(true); // Unlock the zone
            System.out.println("Vous avez utilisé la " + getName() + " et déverrouillé " + locationToUnlock.getName() + " !");
            game.getPlayer().removeItem(this); // Key is consumed after use
        } else if (locationToUnlock != null && locationToUnlock.isOpen()) {
            System.out.println(locationToUnlock.getName() + " est déjà déverrouillée.");
        } else {
            System.out.println("La " + getName() + " ne semble rien déverrouiller ici.");
        }
    }
}