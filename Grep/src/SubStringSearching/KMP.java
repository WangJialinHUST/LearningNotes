package SubStringSearching;

import DataStrcuture.Graph;

/**
 * Created by Wang on 2016/1/14.
 * KMP Algorithm dfa:确定有限状态机
 */
public class KMP {
    private String pat;
    private int[][] dfa;
    Graph G;
    public KMP(String pat){
        //construct the array dfa by the pattern string
        this.pat = pat;
        int M = pat.length();
        int R = 256;
        dfa = new int[R][M];
        dfa[pat.charAt(0)][0] = 1;
        for (int X = 0, j = 1; j < M; j++) {
            for (int c = 0; c < R; c++) {
                dfa[c][j] = dfa[c][X];
            }
            dfa[pat.charAt(j)][j] = j+1;
            X = dfa[pat.charAt(j)][X];
        }
    }

    public int search(String s){
        int M = pat.length();
        int N = s.length();
        int i = 0, j = 0;
        for (i = 0; i < N && j < M; i++) {
            j = dfa[s.charAt(i)][j];
        }
        if (j == M)
            return i - M;
        else
            return N;
    }

    public static void main(String[] args){
        String pat = "AACAA";
        KMP kmp = new KMP(pat);
        String s = "BBcAACAAD";
        int position = kmp.search(s);
    }
}
