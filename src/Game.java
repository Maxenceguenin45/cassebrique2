import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Game extends Canvas implements KeyListener {

    Barre bar =new Barre(250,400,10,50);
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
            int ligne = 3; // Nombre de lignes brique
            int columns = 10; // Nombre de colonnes brique
            int nombreDeVies = 3;
            ArrayList<ArrayList<Brique>> briques = new ArrayList<>();//liste  a 2 dimension
            Balle balle = new Balle(250,3,250,4,20);
            briques = new ArrayList<>();
            ArrayList<Rectangle> elements = new ArrayList<>();

            // Ajoutez la barre
            elements.add(bar);

            // Créez la liste bidimensionnelle pour les briques
            for (int i = 0; i < ligne; i++) {
                ArrayList<Brique> ligneBriques = new ArrayList<>();
                for (int j = 0; j < columns; j++) {
                    Brique brique = new Brique(j * 50, i * 40, 20, 40);
                    ligneBriques.add(brique);
                    elements.add(brique);
                }
                briques.add(ligneBriques);
            }

            Vie[] vies = new Vie[nombreDeVies];
            for (int i = 0; i < vies.length; i++) {
                vies[i] = new Vie(30*i,450,30);
                vies[i].setColor(Color.pink);
            }

            while(true) {

                Graphics2D dessin = (Graphics2D) getBufferStrategy().getDrawGraphics();



                dessin.setColor(Color.white);
                dessin.fillRect(0,0,size,size);



                //----------------------
                bar.setColor(Color.BLACK);
                bar.dessine(dessin);
                for (int i = 0; i < vies.length; i++) {
                    if (vies[i].isFlag()){
                        vies[i].dessine(dessin);
                    }

                }

                balle.dessine(dessin);
                for (ArrayList<Brique> row : briques) {
                    for (Brique brique : row) {

                        if(brique.getVie()>0){
                            brique.setColor(Color.green);
                           brique.dessine(dessin);
                        }
                    }
                }


                balle.deplacement();
                balle.colistionBar(elements);
                if(balle.testCollision(size)){
                    for (int i = 0; i < vies.length; i++){
                        if (vies[i].isFlag()){
                            vies[i].setFlag(false);
                            balle.setPositionX(250);
                            balle.setPositionY(250);
                            break;
                        }

                    }
                }



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

