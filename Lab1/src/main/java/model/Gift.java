package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gift {
    private List<Item> items;
    private String name;
    public Gift(String name) {
        items = new ArrayList<>();
        this.name = name;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void sortItemsByWeight() {
        Collections.sort(items);
    }

    public List<Item> getItemsBySugar(int lowerBound, int upperBound) {
        List<Item> itemsInRange = new ArrayList<>();
        for (Item item: items) {
            if (item.getSugar() < upperBound && item.getSugar() > lowerBound) {
                itemsInRange.add(item);
            }
        }
        return itemsInRange;
    }

    public void printItems() {
        System.out.println(items);
    }

    public List<Item> getAllItems() {
        return new ArrayList<>(items);
    }

    public int getTotalWeight() {
        int total = 0;
        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getWeight();
        }
        return total;
    }
    public int getTotalSugar() {
        int total = 0;
        for (int i = 0; i < items.size(); i++) {
            total += items.get(i).getSugar();
        }
        return total;
    }
}
