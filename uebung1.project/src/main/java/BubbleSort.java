import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] a = {35, 22, 10, 51, 48};
        System.out.println("Eingabe: " + Arrays.toString(a));
        bubbleSort(a);
        System.out.println("Ausgabe: " + Arrays.toString(a));
    }

    public static void bubbleSort (int[] a)
    {
        int tmp;

        for(int i = 1; i < a.length - 1; i++)
        {
            for(int j = a.length - 1; j >= i; j--)
            {
                if(a[j] < a[j - 1])
                {
                    tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
                }
            }
        }
    }
}
