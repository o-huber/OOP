package model;

public class Cookie extends Item{

    public Cookie(String name, int weight, int sugar) {
        super(name, weight, sugar);
    }

    @Override
    public String toString() {
        return "Cookie{" +
                "name='" + getName() +
                ", weight=" + getWeight() +
                ", sugar=" + getSugar() +
                '\'' +
                '}';
    }

}
