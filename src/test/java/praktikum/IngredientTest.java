package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {
    @Test
    public void getPricePositiveTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "сальса", 45.1f);
        assertEquals(45.1f, ingredient.getPrice(), 0.001);
    }
    @Test
    public void getPriceZeroTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "сальса", 0.0f);
        assertEquals(0.0f, ingredient.getPrice(), 0.001);
    }
    @Test
    public void getPriceNegativeTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "сальса", -45.1f);
        assertEquals(-45.1f, ingredient.getPrice(), 0.001);
    }
    @Test
    public void getNameTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "сальса", -45.1f);
        assertEquals("сальса", ingredient.getName());
    }
    @Test
    public void getNameNullTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, null, -45.1f);
        assertNull(ingredient.getName());
    }
    @Test
    public void getNameEmptyTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "", -45.1f);
        assertEquals("", ingredient.getName());
    }
    @Test
    public void getTypeSauceTest() {
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "", -45.1f);
        assertEquals(IngredientType.SAUCE, ingredient.getType());
    }
    @Test
    public void getTypeFillingTest() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "", -45.1f);
        assertEquals(IngredientType.FILLING, ingredient.getType());
    }
    @Test
    public void getTypeTest() {
        Ingredient ingredient = new Ingredient(null, "", -45.1f);
        assertNull(ingredient.getType());
    }
}
