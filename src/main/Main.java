import java.util.Scanner;
 
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        game.init();
        Scanner sc = new Scanner(System.in);
 
        while (true) {
            System.out.print("> ");
            String input = sc.nextLine();
            String[] parts = input.split(" ", 2);
            String cmd = parts[0];
            String argsStr = parts.length > 1 ? parts[1] : "";
 
            ICommand command = game.getRegistry().getCommand(cmd);
            if (command != null) {
                command.execute(argsStr, game);
            } else {
                System.out.println("Commande inconnue. Tapez 'help'.");
            }
        }
    }
}