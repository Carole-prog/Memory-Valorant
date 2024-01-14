import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.util.Random;

import java.awt.event.*;

public class UneImage extends JButton implements MouseListener {
    public static final ImageIcon[] TABIMAGES = {
            new ImageIcon("images/breach.png"),
            new ImageIcon("images/brimstone.png"),
            new ImageIcon("images/chamber.png"),
            new ImageIcon("images/cipher.png"),
            new ImageIcon("images/harbor.png"),
            new ImageIcon("images/jett.png"),
            new ImageIcon("images/kayo.png"),
            new ImageIcon("images/killjoy.png"),
            new ImageIcon("images/neon.png"),
            new ImageIcon("images/omen.png"),
            new ImageIcon("images/phoenix.png"),
            new ImageIcon("images/raze.png"),
            new ImageIcon("images/reyna.png"),
            new ImageIcon("images/sage.png"),
            new ImageIcon("images/sova.png"),
            new ImageIcon("images/viper2.png"),
            new ImageIcon("images/fade.png"),
            new ImageIcon("images/sky.png"),
            new ImageIcon("images/astra.png"),
            new ImageIcon("images/rien.png"),
            new ImageIcon("images/viper.png")
    };

    private int indice;
    private boolean isRevealed = false;

    public UneImage(int indice) {
        super(TABIMAGES[TABIMAGES.length - 1]); // initialisation avec rien.gif
        this.indice = indice;
        addMouseListener(this); // le composant écoute les événements de souris
    }

    public void reveal() {
        setIcon(TABIMAGES[indice]);
        isRevealed = true;
    }

    public void hide() {
        setIcon(TABIMAGES[TABIMAGES.length - 1]);
        isRevealed = false;
    }

    public boolean check(UneImage image) {
        if (getIndice() == (image.getIndice())) {
            return true;
        }
        return false;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        setIcon(TABIMAGES[indice]);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // affichage de l'image associée à l'indice
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // retour à l'image "viper"
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // vide
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // c vide
    }

    public String toString() {
        return "" + indice;
    }

    public static int getImageAleatoire() {
        // Créer une instance de la classe Random
        Random rand = new Random();

        // Générer un index aléatoire
        int indexAleatoire = rand.nextInt(19);

        // Renvoyer l'indice de l'image
        return indexAleatoire;
    }

    public int getIndice() {
        return indice;
    }
}