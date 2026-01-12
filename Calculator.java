import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;

class Calculator extends JFrame implements ActionListener {

    static JFrame frame;
    static JTextField display;

    String num1, operator, num2;

    Calculator() {
        num1 = operator = num2 = "";
    }

    public static void main(String[] args) {
        frame = new JFrame("Calculator");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        Calculator calculator = new Calculator();

        display = new JTextField(16);
        display.setEditable(false);

        JButton[] numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(calculator);
        }

        JButton addButton = new JButton("+");
        JButton subtractButton = new JButton("-");
        JButton multiplyButton = new JButton("*");
        JButton divideButton = new JButton("/");
        JButton equalsButton = new JButton("=");
        JButton clearButton = new JButton("C");

        addButton.addActionListener(calculator);
        subtractButton.addActionListener(calculator);
        multiplyButton.addActionListener(calculator);
        divideButton.addActionListener(calculator);
        equalsButton.addActionListener(calculator);
        clearButton.addActionListener(calculator);

        JPanel panel = new JPanel();
        panel.add(display);

        for (JButton button : numberButtons) {
            panel.add(button);
        }

        panel.add(addButton);
        panel.add(subtractButton);
        panel.add(multiplyButton);
        panel.add(divideButton);
        panel.add(clearButton);
        panel.add(equalsButton);

        frame.add(panel);
        frame.setSize(250, 250);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = e.getActionCommand();

        if (input.matches("\\d")) { // If input is a digit
            if (operator.isEmpty()) {
                num1 += input;
            } else {
                num2 += input;
            }
            display.setText(num1 + operator + num2);
        } else if (input.equals("C")) {
            num1 = operator = num2 = "";
            display.setText("");
        } else if (input.equals("=")) {
            double result = 0;

            switch (operator) {
                case "+":
                    result = Double.parseDouble(num1) + Double.parseDouble(num2);
                    break;
                case "-":
                    result = Double.parseDouble(num1) - Double.parseDouble(num2);
                    break;
                case "*":
                    result = Double.parseDouble(num1) * Double.parseDouble(num2);
                    break;
                case "/":
                    result = Double.parseDouble(num1) / Double.parseDouble(num2);
                    break;
            }

            display.setText(num1 + operator + num2 + "=" + result);
            num1 = String.valueOf(result);
            operator = num2 = "";
        } else {
            if (operator.isEmpty()) {
                operator = input;
            } else {
                if (!num2.isEmpty()) {
                    double result = 0;

                    switch (operator) {
                        case "+":
                            result = Double.parseDouble(num1) + Double.parseDouble(num2);
                            break;
                        case "-":
                            result = Double.parseDouble(num1) - Double.parseDouble(num2);
                            break;
                        case "*":
                            result = Double.parseDouble(num1) * Double.parseDouble(num2);
                            break;
                        case "/":
                            result = Double.parseDouble(num1) / Double.parseDouble(num2);
                            break;
                    }

                    num1 = String.valueOf(result);
                    operator = input;
                    num2 = "";
                }
            }
            display.setText(num1 + operator + num2);
        }
    }
}
