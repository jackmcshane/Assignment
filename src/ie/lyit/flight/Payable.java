package ie.lyit.flight;

public interface Payable {
	//for abstract take in variables
	public abstract double calculateWage(double taxPercentage);
	public abstract double incrementSalary(double incrementAmount);
}
