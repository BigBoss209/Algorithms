package Review;

import Bag.Bag;

/**
 * @Auther LJM
 * @Date 2020/4/29-9:17
 * Description
 */
public class Graph {
    private int V;
    private int E;
    private Bag<Integer>[] adj;

    public Graph(int V){
        this.V = V;
        this.E = 0;
        adj = new Bag[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<Integer>();
        }
    }

    public Graph(int V,int E,String[] data){
        this(V);
        this.E = E;
        for (String s : data) {
            String[] split = s.split(" ");
            addinitEdge(Integer.parseInt(split[0]),Integer.parseInt(split[1]));
        }
    }

    private void addinitEdge(int v,int w){
        adj[v].add(w);
        adj[w].add(v);
    }

    public void addEdge(int v,int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public int getV(){
        return V;
    }

    public int getE(){
        return E;
    }

    @Override
    public String toString() {
        Iterable<Integer> iterable =null;
        String str = "";
        for (int i = 0; i < V; i++) {
            iterable = adj(i);
            str+=i+":";
            for (Integer w : iterable) {
                str += " "+w;
            }
            str += "\n";
        }

        return str;
    }
}
