import Interfaces.Fight;
import Interfaces.Skills;
import Something.ChoiceException;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Person man1 = new Person("Chucky", 12, 8, 25, 0.2);
        Person man2 = new Person("Bob", 14, 12, 30, 0.1);

        List<Person> fighters = new ArrayList<>();
        fighters.add(man1);
        fighters.add(man2);


        for (int i = 0; i < fighters.size(); i++) {
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
        }


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
        }

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
                double kick = 0;
                int adDamage = 0;
                while (man1.getHP() >= 0) {
                    System.out.println("Раунд: " + r);
                    System.out.println("Выберите удар:");
                    System.out.println("1: Джеб");
                    System.out.println("2: Апперкот");
                    System.out.println("3: Хук");
                    if (r%4 == 0) System.out.println("4: Мегапанч");
                    int chooseKick = 0;
                    while (true) {
                        try {
                            chooseKick = Integer.parseInt(reader.readLine());
                            if (chooseKick == 1) {
                                kick = man1.getAgility() + Math.random();
                                adDamage = 0;
                            } else if (chooseKick == 2) {
                                kick = man1.getAgility() + Math.random() - 0.1;
                                adDamage = 1;
                            } else if (chooseKick == 3){
                                kick = man1.getAgility() + Math.random() - 0.2;
                                adDamage = 2;
                            } else if (chooseKick == 4 && r%4 == 0){
                                kick = man1.getAgility() + Math.random();
                                adDamage = 6;
                                break;
                            }

                            if (chooseKick != 1 && chooseKick != 2 && chooseKick !=3) {
                                throw new ChoiceException();
                            }
                        } catch (NumberFormatException | IOException e) {
                            System.out.println("Вы ввели не число");
                        } catch (ChoiceException e) {
                            System.out.println("Вы ввели недопустимое число");
                        }
                        if (chooseKick == 1 || chooseKick == 2 || chooseKick == 3) {
                            break;
                        }
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
                double kick = 0;
                int adDamage = 0;
                while (man2.getHP() >= 0) {
                    System.out.println("Раунд: " + r);
                    System.out.println("Выберите удар:");
                    System.out.println("1: Джеб");
                    System.out.println("2: Апперкот");
                    System.out.println("3: Хук");
                    if (r%4 == 0) System.out.println("4: Мегапанч");
                    int chooseKick = 0;
                    while (true) {
                        try {
                            chooseKick = Integer.parseInt(reader.readLine());
                            if (chooseKick == 1) {
                                kick = man2.getAgility() + Math.random();
                                adDamage = 0;
                            } else if (chooseKick == 2) {
                                kick = man2.getAgility() + Math.random() - 0.1;
                                adDamage = 1;
                            } else if (chooseKick == 3){
                                kick = man2.getAgility() + Math.random() - 0.2;
                                adDamage = 2;
                            } else if (chooseKick == 4 && r%4 == 0){
                                kick = man2.getAgility() + Math.random();
                                adDamage = 6;
                                break;
                            }

                            if (chooseKick != 1 && chooseKick != 2 && chooseKick !=3) {
                                throw new ChoiceException();
                            }
                        } catch (NumberFormatException | IOException e) {
                            System.out.println("Вы ввели не число");
                        } catch (ChoiceException e) {
                            System.out.println("Вы ввели недопустимое число");
                        }
                        if (chooseKick == 1 || chooseKick == 2 || chooseKick == 3) {
                            break;
                        }
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

