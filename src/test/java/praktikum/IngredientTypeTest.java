package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {
    @Test
    public void orderSauceTest() {
        assertEquals(0,IngredientType.SAUCE.ordinal());
    }
    @Test
    public void orderFillingTest() {
        assertEquals(1,IngredientType.FILLING.ordinal());
    }
}
