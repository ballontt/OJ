//package 笔试.airbnb;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//
///**
// * Created by ballontt on 2017/9/20.
// */
//public class Meet {
//    public static ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
//    public static ArrayList<Integer> list = new ArrayList<Integer>();
//    public static HashMap<Integer, Boolean> map = new HashMap<Integer, Boolean>()
//
//    public static int[] meet(String[] wizards) {
//        ArrayList<ArrayList<Integer>> inputs = new ArrayList<ArrayList<Integer>>();
//
//        // 初始化map
//        for(int i = 0; i < wizards.length; i++) {
//            map.put(i, false);
//        }
//
//        for(int i = 0; i < wizards.length; i++) {
//            String[] tmp = wizards[i].split(" ");
//            ArrayList<Integer> numList = new ArrayList<Integer>();
//            for(String s : tmp) {
//                numList.add(Integer.valueOf(s));
//            }
//            inputs.add(numList);
//        }
//
//        meetHelper(inputs, 0);
//
//        if(res.size() == 0){
//            int[] res = {0};
//            return res;
//        }
//        int minIndex = 0;
//        int minPoints = Integer.MAX_VALUE;
//        for(int i = 0; i < res.size(); i++)  {
//            int points = calcMagicPoints(res.get(i));
//            if(points < minPoints) {
//                minPoints = points;
//                minIndex = i;
//            }
//        }
//
//        int[] path = new int[res.get(minIndex).size()];
//        for(int i = 0; i < path.length; i++) {
//            path[i] = res.get(minIndex).get(i);
//        }
//        return path;
//    }
//
//    public static void meetHelper(ArrayList<ArrayList<Integer>> nums, int k) {
//        list.add(k);
//        if(k == 9) {
//            res.add((ArrayList<Integer>)list.clone());
//            return;
//        }
//
//        ArrayList<Integer> curr = nums.get(k);
//        for(Integer i : curr) {
//            if(!map.get(i)) {
//                map.put(i, true);
//                meetHelper(nums, i);
//                list.remove(list.size() - 1);
//                map.put(i, false);
//            }
//        }
//    }
//
//    public static int calcMagicPoints(ArrayList<Integer> nums) {
//        int res = 0;
//        for(int i = 0; i < nums.size() - 1; i++) {
//            int sub = nums.get(i) - nums.get(i+1);
//            res += (sub * sub);
//        }
//        return res;
//    }
//}
