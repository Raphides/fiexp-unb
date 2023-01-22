package br.fiexp_unb.view;

/**
- * A class representing the Screen of the application in the format of a Jframe.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;

public class Screen extends JFrame{
    public Screen() {
        super();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(800, 450));
        this.getContentPane().setBackground(Color.decode("#989EA1"));
        this.setVisible(true);
        this.setTitle("Fiexp - UnB");

    }

    public void addToContentPane(Component Component) {
        this.getContentPane().add(Component);
    }
    
}