package javaSE01.t04;

public class FindMax {
    private double[] series;

    public FindMax(double[] series) {
        this.series = series;
    }

    public double findMax() {
        double max = Double.NEGATIVE_INFINITY;

        for (int i = 1; i <= series.length / 2; i++){
            max = max > series[i - 1] + series[series.length - i] ?
                    max : series[i - 1] + series[series.length - i];
        }

        return max;
    }

    public static void main(String[] args) {
        FindMax findMax = new FindMax(new double[]{1, 2, 3, 7, 3, -2});
        System.out.println("Максимальное значение " + findMax.findMax());
    }
}
