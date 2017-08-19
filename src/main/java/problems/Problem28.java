package problems;

public class Problem28 {

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0)
            return 0;
        int result = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                result = array[i];
                times = 1;
            } else if (array[i] == result)
                times++;
            else {
                times--;
            }
        }
        times = 0;
        for (int anArray : array) {
            if (result == anArray) {
                times++;
            }
        }

        if (times * 2 <= array.length) {
            result = 0;
        }
        return result;
    }

}
