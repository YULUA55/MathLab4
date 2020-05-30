package com.company.Method;

import net.objecthunter.exp4j.Expression;
import java.util.ArrayList;

public class MethodRungeKutta {

    private ArrayList<Double> X;
    private ArrayList<Double> Y;
    private double x0;
    private double y0;
    private double endPoint;
    private double accuracy;
    private Expression expression;

    public MethodRungeKutta(Expression expression, double x0, double y0, double endPoint, double accuracy) {
        this.expression = expression;
        this.x0 = x0;
        this.y0 = y0;
        this.endPoint = endPoint;
        this.accuracy = accuracy;
    }

    public ArrayList<Double> getX() {
        return X;
    }

    public ArrayList<Double> getY() {
        return Y;
    }

    public void solve() {

        double h = Math.pow(accuracy, 1 / 4.0);
        double diff = endPoint - x0;
        if (h > diff)
            throw new IllegalArgumentException("Задана слишком большая погрешность для такого промежутка");
        int count = (int) ((endPoint - x0) / h);
        count++;
        double yi = y0;
        double xi = x0;

        X = new ArrayList<>();
        Y = new ArrayList<>();

        for (int i = 0; i <= count; i++) {
            X.add(xi + h * i);
        }

        for (Double i :
                X) {
            Y.add(yi);
            yi += deltaYi(expression, i, yi, h);
        }

    }

    private double deltaYi(Expression expression, Double x, double y, double h) {
        double k1 = expression.setVariable("x", x).setVariable("y", y).evaluate();
        double k2 = expression.setVariable("x", x + h / 2).setVariable("y", y + h*k1 / 2).evaluate();
        double k3 = expression.setVariable("x", x + h / 2).setVariable("y", y + h*k2 / 2).evaluate();
        double k4 = expression.setVariable("x", x + h).setVariable("y", y + h*k3 ).evaluate();
        return h / 6 * (k1 + 2 * k2 + 2 * k3 + k4);
    }

}
