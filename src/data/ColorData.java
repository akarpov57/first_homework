package data;

public enum ColorData {
    RED("красный"), BLACK ("черный"), WHITE("белый"), BROWN("коричневый"), GINGER("рыжий");

    private String name;
    ColorData(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

}
