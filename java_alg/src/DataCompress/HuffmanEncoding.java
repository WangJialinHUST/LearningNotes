package DataCompress;

import DataStrcuture.MinPQ;

import java.net.HttpURLConnection;

/**
 * Created by Wang on 2016/1/18.
 */
public class HuffmanEncoding {
    private static int R = 256;
    private static class Node implements Comparable<Node>{
        private char ch;
        private int freq;
        private final Node left, right;
        public Node(char ch, int freq, Node left, Node right){
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
        public boolean isLeaf(){
            return (left==null  &&  right==null);
        }
        public int compareTo(Node that){
            return this.freq - that.freq;
        }

    }
    //get the frequcy , construct the Tire
    private static Node buildTrie(int[] freq){
        int maxN  =  100;
        MinPQ<Node> pq = new MinPQ<Node>(maxN);
        for(char c = 0; c < R; c++){
            if (freq[c] > 0){
                pq.insert(new Node(c, freq[c], null, null));
            }
        }
        while(pq.size() > 1){
            Node x = pq.delMin();
            Node y = pq.delMin();
            Node parent = new Node('\0', x.freq + y.freq, x, y);
            pq.insert(parent);
        }

        return pq.delMin();
    }
    //get the code of the char
    private static String[] buildCode(Node root){
        String[] st = new String[R];
        buildCode(st, root, "");
        return st;
    }
    private static void buildCode(String[] st, Node x, String s){
        if (x.isLeaf()) {
            st[x.ch] = s;
            return;
        }

        buildCode(st, x.left, s + '0');
        buildCode(st, x.right, s + '1');
    }
    //compress the data
    public static void compress(String s){
        char[] input = s.toCharArray();
        int[] freq = new int[R];
        for (int i = 0; i < input.length; i++) {
            freq[input[i]]++;
        }
        //CCONSTRUCT THE huffman-tree
        Node root = buildTrie(freq);
        String[] st = new String[R];
        st = buildCode(root);
    }

    //test units

    public static void main(String[] args){
        HuffmanEncoding hfm = new HuffmanEncoding();
        String s = new String("ABCAABC");
        hfm.compress(s);
    }
}
