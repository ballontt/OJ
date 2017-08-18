package 第四章;

/**
 * Created by ballontt on 2017/3/29.
 */
public class TwentyFourthVerifySequenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence == null || sequence.length == 0)
            return false;
        if(sequence.length == 1)
            return true;
        return Verify(sequence,0,sequence.length-1);


    }

    public boolean Verify(int [] sequence,int left,int right) {

        if(left>right) return true;
        int root = sequence[right];
        int i = left;
        while(sequence[i]<root && i<right)
            i++;
        for(int j = i; j<right; j++){
            if(sequence[j] < root)
                return false;
        }
        return (Verify(sequence,left,i-1)&&Verify(sequence,i,right-1));
    }

}
