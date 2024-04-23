package one.hus.oop.decorator;

public abstract class ToppingDecorator extends Bread {
	Bread bread;
	
	public abstract String getDescription();

	public Bread getBread() {
		return this.bread;
	}
}
