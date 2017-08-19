package problems;

import java.util.ArrayList;
import java.util.Collections;

public class Problem27 {

    public static void main(String[] args) {
        Problem27 problem27 = new Problem27();
        ArrayList<String> abc = problem27.Permutation("abc");
        for (String s : abc) {
            System.out.println(s);
        }

    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<String>();
        if (str != null && str.length() > 0) { 
            PermutationHelper(str.toCharArray(), 0, list);
            Collections.sort(list); 
        }
        return list;
    }

    private void PermutationHelper(char[] chars, int index, ArrayList<String> list) {
        if (index==chars.length-1)
            list.add(String.valueOf(chars));
        else{
            for (int i = index; i < chars.length; i++) {
                if (i==index||chars[i]!=chars[index]){
                    swap(chars,index,i);
                    PermutationHelper(chars,index+1,list);
                    swap(chars,index,i);
                }
            }
        }
    }

    private void swap(char[] str, int i, int j) {
        if (i != j) {
            char t = str[i];
            str[i] = str[j];
            str[j] = t;
        }
    }

}
