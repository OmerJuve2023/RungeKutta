package Dao;

import Datos.EulerTO;
import interfaces.Esqueleto;
import org.math.plot.Plot2DPanel;
import org.nfunk.jep.JEP;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Dao implements Esqueleto {
    @Override
    public EulerTO ingress() {
        EulerTO euler = new EulerTO();
        Scanner scanner = new Scanner(System.in);
        print("Income h:\t");
        euler.setH(scanner.nextDouble());
        print("Income Function A:\t");
        euler.setFunctionA(scanner.next());
        print("Income Function B:\t");
        euler.setFunctionB(scanner.next());
        print("Income x1:\t");
        euler.setX1(scanner.nextDouble());
        print("Income y1:\t");
        euler.setY1(scanner.nextDouble());
        print("Income init range:\t");
        euler.setRangeI(scanner.nextInt());
        print("Income final range:\t");
        euler.setRangeF(scanner.nextInt());
        println("----------------------------");
        return euler;
    }

    @Override
    public double[] execution_t(double initial, int N, double h) {
        double[] t = new double[N];
        t[0] = initial;
        for (int i = 1; i < N; i++) {
            t[i] = t[i - 1] + h;
        }
        return t;
    }

    @Override
    public void print(double[] t, double[][] xy, int N) {
        DecimalFormat format = new DecimalFormat("##00.000000");
        DecimalFormat form = new DecimalFormat("#0.00");
        println("iteration" + "\t" + "\t" + "T" + "\t" + "\t" + "\t" + "X" + "\t" + "\t" + "\t" + "Y");
        for (int i = 0; i < N; i++) {
            println("\t" + (i + 1) + "\t" + "|\t" + "\t" + form.format(t[i]) +
                    "\t" + "|\t" + format.format(xy[i][0]) + "\t" + "|\t" + format.format(xy[i][1]));
        }
    }

    @Override
    public void graffiti(String name, double[][] xy, double[] t, String functionA, String functionB) {
        double[] x = new double[xy.length];
        double[] y = new double[xy.length];
        for (int i = 0; i < xy.length; i++) {
            x[i] = xy[i][0];
            y[i] = xy[i][1];
        }

        JFrame panel = new JFrame("Euler graph with two equations");
        panel.setBounds(370, 10, 600, 550);
        panel.setLocationRelativeTo(null);
        panel.setVisible(true);
        panel.setResizable(false);

        Plot2DPanel graffiti = new Plot2DPanel();
        graffiti.setBounds(370, 10, 600, 550);
        graffiti.addLegend("SOUTH");
        graffiti.addLinePlot(functionA, t, x);
        graffiti.addLinePlot(functionB, t, y);
        graffiti.setVisible(true);
        panel.add(graffiti);

    }

    @Override
    public double function(String function, double x, double y) {
        JEP jep = new JEP();
        jep.addStandardFunctions();
        jep.addStandardConstants();
        jep.addVariable("x", x);
        jep.addVariable("y", y);
        jep.parseExpression(function);
        return jep.getValue();
    }

    private void print(String txt) {
        System.out.print(txt);
    }

    private void println(String txt) {
        System.out.println(txt);
    }
}