import Interfaces.CanFight;
import Something.ChoiceException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fighter extends Person implements CanFight {

    private String name;
    private int power;
    private double agility;
    private int hp;

    double getAgility() {
        return this.agility;
    }

    void setAgility(double a) {
        this.agility = a;
    }

    void setPower(int p) {
        this.power = p;
    }

    int getPower() {
        return this.power;
    }

    void setHP(int h) {
        this.hp = h;
    }

    int getHP() {
        return this.hp;
    }

    void setName(String n) {
        this.name = n;
    }

    String getName() {
        return this.name;
    }

    public Fighter(String name, int power, int hp, double agility) {
        this.name = name;
        this.hp = hp;
        this.power = power;
        this.agility = agility;
    }

    public void battle(Fighter fighter) {
        int r = 1;
        double kick = 0;
        int adDamage = 8;
        int protectionArea = 0;
        while (this.getHP() >= 0) {
            System.out.println("Раунд: " + r);
            System.out.println("Выберите действие:");
            System.out.println("1: Джеб");
            System.out.println("2: Апперкот");
            System.out.println("3: Хук");
            System.out.println("4: Защититься");
            if (r % 3 == 0) System.out.println("5: Мегапанч");
            int chooseKick = 0;
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                try {
                    chooseKick = Integer.parseInt(reader.readLine());
                    if (chooseKick == 1) {
                        kick = this.getAgility() + Math.random();
                        adDamage = 0;
                    } else if (chooseKick == 2) {
                        kick = this.getAgility() + Math.random() - 0.1;
                        adDamage = 1;
                    } else if (chooseKick == 3) {
                        kick = this.getAgility() + Math.random() - 0.2;
                        adDamage = 2;
                    } else if (chooseKick == 4) {

                        System.out.println("Выберите область защиты:");
                        System.out.println("1: Лицо");
                        System.out.println("2: Подбородок");
                        System.out.println("3: Виски");
                        do {
                            try {
                                protectionArea = Integer.parseInt(reader.readLine());
                                adDamage = 8;
                                if (protectionArea != 1 && protectionArea != 2 && protectionArea != 3) {
                                    System.out.println("ошибка");
                                    throw new ChoiceException();
                                }

                            } catch (NumberFormatException | IOException e) {
                                e.printStackTrace();
                                System.out.println("Вы ввели не число");
                            } catch (ChoiceException e) {
                                e.printStackTrace();
                                System.out.println("Вы ввели недопустимое число");
                            }

                        } while (protectionArea != 1 && protectionArea != 2 && protectionArea != 3);
                    } else if (chooseKick == 5 && r % 3 == 0) {
                        kick = this.getAgility() + Math.random();
                        adDamage = 6;
                        break;
                    }

                    if (chooseKick != 1 && chooseKick != 2 && chooseKick != 3 && chooseKick != 4) {
                        throw new ChoiceException();
                    }
                } catch (NumberFormatException | IOException e) {
                    e.printStackTrace();
                    System.out.println("Вы ввели не число");
                } catch (ChoiceException e) {
                    e.printStackTrace();
                    System.out.println("Вы ввели недопустимое число");
                }
                if (chooseKick == 1 || chooseKick == 2 || chooseKick == 3 || protectionArea == 1 || protectionArea == 2 || protectionArea == 3) {
                    break;
                }
            }
            if (chooseKick == 1 || chooseKick == 2 || chooseKick == 3 || chooseKick == 5) { // проверяем защитился ли игрок или атаковал
                if (kick > 0.5) { // если атаковал
                    System.out.println("Попал!");
                    System.out.println(fighter.getName() + " получил " + (this.getPower() + adDamage) + " урона");
                    fighter.setHP(fighter.getHP() - (this.getPower() + adDamage));
                    if (fighter.getHP() <= 0) break;
                    System.out.println("У " + fighter.getName() + " осталось " + fighter.getHP() + " хп");
                } else System.out.println("Мимо!");
            } else { // если защитился
                System.out.println("Вы приняли защитную стойку");
            }

            System.out.println("Бьет " + fighter.getName()); // теперь бьет Боб
            int chooseKick2 = (int) (Math.random() * 3);
            int adDamage2;
            if (chooseKick2 == 1) {
                kick = fighter.getAgility() + Math.random();
                adDamage2 = 0;
            } else if (chooseKick2 == 2) {
                kick = fighter.getAgility() + Math.random() - 0.1;
                adDamage2 = 1;
            } else {
                kick = fighter.getAgility() + Math.random() - 0.2;
                adDamage2 = 2;
            }
            if (chooseKick2 == protectionArea) {
                System.out.println("Успешная защита!");
                System.out.println("Контратака!");
                System.out.println(fighter.getName() + " получил " + (this.getPower() + adDamage) + " урона");
                fighter.setHP(fighter.getHP() - (this.getPower() + adDamage));
                if (fighter.getHP() <= 0) break;
                System.out.println("У " + fighter.getName() + " осталось " + fighter.getHP() + " хп");
            } else {
                int p = 0;
                if (protectionArea != -1) {
                    System.out.println("Не удалось защититься");
                    p = 1;
                }
                if (kick > 0.5) {
                    System.out.println(fighter.getName() + " попал!");
                    System.out.println("Вы получили " + (fighter.getPower() + adDamage2) + " урона");
                    this.setHP(this.getHP() - (fighter.getPower() + adDamage2));
                    if (this.getHP() <= 0) break;
                    System.out.println("У вас осталось " + this.getHP() + " хп");
                } else {
                    if (p == 1) System.out.println("но удалось увернуться");
                    System.out.println(fighter.getName() + " промахнулся!");
                }
            }
            //бьет противниу
            protectionArea = -1;
            r++;
        }
        if (this.getHP() <= 0) System.out.println("Вы проиграли");
        else System.out.println("Вы победили");
    } // ручная битва

    public void autoBattle(Fighter man) {
        int r = 1;
        System.out.println("у Chucky в начале битвы" + this.getHP());
        while (this.getHP() >= 0) {
            System.out.println("Раунд " + r);
            double hitPer = this.agility + Math.random();
            System.out.println(this.getName() + " бьет!");
            if (hitPer > 0.5) {
                System.out.println("Попал!");
                man.hp = man.hp - this.power;
                if (man.getHP() <= 0) System.out.println(man.getName() + " теряет сознание!");
                else System.out.println("у " + man.getName() + "'а осталось " + man.getHP() + "хп");
            } else {
                System.out.println("Мимо!");
            }
            if (man.getHP() <= 0) break;
            hitPer = man.agility + Math.random();
            System.out.println(man.getName() + " бьет!");
            if (hitPer > 0.5) {
                System.out.println("Попал!");
                this.hp = this.hp - man.power;
                if (this.getHP() <= 0) System.out.println(this.getName() + " теряет сознание!");
                else System.out.println("у " + this.getName() + "'а осталось " + this.getHP() + "хп");
            } else {
                System.out.println("Мимо!");
            }
            r++;
            System.out.println("");
        }
        if (this.getHP() <= 0) System.out.println("Вы проиграли");
        else System.out.println("Вы победили");
    } // автобитва

    public String toString() {
        return getName() + ": " + this.power + " силы, " + getHP() + " хп, " + this.agility + " ловкости";
    }

    void equals(Fighter man) {
        if (this.agility == man.agility) System.out.println("ловкость на одном уровне");
        else if (this.agility > man.agility) System.out.println("у " + this.getName() + " ловкость выше");
        else System.out.println("у " + man.getName() + " ловкость выше");

        if (this.getHP() == man.getHP()) System.out.println("здоровье на одном уровне");
        else if (this.getHP() > man.getHP()) System.out.println("у " + getName() + " больше здоровья");
        else System.out.println("у " + man.getName() + " больше здоровья");

        if (this.power == man.power) System.out.println("силы равны");
        else if (this.power > man.power) System.out.println(this.getName() + " сильнее");
        else System.out.println(man.getName() + " сильнее");
    } // сравнение персонажей


}





