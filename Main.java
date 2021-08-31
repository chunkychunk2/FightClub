public class Main {
    public static void main(String[] args) {

        Person man1 = new Person();
        Person man2 = new Person();

        man1.setName("Bob");
        man2.setName("Chucky");

        man1.setAge(12);
        man2.setAge(14);

        if (man1.getAge() == man2.getAge()) System.out.println("Ровесники");
        else if (man1.getAge() > man2.getAge()) System.out.println(man1.getName() + " старше");
        else System.out.println(man2.getName() + " старше");

        man1.setPower(8);
        man2.setPower(12);

        if (man1.getPower() == man2.getPower()) System.out.println("силы равны");
        else if (man1.getPower() > man2.getPower()) System.out.println(man1.getName() + " сильнее");
        else System.out.println(man2.getName() + " сильнее");

        man1.setHP(25);
        man2.setHP(30);

        if (man1.getHP() == man2.getHP()) System.out.println("кол-во здоровья одинаковое");
        else if (man1.getHP() > man2.getHP()) System.out.println(man1.getName() + " имеет больше здоровья");
        else System.out.println(man2.getName() + " имеет больше здоровья");

        man1.setAgility(0.2);
        man2.setAgility(0.1);


        if (man1.getAgility() == man2.getAgility()) System.out.println("ловкость на одном уровне");
        else if (man1.agility > man2.getAgility()) System.out.println(man1.getName() + " ловчее");
        else System.out.println(man2.getName() + " ловчее");

        while (man1.getHP() >= 0 && man2.getHP() >= 0) {
            System.out.println(man1.getName() + " бьет!");
            man1.hit();
            if (man1.hit() == true) {
                System.out.println("Попал!");
                man1.kick(man2);
            } else System.out.println("Промах!");


            System.out.println("у " + man2.getName() + "'а " + man2.getHP() + "хп");
            if (man2.getHP() >= 0) {
                System.out.println(man2.getName() + " бьет!");
                man1.hit();
                if (man2.hit() == true) {
                    System.out.println("Попал!");
                    man2.kick(man1);

                } else System.out.println("Промах!");
                System.out.println("у " + man1.getName() + "'а " + man1.getHP() + "хп");
            } else break;


        }
        if (man1.getHP() <= 0) System.out.println(man2.getName() + " победил");
        else System.out.println(man1.getName() + " победил");

    }
}

