package 数组;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by ballontt on 2017/8/15.
 *
 * Question:
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example,
 * Given[100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is[1, 2, 3, 4]. Return its length:4.
 * Your algorithm should run in O(n) complexity.
 *
 */
public class LongConsecutiveSequence {
    public static int longestConsecutive(int[] num) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i : num) {
            set.add(i);
        }

        int longestSeq = 0;
        while(!set.isEmpty()) {
            Iterator<Integer> it = set.iterator();
            int s = it.next();
            set.remove(s);
            int sum = 1;
            int small = s - 1;
            int big = s + 1;
            while(set.size() > 0 && set.contains(small)) {
                set.remove(small);
                sum++;
                small--;
            }
            while(set.size() > 0 && set.contains(big)) {
                set.remove(big);
                sum++;
                big++;
            }
            longestSeq = Math.max(longestSeq, sum);
        }
        return longestSeq;
    }
    public static void main(String[] args) {
        int[] n = {0, -1};
        int i = longestConsecutive(n);
    }
}
