package DataStrcuture;

/**
 * Created by Wang on 2016/1/18.
 */
public class MinPQ<Key extends Comparable<Key>>  {
    //PriorityQueue
    private Key[] pq;
    private int N = 0 ;//store in 1,..., N-1
    private int maxN = 0;
    public MinPQ(int maxN){
        pq = (Key[]) new Comparable[maxN+1];
        this.maxN = maxN;
    }

    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }
    public void insert(Key v){
        //N is too large enlarge the size of the array
        if(N > maxN*0.5){
            Key[] pq_new = (Key[]) new Comparable[2*maxN];
            this.maxN = 2*this.maxN;
            //copy the data
            for (int i = 1; i < 1+size(); i++) {
                pq_new[i] = pq[i];
            }
            this.pq = pq_new;
        }
        pq[++N] = v;
        swim(N);

    }
    public Key delMin(){
        Key min = pq[1];
        exch(1, N--);
        pq[N+1] = null;
        sink(1);
        return min;
    }
    private boolean less(int i, int j){
        return pq[j].compareTo(pq[i]) < 0;
    }
    private void exch(int i, int j){
        Key  tmp = pq[i];
        pq[i] = pq[j];
        pq[j] = tmp;
    }
    private void swim(int k){
        //excute whten inserting the new Key
        while(k > 1 && less(k/2 ,k)){
            exch(k/2, k);
            k = k/2;
        }
    }
    private void sink(int k){
        //excute when del the minmum
        while(2*k <= N){
            int j = 2*k;
            if(j < N && less(j, j+1))
                j++;
            if(!less(k, j))
                break;
            exch(k, j);
            k = j;
        }
    }

    //test units
    public static void main(String[] args){
        MinPQ<Integer> pq = new MinPQ<Integer>(2);
        pq.insert(3);
        pq.insert(5);
        pq.insert(4);
        pq.insert(1);
        pq.insert(8);
        pq.insert(7);
        int a = pq.delMin();
        int b = pq.delMin();
        pq.insert(1);

    }


}
