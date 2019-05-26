package com.mj147.graphics.panels;

import com.mj147.graphics.Button;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanel extends JPanel implements ActionListener {

    private JLabel gameNameLabel;

    private JPanel rulesPanel;

    private JLabel rule1Label;
    private JLabel rule2Label;

    private JPanel buttonPanel;
    private JButton startButton;
    private JButton exitButton;

    private JFrame frame;
    private JPanel mainPanel;

    public StartPanel(JFrame frame, JPanel mainPanel) {
        this.frame = frame;
        this.mainPanel = mainPanel;

        setLayout(new BorderLayout());
        setBackground(new Color(230,255,150));

        gameNameLabel = new JLabel("FIND NEXT");
        gameNameLabel.setPreferredSize(new Dimension(600,180));
        gameNameLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        gameNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        gameNameLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        add(BorderLayout.NORTH, gameNameLabel);

        rulesPanel = new JPanel();
        rulesPanel.setBackground(new Color(230,255,150));
        rulesPanel.setLayout(new BoxLayout(rulesPanel, BoxLayout.Y_AXIS));
        add(BorderLayout.CENTER, rulesPanel);

        rule1Label = new JLabel("Can you find the next number in sequence?");
        rule1Label.setAlignmentX(Component.CENTER_ALIGNMENT);
        rule1Label.setFont(new Font("Arial", Font.PLAIN, 14));
        rulesPanel.add(rule1Label);

        rule2Label = new JLabel("Try to beat 10 levels without any mistake.");
        rule2Label.setAlignmentX(Component.CENTER_ALIGNMENT);
        rule2Label.setFont(new Font("Arial", Font.PLAIN, 14));
        rulesPanel.add(rule2Label);


        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(600,300));
        buttonPanel.setBackground(new Color(230,255,150));
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        add(BorderLayout.SOUTH, buttonPanel);

        startButton = new Button(" START GAME ");
        startButton.addActionListener(this);
        startButton.setPreferredSize(new Dimension(200,100));
        startButton.setBackground(new Color(230,255,150));
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(startButton);

        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20)));

        exitButton = new Button("  EXIT  GAME  ");
        exitButton.addActionListener(this);
        exitButton.setPreferredSize(new Dimension(200,100));
        exitButton.setBackground(new Color(230,255,150));
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buttonPanel.add(exitButton);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(startButton)) {

            frame.remove(this);
            frame.add(mainPanel);
            frame.repaint();
        }
        if (actionEvent.getSource().equals(exitButton)) {
            System.exit(0);
        }
    }
}
