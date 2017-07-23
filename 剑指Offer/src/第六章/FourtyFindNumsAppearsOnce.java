package 第六章;

/**
 * Created by ballontt on 2017/4/5.
 */
public class FourtyFindNumsAppearsOnce {
    public void FindNumsAppearsOnce(int[] array,int num1[],int num2[]) {
        if(array==null || array.length<2 )
            return;
        int tmp = 0;
        for(int i=0; i<array.length; i++) {
            tmp ^= array[i];
        }
        int indexBit = findFirstBitls(tmp);

        for(int i=0; i<array.length; i++) {
            if(isBit(array[i],indexBit))
                num1[0] ^= array[i];
            else
                num2[0] ^= array[i];
        }

    }
    public int findFirstBitls(int num) {
        int indexBit = 0;
        while((num&1)==0 && indexBit <32){
            indexBit++;
            num = num >> 1;
        }
        return indexBit;
    }
    public boolean isBit(int num,int index){
        num = num >> index;
        return (num&1) == 1;
    }

}
