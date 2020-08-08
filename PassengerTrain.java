

public class PassengerTrain extends Train {
    private final int maxTicketNumber;

    //overrides the abstract method of the super-class; getter method for the data attribute maxTicketNumber
    public int getMaxNumber() {
        return maxTicketNumber;
    }

    public PassengerTrain(String code, String startTime, Line line, Station start, Station end, int maxTicketNumber){
        super(code, startTime, line, start, end);
        this.maxTicketNumber = maxTicketNumber;
    }

    public double calculateFare(Station start, Station end) {
        /*
         * overrides the abstract method of the super-class which accepts accepts two input parameters
         * (from – Station, to - Station)
         * and returns the fare rate which is the fare per Kg for the journey (type - double)
         */
        return getLine().getPassengerFarePerKm() * Line.calculateDistance(start, end);
    }

    public String toString() {
        return getCode() + " " + getStartTime() + " " + super.toString() + "Number of Passenger Ticket per Order : " + getMaxNumber();
    }
}