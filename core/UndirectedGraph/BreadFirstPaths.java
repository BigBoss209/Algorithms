package UndirectedGraph;

import Quene.Quene;
import Stack.Stack;

/**
 * @Auther LJM
 * @Date 2020/4/29-10:25
 * Description 广度优先寻找路径
 */
public class BreadFirstPaths {
    private boolean[] marked;
    private int[] pathTo;
    private int s;

    public BreadFirstPaths(Graph G,int s){
        marked = new boolean[G.V()];
        pathTo = new int[G.V()];
        this.s = s;
        bfs(G,s);
    }

    public void bfs(Graph G,int s){
        Quene queue = new Quene<Integer>();
        marked[s] = true;
        queue.enquene(s);
        while (!queue.isEmpty()){
            int v = (int)queue.dequene();
            for (Integer w : G.adj(v)) {
                if(!marked[w]){
                    pathTo[w] = v;
                    marked[w] = true;
                    queue.enquene(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }

    public void PathTo(int v){
        String str = v+" : ";
        for (int x = v; x != s; x = pathTo[x]) {
            str += x +" ";
        }
        str += s;
        System.out.println(str);
    }

    public Iterable getPath(int v){
        Stack stack = new Stack<Integer>();
        for (int x = v;x != s; x=pathTo[x]){
            stack.push(x);
        }
        stack.push(s);
        return stack;
    }

}
