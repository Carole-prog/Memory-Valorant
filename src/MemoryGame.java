import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.Timer;

public class MemoryGame {
    private String mode = "facile";
    private int largeur = 4; // largeur du tableau
    private int longueur = 4; // longueur du tableau
    private UneImage derniereImage = null;
    private ArrayList<UneImage> plateau = new ArrayList<UneImage>(); // ptêt le mettre en arraylist

    public MemoryGame(String name, int largeur_plat, int longueur_plat) {
        mode = name;
        largeur = largeur_plat;
        longueur = longueur_plat;
        shuffle(longueur, largeur);

        // Créer une nouvelle JFrame
        JFrame frame = new JFrame("Mode : " + mode);
        JPanel panel2 = new JPanel(new GridLayout(largeur, longueur));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        int i = 0;
        while (i < plateau.size()) {
            UneImage imageActu = plateau.get(i);
            imageActu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SelectionCase(imageActu);
                }
            });
            panel2.add(imageActu);
            i++;
        }
        frame.add(panel2);

        frame.setVisible(true);
    }

    public String toString() {
        return " Vous êtes sur le mode " + mode + " avec un plateau de " + largeur + " x " + longueur;
    }

    public void shuffle(int longs, int largs) {
        int taille = longs + largs;
        ArrayList<Integer> indices = new ArrayList<Integer>();
        while (indices.size() < taille) {
            int index = UneImage.getImageAleatoire();
            if (!indices.contains(index)) {
                indices.add(index);
            }
        }

        // Ajouter deux fois chaque image correspondante aux indices aléatoires
        for (int i = 0; i < indices.size(); i++) {
            UneImage image1 = new UneImage(indices.get(i));
            UneImage image2 = new UneImage(indices.get(i));
            plateau.add(image1);
            plateau.add(image2);
        }

        // Mélanger les images
        Collections.shuffle(plateau);

        System.out.println(plateau);
    }

    private void SelectionCase(UneImage image) {
        if (!image.isRevealed()) {
            if (derniereImage == null) {
                derniereImage = image;
                image.reveal();
            } else {
                if (derniereImage.check(image)) {
                    derniereImage.setEnabled(false);
                    image.setEnabled(false);
                    derniereImage = null;
                } else {
                    // Laisser l'utilisateur voir les deux images pendant un court instant
                    Timer timer = new Timer(1000, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            derniereImage.hide();
                            image.hide();
                            derniereImage = null;
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            }
        }
    }

    public static void main(String[] args) {
        new AfficheGame();
    }
}