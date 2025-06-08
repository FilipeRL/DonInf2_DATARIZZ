import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SaveSystem saveSystem = new SaveSystem();
        Game game = new Game(saveSystem);

        System.out.println("Charger la dernière sauvegarde ? (oui/non)");
        String input = scanner.nextLine().trim().toLowerCase();

        game.init();

        if (input.equals("oui") && saveSystem.hasSave()) {
            saveSystem.loadAndTrack(); // charge les anciennes commandes
            for (String cmd : saveSystem.load()) {
                game.runCommand(cmd, false); // les rejoue sans les enregistrer à nouveau
            }
            System.out.println("Sauvegarde chargée !");
        }

        while (true) {
            System.out.print("> ");
            String cmd = scanner.nextLine();
            game.runCommand(cmd, true);
        }
    }
}

