public class Main {
      public static void main(String[] args) {

        Person man1 = new Person();
        Person man2 = new Person();

        man1.setName("Bob"); // слабый и ловкий
        man2.setName("Chucky"); // сильный и неуклюжий

        man1.setAge(12);
        man2.setAge(14);

        man1.setPower(8);
        man2.setPower(12);

        man1.setHP(25);
        man2.setHP(30);

        man1.setAgility(0.2);
        man2.setAgility(0.1);


        man1.areTheyEquals(man2);
        System.out.println("");
        int r = 1;
        while (man1.getHP() >= 0 && man2.getHP() >= 0) {

            System.out.println("Раунд " + r);
            System.out.println(man1.getName() + " бьет!");
            man1.kick(man2);
            System.out.println("у " + man2.getName() + "'а " + man2.getHP() + "хп");

            System.out.println(man2.getName() + " бьет!");
            man2.kick(man1);
            System.out.println("у " + man1.getName() + "'а " + man1.getHP() + "хп");
            r++;
            System.out.println();
        }
        if (man1.getHP() <= 0) System.out.println(man2.getName() + " победил");
        else System.out.println(man1.getName() + " победил");


    }
}

