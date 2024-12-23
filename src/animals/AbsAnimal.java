package animals;

import data.ColorData;

// java.lang.classfile.attribute.LineNumberTableAttribute;

public abstract class AbsAnimal {
    private String name = "";
    private int age = -1;
    private int weight = -1;
    private ColorData color = null;

    public AbsAnimal(String name, int age, int weight, ColorData color){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.color = color;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        if (age>20){
            return -1;
        }
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

    public ColorData getColor() {
        return color;
    }

    public void setColor(ColorData color) {
        this.color = color;
    }

    public void say(){
        System.out.println("Я говорю");
    }

    public void go(){
        System.out.println("Я иду");
    }

    public void drink(){
        System.out.println("Я пью");
    }

    public void eat(){
        System.out.println("Я ем");
    }

@Override
    public String toString(){
        return String.format("Привет! Меня зовут %s, мне %d %s, я вешу - %d кг, мой цвет - %s", name, age,
                this.getAgeCase(), weight, color.getName());
}
    private String getAgeCase(){
        int ostatok = age % 10;

        if (ostatok==1){
            return "год";
        }

        if (ostatok==0 || ostatok >= 5 || age>=11){
            return "лет";
        }
        return "года";
        }


    }


