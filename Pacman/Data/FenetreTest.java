package Pacman.Data;

import java.awt.Container;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.AffineTransformOp;
import java.awt.geom.AffineTransform;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Cette classe permet d'afficher rapidement une image dans une fenêtre afin de
 * vérifier visuellement si les découpages effectués dans DataForView sont bons
 * 
 * @author Louis-Baptiste Sobolewski
 */
public class FenetreTest extends JFrame {
    /**
     * Constructeur, prend une Image en paramètre, la scale, et l'affiche
     * 
     * @param image Image à afficher
     */
    FenetreTest(Image image) {
        Image imageScaled = scale(image, 20.0);
        JLabel label = new JLabel(new ImageIcon(imageScaled));
        
        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);
        pane.setLayout(gl);
        gl.setAutoCreateContainerGaps(true);
        gl.setHorizontalGroup(gl.createSequentialGroup().addComponent(label));
        gl.setVerticalGroup(gl.createParallelGroup().addComponent(label));
        pack();

        setVisible(true);
    }

    /**
     * Permet de mettre à l'échelle une image
     * 
     * @param from Image à mettre à l'échelle
     * @param scale échelle à appliquer
     * @return Image mise à l'échelle
     */
    private Image scale(Image from, double scale) {
        BufferedImage fromB = (BufferedImage) from;
        int w = fromB.getWidth();
        int h = fromB.getHeight();
        BufferedImage to = new BufferedImage(w * (int) scale, h * (int) scale, BufferedImage.TYPE_INT_ARGB);
        AffineTransform at = new AffineTransform();
        at.scale(scale, scale);
        AffineTransformOp scaleOp = new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
        to = scaleOp.filter(fromB, to);
        return (Image) to;
    }
}
