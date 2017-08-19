package problems;

public class Problem30 {

    public int FindGreatestSumOfSubArray(int[] array) {
        int len = array.length;
        int nSum = array[0];
        int maxSum = array[0];
        for (int i = 1; i < len; i++) {
            if (nSum + array[i] > array[i]) {
                nSum = nSum + array[i];
            } else {
                nSum = array[i];
            }
            if (nSum > maxSum) {
                maxSum = nSum;
            }
        }
        return maxSum;
    }

}
