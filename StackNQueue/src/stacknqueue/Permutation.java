package stacknqueue;

import edu.princeton.cs.algs4.StdIn;

/**
 *
 * @author Navi-PC
 */
public class Permutation {

    public static void main(String[] args) {
        int length = Integer.parseInt(args[0]);

        RandomizedQueue<String> queue = new RandomizedQueue<>();

        while (!StdIn.isEmpty()) {
            queue.enqueue(StdIn.readString());
        }

        for (int i = 0; i < length; i++) {
            System.out.println(queue.dequeue());
        }
    }
}
