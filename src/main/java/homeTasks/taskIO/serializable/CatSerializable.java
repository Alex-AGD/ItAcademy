package homeTasks.taskIO.serializable;

import java.io.InputStream;
import java.io.Serializable;

public class CatSerializable implements Serializable {
    private transient String name;
    private int age;
    private int weight;

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                '}';
    }

    public CatSerializable(String name, int  age, int weight) {
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    public  String getName(String name) {
        return name;
    }

    public void  setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    transient public InputStream in = System.in; //не будет серелизоваться

}

