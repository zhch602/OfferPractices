package practices.sort;

public class InsertSort {

    public static void main(String[] args) {
        int a[] = {5, 4, 9, 8, 7, 6, 0, 1, 3, 2};
        sort(a);
        for (int i : a) {
            System.out.println(a[i]);
        }

    }


    public static void sort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            int temp = a[i];
            int j = i;
            if (a[j - 1] > temp) {
                while (j >= 1 && a[j - 1] > temp) {
                    a[j] = a[j - 1];
                    j--;
                }
            }
            a[j] = temp;

        }
    }
}
