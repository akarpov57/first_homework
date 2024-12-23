import animals.AbsAnimal;
import data.AnimalTypesData;
import data.ColorData;
import data.CommandsData;
import factory.FactoryAnimal;
import utils.InputUtils;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<AbsAnimal> animals = new ArrayList<>();

        CommandsData[] commandsData = CommandsData.values();

        InputUtils inputUtils = new InputUtils(scanner);

        List<String> commandsNames = new ArrayList<>();
        for (CommandsData commandType : commandsData) {
            commandsNames.add(commandType.name().toLowerCase());
        }
        while (true) {
            String commandStringUser = inputUtils.inputWithValidation(
                    String.format("������� ���� �� ������ %s:\n", String.join("/", commandsNames)),
                    CommandsData.class, "�� ����� �������� �������. ��������� ����:"
            );
 //           System.out.printf("������� ���� �� ������ %s:\n", String.join("/", commandsNames));
 //           String commandStringUser = scanner.next();

            boolean isCommandExist = false;
            for (CommandsData command : commandsData) {
                if (command.name().equals(commandStringUser.trim().toUpperCase())) {
                    isCommandExist = true;
                    break;
                }
            }
            if (!isCommandExist) {
                System.out.println("�� ����� �������� �������. ��������� ����");
                continue;
            }
            switch (CommandsData.valueOf(commandStringUser)) {
                case ADD: {

                    List<String> animalTypesNames = new ArrayList<>();
                    for (AnimalTypesData animalTypesData : AnimalTypesData.values()) {
                        animalTypesNames.add(animalTypesData.name().toLowerCase());
                    }

                    String animalTypesStringUser = inputUtils.inputWithValidation(
                            String.format("������� ���� �� ����� ��������� %s:\n", String.join("/", animalTypesNames)),
                            AnimalTypesData.class, "�� ����� �������� ��� ���������.");


                    System.out.println("������� ��� ���������:");
                    String name = scanner.next();

                    System.out.println("������� ������� ���������:");
                    int age = Integer.parseInt(scanner.next());

                    System.out.println("������� ��� ���������:");
                    int weight = Integer.parseInt(scanner.next());

                    List<String> colorDataNames = new ArrayList<>();
                    for (ColorData colorData : ColorData.values()) {
                        colorDataNames.add(colorData.name().toLowerCase());
                    }

                    String colorDataStr = inputUtils.inputWithValidation(
                            String.format("������� ���� �� ������ ��������� %s:\n", String.join("/", colorDataNames)),
                            ColorData.class, "�� ����� �������� ���� ���������.");
                    ;
                    //   while (true) {
                    //      System.out.printf("������� ���� ��������� %s: ", String.join("/", colorDataNames));
                    //      String colorDataStr = scanner.next();

                    //     if (enumUtils.checkValueEnum(ColorData.class, colorDataStr)) {
                    //         break;
                    //     }
                    //    System.out.printf("���� %s �� ��������������", colorDataStr);


                    // }
                    ColorData colorData = ColorData.valueOf(colorDataStr);
                    AbsAnimal animal = new FactoryAnimal(name, age, weight, colorData).create(AnimalTypesData.valueOf(animalTypesStringUser));

                    break;
                }
                case LIST: {
                    animals.forEach(animal -> System.out.println(animal.toString()));
                    break;
                }
                case EXIT: {
                    System.out.println("�� ����� �� ���������");
                    System.exit(0);
                }
            }
        }
    }
}