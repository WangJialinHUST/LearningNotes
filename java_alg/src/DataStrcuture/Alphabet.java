package DataStrcuture;

/**
 * Created by Wang on 2016/1/18.
 */
public class Alphabet {
    SET<Character> alphabet;
    private char[] alpha;
    public Alphabet(String s){
        //construct method
        alphabet = new SET<Character>();
        for (int i = 0; i < s.length(); i++) {
            alphabet.add(s.charAt(i));
        }
        alpha = new char[alphabet.size()];
        int count = 0;
        for (char c:alphabet){
            alpha[count++] = c;
        }
    }

    public char toChar(int index){
        //get the char of the index
        return alpha[index];

    }

    public int toIndex(char c){
        //get the index of the char
        int i = 0;
        while( i < alpha.length  && alpha[i] != c){
            i++;
        }
        return i == alpha.length ? -1 : i;
    }
    boolean contains(char c){
        //if contains char c
        return toIndex(c) != -1;
    }

    public int R(){
        //the number of the char in the Alphabet
        return alpha.length;
    }

    public int lgR(){
        //the number of bits to express a index
        int next  = alpha.length / 2;
        int count = 1;
        while(next > 1){
            next  = next / 2;
            count++;
        }
        return count;
    }

    public int[] toIndices(String s){
        //convert the S to the integer with radix R
        int[] indices = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            indices[i] = toIndex(s.charAt(i));
        }
        return indices;
    }

    public String toChars(int[] indices){
        String s;
        char[] sChar = new char[indices.length];

        for (int i = 0; i < indices.length; i++) {
            sChar[i] = toChar(indices[i]);
        }
        s = new String(sChar);
        return s;
    }

    public static void main(String[] args){
        String s = "AATCG";
        Alphabet A = new Alphabet(s);
        char c = A.toChar(1);
        int index = A.toIndex(c);
        int R  = A.R();
        int lgR = A.lgR();
        boolean b = A.contains('W');
        b = A.contains('A');
        String ss = "TCTC";
        int[] a = A.toIndices(ss);
        String sss = A.toChars(a);
    }
}
