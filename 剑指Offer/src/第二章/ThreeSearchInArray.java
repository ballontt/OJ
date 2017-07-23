package 第二章;

/**
 * Created by ballontt on 2017/3/21.
 */
public class ThreeSearchInArray {
    public boolean Find(int target,int[][] array) {
        int row = array.length;
        int col = 0;
        boolean found = false;
        if(row != 0) {
            col = array[0].length;
            int rowIndex = 0,colIndex = col - 1;
            while(rowIndex <=row-1 && colIndex >=0) {
                int compNum = array[rowIndex][colIndex];
                if(compNum == target) {
                    found = true;
                    break;
                } else if(compNum > target){
                    colIndex--;
                } else if(compNum < target){
                    rowIndex++;
                }
            }

        }
        return found;
    }

    public static void main(String[] args) {

    }
}
