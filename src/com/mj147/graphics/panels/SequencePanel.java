package com.mj147.graphics.panels;

import com.mj147.Sequence;

import javax.swing.*;
import java.awt.*;

public class SequencePanel extends JPanel {

    Sequence sequence;

    public SequencePanel(Sequence sequence) {
        this.sequence = sequence;

        Color color = new Color(255, 246, 141);
        setBackground(color);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        String sequenceString = sequence.toString();

        Font font = new Font("Arial", Font.PLAIN, 25);
        g.setFont(font);
        FontMetrics fm = g.getFontMetrics();

        int sequenceX = (int) ((this.getWidth() - fm.getStringBounds(sequenceString, g).getWidth() - fm.getStringBounds("?", g).getWidth())/2);
        int sequenceY = (int) (this.getHeight() - fm.getStringBounds(sequenceString, g).getHeight())/2 + 50;

        int lastElementX = (int) (sequenceX + fm.getStringBounds(sequenceString, g).getWidth());
        int lastElementY = sequenceY;

        g.drawString(sequenceString, sequenceX , sequenceY);
        g.setColor(Color.RED);
        g.drawString("?", lastElementX, lastElementY);

        g.dispose();


    }

}
