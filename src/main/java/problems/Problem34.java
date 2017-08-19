package problems;

import java.util.LinkedHashMap;

public class Problem34 {

    public int FirstNotRepeatingChar(String str) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<Character, Integer>();
        for (char c : str.toCharArray()) {
            if (map.containsKey(c)) {
                int time = map.get(c);
                map.put(c, ++time);
            } else
                map.put(c, 1);
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (map.get(c) == 1)
                return i;
        }
        return -1;
    }

}
