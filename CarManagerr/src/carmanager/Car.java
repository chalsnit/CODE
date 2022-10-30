package carmanager;

public class Car {

    private String color;
    private int enginePower;
    private boolean convertible;
    private boolean parkingBrake;

    public Car() {
    }
    ;

    public Car(String color, int enginePower, boolean convertible, boolean parkingBrake) {
        this.color = color;
        this.enginePower = enginePower;
        this.convertible = convertible;
        this.parkingBrake = parkingBrake;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getEnginePower() {
        return enginePower;
    }

    public void setEnginePower(int enginePower) {
        this.enginePower = enginePower;
    }

    public boolean getConvertible() {
        return convertible;
    }

    public void setConvertible(boolean convertible) {
        this.convertible = convertible;
    }

    public boolean getParkingBrake() {
        return parkingBrake;
    }

    public void setParkingBrake(boolean parkingBrake) {
        this.parkingBrake = parkingBrake;
    }

    public void pressStartButton() {
        System.out.println("You have pressed the start button");
    }

    public void pressAcceleratorButton() {
        System.out.println("You have pressed the Accelerator button");
    }

    public void output() {
        System.out.println("\n");
        System.out.println("Color is " + this.color);
        System.out.println("EnginePower is " + this.enginePower);
        System.out.println("Convertible is " + this.convertible);
        System.out.println("ParkingBrake is " + this.parkingBrake);
        System.out.println("\n");
    }

}
