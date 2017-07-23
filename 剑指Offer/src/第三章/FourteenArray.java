package 第三章;

/**
 * Created by ballontt on 2017/3/25.
 * 类似插入排序
 */
public class FourteenArray {
    public void reOrderArray(int [] array) {
        int length = array.length;
        for(int i = 0; i<length; i++) {
            if((array[i] & 0x01) == 1) {
                for(int j = i; j>0; j--) {
                    if((array[j-1] & 0x01) == 0) {
                        int tmp = array[j];
                        array[j] = array[j-1];
                        array[j-1] = tmp;
                    }else{
                        break;
                    }
                }

            }
        }

    }
}
