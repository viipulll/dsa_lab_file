import java.util.*;

public class QUESTION16 {

    // -------------------------------------------------------------
    //   CHECK FOR NEGATIVE WEIGHTS (COMMON FOR BOTH)
    // -------------------------------------------------------------
    static boolean containsNegative(int[][] graph) {
        for (int[] row : graph) {
            for (int w : row) {
                if (w < 0) return true;
            }
        }
        return false;
    }

    // -------------------------------------------------------------
    //              DIJKSTRA USING ADJACENCY MATRIX
    // -------------------------------------------------------------
    static void dijkstraMatrix(int[][] graph, int src) {

        int V = graph.length;

        if (containsNegative(graph)) {
            System.out.println("Error: Graph contains negative weights. Dijkstra not possible.");
            return;
        }

        int[] dist = new int[V];
        boolean[] visited = new boolean[V];

        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {

            int u = -1;
            int minDist = Integer.MAX_VALUE;

            for (int i = 0; i < V; i++) {
                if (!visited[i] && dist[i] < minDist) {
                    minDist = dist[i];
                    u = i;
                }
            }

            visited[u] = true;

            for (int v = 0; v < V; v++) {

                if (!visited[v] && graph[u][v] != 0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u] + graph[u][v] < dist[v]) {

                    dist[v] = dist[u] + graph[u][v];
                }
            }
        }

        System.out.println("\nDijkstra (Adjacency Matrix):");
        for (int i = 0; i < V; i++)
            System.out.println("Distance from " + src + " to " + i + " = " + dist[i]);
    }


    // -------------------------------------------------------------
    //          DIJKSTRA USING ADJACENCY LIST (PQ)
    // -------------------------------------------------------------
    static class Pair {
        int node, dist;
        Pair(int n, int d) { node = n; dist = d; }
    }

    static void dijkstraList(List<List<Pair>> graph, int src) {

        int V = graph.size();

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.dist));
        pq.add(new Pair(src, 0));

        System.out.println("\nDijkstra (Adjacency List):");

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int u = p.node;

            for (Pair edge : graph.get(u)) {

                if (edge.dist < 0) {
                    System.out.println("Error: Graph contains negative weights. Dijkstra not possible.");
                    return;
                }

                if (dist[u] + edge.dist < dist[edge.node]) {
                    dist[edge.node] = dist[u] + edge.dist;
                    pq.add(new Pair(edge.node, dist[edge.node]));
                }
            }
        }

        for (int i = 0; i < V; i++)
            System.out.println("Distance from " + src + " to " + i + " = " + dist[i]);
    }


    // -------------------------------------------------------------
    //                           MAIN
    // -------------------------------------------------------------
    public static void main(String[] args) {

        // ------------------ MATRIX GRAPH ------------------
        int[][] matrixGraph = {
                {0, 10, 0, 30, 100},
                {10, 0, 50, 0, 0},
                {0, 50, 0, 20, 10},
                {30, 0, 20, 0, 60},
                {100, 0, 10, 60, 0}
        };

        dijkstraMatrix(matrixGraph, 0);


        // ------------------ LIST GRAPH ------------------
        int V = 5;
        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++)
            graph.add(new ArrayList<>());

        // Add edges (undirected)
        graph.get(0).add(new Pair(1, 10));
        graph.get(0).add(new Pair(3, 30));
        graph.get(0).add(new Pair(4, 100));

        graph.get(1).add(new Pair(0, 10));
        graph.get(1).add(new Pair(2, 50));

        graph.get(2).add(new Pair(1, 50));
        graph.get(2).add(new Pair(3, 20));
        graph.get(2).add(new Pair(4, 10));

        graph.get(3).add(new Pair(0, 30));
        graph.get(3).add(new Pair(2, 20));
        graph.get(3).add(new Pair(4, 60));

        graph.get(4).add(new Pair(0, 100));
        graph.get(4).add(new Pair(2, 10));
        graph.get(4).add(new Pair(3, 60));

        dijkstraList(graph, 0);
    }
}
