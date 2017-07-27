package string;

/**
 * Created by ballontt on 2017/5/6.
 */
public class Rotation {
    public boolean chkRotation(String A, int lena, String B, int lenb) {
        if(lena != lenb)
            return false;
        String tmp = A+A;
        return tmp.contains(B);
    }
}
