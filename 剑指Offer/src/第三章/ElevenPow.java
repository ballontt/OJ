package 第三章;

/**
 * Created by ballontt on 2017/3/24.
 */
public class ElevenPow {
    public boolean invalidInput = false;
    public double Power(double base, int exponent) {
        invalidInput = false;
        if(equal(base,0) && exponent<=0) {
            invalidInput = true;
            return 0;
        }

        double result = 1.0;
        for(int i=0; i<Math.abs(exponent); i++){
            result *= base;
        }
        if(exponent < 0 )
            return 1.0/result;
        return result;
    }
    public boolean equal(double a,double b) {
        if((a-b) > 0 &&(a-b)<0.0000001)
            return true;
        else if((a-b)<0 &&(a-b)>-0.0000001)
            return true;
        return  false;
    }
    public static void main(String[] args) {
        System.out.println(Math.pow(0,-2));
    }
}
