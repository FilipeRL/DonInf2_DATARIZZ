public class TeleportCrystal extends Item {
    public TeleportCrystal() {
        super("Cristal", "Un cristal magique qui permet de se téléporter à un lieu déjà visité.");
    }

    @Override
    public void use(Game game) {
        System.out.println("Vous sentez une étrange énergie...");
        System.out.println("Utilisez : teleport <nom-lieu> pour vous téléporter.");
    }
}