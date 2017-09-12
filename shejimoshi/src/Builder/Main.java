package Builder;

/**
 * Created by ballontt on 2017/9/8.
 */
public class Main {
    public static void main(String[] args) {
        PersonBuilder person = new PersonBuilder.Builder().address("aa").age(10)
                .sex("男").build();
        System.out.println(person.toString());
    }
}
