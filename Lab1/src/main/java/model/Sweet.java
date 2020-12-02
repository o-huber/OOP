package model;

public class Sweet extends Item{

    public Sweet(String name, int weight, int sugar) {
        super(name, weight, sugar);
    }

    @Override
    public String toString() {
        return "Sweet{" +
                "name='" + getName() +
                ", weight=" + getWeight() +
                ", sugar=" + getSugar() +
                '\'' +
                '}';
    }

}
