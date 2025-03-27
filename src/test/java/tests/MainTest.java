package tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;



public class MainTest {
    public static void main(String[] args) {
        System.out.println("Hello, Test!");
    }

    @Test
    public void testTrue() {
        assertTrue(true);
    }
}