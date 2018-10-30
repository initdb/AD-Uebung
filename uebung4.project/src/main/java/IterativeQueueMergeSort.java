import java.util.LinkedList;
import java.util.Queue;

/**
 * Iterative MergeSort using Queues
 * idea and parts of the code from Sedgewick et al., adapted by W. Mühlbauer
 */
public class IterativeQueueMergeSort {

    /**
     * central queue: a queue that stores queues!
     * - contains in the beginning n queues (each with 1 element),
     * - repeatedly merge until only one queue remains
     * Hint: Java Collection Interface "Queue"
     * - "Queue" is only an interface, here a "LinkedList" is always used as its implementation
     * - enqueue: method add(.)
     * - dequeue: method remove(.)
     * - peek:    methoed peek(.) or element(.) to examine element at head of queue without removing it.
     */
    private static Queue<Queue<Comparable>> centralQueue;


    /**
     * sorts array a. Note: The input array is overwritten with the result.
     * @param a array to be sorted
     */
    public static void sort(Comparable[] a) {
        centralQueue = new LinkedList<Queue<Comparable>>();

        // TODO
        for(int i = 0;i < a.length; i++)
        {
            LinkedList<Comparable> tmp = new LinkedList<>();    // erstellt neue Queue
            tmp.add(a[i]);                                      // fügt arry elemnt zur Queue hinzu
            centralQueue.add(tmp);  // fügt neue Queue zu central Queue hinzu.

        }

        while(centralQueue.size() > 1)
        {
            centralQueue.add(merge(centralQueue.remove(), centralQueue.remove()));
        }

        // write result to array
        for(int i = 0; i < a.length; i++)
        {
            a[i] = centralQueue.element().remove();
        }
    }


    /**
     * Merges 2 sorted (!!!) queues. Returns 1 queue that contains all elements of the two input
     * queues in sorted (!) order.
     * @param a first queue (sorted!)
     * @param b second queue (sorted!)
     * @return queue with elements of a and b in sorted order
     */
    private static Queue<Comparable> merge(Queue<Comparable> a, Queue<Comparable> b)
    {
        Queue<Comparable> c = new LinkedList<Comparable>();
        // TODO
        while(!a.isEmpty() && !b.isEmpty())
        {
            if (a.element().compareTo(b.element()) < 0) /*a kleiner*/
            {
                c.add(a.remove());
            }
            else
            {
                c.add(b.remove());
            }
        }

        while(!a.isEmpty())
        {
            c.add(a.remove());
        }

        while(!b.isEmpty())
        {
            c.add(b.remove());
        }

	    return c;
    }

}
