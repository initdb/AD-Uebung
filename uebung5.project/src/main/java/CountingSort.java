public class CountingSort {

    /**
     * @param input integer array given as input
     * @param k     defines maximum integer value in input; all integers must in range [0..k]
     * @return input array is sorted in a stable (!!) manner
     */
    public static Integer[] sort(Integer[] input, Integer k)
    {
        Integer[] output = new Integer[input.length];
        Integer[] keepCounts = new Integer[k+1];

        // init arrays with 0s, can be done easier ?
        for(int i = 0; i < output.length - 1; i++)
        {
            output[i] = 0;
        }

        for(int i = 0; i < keepCounts.length; i++)
        {
            keepCounts[i] = 0;
        }

        // count all values
        for(int i = 0; i < input.length; i++)
        {
            keepCounts[input[i]] = keepCounts[input[i]]+1;
        }

        // count all values in C[i] which are less then i
        // start with 1 and not 0, since nothing before 1
        for(int i = 1; i < keepCounts.length; i++)
        {
            keepCounts[i] = keepCounts[i-1] + keepCounts[i];
        }

        //0 bis k
        for(int i = input.length; i > 0; i--)
        {
            output[(keepCounts[input[i-1]]-1)] = input[i-1];
            // decremnt counter of current value
            keepCounts[input[i-1]] = keepCounts[input[i-1]] - 1;
        }

        return output;
    }

}
