package problems;

import java.util.Arrays;

public class Problem13 {

    public static void reOrderArray(int[] array) {
        int index = 0;
        int[] record = new int[array.length];
        for (int each : array) {
            if (each % 2 == 1)
                record[index++] = each;
        }
        for (int each : array) {
            if (each % 2 == 0)
                record[index++] = each;
        }
        System.arraycopy(record, 0, array, 0, record.length);
    }

}
