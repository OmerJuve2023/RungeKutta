package interfaces;

import domain.EulerTO;

public interface Esqueleto {
    EulerTO ingress();

    double[] execution_t(double initial, int N, double h);

    void print(double[] t, double[][] xy, int N);

    void graffiti(String name, double[][] xy, double[] t, String functionA, String functionB);

    double function(String function, double x, double y);
    
}
