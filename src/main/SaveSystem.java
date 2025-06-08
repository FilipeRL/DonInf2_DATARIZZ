import java.io.*;
import java.nio.file.*;
import java.util.*;

public class SaveSystem {
    private static final String FILE = "save.txt";
    private final List<String> history = new ArrayList<>();

    public void record(String commandLine) {
        history.add(commandLine);
    }

    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE))) {
            for (String line : history) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Partie sauvegardée !");
        } catch (IOException e) {
            System.out.println("Erreur lors de la sauvegarde.");
        }
    }

    public List<String> load() {
        try {
            return Files.readAllLines(Paths.get(FILE));
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

     public void loadAndTrack() {
        List<String> previous = load();
        history.clear();
        history.addAll(previous);
    }

    public boolean hasSave() {
        return Files.exists(Paths.get(FILE));
    }
}
