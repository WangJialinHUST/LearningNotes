package DataStrcuture;

/**
 * Created by Wang on 2016/1/16.
 */
public class DirectedDFS{
    public boolean[] marked;
    public DirectedDFS(Digraph G, int s){   //在G中找到s可达的所有顶点
        marked = new boolean[G.V()];
        for (int i = 0; i < marked.length; i++) {
            marked[i] = false;
        }
        dfs(G, s);
    }
    //在G中找到从集合sources中的所有定点可达的所有顶点
    public  DirectedDFS(Digraph G, Iterable<Integer> sources){
        marked = new boolean[G.V()];
        for (int i = 0; i < marked.length; i++) {
            marked[i] = false;
        }
        for(int s : sources){
            if(!marked[s])
                dfs(G,s);
        }
    }
    private void dfs(Digraph G, int v){
        marked[v] = true;
        for(int w: G.adj(v)){
            if(!marked[w])
                dfs(G, w);
        }
    }
    boolean marked(int v){  // v是可达的吗
        return marked[v];
    }
}