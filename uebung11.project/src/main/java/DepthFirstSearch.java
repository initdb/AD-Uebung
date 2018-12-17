import java.util.Stack;

/**
 * from Sedgewick et al., adjusted by W. Mühlbauer
 */
public class DepthFirstSearch {

    private int time;                   // used as timer during DFS
    private int[] discoveryTime;
    private int[] finishTime;
    private int[] predecessor;

    // used to color nodes during DFS
    private enum Color {
        WHITE, GRAY, BLACK;
    }
    private Color[] color;              // used for coloring nodes during DFS

    /**
     * Performs a DFS  on graph {@code G} starting from source vertex {@code s}.
     *
     * @param G the graph
     * @param s the source vertex
     * @throws IllegalArgumentException unless {@code 0 <= s < V}
     */
    public DepthFirstSearch(Graph G, int s) {

        discoveryTime = new int[G.V()];
        finishTime = new int[G.V()];
        predecessor = new int[G.V()];
        color = new Color[G.V()];
        time = 0;

        for (int u = 0; u < G.V(); u++) {
            color[u] = Color.WHITE;
            predecessor[u] = -1;
        }

        //dfs(G, s);       // use this one, if normal DFS with recursion should be used instead
        iterativeDFS(G, s);
    }



    // recursive version of DFS, see lecture
    private void dfs(Graph G, int u) {
        time++;
        discoveryTime[u] = time;
        color[u] = Color.GRAY;
        for (int v : G.adj(u)) {
            if (color[v] == Color.WHITE) {
                predecessor[v] = u;
                dfs(G, v);  // recursion
            }
        }
        color[u] = Color.BLACK;
        time++;
        finishTime[u] = time;
    }


    // TODO: iterative version of DFS, DFS shall be started from node u
    private void iterativeDFS(Graph G, int u) {

        time = 1;

        Stack<Integer> stack = new Stack<Integer>();
        discoveryTime[u] = 1;
        color[u] = Color.GRAY;

        stack.push(u);

        while (!stack.isEmpty()) {
            // TODO: ab hier

        }
    }


    public static void main(String[] args) {
        Graph G = new Graph(4);
        G.addEdge(0, 1);
        G.addEdge(1, 2);
        G.addEdge(2, 3);
        G.addEdge(3, 1);
        G.addEdge(0, 3);


        DepthFirstSearch dfs = new DepthFirstSearch(G, 0);
        for (int v = 0; v < G.V(); v++) {
            System.out.println("Node " + v + " has discovery time " + dfs.discoveryTime[v] + " and finish time " + dfs.finishTime[v]);
        }
    }

}

