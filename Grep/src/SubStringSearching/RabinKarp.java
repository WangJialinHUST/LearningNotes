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
    private long RM; //R^(M-1) % Q
    public  RabinKarp(String pat){
        this.pat = pat;
        this.M = pat.length();
        RM = 1;
        Q = bigPrime();//generate a big prime number
        for (int i = 0; i < M; i++) {
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
        return rk2.hash(s, M) == this.patHash;

    }

    public int search(String txt){
        int N = txt.length();
        long txtHash = hash(txt, M);
        int i ;
        if (txtHash == patHash)
            return 0;
        for (i = M; i < N; i++) {
            txtHash = (txtHash + Q - RM*txt.charAt(i-M)) % Q;
            txtHash = (txtHash*R + txt.charAt(i)) % Q;
        }
        if (txtHash == patHash){
            if(check(txt.substring(i-M+1, M)))
                return i-M+1;  //找到匹配
        }
        return N;
    }
    //generate big prime
    //// TODO: 2016/1/21  
    public long bigPrime(){
        int digitNumber = 9;
        StringBuffer s = new StringBuffer("");
        for (int i = 0; i < ; i++) {
            
        }
        start 
    }
}
