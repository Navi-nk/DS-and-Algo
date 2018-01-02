/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quickfind;

/**
 *
 * @author Navi-PC
 */
public class QuickFind {

    private final int[] arr;
    final private int N;

    public QuickFind(int N) {
        this.N = N;
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }
    }

    public boolean isConnected(int p, int q) {
        if (N <= p || N <= q) {
            return false;
        }
        return (arr[p] == arr[q]);
    }

    public void union(int p, int q) {
        if (N <= p || N <= q) {
            return;
        }
        int pid = arr[p];
        int qid = arr[q];

        if (pid == qid) {
            return;
        }

        for (int i = 0; i < N; i++) {
            if (arr[i] == pid) {
                arr[i] = qid;
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("quickfind.QuickFind.main()");
        QuickFind q = new QuickFind(10);
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
