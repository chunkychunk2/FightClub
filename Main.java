import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        Person man1 = new Person();
        Person man2 = new Person();

        man1.setName("Chucky"); // слабый и ловкий
        man2.setName("Bob"); // сильный и неуклюжий

        man1.setAge(12);
        man2.setAge(14);

        man1.setPower(8);
        man2.setPower(12);

        man1.setHP(25);
        man2.setHP(30);

        man1.setAgility(0.2);
        man2.setAgility(0.1);

        man1.areTheyEquals(man2); // сравниваем бойцов

        System.out.println("Выберите бойца:");
        System.out.println("1: Chucky");
        System.out.println("2: Bob");


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


        int chooseFighter;
        do {
            System.out.println("Введите 1 или 2");
            chooseFighter = Integer.parseInt(reader.readLine());
        } while (chooseFighter != 1 && chooseFighter != 2);


        System.out.println();
        System.out.println("Выберите режим битвы");
        System.out.println("1: Автоматический");
        System.out.println("2: Ручной");
        int chooseMode;
        do {
            System.out.println("Введите 1 или 2");
            chooseMode = Integer.parseInt(reader.readLine());
        } while (chooseMode != 1 && chooseMode != 2);

        if (chooseMode == 1) {
            if (chooseFighter == 1) {
                System.out.println("Начинается бой!");
                man1.kick(man2);
            } else {
                System.out.println("Начинается бой!");
                man2.kick(man1);
            }
        } else {
            if (chooseFighter == 1) { // ручной режим за 1 игрока
                int r = 1;
                double kick;
                int adDamage;
                while (man1.getHP() >= 0) {
                    System.out.println("Раунд: " + r);
                    System.out.println("Выберите удар:");
                    System.out.println("1: Джеб");
                    System.out.println("2: Апперкот");
                    System.out.println("3: Хук");
                    int chooseKick = Integer.parseInt(reader.readLine());
                    if (chooseKick == 1) {
                        kick = man1.getAgility() + Math.random();
                        adDamage = 0;
                    } else if (chooseKick == 2) {
                        kick = man1.getAgility() + Math.random() - 0.1;
                        adDamage = 1;
                    } else {
                        kick = man1.getAgility() + Math.random() - 0.2;
                        adDamage = 2;
                    }
                    if (kick > 0.5) {
                        System.out.println("Попал!");
                        System.out.println(man2.getName() + " получил " + (man1.getPower() + adDamage) + " урона");
                        man2.setHP(man2.getHP() - (man1.getPower() + adDamage));
                        if (man2.getHP() <= 0) break;
                        System.out.println("У " + man2.getName() + " осталось " + man2.getHP() + " хп");
                    } else System.out.println("Мимо!");


                    System.out.println("Теперь бьет " + man2.getName());
                    int chooseKick2 = (int) (Math.random() * 3);
                    if (chooseKick2 == 1) {
                        kick = man2.getAgility() + Math.random();
                        adDamage = 0;
                    } else if (chooseKick2 == 2) {
                        kick = man2.getAgility() + Math.random() - 0.1;
                        adDamage = 1;
                    } else {
                        kick = man2.getAgility() + Math.random() - 0.2;
                        adDamage = 2;
                    }
                    if (kick > 0.5) {
                        System.out.println(man2.getName() + " попал!");
                        System.out.println("Вы получили " + (man2.getPower() + adDamage) + " урона");
                        man1.setHP(man1.getHP() - (man2.getPower() + adDamage));
                        if (man1.getHP() <= 0) break;
                        System.out.println("У вас осталось " + man1.getHP() + " хп");
                    } else System.out.println(man2.getName() + " промахнулся!");

                    //бьет противниу

                    r++;
                }
                if (man1.getHP() <= 0) System.out.println("Вы проиграли");
                else System.out.println("Вы победили");
            } else { // ручной режим за 2 игрока
                int r = 1;
                double kick;
                int adDamage;
                while (man2.getHP() >= 0) {
                    System.out.println("Раунд: " + r);
                    System.out.println("Выберите удар:");
                    System.out.println("1: Джеб");
                    System.out.println("2: Апперкот");
                    System.out.println("3: Хук");
                    int chooseKick = Integer.parseInt(reader.readLine());
                    if (chooseKick == 1) {
                        kick = man2.getAgility() + Math.random();
                        adDamage = 0;
                    } else if (chooseKick == 2) {
                        kick = man2.getAgility() + Math.random() - 0.1;
                        adDamage = 1;
                    } else {
                        kick = man2.getAgility() + Math.random() - 0.2;
                        adDamage = 2;
                    }
                    if (kick > 0.5) {
                        System.out.println("Попал!");
                        System.out.println(man1.getName() + " получил " + (man2.getPower() + adDamage) + " урона");
                        man1.setHP(man1.getHP() - (man2.getPower() + adDamage));
                        if (man1.getHP() <= 0) break;
                        System.out.println("У " + man1.getName() + " осталось " + man1.getHP() + " хп");
                    } else System.out.println("Мимо!");


                    System.out.println("Теперь бьет " + man1.getName());
                    int chooseKick2 = (int) (Math.random() * 3);
                    if (chooseKick2 == 1) {
                        kick = man1.getAgility() + Math.random();
                        adDamage = 0;
                    } else if (chooseKick2 == 2) {
                        kick = man1.getAgility() + Math.random() - 0.1;
                        adDamage = 1;
                    } else {
                        kick = man1.getAgility() + Math.random() - 0.2;
                        adDamage = 2;
                    }
                    if (kick > 0.5) {
                        System.out.println(man1.getName() + " попал!");
                        System.out.println("Вы получили " + (man1.getPower() + adDamage) + " урона");
                        man2.setHP(man2.getHP() - (man1.getPower() + adDamage));
                        if (man2.getHP() <= 0) break;
                        System.out.println("У вас осталось " + man2.getHP() + " хп");
                    } else System.out.println(man1.getName() + " промахнулся!");

                    //бьет противниу

                    r++;
                }
                if (man2.getHP() <= 0) System.out.println("Вы проиграли");
                else System.out.println("Вы победили");
            }


        }


    }
}
