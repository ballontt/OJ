package 第六章;

/**
 * Created by ballontt on 2017/4/5.
 */
public class ThirtyEightGetNumberOfK {
    public int GetNumberOfK(int[] array, int k) {
        if(array == null || array.length ==0)
            return 0;
        int first = GetFirstK(array,0,array.length-1,k);
        int last = GetLastK(array,0,array.length-1,k);
        if(first!=-1 && last!=-1)
           return  (last-first)+1;
        return 0;
    }
    private int GetFirstK(int[] array,int low,int high,int k){
        if(low > high)
            return -1;
        int midIndex = (high-low)/2+low;
        int midData  = array[midIndex];
        if(midData == k){
            if(midIndex>low&&array[midIndex-1]!=k || midIndex == low)
                return midIndex;
            else
                high = midIndex - 1;
        }else if(midData > k) {
            high = midIndex - 1;
        }else {
            low = midIndex + 1;
        }
        return GetFirstK(array,low,high,k);
    }
    private int GetLastK(int[] array,int low,int high,int k) {
        if(low > high)
            return -1;
        int midIndex = (high-low)/2+low;
        int midData = array[midIndex];
        if(midData == k){
            if(midIndex<high&&array[midIndex+1]!=k || midIndex==high)
                return midIndex;
            else
                low = midIndex + 1;
        }else if(midData > k) {
            high = midIndex - 1;

        }else {
            low = midIndex + 1;
        }
        return GetLastK(array,low,high,k);
    }
    public static void main(String[] args) {
        ThirtyEightGetNumberOfK  test = new ThirtyEightGetNumberOfK();
        int[] array = {1,2,2,2,3,4,5,5,6};
        int num = test.GetNumberOfK(array,7);
        System.out.println(num);
    }
}
