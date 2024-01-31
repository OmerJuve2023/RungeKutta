package Ejecutable;

import Dao.Runge;
import Datos.EulerTO;

import java.util.Scanner;

public class EjecutableRunge extends Runge {

    EulerTO Datos;
    double[] t;
    double[][] xy;

    public void process() {
        Datos = ingress();
        t = execution_t(Datos.getRangeI(), Datos.getN(), Datos.getH());
        xy = ejecucion_mat(Datos.getH(), Datos.getFunctionA(), Datos.getFunctionB(), Datos.getX1(), Datos.getY1(), Datos.getN(), this.t);
        print(t, xy, Datos.getN());
        graffiti("", xy, t, Datos.getFunctionA(), Datos.getFunctionB());
        System.out.println("Continue:    si/no ");
        Scanner scanner = new Scanner(System.in);
        String rpta = scanner.next();
        if (rpta.equals("si")) {
            process();
        } else {
            System.exit(0);
        }
    }
}
