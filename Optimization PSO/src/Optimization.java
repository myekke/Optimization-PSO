import java.util.Random;

public class Optimization {

    public static double[][] findMin(RealFunction f, int d) {
        int np = 30;
        Random r = new Random();

        double x[][] = new double[np][d];
        double p[][] = new double[np][d];
        double v[][] = new double[np][d];
        double xbest[] = new double[d];

        double rp = 10;
        double rg = 10;
        double fp = 5.2;
        double fg = 1.5;
        double w = 0.3;

        for (int i = 0; i < d; i++) {
            xbest[i] = 100 * r.nextDouble() - 50;
        }

        for (int i = 0; i < np; i++) {
            for (int j = 0; j < d; j++) {
                x[i][j] = 100 * r.nextDouble() - 50;
                p[i][j] = x[i][j];
            }

            if (f.eval(xbest) > f.eval(p[i])) {
                System.arraycopy(p[i], 0, xbest, 0, d);
            }

            for (int j = 0; j < d; j++) {
                v[i][j] = 100 * r.nextDouble() - 50;
            }
        }

        int c = 0;

        while (c++ <= 1000) {
            for (int i = 0; i < np; i++) {
                for (int j = 0; j < d; j++) {
                    rp = r.nextDouble();
                    rg = r.nextDouble();
                    v[i][j] = w * v[i][j] + fp * rp * (p[i][j] - x[i][j]) + fg * rg * (xbest[j] - x[i][j]);
                    x[i][j] += v[i][j];
                }

                if (f.eval(x[i]) < f.eval(p[i])) {
                    System.arraycopy(x[i], 0, p[i], 0, d);
                    if (f.eval(p[i]) < f.eval(xbest)) {
                        System.arraycopy(p[i], 0, xbest, 0, d);
                    }
                }
            }
            printLog(c, xbest, f.eval(xbest));

        }

         return new double[][] {xbest, new double[]{f.eval(xbest)}};
    }

    public static double[][] findMax(RealFunction f, int d) {
        int np = 30;
        Random r = new Random();
        double x[][] = new double[np][d];
        double p[][] = new double[np][d];
        double v[][] = new double[np][d];
        double xbest[] = new double[d];

        double rp = 0;
        double rg = 0;
        double fp = 0.2;
        double fg = 0.5;
        double w = 0.1;

        for (int i = 0; i < d; i++) {
            xbest[i] = 100 * r.nextDouble() - 50;
        }

        for (int i = 0; i < np; i++) {
            for (int j = 0; j < d; j++) {
                x[i][j] = 100 * r.nextDouble() - 50;
                p[i][j] = x[i][j];
            }

            if (f.eval(xbest) < f.eval(p[i])) {
                System.arraycopy(p[i], 0, xbest, 0, d);
            }

            for (int j = 0; j < d; j++) {
                v[i][j] = 100 * r.nextDouble() - 50;
            }
        }

        int c = 0;

        while (c++ <= 1000) {
            for (int i = 0; i < np; i++) {
                for (int j = 0; j < d; j++) {
                    rp = r.nextDouble();
                    rg = r.nextDouble();
                    v[i][j] = w * v[i][j] + fp * rp * (p[i][j] - x[i][j]) + fg * rg * (xbest[j] - x[i][j]);
                    x[i][j] += v[i][j];
                }

                if (f.eval(x[i]) > f.eval(p[i])) {
                    System.arraycopy(x[i], 0, p[i], 0, d);
                    if (f.eval(p[i]) > f.eval(xbest)) {
                        System.arraycopy(p[i], 0, xbest, 0, d);
                    }
                }
            }
            printLog(c, xbest, f.eval(xbest));
        }

        return new double[][]{xbest, new double[]{f.eval(xbest)}};
    }

    private static void printLog(int iteration, double[] x, double y) {
        String s = "The best X in iter. (" + iteration + "), is [ ";
        for (int i = 0; i < x.length - 1; i++) {
            s += x[i] + ", ";
        }
        s += x[x.length - 1] + " ]";
        s += " and Y is " + y;

 //System.out.println(s);
    }
}
