import java.awt.*;

public class Rond extends Sprite {

    protected int diametre;
    public Rond(int positionX, int positionY, int diametre) {
        super(positionX,positionY);
        this.diametre=diametre;

    }

    @Override
    public void dessine(Graphics2D dessin) {
        dessin.setColor(Color.blue);
        dessin.fillOval(positionX,positionY,diametre,diametre);

    }


}
