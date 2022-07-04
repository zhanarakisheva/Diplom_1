package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {

    @Test
    public void getNameTest() {
        Bun bun = new Bun("ржаная булочка", 25);
        assertEquals("ржаная булочка", bun.getName());
    }
    @Test
    public void getNameNullTest() {
        Bun bun = new Bun(null, 25);
        assertNull(bun.getName());
    }
    @Test
    public void getNameEmptyTest() {
        Bun bun = new Bun("", 25);
        assertEquals("", bun.getName());
    }
    @Test
    public void getPricePositiveTest() {
        Bun bun = new Bun("ржаная булочка", 25.5f);
        assertEquals(25.5f, bun.getPrice(), 0.001);
    }
    @Test
    public void getPriceNegativeTest() {
        Bun bun = new Bun("ржаная булочка", -25.1f);
        assertEquals(-25.1f, bun.getPrice(), 0.001);
    }
    @Test
    public void getPriceZeroTest() {
        Bun bun = new Bun("ржаная булочка", 0.0f);
        assertEquals(0.0f, bun.getPrice(), 0.001);
    }
}
