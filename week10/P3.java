// 10.3 In addition to 10.1, display BFS traversal sequence of the undirected graph.

package week10;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P3 {

    private int vertices;
    private int[][] adjacencyMatrix;

    public P3(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 1;
        adjacencyMatrix[destination][source] = 1;
    }

    public void displayDegrees() {
        System.out.println("Vertex Degrees:");

        for (int i = 0; i < vertices; i++) {
            int degree = 0;
            for (int j = 0; j < vertices; j++) {
                degree += adjacencyMatrix[i][j];
            }
            System.out.println("Vertex " + i + ": " + degree + " degree(s)");
        }
    }

    public void displayDFS() {
        System.out.println("DFS Traversal:");

        boolean[] visited = new boolean[vertices];
        dfs(0, visited);
        System.out.println();
    }

    private void dfs(int vertex, boolean[] visited) {
        System.out.print(vertex + " ");
        visited[vertex] = true;

        for (int i = 0; i < vertices; i++) {
            if (adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
                dfs(i, visited);
            }
        }
    }

    public void displayBFS() {
        System.out.println("BFS Traversal:");

        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        visited[0] = true;
        queue.offer(0);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (int i = 0; i < vertices; i++) {
                if (adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices in the graph: ");
        int vertices = scanner.nextInt();

        P3 graph = new P3(vertices);

        System.out.print("Enter the number of edges in the graph: ");
        int edges = scanner.nextInt();

        System.out.println("Enter the edges (source and destination):");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }

        graph.displayDegrees();
        graph.displayDFS();
        graph.displayBFS();
    }
}
