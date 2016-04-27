package javaSE01.t03;

public class CalcFunction {

    private double a;
    private double b;
    private double h;

    public CalcFunction(double a, double b, double h) {
        this.a = a;
        this.b = b;
        this.h = h;
    }

    public void calcData() {
        for (double x = a; x <= b; x += h) {
            System.out.println("x= " + x + ", " + "y= " + function(x));
        }
    }

    static double function(double x){

        return Math.tan(2 * x) - 3;
    }

    public static void main(String[] args) {
        CalcFunction calcFunction = new CalcFunction(1, 10, 0.5);
        calcFunction.calcData();
    }
}
