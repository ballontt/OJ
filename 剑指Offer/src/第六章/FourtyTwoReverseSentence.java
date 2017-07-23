package 第六章;

/**
 * Created by ballontt on 2017/4/5.
 */
public class FourtyTwoReverseSentence {
    public String ReverseSentence(String str) {
        String[] buffer = str.split(" ");
        if(str==null || str.length() == 0 || buffer == null)
            return str;
        StringBuffer sb = new StringBuffer();
        for(int i=buffer.length-1; i>=0; i--) {
            if( i == 0)
                sb.append(buffer[i]);
            else
                sb.append(buffer[i] + " ");
        }
        return sb.toString();
    }
}
