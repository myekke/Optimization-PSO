public class Mymethod implements RealFunction {

    @Override
    public double eval(double[] x) {
        double sum = 0;

        for (int i = 0; i < x.length ; i++) {
            sum+=x[i];
        }
        return sum/x.length;
    }
}

