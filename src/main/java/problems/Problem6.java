package problems;

public class Problem6 {


    public int minNumberInRotateArray(int[] array) {


        int low = 0;
        int high = array.length - 1;
        int mid = low;
        while (array[low] >= array[high]) {

            if (high - low == 1) {
                mid = high;
                break;
            }

            mid = (low + high) / 2;

            if (array[mid] >= array[high]) {
                low = mid;
            } else {
                high = mid;
            }
        }
        return array[mid];

    }

}
