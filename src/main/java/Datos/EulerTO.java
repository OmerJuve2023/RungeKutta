package Datos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EulerTO {

    private double h;
    private String functionA;
    private String functionB;
    private double x1;
    private double y1;
    private int rangeI;
    private int rangeF;

    public int getN() {
        return (int) ((this.rangeF - this.rangeI) / this.h);
    }
    
}
