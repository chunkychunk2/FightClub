public class Person {
    int age;
    double agility;
    int hp;
    String name;
    int power;

    void setAge(int a) {
        this.age = a;
    }

    int getAge() {
        return this.age;
    }

    double getAgility() {
        return this.agility;
    }

    void setAgility(double a) {
        this.agility = a;
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

    void setPower(int p) {
        this.power = p;
    }

    int getPower() {
        return this.power;
    }

    // проверяем попали ли в цель или промахнулись
    // наносим удар и отнимаем хп у цели
    int kick(Person man) {
        double hitPer = this.agility + Math.random();
        if (hitPer > 0.5) {
            System.out.println("Попал!");
            man.hp = (byte) (man.hp - this.power);
            return man.hp;
        } else {
            System.out.println("Мимо!");
            return man.hp;
        }

    }

    void areTheyEquals(Person man) {
        if (this.agility == man.agility) System.out.println("ловкость на одном уровне");
        else if (this.agility > man.agility) System.out.println("у " + this.name + " ловкость выше");
        else System.out.println("у " + man.name + " ловкость выше");

        if (this.age == man.age) System.out.println("ровесники");
        else if (this.age > man.age) System.out.println(this.name + " старше");
        else System.out.println(man.name + " старше");

        if (this.hp == man.hp) System.out.println("здоровье на одном уровне");
        else if (this.hp > man.hp) System.out.println("у " + this.name + " больше здоровья");
        else System.out.println("у " + man.name + " больше здоровья");

        if (this.power == man.power) System.out.println("силы равны");
        else if (this.power > man.power) System.out.println(this.name + " сильнее");
        else System.out.println(man.name + " сильнее");
    }
}
