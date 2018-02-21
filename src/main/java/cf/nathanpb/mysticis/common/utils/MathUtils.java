package cf.nathanpb.mysticis.common.utils;

public class MathUtils {

    public static double decimalToFraction(double x){
        if (x < 0){
            return -decimalToFraction(-x);
        }
        double tolerance = 1.0E-6;
        double h1=1; double h2=0;
        double k1=0; double k2=1;
        double b = x;
        do {
            double a = Math.floor(b);
            double aux = h1; h1 = a*h1+h2; h2 = aux;
            aux = k1; k1 = a*k1+k2; k2 = aux;
            b = 1/(b-a);
        } while (Math.abs(x-h1/k1) > x*tolerance);

        return h1/k1;
    }

    public static double split(double a, double b){
        if(a == 0){
            return 0;
        }
        if(b == 0){
            return a;
        }
        return a / b;
    }
}
