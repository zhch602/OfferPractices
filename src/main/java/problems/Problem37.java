package problems;

public class Problem37 {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 3, 3, 3, 4, 5};
        int[] b = {3, 3, 3, 3, 4, 5};
        Problem37 problem37 = new Problem37();
        System.out.println(problem37.GetNumberOfK(b, 3));
    }

    public int GetNumberOfK(int[] array, int k) {
        int number = 0;
        if (array != null && array.length > 0) {
            int firstK = getFirstK(array, k, 0, array.length - 1);
            int lastK = getLastK(array, k, 0, array.length - 1);
            System.out.println(firstK);
            System.out.println(lastK);
            if (firstK >= 0 & lastK >= 0)
                number = lastK - firstK + 1;
        }
        return number;
    }

    private int getFirstK(int[] array, int k, int start, int end) {
        if (start > end)
            return -1;
        int mid = (start + end) / 2;
        if (array[mid] == k) {
            if (mid > 0 && array[mid - 1] != k || mid == 0)
                return mid;
            else
                end = mid - 1;
        } else if (mid > k) {
            end = mid - 1;
        } else
            start = mid + 1;
        return getFirstK(array, k, start, end);
    }

    private int getLastK(int[] array, int k, int start, int end) {
        if (start > end)
            return -1;
        int mid = (start + end) / 2;
        if (array[mid] == k) {
            if (mid < array.length - 1 && array[mid + 1] != k || mid == array.length - 1)
                return mid;
            else
                start = mid + 1;
        } else if (mid < k) {
            start = mid + 1;
        } else
            end = mid - 1;
        return getLastK(array, k, start, end);
    }

}
