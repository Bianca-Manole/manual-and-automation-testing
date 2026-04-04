import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class StringUtilsTests {

    private StringUtils stringUtils;

    @BeforeEach
    void setup () {
        stringUtils = new StringUtils();
    }

    // --- Reverse Tests ---

    @Test
    void checkReverseOfJava() {
        String word = "java";
        Assertions.assertEquals("avaj", stringUtils.reverse(word));
    }

    @Test
    void checkReverseOfEmpty() {
        Assertions.assertEquals("", stringUtils.reverse(""));
    }

    @Test
    void checkReversOfNull() {
        Assertions.assertThrows(
                NullPointerException.class,
                () -> stringUtils.reverse(null)
        );
    }

    // --- Palindrom Tests ---

    @Test
    void checkWordAbaIsPalindrom() {
        String word = "aba";
        Assertions.assertTrue(stringUtils.isPalindrom(word));
    }

    @Test
    void checkWordJavaIsPalindrom() {
        String word = "java";
        Assertions.assertFalse(stringUtils.isPalindrom(word));
    }

    @Test
    void checkIsPalindromNull() {
        Assertions.assertThrows(
                NullPointerException.class,
                () -> stringUtils.isPalindrom(null)
        );
    }

    // --- CountVowels Tests ---

    @Test
    void checkHelloReturnsTwoVowels() {
        String word = "hello";
        Assertions.assertEquals(2, stringUtils.countVowels(word));
    }

    @Test
    void checkEmptyWordReturnsZeroVowels() {
        String word = "";
        Assertions.assertEquals(0, stringUtils.countVowels(word));
    }

    @Test
    void checkCountVowelsThrowException() {
        Assertions.assertThrows(
                NullPointerException.class,
                () -> stringUtils.countVowels(null)
        );
    }

}
