package problems;

import java.util.ArrayList;

public class Problem42 {

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int ahead = array.length - 1;
        int behind = 0;
        while (ahead > behind) {
            int curSum = array[behind] + array[ahead];
            if (curSum == sum) {
                list.add(array[behind]);
                list.add(array[ahead]);
                break;
            } else if (curSum > sum)
                ahead--;
            else
                behind++;
        }
        return list;
    }

}
