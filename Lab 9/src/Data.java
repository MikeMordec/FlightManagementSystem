public class Data {
	
	// global variables of the class
	String name;
	int miles;
	int priority;

	public int getPriority() {
		return priority;
	}

	public String getName() {
		return name;
	}

	public int getMiles() {
		return miles;
	}

	// constructor has type of data that is required 
    Data(String name, int miles) {
    	// initialize the input variable from main
    	// function to the global variable of the class
		this.name = name;
		this.miles = miles;
	}

	public Data(Flight flight) {
		name = flight.getData().getName();
		miles = flight.getData().getMiles();
		priority = flight.getPriority();
	}
}