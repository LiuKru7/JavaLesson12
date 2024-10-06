package example_3;

import example_2.Calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModernCalculate extends JFrame implements ActionListener {
    private  JTextField display;
    private  JButton kmToMiles, milesToKm;
    private JPanel panel;

    public ModernCalculate() {
        setTitle("Modern Calculator");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

    }





    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new ModernCalculate();
    }
}

