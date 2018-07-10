package com.mycompany;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame{

    JPanel panel;
    JLabel label;
    JTextField textField;

    public static void main(String[] args) {
        new Main();
    }

    public Main(){

        this.setSize(900, 700);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Sierpinski Triangle");

        Draw draw = new Draw();

        panel = new JPanel();

        label = new JLabel("Number of iterations");
        panel.add(label);

        textField = new JTextField(5);
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                draw.iteration = Integer.parseInt(textField.getText());
                draw.repaint();
            }
        });
        panel.add(textField);


        this.add(panel, BorderLayout.NORTH);
        this.add(draw, BorderLayout.CENTER);

        this.setVisible(true);
    }
}
