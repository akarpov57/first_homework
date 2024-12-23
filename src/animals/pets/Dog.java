package animals.pets;

import animals.AbsAnimal;
import data.ColorData;

public class Dog extends AbsAnimal {
    public Dog(String name, int age, int weight, ColorData color){
        super(name, age, weight, color);
    }
}
