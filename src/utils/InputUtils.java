package utils;

import java.util.Locale;
import java.util.Scanner;
public class InputUtils{
private Scanner scanner;
private EnumUtils enumUtils = new EnumUtils();
public InputUtils(Scanner scanner){
    this.scanner = scanner;
}

public <T extends Enum<T>>String inputWithValidation(String userMessage, Class<T> enumClass, String errorMessage){
    while (true){
        System.out.printf(userMessage);
        String userInput = scanner.next().toUpperCase(Locale.ROOT);
        if (!enumUtils.checkValueInEnum(enumClass, userInput)){
            System.out.println(errorMessage);
            continue;
        }
        return userInput;
    }
}


}
