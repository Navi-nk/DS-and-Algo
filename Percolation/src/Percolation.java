
/**
 *
 * @author Navi
 */
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[][] grid;
    private final WeightedQuickUnionUF quickUnionUF1, quickUnionUF2;
    private final int n;
    private int count;
    private final int cellCount;
    //private boolean isPercolates;

    public Percolation(int n) // create n-by-n grid, with all sites blocked
    {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }

        this.n = n;
        cellCount = (n * n);
        //isPercolates = false;

        quickUnionUF1 = new WeightedQuickUnionUF(cellCount);
        quickUnionUF2 = new WeightedQuickUnionUF(cellCount);

        grid = new boolean[n][n];

        for (int i = 0; i < n; i++) {

            if (i != 0) {
                quickUnionUF1.union(0, i);
                quickUnionUF2.union(0, i);
                quickUnionUF2.union(cellCount - 1, cellCount - 1 - i);
            }

            for (int j = 0; j < n; j++) {
                grid[i][j] = false;
            }
        }
    }

    public void open(int row, int col) // open site (row, col) if it is not open already
    {
        if (row > n || row <= 0) {
            throw new IllegalArgumentException();
        }
        if (col > n || col <= 0) {
            throw new IllegalArgumentException();
        }
        int r = row - 1;
        int c = col - 1;

        if (!grid[r][c]) {
            count++;
            grid[r][c] = true;

            if ((r + 1) < n && grid[r + 1][c]) {
                quickUnionUF1.union((r * n) + c, ((r + 1) * n) + c);
                quickUnionUF2.union((r * n) + c, ((r + 1) * n) + c);
            }
            if ((r - 1) >= 0 && grid[r - 1][c]) {
                quickUnionUF1.union((r * n) + c, ((r - 1) * n) + c);
                quickUnionUF2.union((r * n) + c, ((r - 1) * n) + c);
            }
            if ((c + 1) < n && grid[r][c + 1]) {
                quickUnionUF1.union((r * n) + c, ((r * n) + c + 1));
                quickUnionUF2.union((r * n) + c, ((r * n) + c + 1));
            }
            if ((c - 1) >= 0 && grid[r][c - 1]) {
                quickUnionUF1.union((r * n) + c, ((r * n) + c - 1));
                quickUnionUF2.union((r * n) + c, ((r * n) + c - 1));
            }
            //if (row == (cellCount / n) && quickUnionUF.connected(0, ((row - 1) * n) + (col - 1))) {
            //  isPercolates = true;
            //}
        }
    }

    public boolean isOpen(int row, int col) // is site (row, col) open?
    {
        if (row > n || row <= 0) {
            throw new IllegalArgumentException();
        }
        if (col > n || col <= 0) {
            throw new IllegalArgumentException();
        }

        return grid[row - 1][col - 1];

    }

    public boolean isFull(int row, int col) // is site (row, col) full?
    {
        if (row > n || row <= 0) {
            throw new IllegalArgumentException();
        }
        if (col > n || col <= 0) {
            throw new IllegalArgumentException();
        }

        boolean retVal = quickUnionUF1.connected(0, ((row - 1) * n) + (col - 1));

        return retVal && isOpen(row, col);

    }

    public int numberOfOpenSites() // number of open sites
    {
        return count;
    }

    public boolean percolates() // does the system percolate?*/
    {
        if (cellCount == 1) {
            return isOpen(1, 1);
        } else {
            return quickUnionUF2.connected(0, (cellCount - 1));
        }
    }
}
