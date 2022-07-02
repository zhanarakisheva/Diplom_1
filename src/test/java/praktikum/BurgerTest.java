package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    Bun bunMock;
    @Mock
    Ingredient ingredientMock1;
    @Mock
    Ingredient ingredientMock2;
    @Mock
    Ingredient ingredientMock3;

    @Test
    public void setBunsTest() {
        Burger burger = new Burger();
        burger.setBuns(bunMock);
        assertSame(bunMock,burger.bun);
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
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);
        burger.addIngredient(ingredientMock3);
        burger.addIngredient(null);
        burger.addIngredient(ingredientMock3);
        assertEquals(Arrays.asList(ingredientMock1, ingredientMock2, ingredientMock3, null, ingredientMock3), burger.ingredients);
    }
    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);
        burger.addIngredient(ingredientMock3);
        burger.addIngredient(null);
        burger.addIngredient(ingredientMock3);
        burger.removeIngredient(4);
        assertEquals(Arrays.asList(ingredientMock1, ingredientMock2, ingredientMock3, null), burger.ingredients);
    }
    @Test
    public void removeIngredientOutOfBoundTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);
        burger.addIngredient(ingredientMock3);
        burger.addIngredient(null);
        burger.addIngredient(ingredientMock3);
        try {
            burger.removeIngredient(15);
            fail();
        } catch (IndexOutOfBoundsException ignored) {
        }
    }
    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);
        burger.addIngredient(ingredientMock3);
        burger.addIngredient(null);
        burger.addIngredient(ingredientMock3);
        burger.moveIngredient(4, 0);
        assertEquals(Arrays.asList(ingredientMock3,ingredientMock1, ingredientMock2, ingredientMock3, null), burger.ingredients);
    }
    @Test
    public void moveIngredientOutOfBoundTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);
        burger.addIngredient(ingredientMock3);
        burger.addIngredient(null);
        burger.addIngredient(ingredientMock3);
        try {
            burger.moveIngredient(15, 0);
            fail();
        } catch (IndexOutOfBoundsException ignored) {
        }
    }
    @Test
    public void getPriceTest(){
        Burger burger = new Burger();

        when(bunMock.getPrice()).thenReturn(20.0f);
        when(ingredientMock1.getPrice()).thenReturn(12.0f);
        when(ingredientMock2.getPrice()).thenReturn(13.0f);
        when(ingredientMock3.getPrice()).thenReturn(15.0f);

        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);
        burger.addIngredient(ingredientMock3);
        burger.setBuns(bunMock);

        assertEquals(80.0f, burger.getPrice(), 0.001f);
    }
    @Test
    public void getPriceOnlyBunsTest(){
        Burger burger = new Burger();

        when(bunMock.getPrice()).thenReturn(20.0f);

        burger.setBuns(bunMock);

        assertEquals(40.0f, burger.getPrice(), 0.001f);
    }
}
