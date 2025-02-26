public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World again");
        printText("Hello World Again".split(" "));

        System.out.println("_".repeat(20));
        printText("Hello");

        System.out.println("_".repeat(20));
        printText("Hello","World","Again");

        System.out.println("_".repeat(20));
        printText();

        String[] sArray={"first","second","third","fourth","fifth"};
        System.out.println(String.join("_",sArray));
    }

    private static void printText(String... args){
        for (String t:args
             ) {
            System.out.println(t);
        }
    }
}