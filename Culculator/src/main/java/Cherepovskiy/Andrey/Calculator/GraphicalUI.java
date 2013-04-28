package Cherepovskiy.Andrey.Calculator;

import Cherepovskiy.Andrey.Calculator.Servises.Calculator;
import Cherepovskiy.Andrey.Calculator.Servises.EvaluationException;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.BigDecimal;

public class GraphicalUI {
    private JPanel panel;
    private JFrame frame;
    private JLabel labelExpression;
    private JTextField textFieldExpression;
    private JLabel labelResult;
    private JTextField textFieldResult;
    private JButton buttonRun;

    public GraphicalUI() {
        frame = new JFrame("Calculator");
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setBounds(100, 100, 385, 125);
        panel = new JPanel(null);

        labelExpression = new JLabel("Expression");
        labelExpression.setBounds(15, 15, 70, 20);
        panel.add(labelExpression);

        textFieldExpression = new JTextField();
        textFieldExpression.setBounds(90, 15, 280, 20);

        panel.add(textFieldExpression);

        labelResult = new JLabel("Result");
        labelResult.setBounds(15, 40, 70, 20);
        panel.add(labelResult);

        textFieldResult = new JTextField();
        textFieldResult.setBounds(90, 40, 280, 20);
        panel.add(textFieldResult);

        buttonRun = new JButton("Calculate");
        buttonRun.setBounds(140, 70, 120, 20);
        panel.add(buttonRun);
        buttonRun.addActionListener(new ButtonActionListener());
        textFieldExpression.addKeyListener(new KeyActionListener());

        frame.getContentPane().add(panel);
        textFieldExpression.requestFocusInWindow();

        frame.setVisible(true);
    }

    public String getExpression() {
        return textFieldExpression.getText();
    }

    public void setResult(String result) {
        textFieldResult.setText(result);
    }

    public void setPosition(int position) {

        textFieldExpression.setCaretPosition(position);
        textFieldExpression.requestFocusInWindow();
    }

    public void Calculate() {
        try {
            final BigDecimal result = new Calculator().evaluate(getExpression());
            setResult(result.toString());
        } catch (EvaluationException e) {
            setPosition(e.getErrorPosition());
            setResult(e.getMessage());
        }
    }

    private class ButtonActionListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Calculate();
        }
    }

    private class KeyActionListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) {
            if ('\n' == e.getKeyChar()) {
                Calculate();
            }
        }

        @Override
        public void keyPressed(KeyEvent e) {}

        @Override
        public void keyReleased(KeyEvent e) {}
    }

}