package example_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    // Define components
    private JTextField display;
    private JButton[] numberButtons;
    private JButton addButton, subButton, equalButton, clearButton, devideButton, multiplyButton;
    private JPanel panel;

    // Variables to hold values for operations
    private double num1 = 0, num2 = 0, result = 0;
    private char operator;

    // Constructor to initialize the calculator
    public Calculator() {
        setTitle("Simple Calculator");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create display field
        display = new JTextField();
        display.setFont(new Font("Arial", Font.BOLD, 24));
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        // Create number buttons (0-9)
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].setFont(new Font("Arial", Font.BOLD, 24));
            numberButtons[i].addActionListener(this);
        }

        // Create operation buttons
        addButton = new JButton("+");
        subButton = new JButton("-");
        devideButton = new JButton("/");
        multiplyButton = new JButton("*");
        equalButton = new JButton("=");
        clearButton = new JButton("C");

        // Set font for operation buttons
        JButton[] ops = {addButton, subButton, equalButton, clearButton, multiplyButton, devideButton};
        for (JButton btn : ops) {
            btn.setFont(new Font("Arial", Font.BOLD, 24));
            btn.addActionListener(this);
        }

        // Create panel for buttons
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4, 10, 10));

        // Add buttons to panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(multiplyButton);  // Empty space
        panel.add(clearButton);
        panel.add(numberButtons[0]);
        panel.add(equalButton);
        panel.add(devideButton);

        // Add panel to frame
        add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    // Event handling for button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                display.setText(display.getText() + i);  // Append number to display
            }
        }

        if (e.getSource() == addButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '+';
            display.setText("");  // Clear the display
        }

        if (e.getSource() == subButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");  // Clear the display
        }
        if(e.getSource() == multiplyButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '*';
            display.setText("");  // Clear the display
        }
        if(e.getSource() == devideButton) {
            num1 = Double.parseDouble(display.getText());
            operator = '/';
            display.setText("");  // Clear the display
        }


        if (e.getSource() == equalButton) {
            num2 = Double.parseDouble(display.getText());

            // Perform the operation using if-else
            if (operator == '+') {
                result = num1 + num2;
            } else if (operator == '-') {
                result = num1 - num2;
            } else if (operator == '/') {
                result = num1 / num2;
            } else if (operator == '*') {
                result = num1 * num2;
            }

            display.setText(String.valueOf(result));
        }

        if (e.getSource() == clearButton) {
            display.setText("");  // Clear the display
        }

    }

    public static void main(String[] args) {
        // Run the calculator
        new Calculator();
    }
}