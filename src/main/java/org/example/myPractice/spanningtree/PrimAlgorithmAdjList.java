package org.example.myPractice.spanningtree;

import java.util.*;

public class PrimAlgorithmAdjList {
    static class Node {
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        int numVertices = 5;
        List<List<Node>> adjList = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }

        // 添加边到图
        //添加 index 为 0 可达的 Node list
        adjList.get(0).add(new Node(1, 2));
        adjList.get(1).add(new Node(0, 2));
        adjList.get(1).add(new Node(2, 3));
        adjList.get(2).add(new Node(1, 3));
        adjList.get(1).add(new Node(3, 8));
        adjList.get(3).add(new Node(1, 8));
        adjList.get(2).add(new Node(4, 7));
        adjList.get(4).add(new Node(2, 7));
        adjList.get(3).add(new Node(4, 9));
        adjList.get(4).add(new Node(3, 9));
        adjList.get(0).add(new Node(3, 6));
        adjList.get(3).add(new Node(0, 6));
        adjList.get(1).add(new Node(4, 5));
        adjList.get(4).add(new Node(1, 5));

        prim(adjList);
    }
    public static void prim(List<List<Node>> adjList) {
        int numVertices = adjList.size();
        int[] parent = new int[numVertices];
        int[] key = new int[numVertices];
        boolean[] inMST = new boolean[numVertices];

        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        key[0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(numVertices, Comparator.comparingInt(n -> n.weight));
        pq.add(new Node(0, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int u = node.vertex;
            if (inMST[u]) continue;
            inMST[u] = true;

            for (Node neighbor : adjList.get(u)) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;
                if (!inMST[v] && weight < key[v]) {
                    key[v] = weight;
                    pq.add(new Node(v, key[v]));
                    parent[v] = u;
                }
            }
        }

        printMST(parent, adjList);
    }
    private static void printMST(int[] parent, List<List<Node>> adjList) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < parent.length; i++) {
            int finalI = i;
            int weight = adjList.get(i).stream()
                    .filter(n -> n.vertex == parent[finalI])
                    .findFirst()
                    .map(n -> n.weight)
                    .orElse(0);
            System.out.println(parent[i] + " - " + i + "\t" + weight);
        }
    }
}
