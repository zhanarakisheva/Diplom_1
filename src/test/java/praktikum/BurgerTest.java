package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Bun bun;
    private Ingredient ingredient1;
    private Ingredient ingredient2;
    private Ingredient ingredient3;

    @Before
    public void setUp() throws Exception {
        Database database = new Database();
        bun = database.availableBuns().get(0);
        ingredient1 = database.availableIngredients().get(0);
        ingredient2 = database.availableIngredients().get(3);
        ingredient3 = database.availableIngredients().get(4);
    }

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        assertSame(bun,burger.bun);
    }
    @Test
    public void setBunsNullTest() {
        Burger burger = new Burger();
        burger.setBuns(null);
        assertNull(burger.bun);
    }
    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.addIngredient(ingredient3);
        assertEquals(Arrays.asList(ingredient1, ingredient2, ingredient3, ingredient3), burger.ingredients);
    }
    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.addIngredient(ingredient3);
        burger.removeIngredient(3);

        assertEquals(Arrays.asList(ingredient1, ingredient2, ingredient3), burger.ingredients);
    }
    @Test
    public void removeIngredientOutOfBoundTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.addIngredient(ingredient3);
        try {
            burger.removeIngredient(15);
            fail();
        } catch (IndexOutOfBoundsException ignored) {
        }
    }
    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.addIngredient(ingredient3);
        burger.moveIngredient(3, 0);
        assertEquals(Arrays.asList(ingredient3, ingredient1, ingredient2, ingredient3), burger.ingredients);
    }
    @Test
    public void moveIngredientOutOfBoundTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.addIngredient(ingredient3);
        try {
            burger.moveIngredient(15, 0);
            fail();
        } catch (IndexOutOfBoundsException ignored) {
        }
    }
    @Test
    public void getPriceTest(){
        Burger burger = new Burger();

        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        burger.setBuns(bun);

        assertEquals(600.0f, burger.getPrice(), 0.001f);
    }
    @Test
    public void getPriceOnlyBunsTest(){
        Burger burger = new Burger();

        burger.setBuns(bun);

        assertEquals(200.0f, burger.getPrice(), 0.001f);
    }
}
