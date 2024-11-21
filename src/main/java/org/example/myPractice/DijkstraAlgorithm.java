package org.example.myPractice;
import java.util.*;

public class DijkstraAlgorithm {
    public static void main(String[] args) {
        Graph graph = new Graph(9);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 7, 8);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 7, 11);
        graph.addEdge(2, 3, 7);
        graph.addEdge(2, 8, 2);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 4, 9);
        graph.addEdge(3, 5, 14);
        graph.addEdge(4, 5, 10);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 7, 1);
        graph.addEdge(6, 8, 6);
        graph.addEdge(7, 8, 7);

        int[] distances = graph.dijkstra(0);

        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < distances.length; i++) {
            System.out.println(i + " \t\t " + distances[i]);
        }
    }

    static class Graph {
        private final int vertices;
        private final List<List<Node>> adjList;

        Graph(int vertices) {
            this.vertices = vertices;
            adjList = new ArrayList<>(vertices);
            for (int i = 0; i < vertices; i++) {
                adjList.add(new ArrayList<>());
            }
        }

        void addEdge(int src, int dest, int weight) {
            adjList.get(src).add(new Node(dest, weight));
        }

        int[] dijkstra(int start) {
            int[] distances = new int[vertices];
            Arrays.fill(distances, Integer.MAX_VALUE);
            distances[start] = 0;

            PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
            pq.add(new Node(start, 0));

            while (!pq.isEmpty()) {
                Node currentNode = pq.poll();
                int currentVertex = currentNode.vertex;
                int currentDist = currentNode.weight;

                if (currentDist > distances[currentVertex]) {
                    continue;
                }

                for (Node neighbor : adjList.get(currentVertex)) {
                    int newDist = currentDist + neighbor.weight;
                    if (newDist < distances[neighbor.vertex]) {
                        distances[neighbor.vertex] = newDist;
                        pq.add(new Node(neighbor.vertex, newDist));
                    }
                }
            }

            return distances;
        }

        static class Node {
            int vertex;
            int weight;

            Node(int vertex, int weight) {
                this.vertex = vertex;
                this.weight = weight;
            }
        }
    }
}
