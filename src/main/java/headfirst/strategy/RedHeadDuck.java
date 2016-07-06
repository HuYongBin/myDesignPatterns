package headfirst.strategy;

public class RedHeadDuck extends Duck {

    public RedHeadDuck() {
        setFlyBehavior(new FlyWithWings());
        setQuackBehavior(new Quack());
    }

    public void display() {
        System.out.println("I'm a real Red Headed duck");
    }
}
