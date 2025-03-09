public class Test {
    public static void main(String[] args) {
        inFlight(new Jet());
        //OrbitEarth.log("Testing "+new Satelite());

        orbit(new Satelite());
    }

    private static void inFlight(FlightEnabled flight){
        flight.takeOff();
        flight.transition(FlightStages.LAUNCH);
        flight.fly();

        if(flight instanceof Trackable trackable){
            trackable.track();
        }

        flight.land();
    }

    private static void orbit(OrbitEarth flier){
       flier.takeOff();
       flier.fly();
       flier.land();
    }
}
