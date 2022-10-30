
public class Car {
	private String color;
	private int EnginePower;
	private boolean Convertible;
    private boolean ParkingBrake;
    
    public Car(char color, int EnginePower, boolean Convertible, boolean ParkingBrake)
    {
     this.color = color;
     this.EnginePower = EnginePower;
     this.Convertible = Convertible;
     this.ParkingBrake = ParkingBrake;
    }

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getEnginePower() {
		return EnginePower;
	}

	public void setEnginePower(int enginePower) {
		EnginePower = enginePower;
	}

	public boolean isConvertible() {
		return Convertible;
	}

	public void setConvertible(boolean convertible) {
		Convertible = convertible;
	}

	public boolean isParkingBrake() {
		return ParkingBrake;
	}

	public void setParkingBrake(boolean parkingBrake) {
		ParkingBrake = parkingBrake;
	}
    
    
    
}
