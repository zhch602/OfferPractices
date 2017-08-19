package problems;

public class Problem35 {


    public static void main(String[] args) {
        int[] a = {364,637,341,406,747,995,234,971,571,219,993,407,416,366,315,301,601,650,418,355,460,505,360,965,516,648,727,667,465,849,455,181,486,149,588,233,144,174,557,67,746,550,474,162,268,142,463,221,882,576,604,739,288,569,256,936,275,401,497,82,935,983,583,523,697,478,147,795,380,973,958,115,773,870,259,655,446,863,735,784,3,671,433,630,425,930,64,266,235,187,284,665,874,80,45,848,38,811,267,575};
        int[] b = {7,5,6,4};
        Problem35 problem35 = new Problem35();
        System.out.println(problem35.InversePairs(a));
    }

    public int InversePairs(int [] array) {
        return reverseCount(array,0,array.length-1);
    }

    public static int reverseCount(int[] a, int low, int high) {
        int reverseCount = 0;
        if (low < high) {
            int mid = (low + high) / 2;
            reverseCount += reverseCount(a, low, mid);
            reverseCount += reverseCount(a, mid + 1, high);
            reverseCount += merge(a, low, mid, high);
            return reverseCount;
        }
        return 0;
    }

    public static int merge(int[] a, int low, int mid, int high) {
        int reverseCount = 0;
        int[] temp = new int[high - low + 1];
        int i = low;// 左指针
        int j = mid + 1;// 右指针
        int k = 0;
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                reverseCount += mid - i + 1;
                temp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= high) {
            temp[k++] = a[j++];
        }
        System.arraycopy(temp, 0, a, low, temp.length);
        return reverseCount;
    }

}
