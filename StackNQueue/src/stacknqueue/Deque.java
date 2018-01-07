package stacknqueue;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author Navi-PC
 */
public class Deque<Item> implements Iterable<Item> {

    @Override
    public Iterator<Item> iterator() { // return an iterator over items in order from front to end
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {

        private Node<Item> current = first;

        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public Item next() {
            if (current == null) {
                throw new NoSuchElementException();
            }

            Item i = current.item;
            current = current.next;

            return i;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    private class Node<Item> {

        Item item;
        Node<Item> next;
        Node<Item> previous;
    }

    private Node<Item> first;
    private Node<Item> last;
    private int length;

    public Deque() // construct an empty deque
    {
        length = 0;
        first = null;
        last = first;
    }

    public boolean isEmpty() // is the deque empty?
    {
        return first == null;
    }

    public int size() // return the number of items on the deque
    {
        return length;
    }

    public void addFirst(Item item) // add the item to the front
    {
        if (null == item) {
            throw new IllegalArgumentException();
        }

        Node<Item> oldFirst = first;
        Node<Item> node = new Node<>();
        node.item = item;
        node.next = oldFirst;
        node.previous = null;

        if (isEmpty()) {
            last = node;
        } else {
            oldFirst.previous = node;
        }

        first = node;
        length++;

    }

    public void addLast(Item item) // add the item to the end
    {
        if (null == item) {
            throw new IllegalArgumentException();
        }

        Node<Item> oldLast = last;
        Node<Item> node = new Node<>();
        node.item = item;
        node.next = null;
        node.previous = oldLast;

        if (isEmpty()) {
            first = node;
        } else {
            oldLast.next = node;
        }

        last = node;

        length++;
    }

    public Item removeFirst() // remove and return the item from the front
    {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        Node<Item> item = first;

        first = item.next;

        if (null != first) {
            first.previous = null;
        } else {
            last = first;
        }

        length--;

        return item.item;
    }

    public Item removeLast() // remove and return the item from the end
    {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<Item> item = last;
        last = item.previous;

        if (null != last) {
            last.next = null;
        } else {
            first = last;
        }

        length--;

        return item.item;
    }

    public static void main(String[] args) // unit testing (optional)
    {
        Deque<String> d = new Deque<>();
        d.addLast("first");
        d.addLast("Second");
        d.addFirst("third");
        for (String s : d) {
            System.out.println(s);
        }

        System.out.println(d.isEmpty());

        System.out.println(d.size());

        System.out.println(d.removeLast());
        System.out.println(d.isEmpty());
        System.out.println(d.size());

    }
}
