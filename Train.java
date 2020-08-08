
public abstract class Train {
    private final String code;      //a private attribute which stores the train code.
    private final String startTime; //a private attribute which stores the start time in 24-hour format.
    private final Line line;        //a private attribute represents the Line for that train.
    private final Station start;    //a private attribute represents the first station of the train
    private final Station end;      //a private attribute represents the last station of the train

    public abstract double calculateFare(Station start, Station end); //an abstract method which accepts two input parameters
    public abstract int getMaxNumber(); //This method will be overridden by sub-classes’ methods as return Weight

    public String getCode() {
        return code;
    }

    public String getStartTime() {
        return startTime;
    }

    public Line getLine() {
        return line;
    }

    public Station getStart() {
        return start;
    }

    public Station getEnd() {
        return end;
    }

    public Train(String code, String startTime, Line line, Station start, Station end) {
        /*
         * a constructor of the class Train accepts five input parameters
         * (code – String, startTime – String, line – Line, start – Station, end – Station)
         * and initializes the data attributes of the Train.
         */
        this.code = code;
        this.startTime = startTime;
        this.line = line;
        this.start = start;
        this.end = end;
    }

    public boolean isValidRoute(Station from, Station to) {
        /*
         * accepts two arguments input parameters (from – Station, to - Station) returns true or
         * false depending on whether the specified journey is valid or not.
         */
        if (from.getDistance() < to.getDistance()) {
            return getStart().getDistance() <= from.getDistance() && getEnd().getDistance() >= to.getDistance(); //check valid or not, return boolean
        } else {
            return getStart().getDistance() >= from.getDistance() && getEnd().getDistance() <= to.getDistance(); //check valid or not, return boolean
        }
    }

    public double calculateTotalFare(Station start, Station end, int quantity) {
        /*
         * accepts three input parameters (from – Station, to – Station, int quantity) and returns
         * the total fare (type - double) by the following formula:
         * Total Fare = fare rate * quantity
         */
        return calculateFare(start, end) * quantity;
    }

    public String toString() {
        /*
         *returns the basic information of the Train
         * (return type - String) including the train code,
         * the start time, the first station name and the last station name.
         */
        return start.getName() + " -> " + end.getName() + " Max. ";
    }

}