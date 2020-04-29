package UndirectedGraph;

/**
 * @Auther LJM
 * @Date 2020/4/29-12:56
 * Description 连通分量-DFS
 */
public class CC {
    private boolean[] marked;
    private int[] id;
    private int count; //标记第几个分量

    public CC(Graph G){
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int i = 0; i < G.V(); i++) {
            if (!marked[i]){
                dfs(G,i);
                count++;
            }
        }
    }

    private void dfs(Graph G,int v){
        marked[v] = true;
        id[v] = count;
        for (Integer w : G.adj(v)) {

            if(!marked[w]){
                dfs(G,w);
            }
        }
    }

    public boolean connected(int v,int w){
        return id[v] == id[w];
    }

    public int[] id(){
        return id;
    }

    public int count(){
        return count;
    }
}
