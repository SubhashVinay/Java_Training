import java.util.Date;

enum FlightStages implements Trackable{
    GROUNDED,LAUNCH,CRUISE,DATA_COLLECTION;

    @Override
    public void track() {
        if(this != GROUNDED){
            System.out.println("Monitoring "+this);
        }
    }

    public FlightStages getNextStage(){
        FlightStages[] allStages=values();
        return allStages[(ordinal() + 1) % allStages.length];
    }
}
record DragonFly (String name,String type) implements FlightEnabled{
    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
}
class Satelite implements OrbitEarth{

    @Override
    public void achieveOrbit() {
        System.out.printf("Orbit Achieved!");
    }

    @Override
    public void takeOff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void fly() {

    }
}
interface OrbitEarth extends FlightEnabled{
    
    void achieveOrbit();

    static void log(String description){
       var today=new Date();
        System.out.println(today+ " : "+description);
    }
}
interface FlightEnabled{

    double MILES_TO_KM=1.60934;

    double KM_TO_MIlES=0.621371;
    public abstract void takeOff();

    abstract void land();

    void fly();

    default FlightStages transition(FlightStages stage){
        FlightStages nextStage=stage.getNextStage();
        System.out.println("Transitioning from "+stage+" to "+nextStage);
        return nextStage;
    }
}
interface Trackable{
    void track();
}
public abstract class Animal {

    public abstract void move();
}
