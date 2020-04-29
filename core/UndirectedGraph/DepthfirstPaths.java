package UndirectedGraph;

import java.util.Stack;

/**
 * @Auther LJM
 * @Date 2020/4/28-21:59
 * Description 以s为起点的路径
 */
public class DepthfirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DepthfirstPaths(Graph G,int s){
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G,s);
    }

    public void dfs(Graph G,int v){
        marked[v] = true;
        for (Integer w : G.adj(v)) {
            if (!marked[w]){
                edgeTo[w] = v;
                dfs(G,w);
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public int[] edge(){
        return this.edgeTo;
    }

    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for (int x = v;v != s;v = edgeTo[v]) path.push(v);
        path.push(s);
        return path;
    }
}
