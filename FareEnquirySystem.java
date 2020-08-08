
import java.util.*;

public class FareEnquirySystem {
	public static void main(String[] args) throws RuntimeException{
		Scanner sc = new Scanner(System.in);
		int from_number = 0;
		int to_number = 0;
		int v3;
		int v4 = 0;

		//Stations information
		Station[] stations = new Station[7];
		stations[0] = new Station("HongKong", 0);
		stations[1] = new Station("ShenZhen", 50);
		stations[2] = new Station("GuangZhou", 200);
		stations[3] = new Station("ZhengZhou", 700);
		stations[4] = new Station("WuChang", 1000);
		stations[5] = new Station("BeiJing", 2100);
		stations[6] = new Station("InnerMongolia", 2400);


		//Line information
		Line line = new Line("HongKong-WuChang-InnerMongolia", stations, 0.6, 0.02, 0.5);

		//Trains information
		Train[] trains = new Train[5];
		trains[0] = new CargoTrain("C001", "08:00", line, line.getStops()[1], line.getStops()[3], 100);
		trains[1] = new CargoTrain("C002", "12:00", line, line.getStops()[6], line.getStops()[3], 200);
		trains[2] = new PassengerTrain("P001", "10:00", line, line.getStops()[0], line.getStops()[6], 10);
		trains[3] = new PassengerTrain("P002", "18:00", line, line.getStops()[6], line.getStops()[1], 6);
		trains[4] = new ExpressPassengerTrain("X001", "14:30", line, line.getStops()[0], line.getStops()[6], 4);

		System.out.println("Fare Enquiry System");
		System.out.println("===================");
		System.out.println(line);

		//List of all trains
		System.out.println("All train(s) running on this line.");
		for (Train train : trains) System.out.println(train);

		//List all stations
		Station[] s = line.getStops();
		System.out.println("\nList of stations: ");
		for (int i = 0; i < stations.length; i++) {
			System.out.println(i + ". " + s[i].getName());
		}

		String msgBox = "departure station number ";
		String errMsg = "Invalid ";
		String err2Msg = "";
		System.out.print("\nPlease enter " + msgBox + ": ");
		try {
			//ask user input station number
			from_number = sc.nextInt();
			//check station is valid or not
			if (null == s[from_number]) {
			}

			//ask user input station number
			msgBox = "arrival station number ";
			System.out.print("Please enter " + msgBox + ": ");
			//ask user input station number
			to_number = sc.nextInt();
			//check station is valid or not
			if (null == s[to_number]) {
			}

			//print all available train
			msgBox = "train";
			System.out.print("The available " + msgBox + "(s):-");
			//check user input two station is or not a valid route
			for (int i = 0; i < trains.length; i++) {
				if (trains[i].isValidRoute(s[from_number], s[to_number])){
					System.out.print("\n" + i + ". " + trains[i]);
					v4 ++;
					}
				}
			switch (v4) {
				case 0 -> throw new SomeThingWrongException();
			}

			//ask user choose one train on the list
			System.out.print("\nEnter the " + msgBox + " code : ");
			v3 = sc.nextInt();
			//check user input train number is on the list
			if (!trains[v3].isValidRoute(s[from_number], s[to_number])) {
				throw new ArrayIndexOutOfBoundsException();
			}

			//check train is cargo train or passenger train
			if (trains[v3] instanceof CargoTrain){
				msgBox = "cargo weight";
				System.out.print("Please enter " + msgBox + "(KG): ");
				v4 = sc.nextInt();
					if( v4 > trains[v3].getMaxNumber()) {
						errMsg = "Cargo weight exceeds the max Cargo weight per order.";
						throw new TicketOutOfBoundsException();
					}
				msgBox = "KG cargo ";
			}else {
				msgBox = "number of passenger";
				System.out.print("Please enter " + msgBox + ": ");
				v4 = sc.nextInt();
					if( v4 > trains[v3].getMaxNumber()) {
						errMsg = "Number of passengers exceeds the max number of passenger tickets per order.";
						throw new TicketOutOfBoundsException();
					}
				msgBox = " Passenger(s) ";
			}
			System.out.print("Result: ");
			System.out.print("\nFor " + v4 + msgBox + "traveling from " + s[from_number].getName() + " to " + s[to_number].getName() + " on " + trains[v3].getCode());
			System.out.print("\nTotal Fare: HKD " + Math.round(trains[v3].calculateTotalFare(s[from_number], s[to_number], v4)));

		} catch (ArrayIndexOutOfBoundsException a) {
			System.out.print(errMsg + msgBox + err2Msg + "!");
		} catch (InputMismatchException b) {
			System.out.print("Invalid " + msgBox + "!");
		} catch (TicketOutOfBoundsException c) {
			System.out.print(errMsg);
		} catch (SomeThingWrongException d) {
			System.out.print("\nNo Train departs from Station " + from_number + " to Station " + to_number);
		}
		System.out.print("\nBye Bye!");
	}
}