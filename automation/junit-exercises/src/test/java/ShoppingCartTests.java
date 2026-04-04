import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShoppingCartTests {

    private ShoppingCart shoppingCart;

    @BeforeEach
    void setup() {
        shoppingCart = new ShoppingCart();
    }

    @Test
    void checkEmptyCartAmount(){
            Assertions.assertEquals(0, shoppingCart.getItemCount());
    }

    @Test
    void addThreeItemsToCart(){
        shoppingCart.items.add("geaca");
        shoppingCart.items.add("fes");
        shoppingCart.items.add("fular");
        Assertions.assertEquals(3, shoppingCart.getItemCount());
    }

    @Test
    void checkNullItemAddToCartThrowException() {
        Assertions.assertThrows(
                NullPointerException.class,
                () -> shoppingCart.addItem(null)
        );
    }


    @Test
    void removeExistingItemFromCart() {
        shoppingCart.addItem("geaca");
        shoppingCart.addItem("pantofi");
        shoppingCart.addItem("fusta");
        shoppingCart.removeItem("geaca");
        Assertions.assertEquals(2, shoppingCart.getItemCount());
    }

    @Test
    void removeNonExistingItemFromCartThrowException() {
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> shoppingCart.removeItem("fusta")
        );
    }

    @Test
    void removeNullItemFromCartThrowsException() {
        Assertions.assertThrows(
                NullPointerException.class,
                () -> shoppingCart.removeItem(null)
        );
    }


}
