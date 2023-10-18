import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Game extends Canvas implements KeyListener {

    Barre bar =new Barre(250,400,10,30);
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
            int rows = 5; // Nombre de lignes
            int columns = 10; // Nombre de colonnes
            ArrayList<ArrayList<Brique>> briques = new ArrayList<>();//liste  a 2 dimension
            Balle balle = new Balle(250,3,250,4,30);
            briques = new ArrayList<>();
            ArrayList<Rectangle> elements = new ArrayList<>();

            // Ajoutez la barre
            elements.add(bar);

            // Créez la liste bidimensionnelle pour les briques
            for (int i = 0; i < rows; i++) {
                ArrayList<Brique> rowBriques = new ArrayList<>();
                for (int j = 0; j < columns; j++) {
                    Brique brique = new Brique(j * 50, i * 40, 20, 40);
                    rowBriques.add(brique);
                    elements.add(brique);
                }
                briques.add(rowBriques);
            }

            while(true) {

                Graphics2D dessin = (Graphics2D) getBufferStrategy().getDrawGraphics();



                dessin.setColor(Color.white);
                dessin.fillRect(0,0,size,size);



                //----------------------
                bar.dessine(dessin);


                balle.dessine(dessin);
                for (ArrayList<Brique> row : briques) {
                    for (Brique brique : row) {
                        brique.dessine(dessin);
                    }
                }

                balle.deplacement();
                balle.colistionBar(elements);
                balle.testCollision();



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

