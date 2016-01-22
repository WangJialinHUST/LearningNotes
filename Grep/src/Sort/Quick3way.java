package Sort;

/**
 * Created by Wang on 2016/1/20.
 * the enhanced version of the quickSort.
 *even if there are same elements in the array
 */
public class Quick3way {
    public static void sort(Comparable[] a){
        sort(a, 0, a.length-1);
    }
    private static void sort( Comparable[] a, int lo, int hi){
        if (hi <= lo)
            return;
        int i = lo;
        int lt = lo;
        int gt = hi;
        //segmentation element
        Comparable v = a[lo];
        while(i <= gt){
            int cmp = a[i].compareTo(v);
            if (cmp < 0)
                exch(a, lt++, i++);
            else if (cmp > 0)
                exch(a, i, gt--);
            else
                i++;
        }

        sort(a, lo, lt - 1);
        sort(a, gt + 1, hi);
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    //test units
    public static void main(String[] args){
        Integer[] a  = {5, 4, 6, 1, 8, 4, 4};
        Quick3way.sort(a);
    }
}
