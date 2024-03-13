
// WAP to create an un-directed graph using Adjacency Matrix Method and display the 
// degree of each vertex.

package week10;

import java.util.Scanner;

public class P1 {

    private int vertices;
    private int[][] adjacencyMatrix;

    public P1(int vertices) {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices in the graph: ");
        int vertices = scanner.nextInt();

        P1 graph = new P1(vertices);

        System.out.print("Enter the number of edges in the graph: ");
        int edges = scanner.nextInt();

        System.out.println("Enter the edges (source and destination):");
        for (int i = 0; i < edges; i++) {
            int source = scanner.nextInt();
            int destination = scanner.nextInt();
            graph.addEdge(source, destination);
        }

        graph.displayDegrees();
    }
}
