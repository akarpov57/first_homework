package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberUtils {

    public boolean isNumber (String number) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(number.trim());
        return matcher.find();
    }
}
