package link;

/**
 * Created by ballontt on 2017/6/21.
 */
public class test {
    public static void main(String[] args) {
        Stu stu =  new Stu(1, "kollen");
        Object o = stu;
        ((Stu)o).name = "ballontt";
        System.out.println(stu);
    }
}
class Stu{
    public int id;
    public String name;

    public Stu(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Stu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
