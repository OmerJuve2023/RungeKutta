package Dao;


import Datos.EulerTO;
import interfaces.Esqueleto;

import java.text.DecimalFormat;

public class Runge implements Esqueleto {
    Dao dao = new Dao();

    public double[][] ejecucion_mat(double h, String fa, String fb, double x1, double y1, double N, double[] t) {
        double[][] array = new double[(int) N][2];
        array[0][0] = x1;
        array[0][1] = y1;
        double[] K = new double[4];
        double[] L = new double[4];
        DecimalFormat format = new DecimalFormat("####.######");
        for (int i = 1; i < N; i++) {
            System.out.println("itera: " + i + "\t\t" + "t: " + format.format(t[i]));
            K[0] = function(fa, array[i - 1][0], array[i - 1][1]);
            L[0] = function(fb, array[i - 1][0], array[i - 1][1]);
            System.out.println("K1: " + format.format(K[0]) + "\tL1: " + format.format(L[0]));
            K[1] = function(fa, array[i - 1][0] + ((h / 2) * K[0]), array[i - 1][1] + ((h / 2) * L[0]));
            L[1] = function(fb, array[i - 1][0] + ((h / 2) * K[0]), array[i - 1][1] + ((h / 2) * L[0]));
            System.out.println("k2: " + formato(fa, K[1], L[1]) + "=" + format.format(K[1]) + "\t\tL2: " + formato(fb, K[1], L[1]) + "=" + format.format(L[1]));
            K[2] = function(fa, array[i - 1][0] + ((h / 2) * K[1]), array[i - 1][1] + ((h / 2) * L[1]));
            L[2] = function(fb, array[i - 1][0] + ((h / 2) * K[1]), array[i - 1][1] + ((h / 2) * L[1]));
            System.out.println("k3: " + formato(fa, K[2], L[2]) + "=" + format.format(K[2]) + "\t\tL3: " + formato(fb, K[2], L[2]) + "=" + format.format(L[2]));
            K[3] = function(fa, array[i - 1][0] + (h * K[2]), array[i - 1][1] + (h * L[2]));
            L[3] = function(fb, array[i - 1][0] + (h * K[2]), array[i - 1][1] + (h * L[2]));
            System.out.println("k4: " + formato(fa, K[3], L[3]) + "=" + format.format(K[3]) + "\t\tL4: " + formato(fb, K[3], L[3]) + "=" + format.format(L[1]));
            array[i][0] = array[i - 1][0] + ((h / 6) * (K[0] + (2 * K[1]) + (2 * K[2]) + K[3]));
            array[i][1] = array[i - 1][1] + ((h / 6) * (L[0] + (2 * L[1]) + (2 * L[2]) + L[3]));
            System.out.println("----------------------------------------------------------");
        }
        return array;
    }

    private String formato(String funcion, double K, double L) {
        DecimalFormat format = new DecimalFormat("####.0#####");
        return funcion.replace("x", String.valueOf(format.format(K))).replace("y", String.valueOf(format.format(L)));
    }

    @Override
    public EulerTO ingress() {
        return dao.ingress();
    }

    @Override
    public double[] execution_t(double v, int i, double v1) {
        return dao.execution_t(v, i, v1);
    }

    @Override
    public void print(double[] doubles, double[][] doubles1, int i) {
        dao.print(doubles, doubles1, i);
    }

    @Override
    public void graffiti(String s, double[][] doubles, double[] doubles1, String s1, String s2) {
        dao.graffiti(s, doubles, doubles1, s1, s2);
    }

    @Override
    public double function(String s, double v, double v1) {
        return dao.function(s, v, v1);
    }
}