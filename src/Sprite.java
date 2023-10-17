public class Sprite {

        protected int positionX ;
        protected int vitesseHorizontal ;
        protected int positionY ;
        protected int vitesseVertical ;

    public Sprite(int positionX, int vitesseHorizontal, int positionY, int vitesseVertical) {
        this.positionX = positionX;
        this.vitesseHorizontal = vitesseHorizontal;
        this.positionY = positionY;
        this.vitesseVertical = vitesseVertical;
    }

    public void deplacement() {
            this.positionX += this.vitesseHorizontal;
            this.positionY += this.vitesseVertical;
        }

        public void testCollision() {
            if(this.positionX >= 500 - 30 || this.positionX <= 0) {
                this.vitesseHorizontal = - vitesseHorizontal;
            }
            if(this.positionY >= 500 - 30 || this.positionY <= 0) {
                this.vitesseVertical = -vitesseVertical;
            }
        }

        public int getPositionX() {
            return positionX;
        }

        public void setPositionX(int positionX) {
            this.positionX = positionX;
        }

        public int getVitesseHorizontal() {
            return vitesseHorizontal;
        }

        public void setVitesseHorizontal(int vitesseHorizontal) {
            this.vitesseHorizontal = vitesseHorizontal;
        }

        public int getPositionY() {
            return positionY;
        }

        public void setPositionY(int positionY) {
            this.positionY = positionY;
        }

        public int getVitesseVertical() {
            return vitesseVertical;
        }

        public void setVitesseVertical(int vitesseVertical) {
            this.vitesseVertical = vitesseVertical;
        }


}
