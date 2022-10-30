package carmanager;

/**
 *
 * @author nghia
 */
public class Tester {

    public static void main(String[] args) {
        Car car = new Car();
        car.pressStartButton();
        car.pressAcceleratorButton();
        car.output();

        Car car2 = new Car("red", 100, true, true);
        car2.pressAcceleratorButton();
        car2.setColor("black");
        System.out.println("Colour of c2: " + car2.getColor());
        car2.output();
    }
}
