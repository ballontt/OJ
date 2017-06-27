package meituan.common;

import java.util.Random;

/**
 * Created by ballontt on 2017/6/26.
 */
public class Util {
    public static String getIp() {
        String minIpStr = "192.0.0.1";
        String maxIpStr = "192.255.255.255";
        int minIp = 1;
        int maxIp = 255 * 256 * 256 + 255 * 256 + 255;
        Random r = new Random();
        int randomIp = r.nextInt(maxIp - minIp) + minIp;
        String ip = "192." + String.valueOf(randomIp / 256 / 256) + "." + String.valueOf((randomIp % (256 *256)) / 256) + "." + String.valueOf(randomIp % 256);
        return ip;
    }
}
