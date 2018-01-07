
package stacknqueue;
import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;

/**
 *
 * @author Navi-PC
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] items = (Item[]) new Object[1];

    private int end;
    private int length;

    public RandomizedQueue() // construct an empty randomized queue
    {
        length = 0;
        end = 0;
    }

    public boolean isEmpty() // is the randomized queue empty?
    {
        return length == 0;
    }

    public int size() // return the number of items on the randomized queue
    {
        return length;
    }

    public void enqueue(Item item) // add the item
    {
        if (null == item) {
            throw new IllegalArgumentException();
        }

        if (length == items.length) {
            resize(2 * items.length); //double the size of array
        }

        items[end++] = item;

        length++;
    }

    //Resize the array to given capacity
    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];

        for (int i = 0; i < length; i++) {
            copy[i] = items[i];
        }

        items = copy;
    }

    public Item dequeue() // remove and return a random item
    {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        if (length > 0 && length == items.length / 4) {  //if the length of array elements is reduced to 1/4th then decrease the size of the array by half
            resize(items.length / 2);
        }

        int rand = StdRandom.uniform(end);

        Item item = items[rand];

        items[rand] = items[--end];
        items[end] = null;

        length--;

        return item;

    }

    public Item sample() // return a random item (but do not remove it)
    {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return items[StdRandom.uniform(end)];
    }

    public Iterator<Item> iterator() { // return an iterator over items in order from front to end
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> { //Iterator class
        private Item[] iterItems = (Item[]) new Object[end]; ;
        public ListIterator() {
            for(int i =0; i< end; i++){
                iterItems[i] = items[i]; 
            }
            StdRandom.shuffle(iterItems);
        }

        private int current = 0;

        @Override
        public boolean hasNext() {
            return (current < iterItems.length);
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return iterItems[current++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    public static void main(String[] args) // unit testing (optional)
    {
        RandomizedQueue<String> queue = new RandomizedQueue<>();

        queue.enqueue("1");
        queue.enqueue("2");
        queue.enqueue("3");
        queue.enqueue("4");

        for (String s : queue) {
            System.out.println(s);
        }

        for (String s : queue) {
            System.out.println(s);
        }

        System.out.println(queue.size());
        //System.out.println(queue.sample());
    }
}
