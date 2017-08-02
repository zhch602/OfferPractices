package practices.sort;

public class ShellSort {

    public static void main(String[] args) {
        int a[] = {5, 4, 9, 8, 7, 6, 0, 1, 3, 2};
        sort(a);
        for (int i : a) {
            System.out.println(a[i]);
        }
    }

    public static void sort(int[] a) {
        int n = a.length;
        int i, j, h, temp;
        for (h = n / 2; h > 0; h = h / 2) {
            for (i = h; i < n; i++) {
                temp = a[i];
                for (j = i - h; j >= 0; j -= h) {
                    if (temp < a[j]) {
                        a[j + h] = a[j];
                    } else break;
                }
                a[j + h] = temp;
            }
        }
    }

}
