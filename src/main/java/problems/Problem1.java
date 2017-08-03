package problems;


public class Problem1 {

    public static void main(String[] args) {

        int[][] array = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}, {7, 9, 14, 17}};

        System.out.println(Find(0, array));

    }

    public static boolean Find(int target, int[][] array) {

        int column = array.length;
        int row = array[0].length;

        int pos[] = {0, row - 1};

        while (pos[0] < column && pos[1] >= 0) {
            if (target == array[pos[0]][pos[1]]) {
                return true;
            } else if (target < array[pos[0]][pos[1]]) {
                pos[1]--;
            } else
                pos[0]++;
        }
        return false;

    }

}
