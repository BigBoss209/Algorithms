package UndirectedGraph;

import java.util.HashMap;

/**
 * @Auther LJM
 * @Date 2020/4/29-13:31
 * Description 符号表
 */
public class SymbolGraph {
    private HashMap<String,Integer> ST;
    private String[] keys;
    private Graph G;

    public SymbolGraph(String[] data,String sp){
        ST = new HashMap<String,Integer>(data.length);
        keys = new String[data.length];
        String[] split;
        for (int i = 0; i < data.length; i++) {
            split = data[i].split(sp);
            for (int j = 0; j < split.length; j++) {
                if(!ST.containsKey(split[i]))
                    ST.put(split[i],ST.size());
            }

        }
        for (String key : ST.keySet()) {
            keys[ST.get(key)] = key;
        }

        G = new Graph(ST.size());
        for (int i = 0; i < data.length; i++) {
            split = data[i].split(sp);
            int v = ST.get(split[0]);
            for (int w = 1; w < split.length; w++) {
                G.addEdge(v,ST.get(split[i]));
            }

        }

    }


}
