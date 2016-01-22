package SubStringSearching;

/**
 * Created by Wang on 2016/1/15.
 */
public class BoyerMoore {
    private int[] right;  //store the position of jumping
    private String pat;
    public BoyerMoore(String pat){
        int R = 256;
        int M = pat.length();
        right = new int[pat.length()];
        for (int i = 0; i < R; i++) {
            right[i] = -1;
        }
        for (int i = 0; i < M; i++) {
            right[pat.charAt(i)] = i;
        }
    }

    public int search(String txt){
        int N = txt.length();
        int M = pat.length();
        int skip;

        for (int i = 0; i < N-M; i+=skip) {
            skip = 0;
            for (int j = M-1; j >=0; j--) {
                if(pat.charAt(j) != txt.charAt(i+j)) {
                    skip = j - right[txt.charAt(i + j)];
                    if (skip < 1)
                        skip = 1;
                    break;
                }
            }
            if(skip == 0)
                return i;
        }
        return N;
    }
// test units
    public static void main(String[] args){
        String pat = "AACAA";
        String s = "BBcAACAAD";
        BoyerMoore bm = new BoyerMoore(pat);
        int position = bm.search(s);
    }
}
