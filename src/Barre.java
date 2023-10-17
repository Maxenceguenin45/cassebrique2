import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;



public class Barre extends Sprite implements KeyListener {

private int large;
private int longeur;
    public Barre(int positionX, int vitesseHorizontal, int positionY, int vitesseVertical,int large,int longeur) {
        super(positionX, vitesseHorizontal, positionY, vitesseVertical);
        this.large=large;
        this.longeur = longeur;

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

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {


    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
