import java.util.*;

public class QUESTION15 {

    // -----------------------------------------------------------
    //                 PRIM'S ALGORITHM  (Adjacency Matrix)
    // -----------------------------------------------------------
    static int V = 5;

    int minKey(int key[], boolean mstSet[]) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < V; v++)
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }

        return minIndex;
    }

    void primMST(int graph[][]) {
        int parent[] = new int[V];
        int key[] = new int[V];
        boolean mstSet[] = new boolean[V];

        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        key[0] = 0;
        parent[0] = -1;

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < V; v++)
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }

        System.out.println("Prim's MST:");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + " : " + graph[i][parent[i]]);
    }


    // -----------------------------------------------------------
    //                KRUSKAL'S ALGORITHM  (Edge List)
    // -----------------------------------------------------------
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;

        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    static class Subset {
        int parent, rank;
    }

    int find(Subset subsets[], int i) {
        if (subsets[i].parent != i)
            subsets[i].parent = find(subsets, subsets[i].parent);
        return subsets[i].parent;
    }

    void union(Subset subsets[], int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if (subsets[xroot].rank < subsets[yroot].rank)
            subsets[xroot].parent = yroot;
        else if (subsets[xroot].rank > subsets[yroot].rank)
            subsets[yroot].parent = xroot;
        else {
            subsets[yroot].parent = xroot;
            subsets[xroot].rank++;
        }
    }

    void kruskalMST(Edge edges[], int V, int E) {

        Arrays.sort(edges);

        Edge result[] = new Edge[V];
        int e = 0;
        int i = 0;

        Subset subsets[] = new Subset[V];
        for (int v = 0; v < V; v++) {
            subsets[v] = new Subset();
            subsets[v].parent = v;
            subsets[v].rank = 0;
        }

        while (e < V - 1) {
            Edge next = edges[i++];
            int x = find(subsets, next.src);
            int y = find(subsets, next.dest);

            if (x != y) {
                result[e++] = next;
                union(subsets, x, y);
            }
        }

        System.out.println("\nKruskal's MST:");
        for (i = 0; i < e; i++)
            System.out.println(result[i].src + " - " + result[i].dest + " : " + result[i].weight);
    }


    // -----------------------------------------------------------
    //                       MAIN FUNCTION
    // -----------------------------------------------------------
    public static void main(String[] args) {

        QUESTION15 obj = new QUESTION15();

        int graph[][] = {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

        obj.primMST(graph);

        Edge edges[] = {
                new Edge(), new Edge(), new Edge(), new Edge(), new Edge(),
                new Edge(), new Edge(), new Edge(), new Edge()
        };

        edges[0].src = 0; edges[0].dest = 1; edges[0].weight = 2;
        edges[1].src = 1; edges[1].dest = 2; edges[1].weight = 3;
        edges[2].src = 0; edges[2].dest = 3; edges[2].weight = 6;
        edges[3].src = 1; edges[3].dest = 3; edges[3].weight = 8;
        edges[4].src = 1; edges[4].dest = 4; edges[4].weight = 5;
        edges[5].src = 2; edges[5].dest = 4; edges[5].weight = 7;
        edges[6].src = 3; edges[6].dest = 4; edges[6].weight = 9;

        obj.kruskalMST(edges, 5, 7);
    }
}
