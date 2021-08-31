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
    // наносим удар и отнимаем хп у цели
    int kick(Person man) {
        man.hp = (byte) (man.hp - this.power);
        return man.hp;
    }
    // проверяем попали ли в цель или промахнулись
    boolean hit() {
        double hitPer = this.agility + Math.random();
        if (hitPer > 0.5) return true;
        else return false;
    }
}
