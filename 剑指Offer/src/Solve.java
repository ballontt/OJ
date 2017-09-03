/**
 * Created by ballontt on 2017/4/26.
 */
import java.util.*;

public class Solve {
    // Arrays.sort(arr);
    static int[] flag = new int[100];
    static int index = 0;// 记录当前
    public Solve() {
    }
    public static void numGroup(int[] arr, int start, int length, int sum) {
        if (sum == 0) {
            for (int j = 0; j < index; j++) {
                System.out.print(flag[j]+" ");
            }
            System.out.println();
        } else {
            for (int i = start; i < length; i++) {
                flag[index++] = arr[i];
                Solve.numGroup(arr, i + 1, length-1, sum - arr[i]);
            }
        }
        index--;
    }
    public static void main(String[] args) {
        int[] arr = { 1, 3, 2};
        Arrays.sort(arr);
        int sum = 3;
        Solve.numGroup(arr, 0, arr.length, sum);
    }
}
