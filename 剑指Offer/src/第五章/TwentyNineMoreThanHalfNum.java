package 第五章;

/**
 * Created by ballontt on 2017/3/31.
 * 采用阵地攻守的思想：第一个数字作为第一个士兵，守阵地；count = 1；
 * 遇到相同元素，count++;遇到不相同元素，即为敌人，同归于尽,count--；
 * 当遇到count为0的情况，又以新的i值作为守阵地的士兵，继续下去，
 * 到最后还留在阵地上的士兵，有可能是主元素。
 * 再加一次循环，记录这个士兵的个数看是否大于数组一般即可。
 */
public class TwentyNineMoreThanHalfNum {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length==0 || array == null)
            return 0;
        int result = array[0];
        int times = 1;
        for(int i=1; i<array.length; i++) {
            if(times == 0) {
                result = array[i];
                times = 1;
            }else if(result == array[i])
                times--;
            else if(result != array[i])
                times++;
        }

        int nums = 0;
        for(int i=0; i<array.length; i++) {
            if(array[i] == result)
                nums++;
        }
        if(nums*2 <= array.length)
            return 0;
        return result;
    }
}
