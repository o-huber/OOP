package model;

public class Item implements Comparable<Item> {
    private int weight;
    private int sugar;
    private String name;

    public Item(String name, int weight, int sugar) {
        this.weight = weight;
        this.sugar = sugar;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    @Override
    public int compareTo(Item item) {
        return this.weight - item.weight;
    }
}
