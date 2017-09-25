package Observer.Observer;


import java.util.Observable;
import java.util.Observer;

/**
 * Created by ballontt on 2017/4/13.
 */
public class ObserverDemo {
    public static void main(String[] args) {
        WeatherObservable weather = new WeatherObservable();
        Person person1 = new Person("女盆友",weather);
        Person person2 = new Person("父母",weather);
        Person person3 = new Person("老师",weather);
        weather.setWeather("晴天");
        System.out.println(person1.getWeather());
        System.out.println(person2.getWeather());
        System.out.println(person3.getWeather());
        weather.setWeather("雨天");
        System.out.println(person1.getWeather());
        System.out.println(person2.getWeather());
        System.out.println(person3.getWeather());

    }
}
class WeatherObservable extends Observable{
    private String weather;
    public void setWeather(String weather) {
        if(!weather.equals(this.weather)) {
            this.weather = weather;
            setChanged();
        }
        notifyObservers();
    }
    public String getWeather() {
        return this.weather;
    }
}
class Person implements Observer {

    private String weather;
    private String name;

    public Person(String name,Observable obs) {

        obs.addObserver(this);
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.weather = ((WeatherObservable)o).getWeather();
    }

    public String getWeather() {
        return weather;
    }
}
