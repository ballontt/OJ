package 分治;

import java.util.ArrayList;

/**
 * Created by ballontt on 2017/8/29.
 * Question:
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * For example:
 * Given"25525511135",
 * return["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 */
public class RestoreIpAddr {
    public ArrayList<String> restoreIpAddresses(String s) {
        ArrayList<String> result = new ArrayList<String>();
        getIps(s, "", 0, result, 0);
        return result;
    }

    public void getIps(String s, String r, int part, ArrayList<String> list, int idx) {

        if(part == 4 && idx == s.length()) {
            list.add(r);
            return;
        }
        for(int i = 1; i < 4; i++) {
            if(idx + i > s.length()) {
                break;
            }
            String sPart = s.substring(idx, idx + i);
            if((sPart.startsWith("0")&& sPart.length() > 1) ||(i==3 && Integer.valueOf(sPart) > 255)) continue;
            getIps(s, r + sPart + (part==3 ? "" : "."), part+1, list, idx+i);
        }
    }
}
