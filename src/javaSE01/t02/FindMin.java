package javaSE01.t02;

public class FindMin {
    private double e;

    public FindMin(double e) {
        this.e = e;
    }

    private static double calcA(int n) {
        return 1 / Math.pow(n + 1, 2);
    }

    public int calcMin() {
        double a;
        int i = 0;

        do {
            a = calcA(++i);

            System.out.println(a);
        } while (a > e);

        return i;
    }

    public static void main(String[] args) {
        FindMin findMin = new FindMin(0.2);
        System.out.println("Номер минимального значения " + findMin.calcMin());
    }
}
