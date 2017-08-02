package practices.sort;

public class SelectSort {

    public static void main(String[] args) {
        int a[] = {5, 4, 9, 8, 7, 6, 0, 1, 3, 2};
        sort(a);
        for (int i : a) {
            System.out.println(a[i]);
        }

    }

    public static void sort(int[] a) {
        int temp;
        int flag;
        int n = a.length;
        for (int i = 0; i < n; i++) {
            temp = a[i];
            flag = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j] < temp) {
                    temp = a[j];
                    flag = j;
                }
            }
            if (flag != i) {
                a[flag] = a[i];
                a[i] = temp;
            }
        }
    }
}
