// 10.4 WAP to create a directed graph using Adjacency Matrix Method and display the degree of 
// each vertex.

package week10;

import java.util.Scanner;

public class P4 {

    private int vertices;
    private int[][] adjacencyMatrix;

    public P4(int vertices) {
        this.vertices = vertices;
        adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEdge(int source, int destination) {
        adjacencyMatrix[source][destination] = 1;
    }

    public void displayDegrees() {
        System.out.println("Vertex Degrees:");

        for (int i = 0; i < vertices; i++) {
            int inDegree = 0;
            int outDegree = 0;

            for (int j = 0; j < vertices; j++) {
                inDegree += adjacencyMatrix[j][i];
                outDegree += adjacencyMatrix[i][j];
            }

            System.out.println("Vertex " + i + ": In-Degree = " + inDegree + ", Out-Degree = " + outDegree);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of vertices in the directed graph: ");
        int vertices = scanner.nextInt();

       P4 graph = new P4(vertices);

        System.out.print("Enter the number of edges in the directed graph: ");
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

