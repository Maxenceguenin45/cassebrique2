public class Barre extends Rectangle {




    public Barre(int positionX, int positionY, int large, int longeur) {
        super(positionX, positionY,large,longeur);


    }


    public void deplacementD(int taillefenetre) {
        if (positionX + 20 >= 0 && positionX + 20 <= taillefenetre - 20) {
            this.positionX += 20;
        }
    }

    public void deplacementG(int taillefenetre) {
        if (positionX >= 20 && positionX - 20 <= taillefenetre) {
            this.positionX -= 20;
        }
    }



}
