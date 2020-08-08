
public class ExpressPassengerTrain extends PassengerTrain {
    public ExpressPassengerTrain(String code, String startTime, Line line, Station start, Station end, int maxTicketNumber){
        super(code, startTime, line, start, end, maxTicketNumber);
        /*
         * a constructor accepts six input parameters
         */

    }

    public double calculateTotalFare(Station start, Station end, int quantity) {
        return super.calculateFare(start, end) * ( 1 + getLine().getExpressTrainSurcharge() ) * quantity;
        /*
         * overrides the method of the super-class which accepts accepts three input parameters
         * (from – Station, to – Station, quantity - int) and returns the total fare
         */
    }

    public String toString() {
        return super.toString() + " Express Train Surcharge Required!";
        /*
         * returns the information of the Passenger Train (by calling the super class’s
         * toString method)
         */
    }
}