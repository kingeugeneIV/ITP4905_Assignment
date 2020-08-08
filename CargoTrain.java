public class CargoTrain extends Train {
    private final int maxCargoWeight; //a private attribute which stores the maximum cargo weight allowed for each order.

    //overrides the abstract method of the super-class; getter method for the data attribute maxCargoNumber
    public int getMaxNumber() {
        return maxCargoWeight;
    }

    public CargoTrain(String code, String startTime, Line line, Station start, Station end, int maxCargoWeight){
        /*
         * a constructor accepts six input parameters
         * (code – String, startTime – String, line – Line, start – Station, end – Station, maxCargoWeight – int)
         */
        super(code, startTime, line, start, end);
        this.maxCargoWeight = maxCargoWeight;
    }

    public double calculateFare(Station start, Station end) {
        /*
         * overrides the abstract method of the super-class which accepts accepts two input parameters
         * (from – Station, to - Station)
         * and returns the fare rate which is the fare per Kg for the journey (type - double)
         */
        return getLine().getCargoFarePerKm() * Line.calculateDistance(start, end);
    }

    public String toString() {
        /*
         * returns the basic information of the Train including the train code, the start time,
         * the first station name and the last station name (by calling the super class’s toString method)
         */
        return getCode() + " " + getStartTime() + " " + super.toString() + "Cargo Weight per Order : " + getMaxNumber() + " KG";
    }
}