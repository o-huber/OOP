package model;

public class Chocolate extends Item{

    public Chocolate(String name, int weight, int sugar) {
        super(name, weight, sugar);
    }

    @Override
    public String toString() {
        return "Chocolate{" +
                "name='" + getName() +
                ", weight=" + getWeight() +
                ", sugar=" + getSugar() +
                '\'' +
                '}';
    }

}
