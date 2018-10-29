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
        Queue<Comparable> list1 = new LinkedList<>();
        Queue<Comparable> list2 = new LinkedList<>();

        // TODO
        while(list2.element() != null)
        {
            list1 = centralQueue.remove();
            list2 = centralQueue.remove();
            centralQueue.add(merge(list1,list2));
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
        while(a.element() != null)
        {
            while(b.element() != null)
            {
                if (a.element().compareTo(b.element()) < 0) /*a kleiner*/
                {
                    ((LinkedList<Comparable>) c).add(a.remove());
                }
                else
                {
                    ((LinkedList<Comparable>) c).add(b.remove());
                }
            }
            ((LinkedList<Comparable>) c).add(a.remove());
        }

	
	    return c;
    }

}
