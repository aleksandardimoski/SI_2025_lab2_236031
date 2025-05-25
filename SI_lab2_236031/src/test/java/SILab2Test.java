import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    @Test
    void testEveryStatement() {

        // Тест случај 1
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(null, "1234567890123456");
        });
        assertTrue(ex.getMessage().contains("allItems list can't be null!"));


        // Тест случај 2
        List<Item> items1 = new ArrayList<>();
        items1.add(new Item("", 5, 10, 15));

        ex = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(items1, "1234567890123456");
        });
        assertTrue(ex.getMessage().contains("Invalid item!"));

        // Тест случај 3
        List<Item> items2 = new ArrayList<>();
        items2.add(new Item("water", 50, 2, 0.1)); // Јасно валиден item

        ex = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(items2, null); // cardNumber = null
        });

        assertEquals("Invalid card number!", ex.getMessage());


        // Тест случај 4
        List<Item> items3 = new ArrayList<>();
        items3.add(new Item("tea", 5, 10, 0.15));

        ex = assertThrows(RuntimeException.class, () -> {
            SILab2.checkCart(items3, "5296t59632458963");
        });
        assertTrue(ex.getMessage().contains("Invalid character in card number!"));

        // Тест случај 5
        List<Item> items4 = new ArrayList<>();
        items4.add(new Item("tea",2 , 30, 25.0)); // 10 * 5 * (1 - 0.15) = 42.5

        double result = 30 * (1 - 25.0) * 2 - 30;
        assertEquals( result, SILab2.checkCart(items4,"5296859632458963")); // дозволена толеранција од ±0.01
    }



    @Test
    void testMultipleConditionsPenalty() {
        List<Item> items;

        // F F T
        items = new ArrayList<>();
        items.add(new Item("tea", 11, 300, 0.0));  // quantity=11 > 10, price=300, discount=0
        double expected = 11 * 300 * (1 - 0.0) - 30; // 11*300=3300 - 30 = 3270
        assertEquals(expected, SILab2.checkCart(items, "1234567890123456"));

        // T F F
        items = new ArrayList<>();
        items.add(new Item("tea", 9, 310, 0.0));  // quantity=9 <= 10, price=310 > 300, discount=0
        expected = 9 * 310 * (1 - 0.0) - 30; // 2790 - 30 = 2760
        assertEquals(expected, SILab2.checkCart(items, "1234567890123456"));

        // F T F
        items = new ArrayList<>();
        items.add(new Item("tea", 9, 200, 0.20));  // quantity=9, price=200, discount=20%
        expected = 9 * 200 * (1 - 0.20) - 30; // 9*200*0.8=1440 - 30 = 1410
        assertEquals(expected, SILab2.checkCart(items, "1234567890123456"));

        // F F F
        items = new ArrayList<>();
        items.add(new Item("tea", 9, 200, 0.0));  // quantity=9, price=200, discount=0
        expected = 9 * 200 * (1 - 0.0); // 1800, no penalty
        assertEquals(expected, SILab2.checkCart(items, "1234567890123456"));
    }

}