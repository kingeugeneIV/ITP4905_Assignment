
public class Station {
    private final String name;
    private final int distance;

    public Station(String name, int distance) {
        //a constructor of the class Station accepts 2 input parameters
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }
}