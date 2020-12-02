package model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class GiftTest {
    @Test
    void testGift() {
        Gift gift1 = new Gift("g1");
        Item i1 = new Item("i1", 10, 20);
        Item i2 = new Item("i2", 45, 37);
        Item i3 = new Item("i3", 9, 2);
        Item i4 = new Item("i4", 17, 3);

        gift1.addItem(i1);
        gift1.addItem(i2);
        gift1.addItem(i3);
        gift1.addItem(i4);
        gift1.sortItemsByWeight();

        Item arr[] = new Item[]{i3, i1, i4, i2};
        List<Item> expectedSortedItems = new ArrayList<>(Arrays.asList(arr));

        assertEquals(gift1.getAllItems(), expectedSortedItems);

        List<Item> expectedFoundItems = new ArrayList<>();
        expectedFoundItems.add(i1);
        expectedFoundItems.add(i2);
        assertEquals(gift1.getItemsBySugar(5, 40), expectedFoundItems);

        assertEquals(gift1.getTotalSugar(),62);

        assertEquals(gift1.getTotalWeight(), 81);
    }
}