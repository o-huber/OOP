package model;

public class Wafer extends Item{

    public Wafer(String name, int weight, int sugar) {
        super(name, weight, sugar);
    }

    @Override
    public String toString() {
        return "Wafer{" +
                "name='" + getName() +
                ", weight=" + getWeight() +
                ", sugar=" + getSugar() +
                '\'' +
                '}';
    }

}
