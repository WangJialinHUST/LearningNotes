package GraphPack;

import DataStrcuture.Graph;
import DataStrcuture.Queue;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;


/**
 * Created by Wang on 2016/1/22.
 */
public class BreadthFirstPaths{
    private boolean[] marked;
    private int[] edgeTo;  //按照距离存储点
    private final int s; //起点

    public BreadthFirstPaths(Graph G, int s){
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        bfs(G, s);
    }

    //广度搜索核心代码
    private void bfs(Graph G, int s){
        marked[s] = true;
        Queue<Integer> queue = new Queue<Integer>();
        queue.enqueue(s);
        while(!queue.isEmpty()){
            int v = queue.dequeue();   //从队列中删除下一顶点
            for(int w: G.adj(v)){
                if(!marked[w]){
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.enqueue(w);   //加入队列
                }
            }
        }
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
            BreadthFirstPaths bfs = new BreadthFirstPaths(G, 0);
            System.out.println("point 1 has path  to point 5: "+ bfs.hasPathTo(5));
            System.out.println("point 1 has path  to point 4: "+ bfs.hasPathTo(4));
            for (int v:bfs.pathTo(4)) {
                System.out.print(v + " ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}