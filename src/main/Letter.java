public class Letter extends Item {
    private Enigme enigme;

    public Letter(String name, String description, Enigme enigme) {
        super(name, description);
        this.enigme = enigme;
    }

    public Enigme getEnigma() {
        return enigme;
    }

    @Override
    public void use(Game game) {
        System.out.println("Lettre : " + getName());
        System.out.println(getDescription());

        if (!enigme.isResolue()) {
            System.out.println("Énigme : " + enigme.getQuestion());
            System.out.println("Tapez 'resolve <réponse>' pour tenter de la résoudre.");
        } else {
            System.out.println("Cette énigme est déjà résolue.");
        }
    }
}

