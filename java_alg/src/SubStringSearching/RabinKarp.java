package SubStringSearching;

import java.math.BigInteger;
import java.util.Date;
import java.util.Random;

/**
 * Created by Wang on 2016/1/21.
 */

public class RabinKarp {
    private String pat;
    private int R = 256;
    private int M;
    private long patHash;
    private long Q;
    private static int rd = 1;
    //random select these two primes, or you can implements the prime generatiuon by yourself. that would be great!
    private long[] primeArray  = { 978323,2147483647};
    private long RM; //R^(M-1) % Q
    public  RabinKarp(String pat){
        this.pat = pat;
        this.M = pat.length();
        RM = 1;
        rd = 1 - rd;
        Q = primeArray[rd];//generate a big prime number
        //Q = 2147483647;
        for (int i = 1; i < M; i++) {
            RM  = (R*RM) % Q;
        }
        this.patHash = hash(pat, M);
    }

    private long hash(String key, int M){
        long h = 0;
        for (int i = 0; i < M; i++) {
            h = (R*h + key.charAt(i)) % Q;
        }
        return h;
    }
    private boolean check(String s){
        //蒙特卡洛算法或者拉斯维加斯算法
        //蒙特卡洛
        RabinKarp rk2 = new RabinKarp(pat);
        return rk2.hash(s, M) == rk2.patHash;
    }

    public int search(String txt){
        int N = txt.length();
        long txtHash = hash(txt, M);
        int i ;
        if (txtHash == patHash)
            if(check(txt.substring(0, M)))
                return 0;
        for (i = M; i < N; i++) {
            txtHash = (txtHash + Q - RM*txt.charAt(i-M) % Q) % Q;
            txtHash = (txtHash*R + txt.charAt(i)) % Q;
            if (txtHash == patHash){
                if(check(txt.substring(i-M+1, i+1)))
                    return i-M+1;  //找到匹配
            }
        }

        return N;
    }

    public static void main(String[] args){
        String txt = "AEAFBBCCDD";
        String pat = "FBBCCD";
        RabinKarp rk = new RabinKarp(pat);
        int pos = rk.search(txt);
        System.out.println(pos);
    }
}
