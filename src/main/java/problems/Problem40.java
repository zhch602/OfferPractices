package problems;

public class Problem40 {

    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length <= 1){
            num1[0] = num2[0] = 0;
            return;
        }
        int len = array.length, index = 0, sum = 0;
        for (int anArray : array) {
            sum ^= anArray;
        }
        for(index = 0; index < 32; index++){
            if((sum & (1 << index)) != 0) break;
        }
        for (int anArray : array) {
            if ((anArray & (1 << index)) != 0) {
                num2[0] ^= anArray;
            } else {
                num1[0] ^= anArray;
            }
        }
    }

}
