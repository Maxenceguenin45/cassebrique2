public class Balle extends  Sprite{
    private int diametre;
    public Balle(int positionX, int vitesseHorizontal, int positionY, int vitesseVertical,int diametre) {
        super(positionX, vitesseHorizontal, positionY, vitesseVertical);
        this.diametre=diametre;
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
