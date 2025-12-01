import java.util.*;

public class QUESTION14 {

    // Graph using adjacency list
    static class Graph {
        int vertices;
        LinkedList<Integer>[] adj;

        Graph(int v) {
            vertices = v;
            adj = new LinkedList[v];

            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        // Add edge (undirected graph)
        void addEdge(int src, int dest) {
            adj[src].add(dest);
            adj[dest].add(src);
        }

        // BFS Traversal
        void BFS(int start) {
            boolean[] visited = new boolean[vertices];
            Queue<Integer> queue = new LinkedList<>();

            visited[start] = true;
            queue.add(start);

            System.out.print("BFS Traversal: ");

            while (!queue.isEmpty()) {
                int node = queue.poll();
                System.out.print(node + " ");

                for (int neighbor : adj[node]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
            System.out.println();
        }

        // DFS Traversal
        void DFS(int start) {
            boolean[] visited = new boolean[vertices];
            System.out.print("DFS Traversal: ");
            DFSUtil(start, visited);
            System.out.println();
        }

        void DFSUtil(int node, boolean[] visited) {
            visited[node] = true;
            System.out.print(node + " ");

            for (int neighbor : adj[node]) {
                if (!visited[neighbor]) {
                    DFSUtil(neighbor, visited);
                }
            }
        }
    }

    public static void main(String[] args) {

        Graph g = new Graph(6);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 5);

        g.BFS(0);
        g.DFS(0);
    }
}
