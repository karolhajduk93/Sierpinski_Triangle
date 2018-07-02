package com.mycompany;

import javax.swing.*;

public class Main extends JFrame{

    public static void main(String[] args) {
        new Main();
    }

    public Main(){

        this.setSize(500, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Sierpinski Triangle");

        this.setVisible(true);


    }
}
