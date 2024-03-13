// 10.2 In addition to 10.1, display DFS traversal sequence of the undirected graph.

package week10;

import java.util.Scanner;
import java.util.Stack;

public class P2{

    private int vertices;
    private int[][] adjacencyMatrix;

    public P2(int vertices) {
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
        Stack<Integer> stack = new Stack<>();
        stack.push(0); // Start DFS from vertex 0

        while (!stack.isEmpty()) {
            int vertex = stack.pop();

            if (!visited[vertex]) {
                System.out.print(vertex + " ");
                visited[vertex] = true;
            }

            for (int i = vertices - 1; i >= 0; i--) {
                if (adjacencyMatrix[vertex][i] == 1 && !visited[i]) {
                    stack.push(i);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices in the graph: ");
        int vertices = scanner.nextInt();

        P2 graph = new P2(vertices);

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
    }
}
