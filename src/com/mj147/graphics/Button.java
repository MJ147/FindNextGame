package com.mj147.graphics;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {

    public Button(String name) {

        Font font = new Font("Arial", Font.PLAIN, 20);

        setText(name);
        Color color = new Color(255,255,230);
        setBackground(color);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        setFont(font);
    }
}
