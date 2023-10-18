import java.awt.*;

public class Rectangle extends Sprite{
    protected int large;
    protected int longeur;
    private Color color =Color.BLUE;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Rectangle(int positionX, int positionY, int large, int longeur) {
        super(positionX, positionY);
        this.large=large;
        this.longeur=longeur;
    }

    @Override
    public void dessine(Graphics2D dessin) {
        dessin.setColor(color);
        dessin.fillRect(positionX,positionY,longeur,large);


    }

    public int getLarge() {
        return large;
    }

    public void setLarge(int large) {
        this.large = large;
    }

    public int getLongeur() {
        return longeur;
    }

    public void setLongeur(int longeur) {
        this.longeur = longeur;
    }
}
