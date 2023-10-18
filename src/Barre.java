public class Barre extends Rectangle {




    public Barre(int positionX, int positionY, int large, int longeur) {
        super(positionX, positionY,large,longeur);


    }


    public void deplacementD(int taillefenetre) {
        if (positionX + 30 >= 0 && positionX + 30 <= taillefenetre - 20) {
            this.positionX += 30;
        }
    }

    public void deplacementG(int taillefenetre) {
        if (positionX >= 30 && positionX - 30 <= taillefenetre) {
            this.positionX -= 30;
        }
    }



}
