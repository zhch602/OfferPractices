package practices.sort;

public class HeapSort {

    public static void main(String[] args) {
        int a[] = {5, 4, 9, 8, 7, 6, 0, 1, 3, 2};
        sort(a);
        for (int i : a) {
            System.out.println(a[i]);
        }
    }

    public static void adjustMaxHeap(int[] a, int pos, int len) {
        int temp, child;
        for (temp = a[pos]; 2 * pos + 1 <= len; pos = child) {
            child = 2 * pos + 1;
            if (child < len && a[child] < a[child + 1]) {
                child++;
            }
            if (a[child] > temp) {
                a[pos] = a[child];
            } else break;
        }
        a[pos] = temp;
    }

    public static void sort(int[] a) {
        int i, n = a.length;
        for (i = n / 2 - 1; i >= 0; i--) {
            adjustMaxHeap(a, i, n - 1);
        }
        for (i = n - 1; i >= 0; i--) {
//            adjustMaxHeap(a,0,i);
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            adjustMaxHeap(a, 0, i - 1);
        }
    }

}
