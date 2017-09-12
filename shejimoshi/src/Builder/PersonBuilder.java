package Builder;

import java.util.Date;

/**
 * Created by ballontt on 2017/4/12.
 */
public class PersonBuilder {
    private String name;
    private int age;
    private String sex;
    private String address;
    private Date birthday;
    public PersonBuilder(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.sex = builder.sex;
        this.address = builder.address;
        this.birthday = builder.birthday;
    }

    @Override
    public String toString() {
        return "PersonBuilder{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", birthday=" + birthday +
                '}';
    }

    public static class Builder {
        private String name;
        private int age;
        private String sex;
        private String address;
        private Date birthday;

        public Builder name(String name) {
            this.name = name;
            return this;
        }
        public Builder age(int age) {
            this.age = age;
            return this;
        }
        public Builder sex(String sex) {
            this.sex = sex;
            return this;
        }
        public Builder address(String address) {
            this.address = address;
            return this;
        }
        public Builder birthday(Date date ) {
            this.birthday= date;
            return this;
        }

        public PersonBuilder build() {
            return new PersonBuilder(this);
        }

    }


}
