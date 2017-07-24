package 贪心;

/**
 * Created by ballontt on 2017/7/24.
 *
 * Question:
 * There are N gas stations along a circular route, where the amount of gas at station i isgas[i].
 * You have a car with an unlimited gas tank and it costscost[i]of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * Note:
 * The solution is guaranteed to be unique.
 *
 * Answer:
 *
 */
public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int[] sub = new int[gas.length];
        for(int i = 0; i < gas.length; i++) {
            sub[i] = gas[i] - cost[i];
        }
        for(int i = 0; i < sub.length; i++) {
            int res = 0;
            int tmp = i;
            do{
                res += sub[tmp % sub.length];
                if(res < 0) {
                    break;
                }
                tmp++;
            }while(tmp % sub.length != i);
            if(res >= 0){
                return i;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1,2};
        int[] b = {2,1};
        int c = canCompleteCircuit(a, b);
        System.out.println(c);


    }
}

