package com.company.ActionListeners;


import com.company.Chart.Chart;
import com.company.Method.MethodRungeKutta;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    private JTextField inputX0;
    private JTextField inputY0;
    private JTextField inputFunction;
    private JTextField inputAccuracy;
    private JTextField inputXn;
    private Container container;
    private Chart chart;

    private double x0;
    private double y0;
    private double endPoint;
    private double accuracy;
    private Expression expression;


    public ButtonListener(JTextField inputX0, JTextField inputY0, JTextField inputFunction, JTextField inputAccuracy,
                          JTextField inputXn, Container container, Chart chart) {
        this.inputX0 = inputX0;
        this.inputY0 = inputY0;
        this.inputFunction = inputFunction;
        this.inputAccuracy = inputAccuracy;
        this.inputXn = inputXn;
        this.container = container;
        this.chart = chart;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            x0 = Double.parseDouble(inputX0.getText());
            endPoint = Double.parseDouble(inputXn.getText());
            y0 = Double.parseDouble(inputY0.getText());
            String choice = inputFunction.getText();
            accuracy = Double.parseDouble(inputAccuracy.getText());

            try {
                if (choice.contains("y"))
                    expression = new ExpressionBuilder(choice).variables("x", "y").build();
                else
                    expression = new ExpressionBuilder(choice).variables("x").build();

                MethodRungeKutta method = new MethodRungeKutta(expression, x0, y0, endPoint, accuracy);
                method.solve();

                container.remove(1);
                container.add(chart.createChart("График функции", method.getX(), method.getY()), 1);
                container.revalidate();
                container.repaint();
            } catch (Exception ex) {
                System.out.println("Дифференциальное уравнение задано неверно!");
            }


        } catch (NumberFormatException ex) {
            System.out.println("Поля заполнены неккоректно или не заполнены!");
        }

    }
}