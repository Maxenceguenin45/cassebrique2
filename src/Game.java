import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends Canvas implements KeyListener {

    Barre bar =new Barre(0,0,400,0,10,30);


        public Game() throws InterruptedException {

            setSize(500,500);
            setBounds(0,0,500,500);

            JFrame fenetre = new JFrame();
            JPanel panneau = (JPanel)fenetre.getContentPane();
            panneau.setSize(500,500);
            panneau.add(this);

            fenetre.pack();
            fenetre.setResizable(false);
            fenetre.setVisible(true);
            fenetre.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            fenetre.requestFocus();

            createBufferStrategy(2);
            fenetre.addKeyListener(this);
            this.demarrer(fenetre);



            setIgnoreRepaint(true);
            setFocusable(false);


        }

        public void demarrer(JFrame fenetre) throws InterruptedException {

            Balle balle = new Balle(0,3,0,4,30);


            while(true) {

                Graphics2D dessin = (Graphics2D) getBufferStrategy().getDrawGraphics();
                //----------------------
                dessin.setColor(Color.white);
                dessin.fillRect(0,0,500,500);

                dessin.setColor(Color.blue);
                dessin.fillOval(balle.getPositionX(),balle.getPositionY(),balle.getDiametre(),balle.getDiametre());
                dessin.setColor(Color.gray);
                dessin.fillRect(bar.getPositionX(), bar.getPositionY(),bar.getLongeur(),bar.getLarge());
                balle.deplacement();
                balle.colistionBar(bar);
                balle.testCollision();



                //------------------------

                dessin.dispose();
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
            System.out.println(bar.getPositionX());
            if( 500 >= bar.getPositionX() && 0 < bar.getPositionX()){
                System.out.println("r");
                bar.setVitesseHorizontal(-20);
                bar.deplacement();
                bar.setVitesseHorizontal(0);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if( 500-bar.getLongeur()>bar.getPositionX() && 0<= bar.getPositionX()){

                bar.setVitesseHorizontal(20);
                bar.deplacement();
                bar.setVitesseHorizontal(0);
            }

            // Code à exécuter lorsque la touche flèche vers la droite est enfoncée
        }



    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

