package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChocolateTest {
    @Test
    void testChocolate(){
        Chocolate chocolate = new Chocolate("cookie",10,20);
        assertEquals(chocolate.getWeight(), 10);
        assertEquals(chocolate.getSugar(), 20);
        chocolate.setSugar(15);
        assertEquals(chocolate.getSugar(),15);
        chocolate.setWeight(20);
        assertEquals(chocolate.getWeight(), 20);
    }
}