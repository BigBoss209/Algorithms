package UndirectedGraph;


import Bag.Bag;

/**
 * @Auther 刘金明
 * @Date 2020/4/28-17:09
 * Description 无向图  Array + Bag 邻接表
 */
public class Graph {
    private int V;  //顶点数
    private int E;  //边数
    private Bag<Integer>[] adj; //邻接表
//初始化
    public Graph(int V){
        this.V = V;
        this.E = 0;
        this.adj = new Bag[V];
        for (int i = 0; i < V; i++) {
            this.adj[i] = new Bag<Integer>();
        }

    }

    public Graph(int V,int E,String[] data){
        this(V);
        this.E = E;
//        for (String s : data) {
//            String[] nums = s.split(" ");
//            addEdge(Integer.parseInt(nums[0]),Integer.parseInt(nums[1]));
//        }
        for (int i = 0; i < E; i++) {
            String[] nums = data[i].split(" ");
            addInitEdge(Integer.parseInt(nums[0]),Integer.parseInt(nums[1]));
        }
    }

    public int V(){
        return this.V;
    }

    public int E(){
        return this.E;
    }

    //内部初始化连线
    private void addInitEdge(int v,int w){
        this.adj[v].add(w);
        this.adj[w].add(v);
    }

   //外部连线
    public void addEdge(int v,int w){
        this.adj[v].add(w);
        this.adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return  this.adj[v];
    }

    public String toString(){
        String str = "";
        for (int i = 0; i < this.V(); i++) {
            str +=(i+":");
            for (Integer w : this.adj(i)) {
                str += w+" ";
            }
            str+="\n";
        }
        return str;
    }
}
