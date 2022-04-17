import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final int NEGATIVE_EXCEPTION_ERROR = -1;
    private static final int EMPTY_STRING = 0;

    public int add(String str){
        if (str.isEmpty()) return EMPTY_STRING;
        String[] numbers = defaultSeparator(str);
        Matcher customSeparators = getCustomSeparators(str);
        if (customSeparators.find()){
            String splitBy = customSeparators.group("separator");
            Matcher multipleSeparators = getMultipleSeparators(str);
            if (multipleSeparators.find()){
                splitBy = implode(multipleSeparators, "|");
            }
            splitBy = scapeSpecialCharacters(splitBy);
            numbers = customSeparators.group("numbers").split(splitBy);
        }
        return sum(numbers);
    }


    private int sum(String[] numbers) {
        int result = 0;
        for (int index = 0; index < numbers.length; index++){
            int num = convertToInteger(numbers[index]);
            if (isNegativeNumber(num)){
                result = NEGATIVE_EXCEPTION_ERROR;
            }else if (!isNumberBiggerThan1000(num)){
                result += num;
            }
        }
        return result;
    }

    private String[] defaultSeparator(String str) {
        return str.split("[,\n;*+]");
    }

    private Matcher getMultipleSeparators(String str) {
        String multipleSeparatorsPattern = "//\\[(?<delim1>.*)\\]\\[(?<delim2>.*)\\]\n";
        Pattern msp = Pattern.compile(multipleSeparatorsPattern);
        Matcher multipleSeparators = msp.matcher(str);
        return multipleSeparators;
    }

    private Matcher getCustomSeparators(String str) {
        String customSeparatorsPattern = "//(?<separator>.*)\n(?<numbers>.*)";
        Pattern csp = Pattern.compile(customSeparatorsPattern);
        return csp.matcher(str);
    }

    private int convertToInteger(String number) {
        return Integer.parseInt(number);
    }

    private String implode(Matcher multipleSeparators, String by) {
        return multipleSeparators.group("delim1")+ by + multipleSeparators.group("delim2");
    }

    private boolean isNumberBiggerThan1000(int num) {
        return num > 1000;
    }

    private boolean isNegativeNumber(int num) {
        return num < 0;
    }

    private String scapeSpecialCharacters(String splitBy) {
        splitBy = splitBy.replaceAll("\\[|\\]","");
        splitBy = splitBy.replaceAll("[*]","[*]");
        splitBy = splitBy.replaceAll("[+]","[+]");
        return splitBy;
    }
}
