import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SelectionNiv {
    public SelectionNiv() {
        // Créer une nouvelle JFrame
        JFrame frame = new JFrame("Selection des niveaux");

        // Créer un JPanel pour le label centré
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Ajouter un label
        JLabel label = new JLabel("Sélectionnez un niveau");
        panel1.add(label);

        // Ajouter un JPanel pour les boutons
        JPanel panel2 = new JPanel(new GridLayout(2, 2));

        // Ajouter un bouton pour le tutoriel
        JButton tutorialButton = new JButton("Tutorial");
        tutorialButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code à exécuter lorsqu'on clique sur le bouton tutoriel
                JOptionPane.showMessageDialog(null, "Bienvenue dans le tutoriel !");
                new MemoryGame("Tutorial", 1, 1);
                frame.dispose();
            }
        });
        panel2.add(tutorialButton);

        // Ajouter des boutons pour les niveaux
        String[] niveaux = { "Facile", "Moyen", "Difficile" };
        for (String niveau : niveaux) {
            JButton niveauButton = new JButton(niveau);
            niveauButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Code à exécuter lorsqu'on clique sur un bouton de niveau
                    int largeur;
                    int longueur;
                    switch (niveau) {
                        case "Facile":
                            largeur = 4;
                            longueur = 4;
                            break;
                        case "Moyen":
                            largeur = 6;
                            longueur = 6;
                            break;
                        case "Difficile":
                            largeur = 8;
                            longueur = 8;
                            break;
                        default:
                            largeur = 4;
                            longueur = 4;
                            break;
                    }
                    new MemoryGame(niveau, largeur, longueur);
                    frame.dispose();
                }
            });
            panel2.add(niveauButton);
        }

        // Ajouter un bouton de retour
        JButton retourButton = new JButton("Retour");
        retourButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code à exécuter lorsqu'on clique sur le bouton retour
                new AfficheGame();
                frame.dispose();
            }
        });
        panel2.add(retourButton);

        // Ajouter les panneaux à la fenêtre
        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);

        // Paramétrer la fenêtre
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
