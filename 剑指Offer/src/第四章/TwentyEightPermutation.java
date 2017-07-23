package 第四章;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by ballontt on 2017/3/30.
 */
public class TwentyEightPermutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> result = null;
        HashSet<String> setResult = new HashSet<String>(); //HashSet用来去重
        char[] buf = str.toCharArray();
        Permutation(buf,0,setResult);
        result = new ArrayList<String>(setResult);
        Collections.sort(result); //对结果集排序
        return result;

    }
    public void Permutation(char[] str,int begin,HashSet<String> setResult){
        int end = str.length-1;
        if(begin == end) {
            setResult.add(new String(str)); //递归的最后面存入此时的数组状态
        } else{
            for(int i=begin; i<=end; i++) {
                char tmp = str[i];      //依次将字母替换到最前面
                str[i] = str[begin];
                str[begin] = tmp;
                Permutation(str,begin + 1,setResult); //递归后面的组合

                tmp = str[begin]; //将首字母替换回去，保持原来的状态
                str[begin] = str[i];
                str[i] = tmp;
            }
        }

    }

    public static void main(String[] args) {
        TwentyEightPermutation permutation = new TwentyEightPermutation();
        ArrayList<String> result = permutation.Permutation("abbc");
        for(String s : result) {
            System.out.println(s);
        }

    }
}
