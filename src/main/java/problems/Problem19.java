package problems;

import java.util.ArrayList;

public class Problem19 {

    public static void main(String[] args) {
        int[][] matrix = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};
        ArrayList<Integer> list = printMatrix(matrix);
        for (int each : list
                ) {
            System.out.println(each);
        }
    }

    public static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int row = matrix.length;
        int column = matrix[0].length;
        int index = 0;
        while (index * 2 < row && index * 2 < column) {
            int endRow = column - index - 1;
            int endColumn = row - index - 1;
            for (int i = index; i <= endRow; i++) {
                list.add(matrix[index][i]);
            }
            if (index < endColumn - 1) {
                for (int i = index + 1; i < endColumn; i++) {
                    list.add(matrix[i][endRow]);
                }
            }
            if (index < endColumn) {
                for (int i = endRow; i >= index; i--) {
                    list.add(matrix[endColumn][i]);
                }
            }
            if (index < endRow && index < endColumn - 1) {
                for (int i = endColumn - 1; i >= index + 1; i--) {
                    list.add(matrix[i][index]);
                }
            }
            index++;
        }
        return list;
    }

}
