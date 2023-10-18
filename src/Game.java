import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends Canvas implements KeyListener {

    Barre bar =new Barre(400,250,10,30);
    int size =500;


        public Game() throws InterruptedException {

            setSize(size,size);
            setBounds(0,0,size,size);

            JFrame fenetre = new JFrame();
            JPanel panneau = (JPanel)fenetre.getContentPane();
            panneau.setSize(size,size);
            panneau.add(this);

            fenetre.pack();
            fenetre.setResizable(false);
            fenetre.setVisible(true);
            fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


            this.createBufferStrategy(2);
            fenetre.addKeyListener(this);
            setIgnoreRepaint(true);
            setFocusable(false);

            this.demarrer(fenetre);






        }

        public void demarrer(JFrame fenetre) throws InterruptedException {

            Balle balle = new Balle(0,3,0,4,30);


            while(true) {

                Graphics2D dessin = (Graphics2D) getBufferStrategy().getDrawGraphics();



                dessin.setColor(Color.white);
                dessin.fillRect(0,0,size,size);



                //----------------------
                bar.dessine(dessin);


                balle.dessine(dessin);

                balle.deplacement();
                balle.colistionBar(bar);
                balle.testCollision();



                dessin.dispose();
                System.out.println("dispose");
                getBufferStrategy().show();
                Thread.sleep(1000 / 60);
            }
        }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            // Code à exécuter lorsque la touche flèche vers la gauche est enfoncée
            System.out.println(bar.getPositionY());
            bar.deplacementG(size);

        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println(bar.getPositionX());
            bar.deplacementD(size);
            // Code à exécuter lorsque la touche flèche vers la droite est enfoncée
        }



    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

