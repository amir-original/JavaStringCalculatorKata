import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final int NEGATIVE_EXCEPTION_ERROR = -1;

    public int add(String str){
            if (str.isEmpty()){
                return 0;
            }
        String[] numbers = str.split("[,\n;]");
        String customSeparatorsPattern = "//(?<separator>.*)\n(?<numbers>.*)";
        Pattern csp = Pattern.compile(customSeparatorsPattern);
        Matcher customSeparators = csp.matcher(str);

        if (customSeparators.find()){
            String splitBy = customSeparators.group("separator");
            String multipleSeparatorsPattern = "//\\[(?<delim1>.*)\\]\\[(?<delim2>.*)\\]\n";
            Pattern msp = Pattern.compile(multipleSeparatorsPattern);
            Matcher multipleSeparators = msp.matcher(str);
            if (multipleSeparators.find()){
                splitBy = impldeMultipleSeparator(multipleSeparators, "|");
            }
            splitBy = scapeSpcialCharacters(splitBy);
            numbers = customSeparators.group("numbers").split(splitBy);
        }

        int result = 0;
         for (int index = 0; index < numbers.length;index++){
             int num =Integer.parseInt(numbers[index]);
             if (isNegativeNumber(num)){
                 result = NEGATIVE_EXCEPTION_ERROR;
             }else if (!isNumberBiggerThan1000(num)){
                 result += num;
             }

         }
         return result;
    }

    private String impldeMultipleSeparator(Matcher multipleSeparators, String by) {
        return multipleSeparators.group("delim1")+ by + multipleSeparators.group("delim2");
    }

    private boolean isNumberBiggerThan1000(int num) {
        return num > 1000;
    }

    private boolean isNegativeNumber(int num) {
        return num < 0;
    }

    private String scapeSpcialCharacters(String splitBy) {
        splitBy = splitBy.replaceAll("\\[|\\]","");
        splitBy = splitBy.replaceAll("[*]","[*]");
        splitBy = splitBy.replaceAll("[+]","[+]");
        return splitBy;
    }
}
