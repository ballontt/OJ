import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(sc.hasNext()) {
            list.add(sc.nextInt());
        }
        int k = list.get(list.size()-1);
        list.remove(list.size() - 1);
        Collections.sort(list);
        System.out.println(list.get(list.size() - k));
    }


}
