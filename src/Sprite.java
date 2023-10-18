import java.awt.*;

public abstract class Sprite {

        protected int positionX ;

        protected int positionY ;


    public Sprite(int positionX, int positionY) {
        this.positionX = positionX;

        this.positionY = positionY;

    }
    public abstract void dessine (Graphics2D dessin);







        public int getPositionX() {
            return positionX;
        }

        public void setPositionX(int positionX) {
            this.positionX = positionX;
        }



        public int getPositionY() {
            return positionY;
        }

        public void setPositionY(int positionY) {
            this.positionY = positionY;
        }



}
