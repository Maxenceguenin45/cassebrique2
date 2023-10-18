public class Balle extends Rond {
    private int vitesseVertical ;
    private int vitesseHorizontal ;


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
    public void colistionBar (Barre bar){
        if (this.positionY+this.diametre== bar.getPositionY()+bar.getLarge()){

        }
        if(this.positionX+diametre >= bar.getPositionX() && this.positionX-diametre <= bar.getPositionX()+bar.getLarge() && this.positionY+diametre >= bar.getPositionY() && this.positionY-diametre/2 <= bar.getPositionY()+bar.getLarge()) {
            System.out.println("cclalalalala");
            this.vitesseHorizontal=-vitesseHorizontal;
            this.vitesseVertical=-vitesseVertical;

        }
    }
}
