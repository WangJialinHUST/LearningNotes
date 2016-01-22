package DataCompress;

import edu.princeton.cs.introcs.BinaryStdIn;
import edu.princeton.cs.introcs.BinaryStdOut;
import edu.princeton.cs.introcs.StdOut;

/**
 * Created by Wang on 2016/1/18.
 */
public class RunLengthEncoding {
    public static void compress(){
        char cnt = 0;
        boolean b = false,old = false;
        while(!BinaryStdIn.isEmpty()){
            b = BinaryStdIn.readBoolean();
            if(b != old){
                BinaryStdOut.write(cnt);
                cnt = 0;
                old = !old;
            }
            else{
                if(cnt == 255) {
                    BinaryStdOut.write(cnt);
                    cnt = 0;
                    BinaryStdOut.write(cnt);
                }
            }
            cnt++;
        }
        BinaryStdOut.write(cnt);
        BinaryStdOut.close();
    }

    //expand the compressed data to the raw data

    public static void expand(){
        boolean b = false;
        while(!BinaryStdIn.isEmpty()){
            char cnt = BinaryStdIn.readChar();
            for (int i = 0; i < cnt; i++) {
                BinaryStdOut.write(b);
            }
            b = !b;
        }
        BinaryStdOut.close();
    }
}
