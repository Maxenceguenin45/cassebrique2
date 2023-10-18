public class Brique extends Rectangle {
    private int vie =2;
    public Brique(int positionX, int positionY, int large, int longeur) {
        super(positionX, positionY, large, longeur);
    }

    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
    }
}
