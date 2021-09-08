import Something.ChoiceException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Fighter man1 = new Fighter("Chucky", 8, 45, 0.2); // hp 25
        Fighter man2 = new Fighter("Bob", 12, 50, 0.1); // hp 30

        List<Person> fighters = new ArrayList<>();
        fighters.add(man1);
        fighters.add(man2);

        for (int i = 0; i < fighters.size(); i++) { // выводим описание бойцов на экран
            System.out.println(fighters.get(i));
        }

        man1.equals(man2); // сравниваем бойцов

        System.out.println("Выберите бойца:");
        System.out.println("1: " + man1.getName());
        System.out.println("2: " + man2.getName());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int chooseFighter = 0;
        while (true) {
            try {
                chooseFighter = Integer.parseInt(reader.readLine());
                if (chooseFighter != 1 && chooseFighter != 2) {
                    throw new ChoiceException();
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("Вы ввели не число");
            } catch (ChoiceException e) {
                System.out.println("Вы ввели недопустимое число");
            }
            if (chooseFighter == 1 || chooseFighter == 2) {
                break;
            }
        } // выбираем бойца

        System.out.println();
        System.out.println("Выберите режим битвы");
        System.out.println("1: Автоматический");
        System.out.println("2: Ручной");
        int chooseMode = 0;
        while (true) {
            try {
                chooseMode = Integer.parseInt(reader.readLine());
                if (chooseMode != 1 && chooseMode != 2) {
                    throw new ChoiceException();
                }
            } catch (NumberFormatException | IOException e) {
                System.out.println("Вы ввели не число");
            } catch (ChoiceException e) {
                System.out.println("Вы ввели недопустимое число");
            }
            if (chooseMode == 1 || chooseMode == 2) {
                break;
            }
        }  // выбираем режим битвы
        // если выбрали 1, то срабатывает автоматический режим битвы
        if (chooseMode == 1) {
            if (chooseFighter == 1) {
                System.out.println("Начинается бой!");
                man1.autoBattle(man2);
            } else {
                System.out.println("Начинается бой!");
                man2.autoBattle(man1);
            }
        } else {  // ручной режим битвы
            if (chooseFighter == 1) { // ручной режим за 1 игрока
                man1.battle(man2);
            } else { // ручной режим за 2 игрока
                man2.battle(man1);
            }
        }
    }
}

