package practices.sort;

public class QuickSort {

    public static void main(String[] args) {
        int a[] = {5, 4, 9, 8, 7, 6, 0, 1, 3, 2};
        sort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.println(a[i]);
        }
    }

    public static void sort(int[] a, int low, int high) {
        int i, j, index, temp;
        if (low >= high) {
            return;
        }
        i = low;
        j = high;
        index = a[i];
        while (i != j) {
            while (i < j && a[j] >= index) {
                j--;
            }
            while (i < j && a[i] <= index) {
                i++;
            }
            if (i < j) {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        a[low] = a[i];
        a[i] = index;

        sort(a, low, i - 1);
        sort(a, i + 1, high);
    }

}
