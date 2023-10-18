import java.util.ArrayList;

public class Balle extends Rond {
    private int vitesseVertical ;
    private int vitesseHorizontal ;
    private boolean enCollision = false;
    private long dernierTempsCollision = 0;
    private static final long TEMPS_ATTENTE_COLLISION = 69; // Temps d'attente en millisecondes


    public int getVitesseVertical() {
        return vitesseVertical;
    }


    public void setVitesseVertical(int vitesseVertical) {
        this.vitesseVertical = vitesseVertical;
    }


    public int getVitesseHorizontal() {
        return vitesseHorizontal;
    }


    public void setVitesseHorizontal(int vitesseHorizontal) {
        this.vitesseHorizontal = vitesseHorizontal;
    }
    public void testCollision() {
        if(this.positionX >= 500 - 30 || this.positionX <= 0) {
            this.vitesseHorizontal = - vitesseHorizontal;
        }
        if(this.positionY >= 500 - 30 || this.positionY <= 0) {
            this.vitesseVertical = -vitesseVertical;
        }

    }
    public Balle(int positionX, int vitesseHorizontal, int positionY, int vitesseVertical, int diametre) {
        super(positionX, positionY,diametre);

        this.vitesseVertical = vitesseVertical;
        this.vitesseHorizontal = vitesseHorizontal;
    }
    public void deplacement() {
        this.positionX += this.vitesseHorizontal;
        this.positionY += this.vitesseVertical;
    }
    public int getDiametre() {
        return diametre;
    }



    public void setDiametre(int diametre) {
        this.diametre = diametre;
    }
    public void colistionBar(ArrayList<Rectangle> elements) {
        long tempsCourant = System.currentTimeMillis();
        if (tempsCourant - dernierTempsCollision > TEMPS_ATTENTE_COLLISION) {
            for (Rectangle element : elements) {

                if (element instanceof Barre) {
                    Barre bar = (Barre) element;

                    if (this.positionX + diametre >= bar.getPositionX() && this.positionX - diametre <= bar.getPositionX() + bar.getLarge() && this.positionY + diametre >= bar.getPositionY() && this.positionY - diametre / 2 <= bar.getPositionY() + bar.getLarge()) {
                        System.out.println("Collision avec la barre");
                        enCollision = true;
                        dernierTempsCollision = tempsCourant;
                        this.positionX -= this.vitesseHorizontal;
                        this.positionY -= this.vitesseVertical;


                    }


                } else if (element instanceof Brique) {
                    Brique brique = (Brique) element;

                    if (this.positionX + diametre >= brique.getPositionX() && this.positionX - diametre <= brique.getPositionX() + brique.getLarge() && this.positionY + diametre >= brique.getPositionY() && this.positionY - diametre / 2 <= brique.getPositionY() + brique.getLarge()) {
                        System.out.println("Collision avec une brique");
                        enCollision = true;
                        dernierTempsCollision = tempsCourant;
                        this.positionX -= this.vitesseHorizontal;
                        this.positionY -= this.vitesseVertical;


                    }

                }
            }
        }

    }
}
