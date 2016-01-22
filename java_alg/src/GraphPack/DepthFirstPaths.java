package GraphPack;

import DataStrcuture.Graph;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Wang on 2016/1/22.
 */
public class DepthFirstPaths {
    private boolean[] marked;  //标记数组
    private int count;  //与s的连通总数
    private int[] edgeTo; //从起点到一个顶点的路径// difference
    private final int s;// difference


    public DepthFirstPaths(Graph G, int s) {  //构造器
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        dfs(G, s);
    }

    //深度优先搜索递归算法
    private void dfs(Graph G, int s) {
        marked[s] = true;       //标记此节点
        count++;
        for (int w : G.adj(s)) {   //访问s的相邻节点，看其是否被访问
            if (!marked[w]) {
                edgeTo[w] = s;  // difference
                dfs(G, w);
            }
        }
    }

    //顶点是否被访问过
    boolean marked(int s) {
        return marked[s];
    }

    //与s的相连的顶点总数
    public int count() {
        return count;
    }

    //寻找路径
    //判断是否存在s到顶点v的路径
    public boolean hasPathTo(int v) {  // difference
        return marked[v];
    }

    //找出s到v的路径
    public Iterable<Integer> pathTo(int v) {   // difference
        if (!hasPathTo(v)) return null; //不存在路径，返回空
        Stack<Integer> path = new Stack<Integer>();
        for (int w = v; w != s; w = edgeTo[w]) {
            path.push(w);
        }
        path.push(s);
        return path;
    }
    //test unit
    public static void main(String[] args){
        File graphFile = new File("DepthFirstPath.txt");
        try {
            System.out.println(graphFile.getCanonicalPath());
            Scanner in = new Scanner(graphFile);
            Graph G = new Graph(in);
            DepthFirstPaths dfs = new DepthFirstPaths(G, 0);
            System.out.println("point 1 has path  to point 5: "+ dfs.hasPathTo(5));
            System.out.println("point 1 has path  to point 4: "+ dfs.hasPathTo(4));
            for (int v:dfs.pathTo(4)) {
                System.out.print(v + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
