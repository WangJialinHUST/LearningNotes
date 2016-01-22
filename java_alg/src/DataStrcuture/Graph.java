package DataStrcuture;

import edu.princeton.cs.introcs.In;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by Wang on 2016/1/22.
 */
public class Graph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Graph(int V){
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];

        for (int i = 0; i < V; i++) {
            adj[i] = new Bag<Integer>();
        }
    }

    public Graph(Scanner in){
        this(in.nextInt());//read V
        E = in.nextInt();
        for (int i = 0; i < E; i++) {
            int v = in.nextInt();//read the point of the edge
            int w = in.nextInt();
            adj[v].add(w);
            adj[w].add(v);
        }
    }
    // return the number of the points
    public int E(){
        return E;
    }

    //return the number of the edges
    public int V(){
        return V;
    }

    //add edge to the graph
    public void addEdge(int v, int w){
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }
    //return the adj points of point v
    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    //test unit
    public static void main(String[] args){
        File graphFile = new File("Graph.txt");
        try {
            System.out.println(graphFile.getCanonicalPath());
            Scanner in = new Scanner(graphFile);
            Graph G = new Graph(in);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
