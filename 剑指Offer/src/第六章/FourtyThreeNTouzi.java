package 第六章;

/**
 * Created by ballontt on 2017/4/6.
 * 递归的效率比较低，转换为循环的实现：http://www.cnblogs.com/churi/p/3600655.html
 */
public class FourtyThreeNTouzi {

    public int countNumber(int n, int s) {
        if(s < n || s > n*6 )
            return 0;
        if( n == 1)
            return 1;
        else
            return countNumber(n-1,s-6) + countNumber(n-1,s-5) + countNumber(n-1,s-4) + countNumber(n-1,s-3)
                +countNumber(n-1,s-2) + countNumber(n-1,s-1);
    }

    public void printProbability(int n) {
        int total = (int)Math.pow(6,n);
        for(int i = n; i <= n*6; i++) {
            System.out.println(i+"出现的概率："+countNumber(n,i)+"/"+total);
        }
    }

    public static void  main(String[] args) {
        FourtyThreeNTouzi test = new FourtyThreeNTouzi();
        test.printProbability(10);
    }

}
