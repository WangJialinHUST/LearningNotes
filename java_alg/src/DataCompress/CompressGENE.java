package DataCompress;

import DataStrcuture.Alphabet;
import edu.princeton.cs.introcs.BinaryStdIn;
import edu.princeton.cs.introcs.BinaryStdOut;

/**
 * Created by Wang on 2016/1/18.
 * Double bits coding
 */
public class CompressGENE {
    //compress the GENE data
    public static void compress(){
        Alphabet DNA  = new Alphabet("ACTG");
        String s = "ACTG";
        int N = s.length();
        BinaryStdOut.write(N);
        for (int i = 0; i < N; i++) {
            int d = DNA.toIndex(s.charAt(i));
            BinaryStdOut.write(d, DNA.lgR());
        }
        BinaryStdOut.close();
    }
    public static void main(String[] args){
        compress();
    }
}
