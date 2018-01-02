/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quickunion;

/**
 *
 * @author Navi-PC
 */
public class QuickUnion {

    private final int[] arr;
    private final int N;

    public QuickUnion(int N) {
        this.N = N;
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }
    }

    private int root(int p) {
        while (arr[p] != p) {
            p = arr[p];
        }

        return p;
    }

    public boolean isConnected(int p, int q) {
        if (N <= p || N <= q) {
            return false;
        }
        return (root(p) == root(q));
    }

    public void union(int p, int q) {
        if (N <= p || N <= q) {
            return;
        }
        int p_root = root(p);
        int q_root = root(q);

        arr[p_root] = q_root;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("quickfind.QuickFind.main()");
        QuickUnion q = new QuickUnion(10);
        q.union(0, 1);
        q.union(5, 6);
        q.union(0, 6);
        q.union(7, 9);
        q.union(7, 5);
        System.out.println(q.isConnected(1, 5));
        System.out.println(q.isConnected(6, 0));
        System.out.println(q.isConnected(9, 0));
    }
}
