package logic;

public class UnitCard {
	private String name;
	private int bloodCost;
	private int power;
	private int health;
	private String flavorText;

	//constructor
	public UnitCard(String name , int bloodCost , int power , int health , String flavorText){
		setName(name);
		setBloodCost(bloodCost);
		setPower(power);
		setHealth(health);
		setFlavorText(flavorText);
	}

	//getter
	public String getName() {return name;}
	public int getBloodCost() {return bloodCost;}
	public int getPower() {return power;}
	public int getHealth() {return health;}
	public String getFlavorText() {return flavorText;}

	//setter
	public void setName(String name) {
		if(name==null || name.isBlank()) {
			name = "Creature";
		}
		this.name = name;
	}

	public void setBloodCost(int bloodCost) {
		if(bloodCost<0){
			bloodCost = 0;
		}
		this.bloodCost = bloodCost;
	}

	public void setPower(int power) {
		if(power<0){
			power = 0;
		}
		this.power = power;
	}

	public void setHealth(int health) {
		if(health<1){
			health = 1;
		}
		this.health = health;
	}

	public boolean equals(UnitCard other){
		return name.equals(other.getName());
	}

	public void setFlavorText(String flavorText) {
		this.flavorText = flavorText;
	}

	public String toString() {
		return this.getName() + " (POW: " + this.getPower() + ", HP: " + this.getHealth() + ")";
	}
}