package com.mj147.graphics.panels;

import com.mj147.Sequence;
import com.mj147.graphics.MainFrame;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel {

    public static final int HEIGHT = 60;
    public static final int WIDTH = MainFrame.WIDTH;


    private JLabel levelLabel;
    private JLabel timeLabel;
    private int level;


    public InfoPanel(Sequence sequence) {

        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setLayout(new BorderLayout());
        Font font = new Font("Arial", Font.PLAIN, 20);
        Color color = new Color(255,255,210);
        setBackground(color);


        levelLabel = new JLabel("Level: " + level, SwingConstants.CENTER);
        levelLabel.setPreferredSize(new Dimension(WIDTH/2,100));
        levelLabel.setFont(font);
        timeLabel = new JLabel("Time:", SwingConstants.CENTER);
        timeLabel.setPreferredSize(new Dimension(WIDTH/2,100));
        timeLabel.setFont(font);

        add(BorderLayout.WEST, levelLabel);
        add(BorderLayout.EAST, timeLabel);

    }

    public void refreshLabel() {
        levelLabel.setText("Level:" + level);
        levelLabel.setAlignmentX(CENTER_ALIGNMENT);
    }
}
