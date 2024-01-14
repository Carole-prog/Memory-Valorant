import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AfficheGame {

    public AfficheGame() {
        // Obtenir la taille de l'écran
        // Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Créer une nouvelle JFrame
        JFrame frame = new JFrame("Menu du Memory");

        // Créer un JPanel pour le label centré
        JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Créer un JLabel centré avec la police et la taille souhaitées
        JLabel label1 = new JLabel("Memory");
        label1.setFont(new Font("Arial", Font.BOLD, 50));

        // Ajouter le JLabel au JPanel
        panel1.add(label1);

        // Créer un JPanel pour les boutons
        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Créer les boutons et les ajouter au JPanel
        JButton button1 = new JButton("Sélectionner un niveau");
        JButton button2 = new JButton("Quitter");
        panel2.add(button1);
        panel2.add(button2);

        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code à exécuter lorsqu'on clique sur le bouton retour
                new SelectionNiv();
                frame.dispose();
            }
        });

        // Permet de quitter la fenêtre en cliquant sur le bouton quitter (logique)
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel label2 = new JLabel("Carole Mackowiak 2022-2023");

        // Ajouter le JLabel au JPanel
        panel3.add(label2);

        // Ajouter les panneaux à la JFrame et les placer sur la fenêtre
        frame.add(panel1, BorderLayout.NORTH);
        frame.add(panel2, BorderLayout.CENTER);
        frame.add(panel3, BorderLayout.SOUTH);

        // la taille de l'écran en pleine écran
        // frame.setSize(screenSize.width, screenSize.height);

        // La taile de l'écran avec les dimensions qu'on veut
        frame.setSize(325, 200);
        frame.setLocationRelativeTo(null);

        // Afficher la JFrame Si on en a d'autre la mettre à false et ensuite à True
        frame.setVisible(true);
    }
}
