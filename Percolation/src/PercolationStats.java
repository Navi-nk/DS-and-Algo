
/**
 *
 * @author Navi
 */
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private final double[] thresholds;
    private final double sqrtT;
    private double meanVal;
    private double stdVal;
    
    private static final double CONFIDENCE_95 = 1.96;

    public PercolationStats(int n, int trials) // perform trials independent experiments on an n-by-n grid
    {

        if (n <= 0 || trials <= 0) {
            throw new IllegalArgumentException();
        }

        thresholds = new double[trials];
        int t = trials;
        sqrtT = Math.sqrt((double) t);
        int count = n * n;

        for (int i = 0; i < trials; i++) {
            Percolation p = new Percolation(n);
            int[] rand = StdRandom.permutation(count);

            for (int j = 0; j < count; j++) {
                p.open((rand[j] / n) + 1, (rand[j] % n) + 1);
                if (p.percolates()) {
                    break;
                }
            }

            thresholds[i] = (double) (p.numberOfOpenSites()) / count;
        }

    }

    public double mean() // sample mean of percolation threshold
    {
        meanVal = StdStats.mean(thresholds);
        return meanVal;
    }

    public double stddev() // sample standard deviation of percolation threshold
    {
        stdVal = StdStats.stddev(thresholds);
        return stdVal;
    }

    public double confidenceLo() // low  endpoint of 95% confidence interval
    {
        if(meanVal == 0)
            mean();
        if(stdVal == 0)
            stddev();
        return (meanVal - ((CONFIDENCE_95 * stdVal) / sqrtT));
    }

    public double confidenceHi() // high endpoint of 95% confidence interval
    {
        if(meanVal == 0)
            mean();
        if(stdVal == 0)
            stddev();
        return (meanVal + ((CONFIDENCE_95 * stdVal) / sqrtT));
    }

    public static void main(String[] args) // test client (described below)
    {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);

        PercolationStats percolationStats = new PercolationStats(n, t);

        System.out.println(String.format("mean                    = %4.10f", percolationStats.mean()));
        System.out.println(String.format("stddev                  = %4.10f", percolationStats.stddev()));
        System.out.println(String.format("%s Confidence interval = [%4.10f,%4.10f]", "95%", percolationStats.confidenceLo(), percolationStats.confidenceHi()));

    }
}
