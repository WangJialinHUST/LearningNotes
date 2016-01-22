package DataStrcuture;

/**
 * Created by Wang on 2016/1/16.
 */
public class Digraph{
    private final int V;
    private int E;
    private Bag<Integer>[] adj;
    public Digraph(int V){
        this.V = V;
        this.E = 0;
        adj =  new Bag[this.V];
        for(int v = 0; v < V; v++){
            adj[v] = new Bag<Integer>();
        }
    }
    /// TODO: 2016/1/22 (int In) 
    public int V(){
        return V;
    }
    public int E(){
        return E;
    }
    public void addEdge(int v, int w){
        adj[v].add(w);
        E++;
    }
    public Iterable<Integer> adj(int v){
        return adj[v];
    }
    public Digraph reverse(){
        Digraph R = new Digraph(V);
        for(int v = 0; v < V; v++){
            for(int w :adj(v)){
                R.addEdge(w, v);
            }
        }
        return R;
    }
}