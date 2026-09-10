/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rmi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

/**
 *
 * @author prasad
 */
public class Client {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculatorGUI().setVisible(true);
        });
    }
}

class CalculatorGUI extends JFrame {
    private JTextField number1Field;
    private JTextField number2Field;
    private JTextField resultField;
    private CalcIntf calculator;

    public CalculatorGUI() {
        try {
            calculator = (CalcIntf) Naming.lookup("//localhost:1091/Calculator");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error connecting to server: " + e.getMessage());
            System.exit(1);
        }

        setTitle("RMI Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        JLabel number1Label = new JLabel("Number 1:");
        number1Field = new JTextField();

        JLabel number2Label = new JLabel("Number 2:");
        number2Field = new JTextField();

        JLabel resultLabel = new JLabel("Result:");
        resultField = new JTextField();
        resultField.setEditable(false);

        JButton addButton = new JButton("+");
        JButton subtractButton = new JButton("-");
        JButton multiplyButton = new JButton("x");
        JButton divideButton = new JButton("/");

        addButton.addActionListener(new OperationListener("add"));
        subtractButton.addActionListener(new OperationListener("sub"));
        multiplyButton.addActionListener(new OperationListener("mul"));
        divideButton.addActionListener(new OperationListener("div"));

        add(number1Label);
        add(number1Field);
        add(number2Label);
        add(number2Field);
        add(resultLabel);
        add(resultField);
        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(divideButton);
    }

    private class OperationListener implements ActionListener {
        private String operation;

        public OperationListener(String operation) {
            this.operation = operation;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                float num1 = Float.parseFloat(number1Field.getText());
                float num2 = Float.parseFloat(number2Field.getText());
                float result = 0;

                switch (operation) {
                    case "add":
                        result = calculator.add(num1, num2);
                        break;
                    case "sub":
                        result = calculator.sub(num1, num2);
                        break;
                    case "mul":
                        result = calculator.mul(num1, num2);
                        break;
                    case "div":
                        result = calculator.div(num1, num2);
                        break;
                }

                resultField.setText(String.valueOf(result));
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(CalculatorGUI.this, "Error: " + ex.getMessage());
            }
        }
    }
}
