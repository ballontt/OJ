package 第五章;

/**
 * Created by ballontt on 2017/4/1.
 */
public class ThirtyOneFindGreatestSumOfSubArray {
    boolean inValided = true;
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0) {
            inValided = false;
            return 0;
        }
        int maxSum = array[0];
        int tmpSum = array[0];
        for(int i=1; i<array.length; i++) {
            if(tmpSum < 0)
                tmpSum = array[i];
            else
                tmpSum += array[i];
            if(tmpSum > maxSum)
                maxSum = tmpSum;
        }
        return maxSum;
    }
    public static void main(String[] args) {
        ThirtyOneFindGreatestSumOfSubArray test = new ThirtyOneFindGreatestSumOfSubArray();
        int[] a = {5,-9,4,11};
        System.out.println(test.FindGreatestSumOfSubArray(a));
    }
}
