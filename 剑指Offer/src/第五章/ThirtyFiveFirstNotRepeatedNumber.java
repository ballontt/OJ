package 第五章;

import java.util.HashMap;

/**
 * Created by ballontt on 2017/4/3.
 */
public class ThirtyFiveFirstNotRepeatedNumber {
    public int FirstNotRepeatingChar(String str) {
        if(str == null || str.length()==0)
            return -1;
        HashMap<Character,Integer> hashMap = new HashMap<Character,Integer>();
        char[] array = str.toCharArray();
        for(int i=0; i<array.length; i++) {
            if(hashMap.containsKey(array[i])){
                int value = hashMap.get(array[i]);
                hashMap.put(array[i],++value);
            }else{
                hashMap.put(array[i],1);
            }
        }
        int result = 0;
        for(int i=0; i<array.length;i++){
            if(hashMap.get(array[i]) == 1) {
                result = array[i];
                break;
            }
        }
        return result;
    }

}
