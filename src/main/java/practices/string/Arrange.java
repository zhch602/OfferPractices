package practices.string;

import java.util.HashSet;
import java.util.Set;

public class Arrange {

    private int[] numbers = {1, 2, 2, 3, 4, 5};
    private int n = numbers.length;
    //用来标记图中结点是否被遍历过
    private boolean[] visited = new boolean[n];
    //图的二维数组表示
    private int[][] graph = new int[n][n];
    //数字的组合
    private String combination = "";

    public Set<String> getAllCombination() {
        buildGraph();
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < n; i++) {
            this.depthFirstSearch(i, set);
        }
        return set;
    }

    public void buildGraph() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    graph[i][j] = 0;
                else
                    graph[i][j] = 1;
            }
        }
        graph[3][5] = 0;
        graph[5][3] = 0;
    }

    public void depthFirstSearch(int start, Set<String> set) {
        visited[start] = true;
        combination = combination + numbers[start];
        if (combination.length() == n) {
            if (combination.indexOf("4") != 2)
                set.add(combination);
        }
        for (int i = 0; i < n; i++) {
            if (graph[start][i] == 1 && !visited[i])
                depthFirstSearch(i, set);
        }
        combination = combination.substring(0, combination.length() - 1);
        visited[start] = false;
    }

    public static void main(String[] args) {
        Arrange arrange = new Arrange();
        Set<String> set = arrange.getAllCombination();
        for (String s : set) {
            System.out.println(s);
        }

    }


}
