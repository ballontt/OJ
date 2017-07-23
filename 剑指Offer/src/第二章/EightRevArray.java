package 第二章;

/**
 * Created by ballontt on 2017/3/22.
 */
public class EightRevArray {

 public static int minNumberInRotateArray(int [] array) throws Exception{
    if(array == null) {
        throw new Exception("array cann't be null!");
    }
    if(array.length == 0)
        return 0;
    int leftIndex = 0;
    int rightIndex = array.length-1;
    int midIndex = leftIndex;
    while(array[leftIndex] >= array[rightIndex]) {
        if(rightIndex - leftIndex == 1) {
            midIndex = rightIndex;
            break;
        }
        midIndex = (leftIndex + rightIndex) / 2;
        if(array[leftIndex] == array[midIndex] && array[rightIndex] == array[midIndex]) {
            return minInOrder(array,leftIndex,rightIndex);
        }
        if(array[leftIndex] <= array[midIndex]) {
            leftIndex = midIndex;
        }
        else if (array[midIndex] <= array[rightIndex]) {
            rightIndex = midIndex;
        }
    }
    return array[midIndex];
}

    public static int minInOrder(int[] array,int index1,int index2) {
        int minNum = array[index1];
        for(int i = index1; i <=index2;i++) {
            if(array[i] < minNum)
                minNum = array[i];
        }
        return minNum;
    }
    public static void main(String[] args) throws Exception {
        int[] a = {5,7,8,10,2,3,5};
        System.out.println(minNumberInRotateArray(a));
    }
}