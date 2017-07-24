package 动态规划;

import java.util.Vector;

/**
 * Created by ballontt on 2017/7/17.
 *
 * Question:
 * There are N children standing in a line. Each child is assigned a rating value.
 * You are giving candies to these children subjected to the following requirements:
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 *
 * Answer:
 * 核心实现是从左遍历，在从右遍历一遍,每次比较都是和右边都比
 *
 */
public class Candy {
    public int candy(int[] ratings) {
        if(ratings == null) {
            return 0;
        } else if(ratings.length == 1) {
            return 1;
        }

        int[] nums = new int[ratings.length];
        // 将所有值设置为1
        for(int i = 0; i < nums.length; i++) {
            nums[i] = 1;
        }
        // 从左向右遍历，这个主要是比较都左侧都值,也就是以 i+1 为中心做比较
        for(int i = 0; i < nums.length - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                nums[i + 1] = nums[i] + 1;
            }
        }
        // 从右向左遍历，以i为中心和i+1比较。
        for(int i = nums.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i + 1]) {
                nums[i]  = Math.max(nums[i], nums[i + 1] + 1);
            }
        }
        int result = 0;
        for(int i : nums) {
            result += i;
        }
        return result;

    }
}
