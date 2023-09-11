package PartIV;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {
    private Image[] images;

    public ImagePanel(Image[] images) {
        this.images = images;
        Dimension size = new Dimension(images[0].getWidth(null) * images.length, images[0].getHeight(null));
        setPreferredSize(size);
        setLayout(null);
    }

    public void setImages(Image[] images) {
        this.images = images;
        Dimension size = new Dimension(images[0].getWidth(null) * images.length, images[0].getHeight(null));
        setPreferredSize(size);
        revalidate();
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 0;
        for (Image image : images) {
            g.drawImage(image, x, 0, null);
            x += image.getWidth(null);
        }
    }
}

