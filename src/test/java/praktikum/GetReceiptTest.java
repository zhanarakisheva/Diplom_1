package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class GetReceiptTest {

    private final Bun bun;
    private final List<Ingredient> ingredients;
    private final String expected;

    public GetReceiptTest(Bun bun, List<Ingredient> ingredients, String expected) {
        this.bun = bun;
        this.ingredients = ingredients;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[] getParameters() {
        return new Object[][]{
                { new Bun("Крабсбургер", 20.0f), List.of(
                        new Ingredient(IngredientType.SAUCE, "горчица", 12.0f),
                        new Ingredient(IngredientType.FILLING, "помидор", 13.0f),
                        new Ingredient(IngredientType.FILLING, "огурчик", 15.0f)
                ), "(==== Крабсбургер ====)\n= sauce горчица =\n= filling помидор =\n= filling огурчик =\n(==== Крабсбургер ====)\n\nPrice: 80.000000\n"
                },
                {new Bun("Крабсбургер", 20.0f), List.of(),"(==== Крабсбургер ====)\n(==== Крабсбургер ====)\n\nPrice: 40.000000\n"}
        };
    }
    @Test
    public void getReceiptTest() {
        Burger burger = new Burger();

        burger.setBuns(bun);
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }

        assertEquals(expected, burger.getReceipt());
    }
}
