package depthFist;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Main {
	   // Function to perform BFS traversal from a given source vertex in a graph to
    // determine if a destination vertex is reachable from the source or not
    public static boolean isConnected(Graph graph, int src, int dest,
        boolean[] discovered)
    {
        // create a queue for doing BFS
        Queue<Integer> q = new ArrayDeque<>();
 
        // mark the source vertex as discovered
        discovered[src] = true;
 
        // enqueue source vertex
        q.add(src);
 
        // loop till queue is empty
        while (!q.isEmpty())
        {
            // dequeue front node and print it
            int v = q.poll();
 
            // if destination vertex is found
            if (v == dest) {
                return true;
            }
 
            // do for every edge `v —> u`
            for (int u: graph.adjList.get(v))
            {
                if (!discovered[u])
                {
                    // mark it as discovered and enqueue it
                    discovered[u] = true;
                    q.add(u);
                }
            }
        }
 
        return false;
    }
 
    public static void main(String[] args)
    {
        // List of graph edges as per the above diagram
        List<Edge> edges = Arrays.asList(Edge.of(0, 3), Edge.of(1, 0),
                                            Edge.of(1, 2), Edge.of(1, 4),
                                            Edge.of(2, 7), Edge.of(3, 4),
                                            Edge.of(3, 5), Edge.of(4, 3),
                                            Edge.of(4, 6), Edge.of(5, 6),
                                            Edge.of(6, 7));
 
        // total number of nodes in the graph (labeled from 0 to `N-1`)
        int N = 8;
 
        // build a graph from the given edges
        Graph graph = new Graph(edges, N);
 
        // to keep track of whether a vertex is discovered or not
        boolean[] discovered = new boolean[N];
 
        // source and destination vertex
        int src = 7, dest = 0;
 
        // perform BFS traversal from the source vertex to check the connectivity
        if (isConnected(graph, src, dest, discovered))
        {
            System.out.println("A path exists from vertex " + src +
                    " to vertex " + dest);
        }
        else {
            System.out.println("No path exists between vertices " + src +
                    " and " + dest);
        }
    }
}
