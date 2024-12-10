import animals.AbsAnimal;
import data.AnimalTypesData;
import data.CommandsData;
import factory.FactoryAnimal;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<AbsAnimal> animals = new ArrayList<>();

        CommandsData[] commandsData = CommandsData.values();

        List<String> commandsNames = new ArrayList<>();
        for (CommandsData commandType: commandsData) {
            commandsNames.add(commandType.name().toLowerCase());
        }
        while (true){
            System.out.printf("Введите одну из команд %s:\n", String.join("/", commandsNames));
            String commandStringUser = scanner.next();

            boolean isCommandExist = false;
            for (CommandsData command: commandsData) {
                if(command.name().equals(commandStringUser.trim().toUpperCase())) {
                    isCommandExist = true;
                    break;
                }
            }
        if (!isCommandExist) {
            System.out.println("Вы ввели неверную команду. Повторите ввод");
            continue;
        }
        switch (CommandsData.valueOf(commandStringUser)) {
            case ADD: {

        }
            case LIST: {
                animals.forEach(animal -> System.out.println(animal.toString()));
                break;
            }
            case EXIT: {
                System.out.println("Вы вышли из программы");
                System.exit(0);
            }
        }
    }
}
