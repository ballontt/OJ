package 第六章;

/**
 * Created by ballontt on 2017/4/6.
 */
public class FourtySixNadd {
    public int Sum_Solution(int n) {
        int sum = 0;
        boolean end =  (n>0) && (sum = n+Sum_Solution(n-1))>0;
        return sum;
    }
    public static void main(String[] args) {
        FourtySixNadd test = new FourtySixNadd();
        int result = test.Sum_Solution(10);
        System.out.println(result);
    }
}
