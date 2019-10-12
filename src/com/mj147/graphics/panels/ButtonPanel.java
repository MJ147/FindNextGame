package com.mj147.graphics.panels;

import com.mj147.Sequence;
import com.mj147.graphics.Button;
import com.mj147.graphics.MainFrame;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel implements ActionListener {

    public static final int HEIGHT = 250;
    public static final int WIDTH = MainFrame.WIDTH;

    private JButton[] buttonsTable = new JButton[4];
    private int lastElement;
    private int counterOfRandomNumbers = 1;
    private boolean isClick = false;
    private Sequence sequence;
    private JPanel sequencePanel;
    private  MainFrame mainFrame;
    private int score = 0;


    public ButtonPanel(Sequence sequence, JPanel sequencePanel, MainFrame mainFrame) {

        this.sequence = sequence;
        this.sequencePanel = sequencePanel;
        this.mainFrame = mainFrame;

        score = mainFrame.getScore();

        Color color = new Color(255, 246, 141);
        setBackground(color);
        setBorder(new LineBorder(color, 60));
        setLayout(new GridLayout(2,2,30, 30));
        setPreferredSize(new Dimension(WIDTH, HEIGHT));

        sequence.makeSequence();
        lastElement = sequence.getLastElement();

        buttonsTable[0] = new com.mj147.graphics.Button(String.valueOf(lastElement));
        buttonsTable[1] = new com.mj147.graphics.Button(String.valueOf(randomNumber()));
        buttonsTable[2] = new com.mj147.graphics.Button(String.valueOf(randomNumber()));
        buttonsTable[3] = new Button(String.valueOf(randomNumber()));

        buttonsTable[0].addActionListener(this);
        buttonsTable[1].addActionListener(this);
        buttonsTable[2].addActionListener(this);
        buttonsTable[3].addActionListener(this);

        addButtons();

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        if (!isClick) {
            isClick = true;
            if (!actionEvent.getSource().equals(buttonsTable[0])){
                for (JButton button : buttonsTable) {
                    if (actionEvent.getSource().equals(button)) {
                        button.setBackground(Color.RED);
                    }
                }

                mainFrame.getContentPane().removeAll();
                mainFrame.addMistakePanel();
                mainFrame.revalidate();
                mainFrame.doLayout();
                mainFrame.repaint();
                score = 0;
                mainFrame.setScore(score);

            } else {
                score++;
                mainFrame.setScore(score);
                sequence.makeSequence();
                lastElement = sequence.getLastElement();
                refreshButtons();
                sequencePanel.repaint();
            }
        }
    }

    private int randomNumber() {

        int[] answers = new int[++counterOfRandomNumbers];
        answers[0] = lastElement;
        int temp;
        do {
            temp = (int) (Math.random() * 50 + lastElement - 25);
        } while (contains(answers,temp));
        answers[counterOfRandomNumbers-1] = temp;
        return temp;
    }

    public boolean contains(int[] table, int value) {

        boolean result = false;

        for (int valueInTable : table) {
            if (value == valueInTable) {
                result = true;
                break;
            }
        }

        return result;
    }

    public void refreshButtons() {

        this.removeAll();
        addButtons();
        buttonsTable[0].setText(String.valueOf(lastElement));
        buttonsTable[1].setText(String.valueOf(randomNumber()));
        buttonsTable[2].setText(String.valueOf(randomNumber()));
        buttonsTable[3].setText(String.valueOf(randomNumber()));

        isClick = false;

    }

    public void addButtons() {

        for (int i = 0; i < buttonsTable.length ; i++) {
            int random = -1;

            do {
                random = (int) (Math.random() * 4);
            } while (buttonsTable[random].getParent() != null);

            add(buttonsTable[random]);

        }
    }

}
