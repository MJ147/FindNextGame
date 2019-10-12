package com.mj147.graphics;

import com.mj147.Sequence;
import com.mj147.graphics.panels.ButtonPanel;
import com.mj147.graphics.panels.SequencePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{

    public static final int WIDTH = 600;
    public static final int HEIGHT = 600;

    private JPanel gamePanel;
    private JPanel startPanel;
    private MistakePanel mistakePanel;
    private int score;

    private Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

    public MainFrame() {

        super("Find Next");
        setSize(WIDTH, HEIGHT);
        setLocation((dim.width - WIDTH)/2, (dim.height - HEIGHT)/2 );

        startPanel = new StartPanel();
        add(startPanel);

        gamePanel = new GamePanel();
        mistakePanel = new MistakePanel();

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void addMistakePanel() {
        mistakePanel.setScore(score);
        getContentPane().add(mistakePanel);
    }

    class GamePanel extends JPanel {

        private JPanel buttonPanel;
        private JPanel sequencePanel;

        private Sequence sequence = new Sequence();

        public GamePanel() {
            super();

            Color color = new Color(230,255,150);
            setBackground(color);
            setLayout(new BorderLayout());

            sequencePanel = new SequencePanel(sequence);
            buttonPanel = new ButtonPanel(sequence, sequencePanel, MainFrame.this);

            add(BorderLayout.SOUTH, buttonPanel);
            add(BorderLayout.CENTER, sequencePanel);

        }
    }

    class StartPanel extends JPanel implements ActionListener {

        private JLabel gameNameLabel;

        private JPanel rulesPanel;

        private JLabel rule1Label;
        private JLabel rule2Label;

        private JPanel buttonPanel;
        private JButton startButton;
        private JButton exitButton;

        public StartPanel() {

            setLayout(new BorderLayout());
            Color color = new Color(0,255,210);
            Color buttonColor = new Color(144, 255, 250);
            setBackground(color);

            gameNameLabel = new JLabel("FIND NEXT");
            gameNameLabel.setPreferredSize(new Dimension(600,180));
            gameNameLabel.setFont(new Font("Arial", Font.PLAIN, 40));
            gameNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            gameNameLabel.setVerticalAlignment(SwingConstants.BOTTOM);
            add(BorderLayout.NORTH, gameNameLabel);

            rulesPanel = new JPanel();
            rulesPanel.setBackground(color);
            rulesPanel.setLayout(new BoxLayout(rulesPanel, BoxLayout.Y_AXIS));
            add(BorderLayout.CENTER, rulesPanel);

            rule1Label = new JLabel("Can you find the next number in a sequence?");
            rule1Label.setAlignmentX(Component.CENTER_ALIGNMENT);
            rule1Label.setFont(new Font("Arial", Font.PLAIN, 14));
            rulesPanel.add(rule1Label);

            rule2Label = new JLabel("Try to beat as many levels as you can without any mistake.");
            rule2Label.setAlignmentX(Component.CENTER_ALIGNMENT);
            rule2Label.setFont(new Font("Arial", Font.PLAIN, 14));
            rulesPanel.add(rule2Label);


            buttonPanel = new JPanel();
            buttonPanel.setPreferredSize(new Dimension(600,300));
            buttonPanel.setBackground(color);
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
            add(BorderLayout.SOUTH, buttonPanel);

            startButton = new Button(" START GAME ");
            startButton.addActionListener(this);
            startButton.setBackground(buttonColor);
            startButton.setPreferredSize(new Dimension(200,100));
            startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            buttonPanel.add(startButton);

            buttonPanel.add(Box.createRigidArea(new Dimension(0, 20)));

            exitButton = new Button("  EXIT  GAME  ");
            exitButton.addActionListener(this);
            exitButton.setBackground(buttonColor);
            exitButton.setPreferredSize(new Dimension(200,100));
            exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            buttonPanel.add(exitButton);

        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getSource().equals(startButton)) {

                getContentPane().remove(this);
                getContentPane().add(gamePanel);
                getContentPane().revalidate();
                getContentPane().doLayout();

            }
            if (actionEvent.getSource().equals(exitButton)) {
                System.exit(0);
            }

        }
    }

    class MistakePanel extends JPanel implements ActionListener {

        private JLabel gameNameLabel;
        private JPanel buttonPanel;

        private JButton restartButton;
        private JButton exitButton;

        private JPanel resultPanel;
        private JLabel resultLabel;

        private int score;

        public MistakePanel() {

            setLayout(new BorderLayout());
            Color color = new Color(0,255,210);
            Color buttonColor = new Color(144, 255, 250);
            setBackground(color);
            gameNameLabel = new JLabel("WRONG ANSWER");
            gameNameLabel.setPreferredSize(new Dimension(600,180));
            gameNameLabel.setFont(new Font("Arial", Font.PLAIN, 40));
            gameNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
            gameNameLabel.setVerticalAlignment(SwingConstants.BOTTOM);
            add(BorderLayout.NORTH, gameNameLabel);

            resultPanel = new JPanel();
            resultPanel.setBackground(color);
            resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.Y_AXIS));
            add(BorderLayout.CENTER, resultPanel);

            resultLabel = new JLabel("Your score is: " + score);
            resultLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            resultLabel.setFont(new Font("Arial", Font.PLAIN, 14));
            resultPanel.add(resultLabel);

            buttonPanel = new JPanel();
            buttonPanel.setPreferredSize(new Dimension(600,300));
            buttonPanel.setBackground(color);
            buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
            add(BorderLayout.SOUTH, buttonPanel);

            restartButton = new Button("    RESTART    ");
            restartButton.addActionListener(this);
            restartButton.setPreferredSize(new Dimension(200,100));
            restartButton.setBackground(buttonColor);
            restartButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            buttonPanel.add(restartButton);

            buttonPanel.add(Box.createRigidArea(new Dimension(0, 20)));

            exitButton = new Button("  EXIT  GAME  ");
            exitButton.addActionListener(this);
            exitButton.setPreferredSize(new Dimension(150,50));
            exitButton.setBackground(buttonColor);
            exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            buttonPanel.add(exitButton);

        }

        public void setScore(int score) {
            this.score = score;
            resultLabel.setText("Your score is: " + score);
        }

        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            if (actionEvent.getSource().equals(restartButton)) {
                setScore(0);
                getContentPane().removeAll();
                getContentPane().add(new GamePanel());
                getContentPane().repaint();
                getContentPane().revalidate();
                getContentPane().doLayout();

            }
            if (actionEvent.getSource().equals(exitButton)) {
                System.exit(0);
            }

        }
    }
}
