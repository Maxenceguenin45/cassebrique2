import java.awt.*;

public class Rond extends Sprite {

    protected int diametre;
    private Color color =Color.BLUE;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Rond(int positionX, int positionY, int diametre) {
        super(positionX,positionY);
        this.diametre=diametre;

    }

    @Override
    public void dessine(Graphics2D dessin) {
        dessin.setColor(color);
        dessin.fillOval(positionX,positionY,diametre,diametre);

    }


}
