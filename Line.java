
import java.util.*;

public class Line {
    private final String name;
    private final Station[] stops;
    private final double passengerFarePerKm;
    private final double cargoFarePerKm;
    private final double expressTrainSurcharge;
    private String list = "";

    public String getName() {
        return name;
    }

    public Station[] getStops() {
        return stops;
    }

    public double getPassengerFarePerKm() {
        return passengerFarePerKm;
    }

    public double getCargoFarePerKm() {
        return cargoFarePerKm;
    }

    public double getExpressTrainSurcharge() {
        return expressTrainSurcharge;
    }

    public Line(String name, Station[] stops, double passengerFarePerKm, double cargoFarePerKm, double expressTrainSurcharge) {
        //a constructor of the class Line accepts five input parameters
        this.name = name;
        this.stops = stops;
        this.passengerFarePerKm = passengerFarePerKm;
        this.cargoFarePerKm = cargoFarePerKm;
        this.expressTrainSurcharge = expressTrainSurcharge;
    }

    public String getList() {
        Arrays.stream(stops).forEach(stop -> list += " > " + stop.getName() + ",(" + stop.getDistance() + ")");
        StringBuilder buff = new StringBuilder(list);
        buff.delete(0, 3);                  //delete first " > "
        list = buff.toString();
        list +=  "\n"+"\n" + "Fares Summary: " + "\n"
                + "Passenger Per KM: HKD " + getPassengerFarePerKm() + "\n"
                + "Cargo Per KG Per KM: HKD " + getCargoFarePerKm() + "\n"
                + "Express Train Surcharge: " + Math.round(expressTrainSurcharge * 100) + "%" + "\n";
        return list;
    }

    public String toString() {
        /*
         * returns the information of the Line
         */
        return getName() + "\n" + getList();
    }

    public static int calculateDistance(Station start, Station end) {
        /*
         * returns the distance in KM between specified stations.
         */
        return Math.abs(start.getDistance() - end.getDistance());
    }
}