package world;

public class App {
    public static void main(String[] args){
        World Earth = new World();

        for (int i = 1; i <= 10; i++){
            System.out.println();
            System.out.println("Day " + i);
            Earth.RunDay();
            Earth.WriteHealth();
        }

    }
}
