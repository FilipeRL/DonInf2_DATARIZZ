public class Enigme {
    private String question;
    private String reponse;
    private boolean resolue;
    private Item recompense;

    public Enigme(String question, String reponse, Item recompense) {
        this.question = question;
        this.reponse = reponse.trim().toLowerCase();
        this.resolue = false;
        this.recompense = recompense;
    }

    public String getQuestion() {
        return question;
    }

    public boolean isResolue() {
        return resolue;
    }

    public Item getRecompense() {
        return recompense;
    }

    public boolean tenterReponse(String tentative) {
        if (tentative.trim().toLowerCase().equals(reponse)) {
            resolue = true;
            return true;
        }
        return false;
    }
}
