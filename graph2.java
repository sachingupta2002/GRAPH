import java.util.*;

class graph2 {
    private int V;
    private int[][] adj;

    /**
     * Constructs a new Graph object with the specified number of vertices.
     *
     * @param vertices Number of vertices in the graph
     */
    public graph2(int vertices) {
         this.V= vertices;
        adj = new int[V][V];
    }

    /**
     * To add an edge between two vertices of the graph
     *
     * @param s First vertice.
     * @param e Second vertice.
     */
    public void addEdge(int s, int e) {
        //for an undirected graph
        adj[s][e] = 1;
        adj[e][s] = 1;
    }
    /**
     * To delete an edge from the graph
     *
     * @param s The First vertex of an edge.
     * @param e The Second vertex of an edge.
     */
    public void delete_node(int s , int e)
    {
        //for an undirected graph
        adj[s][e]=0;
        adj[e][s]=0;
    }

    /**
     * To do Depth First Search Traversal of the Graph.
     *
     * @param s The Source vertex from which the traversal starts.
     */
    public void dfs(int s) {
        boolean[] visited = new boolean[V];
        dfs(s, visited);
    }

    private void dfs(int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");

        for (int i = 0; i < V; i++) {
            if (adj[s][i] == 1 && !visited[i]) {
               dfs(i, visited);
            }
        }
    }

    /**
     * To do Breadth First Search Traversal of the Graph.
     *
     * @param s The Source vertex from which the traversal starts.
     */
    public void bfs(int s) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();

        visited[s] = true;
        q.add(s);

        while (!q.isEmpty()) {
            int vertex = q.poll();
            System.out.print(vertex + " ");

            for (int i = 0; i < V; i++) {
                if (adj[vertex][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }



    public static void main(String[] args) {
        int V = 5; // Number of vertices
        graph2 graph = new graph2(V);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);

        System.out.println("Depth-First Traversal (DFS):");
        graph.dfs(0);
        System.out.println();

        System.out.println("Breadth-First Traversal (BFS):");
        graph.bfs(0);
        System.out.println();
    }
}

