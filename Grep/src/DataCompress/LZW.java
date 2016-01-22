package DataCompress;

import DataStrcuture.TST;
import edu.princeton.cs.introcs.BinaryStdIn;
import edu.princeton.cs.introcs.BinaryStdOut;

import javax.swing.text.Position;

/**
 * Created by Wang on 2016/1/18.
 */
public class LZW {
    private static final int R = 256; //输入字符数
    private static final int L = 4096;    //编码总数2^12
    private static final int W = 12;     //编码位宽

    //compress algorithm
    public static void compress(String input){
        TST<Integer> st = new TST<Integer>();

        for (int i = 0; i < R; i++) {
            st.put(""+(char) i, i);
        }
        int code = R + 1;//R为EOF

        while(input.length() > 0){
            String s = st.longestPrefixOf(input);
            BinaryStdOut.write(st.get(s), W);

            int t = s.length();
            if (t < input.length() && code < L)
                st.put(input.substring(0, t+1), code++);
            input = input.substring(t);
        }
        BinaryStdOut.write(R, W);
        BinaryStdOut.close();
    }

    //expand algorithm
    public static void expand(int[] input){
        String[] st = new String[L];
        int i; //下一个待补全的编码值
        for (i = 0; i < R; i++) {
            st[i] = "" + (char)i;
        }
        st[i++] = ""; //EOF

     //   int codeword = BinaryStdIn.readInt(W);
        int cnt = 0;
        int codeword = input[cnt++];
        String val = st[codeword];
        while(cnt < input.length){
           // BinaryStdOut.write(val);
           // codeword = BinaryStdIn.readInt(W);
            codeword = input[cnt++];
            if (codeword == R)
                break;
            String s  = st[codeword];
            if (i == codeword)
                s = val + val.charAt(0);
            if (i < L)
                st[i++] = val + s.charAt(0);
            val = s;
        }
        //BinaryStdOut.close();
    }
    //test units
    public static void main(String[] args){
        int[] input = {65,66,257,259};
        expand(input);
    }
}
