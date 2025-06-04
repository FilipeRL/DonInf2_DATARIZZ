public class ResolveCommand implements ICommand {
    @Override
    public String getKeyword() {
        return "resolve";
    }

    @Override
    public String getHelpText() {
        return "Permet de résoudre une énigme en répondant.";
    }

    @Override
    public void execute(String args, Game game) {
        if (args == null || args.trim().isEmpty()) {
            System.out.println("Usage: resolve <réponse>");
            return;
        }

        String tentative = args.trim().toLowerCase();

        for (Item item : game.getPlayer().getItemInInventory()) {
            if (item instanceof Letter) {
                Enigme enigme = ((Letter) item).getEnigma();

                if (!enigme.isResolue()) {
                    if (enigme.tenterReponse(tentative)) {
                        System.out.println("Bonne réponse !");
                        if (enigme.getRecompense() != null) {
                            game.getPlayer().addItem(enigme.getRecompense());
                            System.out.println("Vous avez reçu : " + enigme.getRecompense().getName());
                        }
                        return;
                    } else {
                        System.out.println("Mauvaise réponse. Essayez encore.");
                        return;
                    }
                }
            }
        }

        System.out.println("Vous n’avez pas d’énigme non résolue.");
    }
}
