public class Dog extends Animal{

    public Dog(String type, String size, int weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        if(speed.equals("slow")){
            System.out.println(getExplicitType() +" Walking");
        }else{
            System.out.println(getExplicitType() +" Running");
        }
    }

    @Override
    public void makeNoise() {
        if(type == "Wolf"){
            System.out.println("Howling!");
        }else{
            System.out.println("Woof!");
        }
    }
}
