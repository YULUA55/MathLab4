package com.company.Drawing;

import com.company.ActionListeners.ButtonListener;
import com.company.Chart.Chart;
import org.jdesktop.swingx.VerticalLayout;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;


public class GUI extends JFrame {

    private JButton checkButton = new JButton("Нарисовать");

    private JLabel labelX0 = new JLabel("Координата X0 : ");
    private JLabel labelXn = new JLabel("Координата Xn : ");
    private JLabel labelY0 = new JLabel("Координата Y0 : ");
    private JLabel labelFunction = new JLabel("y'= : ");
    private JLabel labelAccuracy = new JLabel("Точность : ");

    private JTextField inputX0 = new JTextField("",5);
    private JTextField inputXn = new JTextField("",5);
    private JTextField inputY0 = new JTextField("", 5);
    private JTextField inputFunction = new JTextField("", 5);
    private JTextField inputAccuracy = new JTextField("", 5);


    public GUI() {
        super("График функции");
        this.setBounds(100, 100, 700, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        labelX0.setForeground(Color.white);
        labelXn.setForeground(Color.white);
        labelY0.setForeground(Color.white);
        labelFunction.setForeground(Color.white);
        labelAccuracy.setForeground(Color.white);
        labelX0.setPreferredSize(new Dimension(50, 50));
        inputX0.setPreferredSize(new Dimension(50, 50));
        labelXn.setPreferredSize(new Dimension(50, 50));
        inputXn.setPreferredSize(new Dimension(50, 50));
        labelY0.setPreferredSize(new Dimension(50, 50));
        inputY0.setPreferredSize(new Dimension(50, 50));
        labelFunction.setPreferredSize(new Dimension(50, 50));
        inputFunction.setPreferredSize(new Dimension(50, 50));
        labelAccuracy.setPreferredSize(new Dimension(50, 50));
        inputAccuracy.setPreferredSize(new Dimension(50, 50));


        JPanel inputPanel = new JPanel(new VerticalLayout());
        inputPanel.setBackground(new Color(54,54,54));
        inputPanel.setPreferredSize(new Dimension(500,200));
        inputPanel.add(labelX0);
        inputPanel.add(inputX0);
        inputPanel.add(labelXn);
        inputPanel.add(inputXn);
        inputPanel.add(labelY0);
        inputPanel.add(inputY0);
        inputPanel.add(labelFunction);
        inputPanel.add(inputFunction);
        inputPanel.add(labelAccuracy);
        inputPanel.add(inputAccuracy);
        inputPanel.add(new Label());
        inputPanel.add(new Label());
        inputPanel.add(new Label());
        inputPanel.add(new Label());
        inputPanel.add(checkButton);

        container.add(inputPanel);

        Chart chart = new Chart();
        checkButton.addActionListener(new ButtonListener(inputX0, inputY0, inputFunction, inputAccuracy, inputXn, container, chart));

        container.add(chart.createChart("График", new ArrayList<Double>(), new ArrayList<Double>()),1);

        setLayout(new BoxLayout(container, 0));
    }
}