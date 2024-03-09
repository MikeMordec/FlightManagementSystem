import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	public static void main(String args[]) {
		PriorityQueue<Flight> flights = new PriorityQueue<Flight>(10, new SortQueue());
		flights.add(new Flight(new Data("0001", 2002), 1));
		flights.add(new Flight(new Data("0002", 200), 1));
		flights.add(new Flight(new Data("0003", 330), 2));
		flights.add(new Flight(new Data("0004", 300), 3));
		flights.add(new Flight(new Data("0005", 200), 1));
		flights.add(new Flight(new Data("0006", 550), 1));
		flights.add(new Flight(new Data("0007", 3000), 2));
		flights.add(new Flight(new Data("0008", 1130), 3));
		flights.add(new Flight(new Data("0010", 757), 3));
		flights.add(new Flight(new Data("0009", 1220), 3));
		// Printing all elements
		System.out.println("The queue elements:");
		Data[] dataRecs = new Data[10];
		int i = 0;
		while (!flights.isEmpty()) {
			// store data
			dataRecs[i++] = new Data(flights.poll());
		}
		for (Data recs : dataRecs)
			System.out.println(recs.getName() + " " + recs.getMiles() + " " + recs.getPriority());
	}
}

class SortQueue implements Comparator<Flight> {
	@Override
	public int compare(Flight f1, Flight f2) {
		int priorityDiff = 100000*f1.getPriority() - 100000*f2.getPriority();
		int distanceDiff = 3000-f1.getData().getMiles() - 3000-f2.getData().getMiles();
		int res = priorityDiff-distanceDiff;
		//System.out.println("\t" + res + "\t" + f1 + "\t" + f2);
		return res;
	}
}

class Flight {
	Data data;
	private final int priority;

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	Flight(Data data2, int priority) {
		this.data = data2;
		this.priority = priority;
	}

	public Flight() {
		priority = 0;
	}

	public int getPriority() {
		return priority;
	}

	@Override
	public String toString() {
		return "Flight{ priority = " + priority + ", miles = " + data.getMiles() + ", Flight name = " + data.getName()
				+ " }";
	}
}