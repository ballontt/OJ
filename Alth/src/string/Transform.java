package string;

/**
 * Created by ballontt on 2017/5/6.
 */
public class Transform {
    public boolean chkTransform(String A,int lena, String B, int lenb) {
        if(lena != lenb)
            return false;
        int[] map = new int[256];
        for(int i=0; i<lena; i++) {
            map[A.charAt(i)]++;
        }
        for(int i=0; i<lenb; i++) {
            if(map[B.charAt(i)]-- == 0)
                return false;
        }
        return true;
    }
}

