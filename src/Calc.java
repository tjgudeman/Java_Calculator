/* Name: TJ Gudeman
 * Email: trevor.gudeman@nwciowa.edu
 * Description: This program functions as a calculator with an added aValue and bValue with a function display and an answer. 
 * 				It also can be controlled by the keyboard.
 */
public class Calc {
	private double valueA;
	private double valueB;

	public Calc() {
		setValueA(0);
		setValueB(0);
	}

	public double getValueA() {
		return valueA;
	}

	public void setValueA(double valueA) {
		this.valueA = valueA;
	}

	public double getValueB() {
		return valueB;
	}

	public void setValueB(double valueB) {
		this.valueB = valueB;
	}

}