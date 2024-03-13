import java.util.ArrayList;
import java.util.Scanner;

public class P15aa {
    static int[] weights;
    static ArrayList<ArrayList<Integer>> tree;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        weights = new int[n];
        tree = new ArrayList<>();
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            int u = sc.nextInt() - 1;
            int v = sc.nextInt() - 1;
            tree.get(u).add(v);
            tree.get(v).add(u);
        }

        Result result = dfs(0);

        System.out.println(result.sum + " " + result.components);
    }

    static Result dfs(int node) {
        visited[node] = true;
        int sum = weights[node];
        int components = 1;

        for (int neighbor : tree.get(node)) {
            if (!visited[neighbor]) {
                Result neighborResult = dfs(neighbor);
                sum += Math.max(neighborResult.sum, 0);
                components += neighborResult.components;
            }
        }

        return new Result(sum, components);
    }

    static class Result {
        int sum;
        int components;

        Result(int sum, int components) {
            this.sum = sum;
            this.components = components;
        }
    }
}
