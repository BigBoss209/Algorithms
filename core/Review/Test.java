package Review;


import java.util.Stack;

/**
 * @Auther LJM
 * @Date 2020/4/28-18:03
 * Description
 */
public class Test {
    public static void main(String[] args) {
//        定义无向图
//        String[] data = {"0 5","4 3","0 1","9 12","6 4","5 4","0 2",
//        "11 12","9 10","0 6","7 8","9 11","5 3"};
//        Graph graph = new Graph(13,13,data);
//        System.out.println(graph.getE());
//        System.out.println(graph.toString());

//        深度优先查找路径
        String[] data = {"0 5","2 4","2 3","1 2","0 1","3 4","3 5","0 2"
        };
        Graph graph = new Graph(6,8,data);
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph, 0);
        int[] pathTo = depthFirstSearch.getPathTo();

        for (int i = 0; i < pathTo.length; i++) {
            System.out.println(i+" : "+pathTo[i]);
        }

//        DepthfirstPaths paths = new DepthfirstPaths(graph,0);
//        for (int v = 0; v < graph.V(); v++) {
//            System.out.print(0+" to "+ v +":");
//            for (Integer w : paths.pathTo(v)) {
//                if(w == 0) System.out.print(w);
//                else System.out.print(w+"-");
//
//            }
//            System.out.println("");
//        }


    }
}
