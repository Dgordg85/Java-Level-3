package Lesson_01;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> box;

    public Box() {
        box = new ArrayList<>();
    }

    public Float getBoxWeight(){
        return box.size() * box.get(0).getFruitWeight();
    }

    public void putFruit(T fruit){
        box.add(fruit);
    }

    public Boolean compare(Box box){
        return Math.abs(this.getBoxWeight() - box.getBoxWeight()) < 0.0001;
    }

    public void intersperse(Box<T> box){
        box.getBox().addAll(this.box);
        this.box.clear();
    }

    public List<T> getBox() {
        return box;
    }

    public int countInfo(){
        return box.size();
    }
}
