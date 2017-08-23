package problems;

public class Problem51 {

    public int[] multiply(int[] A) {
        int length = A.length;
        int[] B = new int[length];
        if (length > 1) {
            B[0] = 1;
            for (int i = 1; i < length; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }
            double temp = 1;
            for (int i = length - 2; i >= 0; i--) {
                temp *= A[i + 1];
                B[i] *= temp;
            }
        }
        return B;
    }

}
