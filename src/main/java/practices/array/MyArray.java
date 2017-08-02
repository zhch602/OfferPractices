package practices.array;

import practices.sort.QuickSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MyArray {

    public static void main(String[] args) {
        int a[] = {5, 4, 9, 8, 1, 6, 0, 1, 3, 2};
        int b[] = {1, -2, 4, 8, -4, 7, -1, -5};
        int c[] = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 5, 5, 5, 5};
        int d[] = {-3, -2, -1, 1, 2, 2, 3, 4, 5};
        int e[] = {1, 2, 5, 7, 0, 3, 4, 6, 8};
        int f[] = {1, 3, 5, 7, 9};
        int g[] = {2, 3, 5, 7, 8};
        int h[] = {8, 7, 5, 0, 6};
        int i[] = {1, 5, 3, 2, 6};
        int j[] = {3, 4, 5, 7};
        int k[] = {8, 9, 10, 16, 17};
        int l[] = {19, 21, 23, 24, 37, 40};
//        ArrayList<Integer> mixed = mixed(f, g);
//        for (Integer integer : mixed) {
//            System.out.println(integer);
//        }
//        for (int each : e) {
//            System.out.println(each);
//        }
//        System.out.println(minDistance(j, k, l));
    }

    /**
     * 求两个数字较大值
     *
     * @param a a
     * @param b b
     * @return max
     */
    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    /**
     * 求三个数字最大值
     *
     * @param a a
     * @param b b
     * @param c c
     * @return max
     */
    public static int max(int a, int b, int c) {
        int max = a > b ? a : b;
        return max > c ? max : c;
    }

    /**
     * 求两个数字较小值
     *
     * @param a a
     * @param b b
     * @return min
     */
    public static int min(int a, int b) {
        return a > b ? b : a;
    }

    /**
     * 求三个数字最小值
     *
     * @param a a
     * @param b b
     * @param c c
     * @return min
     */
    public static int min(int a, int b, int c) {
        int min = a > b ? b : a;
        return min > c ? c : min;
    }


    /**
     * 如何寻找数组中的最小值和最大值
     *
     * @param array 数组
     * @return Max and Min
     */
    public static int[] getMaxMin(int[] array) {
        int max = array[0];
        int min = array[0];
        int len = array.length;
        int[] result = new int[2];
        for (int i = 1; i < len - 1; i++) {
            if (i + 1 > len) {
                if (array[i] > max)
                    max = array[i];
                if (array[i] < min)
                    max = array[i];
            }
            if (array[i] > array[i + 1]) {
                if (array[i] > max)
                    max = array[i];
                if (array[i + 1] < min) {
                    min = array[i + 1];
                }
            } else {
                if (array[i + 1] > max)
                    max = array[i + 1];
                if (array[i] < min) {
                    min = array[i];
                }
            }
        }
        result[0] = max;
        result[1] = min;
        return result;
    }

    /**
     * 寻找数组中第二大的数
     *
     * @param array 数组
     * @return secMax
     */
    public static int secondMax(int[] array) {
        int max = array[0];
        int secMax = Integer.MIN_VALUE;
        int len = array.length;
        for (int i = 1; i < len; i++) {
            if (array[i] > max) {
                secMax = max;
                max = array[i];
            } else {
                if (array[i] > secMax)
                    secMax = array[i];
            }
        }
        return secMax;
    }

    /**
     * 求最大子数组之和
     *
     * @param array 数组
     * @return max and index
     */
    public static int maxSubArray(int[] array) {
        int len = array.length;
        int nSum = array[0];
        int maxSum = array[0];
        int begin = 0;
        int end = 0;
        for (int i = 1; i < len; i++) {
            if (nSum + array[i] > array[i]) {
                nSum = nSum + array[i];
                end++;
            } else {
                nSum = array[i];
                begin = i;
                end = i;
            }
            if (nSum > maxSum) {
                maxSum = nSum;
                end--;
            }
        }
        System.out.println(begin + " " + end + 1);
        return maxSum;
    }

    /**
     * 寻找出数组中重复元素最多的数
     *
     * @param array 数组
     * @return result
     */
    public static int mostFrequent(int[] array) {
        int result = 0;
        int most = 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int anArray : array) {
            if (map.containsKey(anArray)) {
                map.put(anArray, map.get(anArray) + 1);
            } else map.put(anArray, 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value > most) {
                result = key;
                most = value;
            }
        }
        return result;
    }

    /**
     * 求数组中两两相加等于20的组合种数
     *
     * @param array 数组
     * @param sum   cpint
     */
    public static void findSum(int[] array, int sum) {
        QuickSort.sort(array, 0, array.length - 1);
        int begin = 0;
        int end = array.length - 1;
        while (begin < end) {
            if (array[begin] + array[end] < sum)
                begin++;
            else if (array[begin] + array[end] > sum)
                end--;
            else {
                System.out.println(array[begin] + "," + array[end]);
                begin++;
                end--;
            }
        }
    }

    /**
     * 将数组逆序
     *
     * @param array 数组
     * @param begin 起始
     * @param end   结束
     */
    public static void reverse(int[] array, int begin, int end) {
        while (begin < end) {
            int temp = array[end];
            array[end] = array[begin];
            array[begin] = temp;
            begin++;
            end--;
        }
    }

    /**
     * 把一个数组循环右移k位
     *
     * @param array 数组
     * @param k     位数
     */
    public static void shiftK(int[] array, int k) {
        int len = array.length;
        k = k % len;
        reverse(array, len - k, len - 1);
        reverse(array, 0, len - k - 1);
        reverse(array, 0, len - 1);
    }

    /**
     * 找出数组中第k个最小的数
     *
     * @param array 数组
     * @param k     位数
     * @return array[k]
     */
    public static int getKMin(int[] array, int k) {
        QuickSort.sort(array, 0, array.length - 1);
        return array[k];
    }

    /**
     * 找出数组中只出现一次的数字
     *
     * @param array       数组
     * @param appearTimes 其他数字出现次数
     * @return appearOnce
     */
    public static int findOnce(int[] array, int appearTimes) {
        int len = array.length;
        int[] bitCount = new int[32];
        for (int anArray : array) {
            for (int j = 0; j < 32; j++) {
                bitCount[j] += ((anArray >> j) & 1);
            }
        }
        int appearOnce = 0;
        for (int i = 0; i < 32; i++) {
            if (bitCount[i] % appearTimes != 0) {
                appearOnce += (1 << i);
            }
        }
        return appearOnce;
    }

    /**
     * 找出数组中唯一的重复元素
     *
     * @param array 数组
     * @return temp2-temp1
     */
    public static int findDup(int[] array) {
        int len = array.length;
        int temp1 = 0;
        int temp2 = 0;
        for (int i = 0; i < len - 1; i++) {
            temp1 += i + 1;
            temp2 += array[i];
        }
        temp2 += array[len - 1];
        return temp2 - temp1;
    }

    /**
     * 用递归方法求一个整数数组的最大元素
     *
     * @param array 数组
     * @param begin 起始
     * @return 递归
     */
    public static int findMax(int[] array, int begin) {
        int len = array.length - begin;
        if (len == 1)
            return array[begin];
        else
            return max(array[begin], findMax(array, begin + 1));
    }

    /**
     * 求数对之差的最大值
     *
     * @param array 数组
     * @return diff
     */
    public static int getMaxDiff(int[] array) {
        int diff = 0;
        int max = array[0];
        for (int anArray : array) {
            diff = max(diff, max - anArray);
            max = max(max, anArray);
        }
        return diff;
    }

    /**
     * 求绝对值最小的数
     *
     * @param array 数组
     * @return absMin
     */
    public static int getMinAbsoluteValue(int[] array) {
        int len = array.length;
        if (array[0] >= 0)
            return array[0];
        if (array[len - 1] <= 0)
            return array[len - 1];
        int mid = 0;
        int begin = 0;
        int end = len - 1;
        int absMin = 0;
        while (true) {
            mid = begin + (end - begin) / 2;
            if (array[mid] == 0)
                return 0;
            else if (array[mid] > 0) {
                if (array[mid - 1] > 0)
                    end = mid - 1;
                else if (array[mid - 1] == 0)
                    return 0;
                else
                    break;
            } else {
                if (array[mid + 1] < 0)
                    begin = mid + 1;
                else if (array[mid + 1] == 0)
                    return 0;
                else
                    break;
            }
        }
        if (array[mid] > 0) {
            if (array[mid] < Math.abs(array[mid - 1]))
                absMin = array[mid];
            else
                absMin = array[mid - 1];
        } else {
            if (Math.abs(array[mid]) < array[mid + 1])
                absMin = array[mid];
            else
                absMin = array[mid + 1];
        }
        return absMin;
    }

    /**
     * 求数组长两个元素的最小距离
     *
     * @param array 数组
     * @param n1    n1
     * @param n2    n2
     * @return minDist
     */
    public static int minDistance(int[] array, int n1, int n2) {
        int len = array.length;
        int indexN1 = -1;
        int indexN2 = -1;
        int minDist = Integer.MIN_VALUE + 1;
        for (int i = 0; i < len; i++) {
            if (array[i] == n1) {
                indexN1 = i;
                if (indexN2 >= 0)
                    minDist = min(Math.abs(minDist), Math.abs(indexN1 - indexN2));
            }
            if (array[i] == n2) {
                indexN2 = i;
                if (indexN1 >= 0)
                    minDist = min(Math.abs(minDist), Math.abs(indexN1 - indexN2));
            }
        }
        return minDist;
    }

    /**
     * 求指定数字在数组中第一次出现的位置
     *
     * @param array 数组
     * @param n     n
     * @return index
     */
    public static int findIndex(int[] array, int n) {
        int len = array.length;
        int i = 0;
        while (i < len) {
            if (array[i] == n)
                return i;
            else
                i += Math.abs(n - array[i]);
        }
        return -1;
    }

    /**
     * 对数组的两个子有序段进行合并
     *
     * @param array 数组
     * @param mid   mid
     */
    public static void sort(int[] array, int mid) {
        int temp;
        int len = array.length;
        for (int i = 0; i < mid; i++) {
            if (array[mid] < array[i]) {
                temp = array[i];
                array[i] = array[mid];
                array[mid] = temp;
                for (int j = mid; j < len - 1; j++) {
                    if (array[j + 1] < array[j]) {
                        temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }
    }

    /**
     * 计算两个有序整型数组的交集
     *
     * @param array1 数组
     * @param array2 数组
     * @return mix
     */
    public static ArrayList<Integer> mixed(int[] array1, int[] array2) {
        ArrayList<Integer> mix = new ArrayList<Integer>();
        int i = 0, j = 0;
        int len1 = array1.length;
        int len2 = array2.length;
        while (i < len1 && j < len2) {
            if (array1[i] == array2[j]) {
                mix.add(array1[i]);
                i++;
                j++;
            } else if (array1[i] > array2[j])
                j++;
            else
                i++;
        }
        return mix;
    }

    /**
     * 判断一个数组中数值是否连续相邻
     *
     * @param array 数组
     * @return bool
     */
    public static Boolean isContinuous(int[] array) {
        int min = -1, max = -1;
        for (int each : array
                ) {
            if (each != 0) {
                if (min > each || min == -1)
                    min = each;
                if (max < each || max == -1)
                    max = each;
            }
        }
        return max - min <= array.length - 1;
    }

    /**
     * 归并
     *
     * @param a    a
     * @param low  low
     * @param mid  mis
     * @param high igh
     * @return 递归
     */
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

    /**
     * 求数组中反序对的个数
     *
     * @param a    a
     * @param low  low
     * @param high high
     * @return reverseCount
     */
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

    /**
     * 求解最小三元组距离
     *
     * @param a a
     * @param b b
     * @param c c
     * @return minDist
     */
    public static int minDistance(int[] a, int[] b, int[] c) {
        int aLen = a.length;
        int bLen = c.length;
        int cLen = b.length;
        int curDist = 0, min = 0, i = 0, j = 0, k = 0;
        int minDist = Integer.MAX_VALUE;
        while (true) {
            curDist = max(Math.abs(a[i] - b[j]), Math.abs(a[i] - c[k]), Math.abs(b[j] - c[k]));
            if (curDist < minDist)
                minDist = curDist;
            min = min(a[i], b[j], c[k]);
            if (min == a[i])
                if (++i >= aLen)
                    break;
                else if (min == b[j])
                    if (++j >= bLen)
                        break;
                    else if (++k >= cLen)
                        break;
        }
        return minDist;
    }

}
