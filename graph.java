import java.util.*;
public class graph {
    ArrayList<ArrayList<Integer>> adj;
    int size;

    /**
     * Constructs a new Graph object with the specified number of vertices.
     *
     * @param V Number of vertices in the graph
     */
    graph(int V)
    {
        this.size=V;
        this.adj= new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<>());
        }
    }
    /**
     * To add an edge between two vertices of the graph
     *
     * @param s First vertice.
     * @param e Second vertice.
     */
    public void add_node(int s, int e)
    {
        adj.get(s).add(e);
        adj.get(e).add(s);
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
        adj.get(s).remove(e);
        adj.get(e).add(s);
    }


    public void dfs(int s , boolean[]visited)
    {
        visited[s]=true;
        System.out.print(s+" ");

        for(int u:adj.get(s))
        {
            if(visited[u]==false)
            {
                dfs(u,visited);
            }
        }

    }

    /**
     * To do Depth First Search Traversal of the Graph.
     *
     * @param s The Source vertex from which the traversal starts.
     */
    public void dfs(int s)
    {
        boolean[]visited = new boolean[this.size];
        dfs(s,visited);
    }

    /**
     * To do Breadth First Search Traversal of the Graph.
     *
     * @param s The Source vertex from which the traversal starts.
     */
    public void bfs(int s)
    {
        boolean[] visited = new boolean[size];

        Queue<Integer> q = new LinkedList<>();

        q.add(s);

        visited[s]=true;

        while(!q.isEmpty())
        {
            int count=q.size();

            for(int i=0;i<count;i++)
            {
                int v=q.poll();
                System.out.print(v+" ");

                for(int u:adj.get(v))
                {
                    if(visited[u]==false)
                    {
                        q.add(u);
                        visited[u]=true;
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        int V=5;//Number of vertices

        graph g= new graph(V);
        g.add_node(1,0);
        g.add_node(1,3);
        g.add_node(2,0);
        g.add_node(2,3);
        g.add_node(2,4);
        System.out.println("Depth first search of the graph is :");
        g.dfs(0);
        System.out.println();
        System.out.println("Breadth first seach of the graph is :");
        g.bfs(0);
    }
}
