import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    @Test
    void should_return_0_when_given_empty_string() {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("");

        Assertions.assertEquals(0,result);
    }

    @Test
    void should_return_1_when_given_one() {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("1");

        Assertions.assertEquals(1,result);
    }

    @Test
    void should_return_2_when_given_two() {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("2");

        Assertions.assertEquals(2,result);
    }
    @Test
    void should_return_3_when_given_three() {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("3");

        Assertions.assertEquals(3,result);
    }

    @Test
    void should_return_4_when_given_four() {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("4");

        Assertions.assertEquals(4,result);
    }

    @Test
    void should_return_0_when_given_zero_and_zero() {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("0,0");

        Assertions.assertEquals(0,result);
    }

    @Test
    void should_return_1_when_given_one_and_zero() {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("1,0");

        Assertions.assertEquals(1,result);
    }

    @Test
    void should_return_3_when_given_one_and_two() {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("1,2");

        Assertions.assertEquals(3,result);
    }

    @Test
    void should_return_10_when_given_unknown_amount_number() {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("1,1,1");

        Assertions.assertEquals(3,result);
    }

    @Test
    void should_return_12_when_given_unknown_amount_number() {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("3,3,3,3");

        Assertions.assertEquals(12,result);
    }

    @Test
    void should_return_15_when_given_unknown_amount_number() {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("3,3,3,3,3");

        Assertions.assertEquals(15,result);
    }

    @Test
    void should_return_45_when_given_unknown_amount_number() {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("1,2,3,4,5,6,7,8,9");

        Assertions.assertEquals(45,result);
    }

    @Test
    void should_return_6_and_recognise_coma_and_backslash_is_separator() {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("1\n2,3");

        Assertions.assertEquals(6,result);
    }

    @Test
    void should_return_12_and_recognise_coma_and_backslash_is_separator() {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("1,3,3\n5");

        Assertions.assertEquals(12,result);
    }

    @Test
    void should_return_18_and_recognise_coma_and_backslash_is_separator() {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("1,3,3\n5\n2,4");

        Assertions.assertEquals(18,result);
    }

    @Test
    void should_return_3_and_support_custom_separators() {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("//;\n1;2");

        Assertions.assertEquals(3,result);
    }

    @Test
    void should_return_5_and_support_custom_separators() {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("//!\n1!2!2");

        Assertions.assertEquals(5,result);
    }

    @Test
    void should_return_8_and_support_custom_separators() {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("//&\n1&2&2&3");

        Assertions.assertEquals(8,result);
    }

    @Test
    void should_return_negative_1_when_given_negative_numbers() {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("1,-2,-3");
        Assertions.assertEquals(-1,result);

    }

    @Test
    void should_return_2_and_ignore_numbers_bigger_than_1000() {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("10001,2");
        Assertions.assertEquals(2,result);

    }

    @Test
    void should_return_6_and_separators_can_be_of_any_length() {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("//[***]\n1***2***3");
        Assertions.assertEquals(6,result);
    }

    @Test
    void should_return_8_and_separators_can_be_of_any_length() {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("//[%%%]\n1%%%2%%%5");
        Assertions.assertEquals(8,result);
    }

    @Test
    void should_return_12_and_separators_can_be_of_any_length() {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("//[@@@]\n1@@@2@@@3@@@6");
        Assertions.assertEquals(12,result);
    }

    @Test
    void should_return_15_and_separators_can_be_of_any_length() {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("//[+++]\n1+++2+++3+++6+++3");
        Assertions.assertEquals(15,result);
    }

    @Test
    void should_return_6_and_allow_multiple_separators() {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("//[*][%]\n1*2%3");
        Assertions.assertEquals(6,result);
    }

    @Test
    void should_return_9_and_allow_multiple_separators() {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("//[&][!]\n4&2!3");
        Assertions.assertEquals(9,result);
    }

    @Test
    void should_return_10_and_allow_multiple_separators() {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("//[@][+]\n4@2+3");
        Assertions.assertEquals(9,result);
    }

    @Test
    void should_return_6_and_handle_multiple_separators_with_any_character_length() {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("//[foo][bar]\n1foo2bar3");
        Assertions.assertEquals(6,result);
    }

    @Test
    void should_return_46_and_handle_multiple_separators_with_any_character_length() {
        StringCalculator calculator = new StringCalculator();

        int result = calculator.add("//[jadid][new]\n1jadid20new25");
        Assertions.assertEquals(46,result);
    }



}
