package ProgramTips;

/**
 * Created by Wang on 2016/1/24.
 * this program is used to compare if-else and  test-expr?expr1:expr2
 */
public class IfElse {
    static int N;
    double a[];
    double b[];
    double c[];
    double d[];
    public IfElse(int N){
        this.N = N;
        a = new double[N];
        b = new double[N];
        c = new double[N];
        d = new double[N];

    }

    public void Test1(){
        for(int iter = 0; iter < 300; iter++) {
            for (int i = 0; i < N; i++) {
                a[i] = Math.random();
                b[i] = Math.random();
            }
            for (int i = 0; i < N; i++) {
                if (a[i] > b[i])
                    c[i] = Math.pow(a[i], b[i]);
                else
                    c[i] = Math.pow(b[i] ,a[i]);
            }
        }
    }


    public void Test2(){
        for(int iter = 0; iter < 300; iter++) {
            for (int i = 0; i < N; i++) {
                a[i] = Math.random();
                b[i] = Math.random();
            }
            for (int i = 0; i < N; i++) {
                d[i] = a[i] > b[i] ?  Math.pow(a[i], b[i]) : Math.pow(b[i] ,a[i]);
            }
        }
    }

    public void Test3(){
        for(int iter = 0; iter < 300; iter++) {
            for (int i = 0; i < N; i++) {
                a[i] = Math.random();
                b[i] = Math.random();
            }
            for (int i = 0; i < N; i++) {
                if (a[i] > b[i])
                    c[i] = Math.pow(a[i], b[i])*(a[i] - b[i])/a[i];
                else
                    c[i] = Math.pow(b[i] ,a[i])*(a[i] - b[i])/b[i];
            }
        }
    }

    public void Test4(){
        for(int iter = 0; iter < 300; iter++) {
            for (int i = 0; i < N; i++) {
                a[i] = Math.random();
                b[i] = Math.random();
            }
            for (int i = 0; i < N; i++) {
                d[i] = a[i] > b[i] ?  Math.pow(a[i], b[i])*(a[i] - b[i])/a[i] : Math.pow(b[i] ,a[i])*(a[i] - b[i])/b[i];
            }
        }
    }

    public static void main(String[] args){
        IfElse ie = new IfElse(5000000);
        double t1 = System.currentTimeMillis();
        ie.Test1();
        t1 = System.currentTimeMillis() - t1;
        double t2 = System.currentTimeMillis();
        ie.Test2();
        t2 = System.currentTimeMillis() - t2;
        double t3 = System.currentTimeMillis();
        ie.Test3();
        t3 = System.currentTimeMillis() - t3;
        double t4 = System.currentTimeMillis();
        ie.Test4();
        t4 = System.currentTimeMillis() - t4;
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(t4);
    }
}
