package problems;

import java.util.ArrayList;

public class Problem41 {

    public static void main(String[] args) {
        Problem41 problem41 = new Problem41();
        ArrayList<ArrayList<Integer>> arrayLists = problem41.FindContinuousSequence(15);
        for (ArrayList<Integer> arrayList : arrayLists) {
            for (Integer integer : arrayList) {
                System.out.println(integer);
            }
            System.out.println();
        }

    }

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
        if (sum < 3)
            return lists;
        int small = 1;
        int big = 2;
        int middle = (1 + sum) / 2;
        int curSum = small + big;
        while (small < middle) {
            if (curSum == sum) {
                ArrayList<Integer> list = new ArrayList<Integer>();
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }
                lists.add(list);
                big++;
                curSum += big;
            } else if (curSum > sum) {
                curSum -= small;
                small++;
            } else {
                big++;
                curSum += big;
            }
        }
        return lists;
    }

}
