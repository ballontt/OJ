package 回溯;

/**
 * Created by ballontt on 2017/9/19.
 *
 * Question:
 * The set[1,2,3,…,n]contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 *
 * Given n and k, return the k th permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 */
public class PermutationSequence {
    public int k = 0;
    public String res;
    public String getPermutation(int n, int k) {
        this.k =k;
        char[] arr = new char[n];
        for(int i = 0; i < n; i++) {
            arr[i] = String.valueOf(i+1).charAt(0);
        }

        getKth(arr, 0);

        return res;
    }
    public void getKth(char[] A, int begin) {
        if(begin == A.length) {
            if((--k) == 0) {
                res = new String(A);
            }
        }
        for(int i = begin; i < A.length; i++) {
            swap(A, begin, i);

            getKth(A, i+1);

            swap(A, begin, i);

        }
    }

    public void swap(char[] A, int i, int j) {
        char tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args) {
        PermutationSequence p = new PermutationSequence();
        String tmp = p.getPermutation(2, 2);
        System.out.println(tmp);
    }
}
