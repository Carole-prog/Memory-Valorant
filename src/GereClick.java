import java.awt.event.*;
import javax.swing.*;

public class GereClick implements ActionListener {
    private int compteur = 0;
    private JButton btn;
    private int nbImages;

    public GereClick(JButton btn, int nbImages) {
        this.btn = btn;
        this.nbImages = nbImages;
    }

    public void actionPerformed(ActionEvent evt) {
        compteur++;
        if (compteur == nbImages) {
            compteur = 0;
        }
        btn.setIcon(UneImage.TABIMAGES[compteur]);
        btn.setSize(224, 224);
    }
}
