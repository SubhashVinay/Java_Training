public class Fish extends Animal{

    public Fish(String type, String size, int weight) {
        super(type, size, weight);
    }

    @Override
    public void move(String speed) {
        if(speed.equals("slow")){
            System.out.println(getExplicitType() +" lazily swimming");
        }else{
            System.out.println(getExplicitType() +" darting franatically");
        }
    }

    @Override
    public void makeNoise() {
        if(type == "Goldfish"){
            System.out.println("Swish!");
        }else{
            System.out.println("Splash!");
        }
    }
}
