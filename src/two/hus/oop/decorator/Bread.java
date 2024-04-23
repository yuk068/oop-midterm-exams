package two.hus.oop.decorator;

public abstract class Bread {
	protected String description = "Bread";
  
	public String getDescription() {
		return description;
	}
 
	public abstract double cost();

	@Override
	public String toString() {
		return description;
	}
}
