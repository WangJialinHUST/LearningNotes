package DataStrcuture;

/**
 * Created by Wang on 2016/1/18.
 * 三向单词查找树的符号表
 */
public class TST<Value> {
    private Node root;
    private class Node{
        char c;
        Node left, mid, right;
        Value val;
    }

    public Value get(String key){
        Node x = get(root, key, 0);
        if (x == null)
                return null;
        return (Value) x.val;
    }
    private Node get(Node x, String key, int d){
        if (x == null)
            return null;
        char c = key.charAt(d);
        if(c < x.c) return get(x.left, key, d+1);
        else if (c > x.c) return get(x.right, key, d+1);
        else if(d < key.length() -1)
            return get(x.mid, key, d+1);
        else return x;  //查找命中
    }

    public void put(String key, Value val){
        root = put(root, key, val, 0);
    }
    private Node put(Node x, String key, Value val, int d){
        char c = key.charAt(d);
        if(x == null) {
            x = new Node();
            x.c  = c;
        }
        if(c < x.c) x.left = put(x.left, key, val, d);
        else if (c > x.c) x.right = put(x.right, key, val, d);
        else if (d < key.length() - 1) x.mid = put(x.mid, key, val, d+1);
        else x.val = val;
        return x;
    }
    //查找最长前缀
    public String longestPrefixOf(String s){
        int length = search(root, s, 0, 0);
        return s.substring(0, length);
    }

    private int search(Node x, String s, int length, int d){
        if(x == null)
            return length;
        if(x.val != null)
            length = d;
        if (d == s.length())
            return length;
        char c = s.charAt(d);
        if (c < x.c)
            return search(x.left, s, length, d);
        else if(c > x.c)
            return search(x.right, s, length, d);
        else
            return search(x.mid, s, length, d+1);
    }

    //test units
    public static void main(String[] args){
        TST<Integer> tst = new TST<Integer>();
        tst.put("abc",1);
        tst.put("abd",2);
        tst.put("abcde",5);
        String s = tst.longestPrefixOf("abcdef");
    }
}
