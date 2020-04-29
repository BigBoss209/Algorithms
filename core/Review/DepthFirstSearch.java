package Review;

/**
 * @Auther LJM
 * @Date 2020/4/29-9:39
 * Description 查找顶点s的所有连通路径 DFS
 */
public class DepthFirstSearch {
    private boolean[] marked;
    private int count;

    private int[] pathTo;

    public DepthFirstSearch(Graph G,int s){
        pathTo = new int[G.getV()];

        this.marked = new boolean[G.getV()];
        count = 0;
        dfs(G,s);
    }

    private void dfs(Graph G,int v){
        marked[v] = true;
        for (Integer w : G.adj(v)) {
            count++;
            if (!marked[w]){
                pathTo[w] = v;
                dfs(G,w);
            }
        }
    }

    public boolean marked(int v){
        return marked[v];
    }

    public int getCount() {
        return count;
    }

    public int[] getPathTo() {
        return pathTo;
    }
}
