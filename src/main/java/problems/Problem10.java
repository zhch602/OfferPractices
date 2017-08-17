package problems;

public class Problem10 {

    public int RectCover(int target) {
        if (target <= 2) {
            return target;
        }
        int[] record = new int[target + 1];
        record[0] = 1;
        record[1] = 2;
        for (int i = 2; i < target; i++) {
            record[i] = record[i - 1] + record[i - 2];
        }
        return record[target - 1];
    }

}
