public class BusStop {
    private String time;
    private String line;
    private String destination;

    public BusStop(String time, String line, String destination) {
        this.time = time;
        this.line = line;
        this.destination = destination;
    }

    @Override
    public String toString() {
        return "BusStop{" +
                "time='" + time + '\'' +
                ", line='" + line + '\'' +
                ", destination='" + destination + '\'' +
                '}';
    }

    public String getTime() {
        return time;
    }

    public String getLine() {
        return line;
    }

    public String getDestination() {
        return destination;
    }
}
