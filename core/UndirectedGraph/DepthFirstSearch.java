package UndirectedGraph;

/**
 * @Auther 刘金明
 * @Date 2020/4/28-21:36
 * Description 深度优先搜索
 */
public class DepthFirstSearch {
    private boolean[] marked; //记录该顶点是否走过
    private int count; //与s连通的顶点数

    public DepthFirstSearch(Graph graph,int s){
        this.marked = new boolean[graph.V()];//初始化为false
        dfs(graph,s);
    }
//递归
    public void dfs(Graph G,int v){
        marked[v]=true;
        count++;
        for (Integer w : G.adj(v)) {
            if(!marked[w]) dfs(G,w);
        }
    }

    public boolean marked(int v){
        return marked[v];
    }

    public int count(){
        return count;
    }
}
