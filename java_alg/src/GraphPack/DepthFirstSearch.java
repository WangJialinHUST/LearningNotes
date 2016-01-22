package GraphPack;

import DataStrcuture.Graph;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Wang on 2016/1/22.
 */
public class DepthFirstSearch{
    private boolean[] marked;  //标记数组
    private int count;  //与s的连通总数

    public DepthFirstSearch(Graph G, int s){  //构造器
            marked = new boolean [G.V()];
            dfs(G, s);
    }

    //深度优先搜索递归算法
    private void dfs(Graph G, int s){
            marked[s]  = true;       //标记此节点
            count++;
            for(int w : G.adj(s)){   //访问s的相邻节点，看其是否被访问
                if(!marked[w]) dfs(G, w);
            }
    }

    //顶点是否被访问过
    boolean marked(int s){
        return marked[s];
    }

    //与s的相连的顶点总数
    public int count(){
        return count;
    }
    //test unit
    public static void main(String[] args){
        File graphFile = new File("DepthFirstPaths.txt");
        try {
            System.out.println(graphFile.getCanonicalPath());
            Scanner in = new Scanner(graphFile);
            Graph G = new Graph(in);
            DepthFirstSearch dfs = new DepthFirstSearch(G, 1);
            System.out.println(dfs.count);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}